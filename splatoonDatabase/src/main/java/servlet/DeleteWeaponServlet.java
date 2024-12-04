package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.DeleteWeaponLogic;

/**
 * Servlet implementation class AccountEditServlet
 */
@WebServlet("/DeleteWeaponServlet")
public class DeleteWeaponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String[] weaponIds = request.getParameterValues("weaponIds");

		if (weaponIds != null && weaponIds.length > 0) {

			DeleteWeaponLogic deleteWeaponLogic = new DeleteWeaponLogic();
			Boolean result = deleteWeaponLogic.execute(weaponIds);

			if (!result) {

				request.setAttribute("message", "削除に失敗しました");

			} else {

				request.setAttribute("message", "削除に成功しました");
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteWeaponResult.jsp");
			dispatcher.forward(request, response);

		} else {

			HttpSession session = request.getSession();
			session.setAttribute("message", "削除対象のブキを選択してください");

			response.sendRedirect("WeaponListServlet");

		}

	}

}
