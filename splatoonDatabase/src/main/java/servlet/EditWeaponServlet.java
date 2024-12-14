package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.GetEditWeaponDataLogic;
import model.Weapon;

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
		String selectedWeaponId = request.getParameter("weaponId");
		GetEditWeaponDataLogic getEditWeaponDataLogic = new GetEditWeaponDataLogic();
		// ブキIDで武器情報を取得
		Weapon weapon = getEditWeaponDataLogic.getEditWeaponDataLogic(selectedWeaponId);

		request.setAttribute("weapon", weapon);

		if (selectedWeaponId != null) {
			int weaponId = Integer.parseInt(selectedWeaponId);
			request.setAttribute("weaponId", weaponId);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editWeapon.jsp");
			dispatcher.forward(request, response);

		} else {

			request.setAttribute("message", "ブキが選択されていません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("WeaponListServlet");
			dispatcher.forward(request, response);

		}

	}

}
