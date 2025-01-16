package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.GetWeaoponListLogic;
import model.Weapon;

/**
 * Servlet implementation class SearchWeaponListServlet
 */
@WebServlet("/SearchWeaponListServlet")
public class SearchWeaponListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = (String) request.getAttribute("message");
		String searchBy = request.getParameter("searchBy");
		String searchKeyword = request.getParameter("searchKeyword");
		String matchType = request.getParameter("matchType");

		if (message != null) {
			request.setAttribute("message", message);
		}

		// 初期値のセット
		if (searchBy == null)
			searchBy = "type";
		if (searchKeyword == null)
			searchKeyword = "";
		if (matchType == null)
			matchType = "partial";

		GetWeaoponListLogic getWeaponListLogic = new GetWeaoponListLogic();
		List<Weapon> weaponList = getWeaponListLogic.getSearchWeaponListLogic(searchBy, searchKeyword, matchType);

		if (weaponList.size() == 0) {

			request.setAttribute("mismatchMsg", "条件に一致するブキがありません");
		}

		request.setAttribute("weaponList", weaponList);
		request.setAttribute("searchBy", searchBy);
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("matchType", matchType);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/weaponList.jsp");
		dispatcher.forward(request, response);

	}

}
