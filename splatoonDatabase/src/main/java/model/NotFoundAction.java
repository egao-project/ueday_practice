package model;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;

public class NotFoundAction implements Action {
	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap) throws ServletException, IOException {
		throw new ServletException("404 Not Found: アクションが見つかりません");
	}
}
