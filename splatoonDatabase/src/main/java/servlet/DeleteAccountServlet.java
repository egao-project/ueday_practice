package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import service.DeleteAccountLogic;

/**
 * Servlet implementation class AccountEditServlet
 */
@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String[] userIds = request.getParameterValues("userIds");

		if (userIds != null && userIds.length > 0) {

			DeleteAccountLogic deleteAccountLogic = new DeleteAccountLogic();
			Boolean result = deleteAccountLogic.execute(userIds);

			if (!result) {

				request.setAttribute("message", "削除に失敗しました");

			} else {

				request.setAttribute("message", "削除に成功しました");

			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteAccountResult.jsp");
			dispatcher.forward(request, response);

		} else {

			HttpSession session = request.getSession();
			session.setAttribute("message", "削除対象のアカウントを選択してください");

			response.sendRedirect("AccountListServlet");

		}

	}

}
