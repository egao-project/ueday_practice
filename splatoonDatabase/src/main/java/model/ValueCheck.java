package model;

import java.util.ArrayList;
import java.util.List;

public class ValueCheck {
	public List<String> createWeaponValueCheck(String type, String name, String range, String damage, String sub,
			String special) {
		List<String> errors = new ArrayList<>();

		if (!name.matches("^.{1,20}$") || name.length() > 20) {
			errors.add("名前は20文字以内で入力してください。");
		}
		if (!type.matches("^[ァ-ヶー]{1,10}+$") || type.length() > 10) {
			errors.add("種類は全角カタカナ、10文字以内で入力してください。");
		}
		if (!range.matches("^[0-9.]{1,5}+$") || range.length() > 10) {
			errors.add("射程は半角数字と.(ドット)、5文字以内で入力してください。");
		}
		if (!damage.matches("^[0-9.]{1,10}+$") || damage.length() > 10) {
			errors.add("ダメージは半角数字と.(ドット)、10文字以内で入力してください。");
		}
		if (!sub.matches("^[ァ-ヶー]{1,20}+$") || sub.length() > 20) {
			errors.add("サブは全角カタカナ、20文字以内で入力してください。");
		}
		if (!special.matches("^[ァ-ヶー]{1,20}+$") || special.length() > 20) {
			errors.add("スペシャルは全角カタカナ、20文字以内で入力してください。");
		}

		return errors;
	}

}
