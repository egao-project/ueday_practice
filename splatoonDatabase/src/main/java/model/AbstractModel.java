package model;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;

public abstract class AbstractModel implements Action {
	ExecuteResult result = new ExecuteResult(true);

	public abstract ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServletException, IOException;

}
