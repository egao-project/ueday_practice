package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Account;
import model.GetAccoutListLogic;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/AccountListServlet")
public class AccountListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		GetAccoutListLogic getAccountListLogic = new GetAccoutListLogic();
		List<Account> accountList = getAccountListLogic.getAllAccountListLogic();

		request.setAttribute("accountList", accountList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/accountList.jsp");
		dispatcher.forward(request, response);

	}

}
