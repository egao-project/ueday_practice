package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.UpdateWeapontLogic;
import model.Weapon;

/**
 * Servlet implementation class UpdateWeaponServlet
 */
@WebServlet("/UpdateWeaponServlet")
public class UpdateWeaponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Weapon editWeapon = new Weapon();

		editWeapon.setWeaponId(Integer.parseInt(request.getParameter("weaponId")));
		editWeapon.setName(request.getParameter("name"));
		editWeapon.setType(request.getParameter("type"));
		editWeapon.setRange(request.getParameter("range"));
		editWeapon.setDamage(request.getParameter("damage"));
		editWeapon.setSub(request.getParameter("sub"));
		editWeapon.setSpecial(request.getParameter("special"));

		UpdateWeapontLogic bo = new UpdateWeapontLogic();
		boolean result = bo.execute(editWeapon);

		if (!result) {
			request.setAttribute("message", "更新に失敗しました");
		} else {
			request.setAttribute("message", "更新に成功しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateWeaponResult.jsp");
			dispatcher.forward(request, response);
		}

	}

}
