package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class SqlPractice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("番号を選択してください。\n" +
				"１．参照\n" +
				"２．登録\n" +
				"３．更新\n" +
				"４．削除\n");
		int i = scanner.nextInt();
		switch (i) {
		case 1:
			ArrayList<Weapon> readWeaponsData = Read.readWeapons();
			System.out.println("参照結果");
			for (Weapon weapon : readWeaponsData) {
				System.out.println("武器名：" + weapon.getWeaponName() + "\n"
						+ "武器種：" + weapon.getWeaponType() + "\n"
						+ "射程：" + weapon.getWeaponRange() + "\n"
						+ "ダメージ：" + weapon.getWeaponDamage() + "\n"
						+ "サブ：" + weapon.getWeaponSub() + "\n"
						+ "スペシャル：" + weapon.getWeaponSpecial() + "\n");
			}

			break;
		case 2:
			ArrayList<String> insertWeapon = Insert.insertWeapons();
			System.out.println("以下の内容で登録しました");
			System.out.println("武器名：" + insertWeapon.get(0) + "\n"
					+ "武器種：" + insertWeapon.get(1) + "\n"
					+ "射程：" + insertWeapon.get(2) + "\n"
					+ "ダメージ：" + insertWeapon.get(3) + "\n"
					+ "サブ：" + insertWeapon.get(4) + "\n"
					+ "スペシャル：" + insertWeapon.get(5) + "\n");
			break;
		case 3:
			Update.UpdateWeapons();
			System.out.println("更新しました");
			break;
		case 4:
			Delete.DeleteWeapons();
			System.out.println("削除しました");
			break;

		default:
			scanner.close();
			throw new IllegalArgumentException("Unexpected value: " + i);
		}
		scanner.close();
	}
}
