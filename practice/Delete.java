package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Delete {
	public static void DeleteWeapons() {
		Weapon weapon = new Weapon();
		String databeseName = "splatoon3";
		String propaties = "?characterEncoding=UTF-8&useSSL=false";
		String url = "jdbc:mySQL://localhost/" + databeseName + propaties;
		//DB接続用・ユーザ定数
		String user = "test";
		String pass = "2525";
		System.out.println("データベースから武器を削除します");
		try (Scanner scanner = new Scanner(System.in)) {
			//武器の名前
			System.out.println("削除する武器名を入力");
			weapon.setWeaponName(scanner.next());
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

			String sql = "DELETE FROM test_table where name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, weapon.getWeaponName());

			pstmt.executeUpdate();
			pstmt.close();

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
	}

}