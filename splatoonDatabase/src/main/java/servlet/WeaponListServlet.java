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

		GetWeaoponListLogic getWeaponListLogic = new GetWeaoponListLogic();
		List<Weapon> weaponList = getWeaponListLogic.getAllWeaponListLogic();

		request.setAttribute("weaponList", weaponList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/weaponList.jsp");
		dispatcher.forward(request, response);

	}
}
