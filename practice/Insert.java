package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Insert {
	public static ArrayList<String> insertWeapons() {
		Weapon weapon = new Weapon();
		ArrayList<String> weaponData = new ArrayList<>();
		String databeseName = "splatoon3";
		String propaties = "?characterEncoding=UTF-8&useSSL=false";
		String url = "jdbc:mySQL://localhost/" + databeseName + propaties;
		//DB接続用・ユーザ定数
		String user = "test";
		String pass = "2525";
		System.out.println("データベースに武器を登録します");
		try (Scanner scanner = new Scanner(System.in)) {
			//武器の名前
			System.out.println("武器名を入力");
			weapon.setWeaponName(scanner.next());
			//武器の種類
			System.out.println("武器の種類を入力");
			weapon.setWeaponType(scanner.next());
			//射程
			System.out.println("武器の射程を入力");
			weapon.setWeaponRange(scanner.next());
			//威力
			System.out.println("武器の威力を入力");
			weapon.setWeaponDamage(scanner.next());
			//スペシャル
			System.out.println("武器のスペシャルを入力");
			weapon.setWeaponSpecial(scanner.next());
			//サブ
			System.out.println("武器のサブを入力");
			weapon.setWeaponSub(scanner.next());

			weaponData.add(weapon.getWeaponName());
			weaponData.add(weapon.getWeaponType());
			weaponData.add(weapon.getWeaponRange());
			weaponData.add(weapon.getWeaponDamage());
			weaponData.add(weapon.getWeaponSub());
			weaponData.add(weapon.getWeaponSpecial());

			scanner.close();

		} catch (InputMismatchException e) {
			System.out.println("入力エラー");
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("ドライバのロードに失敗しました。");
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("データベース接続完了");

			String sql = "INSERT INTO test_table (name, type, damage, special, sub, syatei)\n"
					+ "VALUES(?,?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			int j = 1;
			for (int i = 0; i < weaponData.size(); i++) {
				pstmt.setString(j, weaponData.get(i));
				j++;
			}
			pstmt.executeUpdate();
			pstmt.close();
			return weaponData;

		} catch (SQLException e) {
			System.out.println("エラーが発生");
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}