package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import service.LoginUser;

public class AccountsDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost/splatoon3_database";
	private final String DB_USER = "test";
	private final String DB_PASS = "2525";

	public Account findByLogin(LoginUser loginUser) {
		Account account = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "SELECT user_id, pass, name\n"
					+ "FROM accounts WHERE user_id=? AND pass=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginUser.getUser_id());
			pStmt.setString(2, loginUser.getPass());

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				String user_id = rs.getString("user_id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				account = new Account(user_id, pass, name);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("エラーが発生しました");
			return null;
		}
		return account;
	}

	//すべての登録済みアカウントをデータベースから取得する
	public List<Account> allAccountData() {

		List<Account> accountList = new ArrayList<Account>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "SELECT * FROM accounts";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String user_id = rs.getString("user_id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				Account account = new Account(user_id, pass, name);
				accountList.add(account);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("エラーが発生しました");
			return null;
		}
		return accountList;
	}

	//新たなアカウントをデータベースに登録する
	public boolean createAccount(Account account) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "INSERT INTO accounts (user_id, pass, name)\n"
					+ "VALUE(?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getName());

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

	//選択したアカウントの情報を更新する
	public boolean updateAccount(String userId, String newName) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		} //データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//UPDATE文を準備
			String sql = "UPDATE accounts SET name = ? WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, newName);
			pStmt.setString(2, userId);
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

	//選択したアカウントをデータベースから削除する
	public boolean deleteAccount(String[] userIds) {
		// TODO 自動生成されたメソッド・スタブ

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		} //データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文を準備
			String sql = "DELETE FROM accounts WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			for (String userId : userIds) {
				pStmt.setString(1, userId);
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
}
