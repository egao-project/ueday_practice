package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class EditWeaponServlet
 */
@WebServlet("/EditWeaponServlet")
public class EditWeaponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String selectedWeaponId = request.getParameter("weaponIds");

		//		String type = request.getParameter("type");
		//		String name = request.getParameter("name");
		//		String range = request.getParameter("range");
		//		String damage = request.getParameter("damage");
		//		String sub = request.getParameter("sub");
		//		String special = request.getParameter("special");
		//
		//		Weapon weapon = new Weapon(type, name, range, damage, sub, special);
		//		request.setAttribute("weapon", weapon);

		if (selectedWeaponId != null) {
			int weaponId = Integer.parseInt(selectedWeaponId);
			request.setAttribute("weaponId", weaponId);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editWeapon.jsp");
			dispatcher.forward(request, response);
		} else {

			HttpSession session = request.getSession();
			session.setAttribute("message", "ブキが選択されていません");

			response.sendRedirect("WeaponListServlet");
		}

	}

}
