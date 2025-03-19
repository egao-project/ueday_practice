package model;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;

public interface Action {
	ExecuteResult execute(Map<String, String[]> paramMap) throws ServletException, IOException;
}
