package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.GetWeaoponListLogic;
import model.Weapon;

/**
 * Servlet implementation class WeaponListServlet
 */
@WebServlet("/WeaponListServlet")
public class WeaponListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 絞り込み検索実行時に送られてくる値を取得
		String[] searchBy = request.getParameterValues("searchBy");
		String searchKeyword = request.getParameter("searchKeyword");
		String matchType = request.getParameter("matchType");

		HttpSession session = request.getSession();

		if (searchBy == null && matchType == null) {
			// 絞り込み検索を行っていない場合、セッションに保持されている値を取得
			searchBy = (String[]) session.getAttribute("searchBy");
			searchKeyword = (String) session.getAttribute("searchKeyword");
			matchType = (String) session.getAttribute("matchType");

		}
		// 初回の画面遷移時に初期値をセット
		if (searchKeyword == null)
			searchKeyword = "";
		if (matchType == null)
			matchType = "partial";

		List<Weapon> weaponList = new ArrayList<Weapon>();

		GetWeaoponListLogic getWeaponListLogic = new GetWeaoponListLogic();

		if (searchKeyword == "") {
			// 検索キーワードが空白の場合、ブキ一覧を全件取得
			weaponList = getWeaponListLogic.getAllWeaponListLogic();

			if (weaponList.size() == 0 || weaponList == null)
				request.setAttribute("mismatchMsg", "表示するブキがありません");

		} else {
			// 絞り込み検索実行
			weaponList = getWeaponListLogic.getSearchWeaponListLogic(searchBy, searchKeyword, matchType);

			if (weaponList.size() == 0 || weaponList == null)
				request.setAttribute("mismatchMsg", "条件に一致するブキがありません");

		}

		request.setAttribute("weaponList", weaponList);
		session.setAttribute("searchBy", searchBy);
		session.setAttribute("searchKeyword", searchKeyword);
		session.setAttribute("matchType", matchType);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/weaponList.jsp");
		dispatcher.forward(request, response);

	}

}
