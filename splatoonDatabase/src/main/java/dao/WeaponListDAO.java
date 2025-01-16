package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Weapon;

public class WeaponListDAO {
	// ブキのリストを全件取得
	public List<Weapon> allWeaponData() {

		List<Weapon> weaponList = new ArrayList<Weapon>();
		//SELECT文を準備
		String sql = "SELECT * FROM weapons";

		//データベースに接続
		try {
			Connection conn = DBConnectionManager.getConnection();
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

	// ブキのリストをフィルタリングして取得(部分一致)
	public List<Weapon> searchWeaponDataPartial(String searchBy, String searchKeyword) {

		List<Weapon> weaponList = new ArrayList<Weapon>();
		//SELECT文を準備
		String sql = "SELECT * FROM weapons WHERE " + searchBy + " LIKE ?";

		//データベースに接続
		try {
			Connection conn = DBConnectionManager.getConnection();
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, searchKeyword);

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

	// ブキのリストをフィルタリングして取得(完全一致)
	public List<Weapon> searchWeaponDataExact(String searchBy, String searchKeyword) {

		List<Weapon> weaponList = new ArrayList<Weapon>();
		//SELECT文を準備
		String sql = "SELECT * FROM weapons WHERE " + searchBy + " = ?";

		//データベースに接続
		try {

			Connection conn = DBConnectionManager.getConnection();
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, searchKeyword);

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

	//ブキ編集の際に、初期値を設定するためのメソッド
	public Weapon editWeaponData(String weaponId) {
		//SELECT文を準備
		String sql = "SELECT type, name, weapon_range, damage, sub, special FROM weapons WHERE weapon_id = ?";
		Weapon weapon = new Weapon();

		//データベースに接続
		try {
			Connection conn = DBConnectionManager.getConnection();

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, weaponId);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String type = rs.getString("type");
				String name = rs.getString("name");
				String range = rs.getString("weapon_range");
				String damage = rs.getString("damage");
				String sub = rs.getString("sub");
				String special = rs.getString("special");
				weapon = new Weapon(type, name, range, damage, sub, special);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("エラーが発生しました");
			return null;
		}
		return weapon;
	}

	public boolean updateWeapon(Weapon editWeapon) {
		// TODO 自動生成されたメソッド・スタブ
		int weaponId = editWeapon.getWeaponId();
		String type = editWeapon.getType();
		String name = editWeapon.getName();
		String range = editWeapon.getRange();
		String damage = editWeapon.getDamage();
		String sub = editWeapon.getSub();
		String special = editWeapon.getSpecial();

		//UPDATE文を準備
		String sql = "UPDATE weapons SET type = ?, name = ?, weapon_range = ?, damage = ?, sub = ?, special = ? WHERE weapon_id = ?";

		//データベースに接続
		try {
			Connection conn = DBConnectionManager.getConnection();

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
		//DELETE文を準備
		String sql = "DELETE FROM weapons WHERE weapon_id = ?";

		//データベースに接続
		try {
			Connection conn = DBConnectionManager.getConnection();

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
		//INSERT文を準備
		String sql = "INSERT INTO weapons (type, name, weapon_range, damage, sub, special)\n"
				+ "VALUE(?,?,?,?,?,?)";
		//データベースに接続
		try {
			Connection conn = DBConnectionManager.getConnection();

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
