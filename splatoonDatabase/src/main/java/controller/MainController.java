package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Action;
import model.ExecuteResult;
import model.NotFoundAction;
import util.ActionData;
import util.ActionLoader;
import util.ScreenTransition;
import util.SessionParamUtil;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, ActionData> actions = new HashMap<>();
	ExecuteResult result = new ExecuteResult();

	@Override
	public void init() {
		// ActionLoader を使ってアクションを読み込み
		actions = ActionLoader.loadActions();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			ScreenTransition.forward(request, response, "/WEB-INF/top.jsp");
		} else {
			doService(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doService(request, response);
	}

	protected void doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		Map<String, String[]> parameterMap = new HashMap<>(request.getParameterMap());
		// セッションから検索条件を取得
		Map<String, String[]> sessionParams = (Map<String, String[]>) session.getAttribute("sessionParams");

		if (sessionParams != null) {
			for (Map.Entry<String, String[]> entry : sessionParams.entrySet()) {
				parameterMap.putIfAbsent(entry.getKey(), entry.getValue());
			}
		}
		// アクションデータを取得（デフォルトは NotFoundAction）
		ActionData actionData = actions.getOrDefault(action, new ActionData(
				new NotFoundAction(), "/WEB-INF/jsp/notFound.jsp", "/WEB-INF/jsp/notFound.jsp"));

		Action executeAction = actionData.getAction();
		result = executeAction.execute(parameterMap, sessionParams);
		request.setAttribute("dataMap", result.getData());

		Map<String, String[]> sessionToParams = SessionParamUtil.sessionParams(result.getData());
		if (sessionToParams != null) {
			session.setAttribute("sessionParams", sessionToParams);
		}

		// 成功・失敗に応じてjspを選択
		String nextPage = result.isSuccess() ? actionData.getSuccessJspPath() : actionData.getFailureJspPath();
		ScreenTransition.forward(request, response, nextPage);

	}

}
