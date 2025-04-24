package util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import model.Action;

public class ActionLoader {
	private static final ResourceBundle bundle = ResourceBundle.getBundle("actions");

	public static Map<String, ActionData> loadActions() {
		Map<String, ActionData> actions = new HashMap<>();

		for (String key : bundle.keySet()) {
			String value = bundle.getString(key);
			String[] parts = value.split("@", 3); // 最大3つに分割

			if (parts.length < 3) {
				System.err.println("無効なフォーマット: " + value);
				continue;
			}

			String className = parts[0]; // クラス名
			String successJspPath = parts[1]; // 成功時の遷移先
			String failureJspPath = parts[2]; // 失敗時の遷移先

			try {
				Class<?> actionClass = Class.forName("model." + className);
				Action actionInstance = (Action) actionClass.getDeclaredConstructor().newInstance();

				actions.put(key, new ActionData(actionInstance, successJspPath, failureJspPath));
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("アクションのロードに失敗しました: " + className);
			}
		}

		return actions;
	}
}
