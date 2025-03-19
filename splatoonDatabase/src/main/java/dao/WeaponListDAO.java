package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DTO.WeaponListDTO;
import model.Weapon;
import util.DBConnectionManager;

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
	public List<Weapon> searchWeaponDataPartial(String[] searchBy, String searchKeyword) {

		List<Weapon> weaponList = new ArrayList<Weapon>();
		//SELECT文を準備
		StringBuilder sql = new StringBuilder("SELECT * FROM weapons");//メモ：Stringより文字列連結の効率が良い
		Set<String> set = new HashSet<String>(Arrays.asList(searchBy));
		List<String> conditions = new ArrayList<>();
		List<String> params = new ArrayList<>();

		if (searchBy != null && searchBy.length > 0) {
			// 検索項目が存在する場合条件式を追加
			sql.append(" WHERE ");
			if (set.contains("type")) {
				conditions.add("type LIKE ?");
			}
			if (set.contains("name")) {
				conditions.add("name LIKE ?");
			}
			if (set.contains("range")) {
				conditions.add("weapon_range LIKE ?");
			}
			if (set.contains("damage")) {
				conditions.add("damage LIKE ?");
			}
			if (set.contains("sub")) {
				conditions.add("sub LIKE ?");
			}
			if (set.contains("special")) {
				conditions.add("special LIKE ?");
			}
			// joinでORを追加し結合
			sql.append(String.join(" OR ", conditions));
		}

		for (int i = 0; i < conditions.size(); i++) {
			params.add("%" + searchKeyword + "%");
		}

		//データベースに接続
		try {
			Connection conn = DBConnectionManager.getConnection();
			PreparedStatement pStmt = conn.prepareStatement(sql.toString());

			for (int i = 0; i < params.size(); i++) {
				pStmt.setString(i + 1, params.get(i));
			}

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
	public List<Weapon> searchWeaponDataExact(String[] searchBy, String searchKeyword) {

		List<Weapon> weaponList = new ArrayList<Weapon>();
		//SELECT文を準備
		StringBuilder sql = new StringBuilder("SELECT * FROM weapons");
		Set<String> set = new HashSet<String>(Arrays.asList(searchBy));
		List<String> conditions = new ArrayList<>();
		List<String> params = new ArrayList<>();

		if (searchBy != null && searchBy.length > 0) {
			sql.append(" WHERE ");
			if (set.contains("type")) {
				conditions.add("type = ?");
			}
			if (set.contains("name")) {
				conditions.add("name = ?");
			}
			if (set.contains("range")) {
				conditions.add("weapon_range = ?");
			}
			if (set.contains("damage")) {
				conditions.add("damage = ?");
			}
			if (set.contains("sub")) {
				conditions.add("sub = ?");
			}
			if (set.contains("special")) {
				conditions.add("special = ?");
			}
			sql.append(String.join(" OR ", conditions));
		}

		for (int i = 0; i < conditions.size(); i++) {
			params.add(searchKeyword);
		}

		//データベースに接続
		try {

			Connection conn = DBConnectionManager.getConnection();
			PreparedStatement pStmt = conn.prepareStatement(sql.toString());

			for (int i = 0; i < params.size(); i++) {
				pStmt.setString(i + 1, params.get(i));
			}

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

	// ブキ編集画面
	public WeaponListDTO editWeapon(Weapon editWeapon) {
		WeaponListDTO weaponListDTO = new WeaponListDTO();
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
				weaponListDTO.setMessage("ブキデータの更新に失敗しました");
			} else {
				weaponListDTO.setMessage("ブキデータの更新に成功しました");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("エラーが発生しました");
			return weaponListDTO;
		}
		return weaponListDTO;

	}

	// ブキ削除
	public WeaponListDTO deleteWeapon(String[] weaponIds) {
		// TODO 自動生成されたメソッド・スタブ
		WeaponListDTO weaponListDTO = new WeaponListDTO();
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
					weaponListDTO.setMessage("データの削除に失敗しました");
				} else {
					weaponListDTO.setMessage("データの削除に成功しました");
				}
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("エラーが発生しました");
			return weaponListDTO;
		}
		return weaponListDTO;

	}

	// ブキ登録画面
	public WeaponListDTO registerWeapon(Weapon weapon) {
		// TODO 自動生成されたメソッド・スタブ
		WeaponListDTO weaponListDTO = new WeaponListDTO();
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
				weaponListDTO.setMessage("ブキデータの登録に失敗しました");
			} else {
				weaponListDTO.setMessage("ブキデータの登録に成功しました");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("エラーが発生しました");
			return weaponListDTO;
		}
		return weaponListDTO;
	}

}
