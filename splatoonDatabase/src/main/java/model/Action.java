package model;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;

public interface Action {

	void pretreatment(Map<String, String[]> parameterMap, Map<String, String[]> sessionParams);

	ExecuteResult execute(Map<String, String[]> parameterMap, Map<String, String[]> sessionParams)
			throws ServletException, IOException;

	void postProcessing();
}
