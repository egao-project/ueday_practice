package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.UpdateAccountLogic;

/**
 * Servlet implementation class AccountUpdateServlet
 */
@WebServlet("/UpdateAccountServlet")
public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String newName = request.getParameter("newName");

		if (userId == null || newName == null || newName.isEmpty()) {
			response.sendRedirect("AccountListServlet");
			return;
		} else {
			UpdateAccountLogic updateAccountLogic = new UpdateAccountLogic();
			boolean result = updateAccountLogic.execute(userId, newName);

			if (!result) {
				request.setAttribute("message", "更新に失敗しました");
			}
			request.setAttribute("message", "更新に成功しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateAccountResult.jsp");
			dispatcher.forward(request, response);
		}
	}

}
