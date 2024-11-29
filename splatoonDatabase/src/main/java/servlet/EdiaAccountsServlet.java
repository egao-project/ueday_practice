package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.EditAccount;

/**
 * Servlet implementation class EdiaAccountsServlet
 */
@WebServlet("/EdiaAccountsServlet")
public class EdiaAccountsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userIds");
		String newName = request.getParameter("newName");

		EditAccount editAccount = new EditAccount(userId, newName);

		HttpSession session = request.getSession();
		session.setAttribute("editAccount", editAccount);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editAccount.jsp");
		dispatcher.forward(request, response);
	}

}
