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
				String range = rs.getString("weapon_range");
				String damage = rs.getString("damage");
				String sub = rs.getString("sub");
				String special = rs.getString("special");
				Weapon weapon = new Weapon(weaponId, type, name, range, damage, sub, special);
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

	//	public boolean updateWeapon(EditWeapon editWeapon) {
	public boolean updateWeapon(Weapon editWeapon) {
		// TODO 自動生成されたメソッド・スタブ
		int weaponId = editWeapon.getWeaponId();
		String type = editWeapon.getType();
		String name = editWeapon.getName();
		String range = editWeapon.getRange();
		String damage = editWeapon.getDamage();
		String sub = editWeapon.getSub();
		String special = editWeapon.getSpecial();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "UPDATE weapons SET type = ?, name = ?, weapon_range = ?, damage = ?, sub = ?, special = ? WHERE weapon_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, type);
			pStmt.setString(2, name);
			pStmt.setString(3, range);
			pStmt.setString(4, damage);
			pStmt.setString(5, sub);
			pStmt.setString(6, special);
			pStmt.setInt(7, weaponId);

			int result = pStmt.executeUpdate();

			if (result == 0) {
				return false;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("エラーが発生しました");
			return false;
		}
		return true;

	}

	public boolean deleteWeapon(String[] weaponIds) {
		// TODO 自動生成されたメソッド・スタブ

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		} //データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "DELETE FROM weapons WHERE weapon_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			for (String weaponId : weaponIds) {
				pStmt.setString(1, weaponId);
				int result = pStmt.executeUpdate();
				if (result == 0) {
					return false;
				}
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("エラーが発生しました");
			return false;
		}
		return true;

	}

	public boolean createWeapon(Weapon weapon) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "INSERT INTO weapons (type, name, weapon_range, damage, sub, special)\n"
					+ "VALUE(?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, weapon.getType());
			pStmt.setString(2, weapon.getName());
			pStmt.setString(3, weapon.getRange());
			pStmt.setString(4, weapon.getDamage());
			pStmt.setString(5, weapon.getSub());
			pStmt.setString(6, weapon.getSpecial());

			int result = pStmt.executeUpdate();

			if (result == 0) {
				return false;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("エラーが発生しました");
			return false;
		}
		return true;
	}

}
