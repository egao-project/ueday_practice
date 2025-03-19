package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Action;
import model.ExecuteResult;
import model.NotFoundAction;
import util.ActionLoader;
import util.ScreenTransition;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> actions = new HashMap<>();
	ExecuteResult result = new ExecuteResult("/WEB-INF/top.jsp");

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
			ScreenTransition.forward(request, response, result.getNextPage());
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
		Map<String, String[]> parameterMap = request.getParameterMap();
		String action = request.getParameter("action");
		Action executeAction = actions.getOrDefault(action, new NotFoundAction());
		result = executeAction.execute(parameterMap);
		request.setAttribute("dataMap", result.getData());
		ScreenTransition.forward(request, response, result.getNextPage());

	}

}
