package util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import model.Action;

// アクション読み込みクラス
public class ActionLoader {
	private static final ResourceBundle bundle = ResourceBundle.getBundle("actions");

	public static Map<String, Action> loadActions() {
		Map<String, Action> actions = new HashMap<>();
		for (String key : bundle.keySet()) {
			String className = bundle.getString(key);
			try {
				Class<?> actionClass = Class.forName("model." + className);
				Action actionInstance = (Action) actionClass.getDeclaredConstructor().newInstance();
				actions.put(key, actionInstance);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("アクションのロードに失敗しました: " + className);
			}
		}

		return actions;
	}

}
