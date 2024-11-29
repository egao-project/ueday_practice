package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Weapon;

public class WeaponListDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost/splatoon3_database";
	private final String DB_USER = "test";
	private final String DB_PASS = "2525";

	public List<Weapon> allWeaponData() {

		List<Weapon> weaponList = new ArrayList<Weapon>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "SELECT * FROM weapons";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int weaponId = rs.getInt("weapon_id");
				String type = rs.getString("type");
				String name = rs.getString("name");
				String weapon_range = rs.getString("weapon_range");
				String damage = rs.getString("damage");
				String sub = rs.getString("sub");
				String special = rs.getString("special");
				Weapon weapon = new Weapon(weaponId, type, name, weapon_range, damage, sub, special);
				weaponList.add(weapon);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("エラーが発生しました");
			return null;
		}
		return weaponList;
	}

}
