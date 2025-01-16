package servlet;

import java.util.ArrayList;
import java.util.List;

public class ValueCheck {
	public List<String> createWeaponValueCheck(String type, String name, String range, String damage, String sub,
			String special) {
		List<String> errors = new ArrayList<>();
		// ブキ名の入力チェック
		if (name.length() > 20) {
			errors.add("名前は20文字以内で入力してください。");
		}

		// ブキの種類の入力チェック
		if (!type.matches("^[ァ-ヶー]+$")) {
			errors.add("種類は全角カタカナで入力してください。");
		} else if (type.length() > 10) {
			errors.add("種類は10文字以内で入力してください。");
		}

		// 射程の入力チェック
		if (!range.matches("^[0-9.]+$")) {
			errors.add("射程は半角数字と.(ドット)で入力してください。");
		} else if (range.length() > 5) {
			errors.add("射程は5桁以内で入力してください。");
		}

		// ダメージの入力チェック
		if (!damage.matches("^[0-9.]+$")) {
			errors.add("ダメージは半角数字と.(ドット)で入力してください。");
		} else if (damage.length() > 5) {
			errors.add("ダメージは5桁以内で入力してください。");
		}

		// サブウェポンの入力チェック
		if (!sub.matches("^[ァ-ヶー]+$")) {
			errors.add("サブは全角カタカナで入力してください。");
		} else if (sub.length() > 20) {
			errors.add("サブは20文字以内で入力してください。");
		}

		// スペシャルウェポンの入力チェック
		if (!special.matches("^[ァ-ヶー]+$")) {
			errors.add("スペシャルは全角カタカナで入力してください。");
		} else if (special.length() > 20) {
			errors.add("スペシャルは20文字以内で入力してください。");
		}

		return errors;
	}

}
