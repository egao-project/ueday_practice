package util;

import java.util.HashMap;
import java.util.Map;

public class SessionParamUtil {

	public static Map<String, String[]> sessionParams(Map<String, Object> dataMap) {
		Map<String, String[]> saveMap = new HashMap<>();

		Object searchBy = dataMap.get("searchBy");
		Object searchKeyword = dataMap.get("searchKeyword");
		Object matchType = dataMap.get("matchType");

		if (searchBy != null && searchBy instanceof String[]) {
			saveMap.put("searchBy", (String[]) searchBy);
		}
		if (searchKeyword != null && searchKeyword instanceof String) {
			saveMap.put("searchKeyword", new String[] { (String) searchKeyword });
		}
		if (matchType != null && matchType instanceof String) {
			saveMap.put("matchType", new String[] { (String) matchType });
		}

		return saveMap.isEmpty() ? null : saveMap;
	}
}
