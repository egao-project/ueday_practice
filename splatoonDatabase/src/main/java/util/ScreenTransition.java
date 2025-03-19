package util;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ScreenTransition {

	// forward の共通メソッド
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	// sendRedirect の共通メソッド
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url)
			throws IOException {
		String contextPath = request.getContextPath();
		String action = request.getParameter("action");

		if (action != null && !action.isEmpty()) {
			url += "?action=" + action;
		}

		response.sendRedirect(contextPath + "/" + url);
	}
}
