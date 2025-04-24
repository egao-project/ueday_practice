package util;

import java.util.Map;

public class JudgeParams {
	public static String[] getReqParam(String key, Map<String, String[]> sessionMap, Map<String, String[]> paramMap) {
		if (paramMap != null && paramMap.containsKey(key)) {
			// リクエストパラメータが存在していればセッションより優先して取得する
			return paramMap.get(key);
		} else if (sessionMap != null && sessionMap.containsKey(key)) {
			return sessionMap.get(key);
		}
		return null;
	}
}
