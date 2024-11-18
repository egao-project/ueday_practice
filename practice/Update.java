package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Update {
	public static void UpdateWeapons() {
		String updateValue = null;
		int whereId = 0;
		String databeseName = "splatoon3";
		String propaties = "?characterEncoding=UTF-8&useSSL=false";
		String url = "jdbc:mySQL://localhost/" + databeseName + propaties;
		//DB接続用・ユーザ定数
		String user = "test";
		String pass = "2525";
		System.out.println("登録内容を更新します");
		try (Scanner scanner = new Scanner(System.in)) {
			//UPDATEしたい内容を入力
			System.out.println("更新後の値を入力");
			updateValue = scanner.next();
			//WHEREの条件式を入力
			System.out.println("条件を入力");
			whereId = scanner.nextInt();

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

			String sql = "UPDATE test_table SET name = ? WHERE id = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updateValue);
			pstmt.setInt(2, whereId);
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