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
		String searchBy = request.getParameter("searchBy");
		String searchKeyword = request.getParameter("searchKeyword");
		String matchType = request.getParameter("matchType");

		// 初期値のセット
		if (searchBy == null)
			searchBy = "type";
		if (searchKeyword == null)
			searchKeyword = "";
		if (matchType == null)
			matchType = "partial";

		GetWeaoponListLogic getWeaponListLogic = new GetWeaoponListLogic();
		List<Weapon> weaponList = getWeaponListLogic.getAllWeaponListLogic();

		// 検索条件に基づくフィルタリング		
		List<Weapon> filteredWeapons = new ArrayList<>();

		for (Weapon weapon : weaponList) {
			String valueToCheck = getWeaponAttribute(weapon, searchBy);
			//条件に合う場合、リストに追加
			if (matchType.equals("exact")) {
				if (valueToCheck.equals(searchKeyword)) {
					filteredWeapons.add(weapon);
				}
			} else {
				if (valueToCheck.contains(searchKeyword)) {
					filteredWeapons.add(weapon);
				}
			}
		}

		if (filteredWeapons.size() == 0) {
			request.setAttribute("mismatchMsg", "条件に一致するブキがありません");
		}

		request.setAttribute("weaponList", filteredWeapons);
		request.setAttribute("searchBy", searchBy);
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("matchType", matchType);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/weaponList.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		List<Weapon> weaponList = getWeaponListLogic.getAllWeaponListLogic();

		// 検索条件に基づくフィルタリング
		List<Weapon> filteredWeapons = new ArrayList<>();

		for (Weapon weapon : weaponList) {
			String valueToCheck = getWeaponAttribute(weapon, searchBy);
			//条件に合う場合、リストに追加
			if (matchType.equals("exact")) {
				if (valueToCheck.equals(searchKeyword)) {
					filteredWeapons.add(weapon);
				}
			} else {
				if (valueToCheck.contains(searchKeyword)) {
					filteredWeapons.add(weapon);
				}
			}
		}

		request.setAttribute("weaponList", filteredWeapons);
		request.setAttribute("searchBy", searchBy);
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("matchType", matchType);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/weaponList.jsp");
		dispatcher.forward(request, response);

	}

	// 武器属性を取得するためのユーティリティメソッド
	private String getWeaponAttribute(Weapon weapon, String attribute) {
		switch (attribute) {
		case "type":
			return weapon.getType();
		case "name":
			return weapon.getName();
		case "sub":
			return weapon.getSub();
		case "special":
			return weapon.getSpecial();
		default:
			return "";
		}
	}
}
