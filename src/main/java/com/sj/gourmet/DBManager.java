package com.sj.gourmet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// db���� �۾��� �Ҷ� �����ڵ带 �� ���Ŀ� �۾� �ؿ�
// �� ���� ����

// �װ� AOP ����
public class DBManager {

	// db�۾��ÿ� ��¶�� ���� �ؾߵ�
	public static Connection connect() throws SQLException {
		// ����
		String url = "jdbc:oracle:thin:@DB202204301707_high?TNS_ADMIN=C:\\Users\\82103\\OneDrive\\���� ȭ��\\Wallet_DB202204301707";
		System.out.println("���� ����!");
		return DriverManager.getConnection(url, "MACUSER", "Soldesk802!!!");
	}

	// ������ ������ �ѹ��� �ݱ�
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
