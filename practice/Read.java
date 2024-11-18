package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Read {

	public static ArrayList<Weapon> readWeapons() {
		String databeseName = "splatoon3";
		String propaties = "?characterEncoding=UTF-8&useSSL=false";
		String url = "jdbc:mySQL://localhost/" + databeseName + propaties;
		//DB接続用・ユーザ定数
		String user = "test";
		String pass = "2525";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("ドライバのロードに失敗しました。");
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("データベース接続完了");

			String sql = "SELECT * FROM test_table;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			ArrayList<Weapon> weapons = new ArrayList<>();
			while (resultSet.next()) {
				Weapon weapon = new Weapon();
				weapon.setWeaponName(resultSet.getString("name"));
				weapon.setWeaponRange(resultSet.getString("syatei"));
				weapon.setWeaponDamage(resultSet.getString("damage"));
				weapon.setWeaponSpecial(resultSet.getString("special"));
				weapon.setWeaponSub(resultSet.getString("sub"));
				weapon.setWeaponType(resultSet.getString("type"));
				weapons.add(weapon);
			}
			resultSet.close();
			pstmt.close();
			return weapons;

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
		//		System.out.println();
		return null;

	}

}