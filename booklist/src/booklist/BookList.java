package booklist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookList {
	Connection con;  //�������
	Statement stmt;	 //�������
	ResultSet rs;	 //�������
	
	//�������
	//1.����
//	int bookid;
//	String bookname;
//	String publisher;
//	int price;
	
	//2.�迭
//	int bookid_arr[] = new int[11];
//	String bookname_arr[] = new String[11];
//	String publisher_arr[] = new String[11];
//	int price_arr[] = new int[11];
	//3.��ü
	//4.��ü�迭
	
	public BookList() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		/*11g express edition�� orcl ��� XE�� �Է��Ѵ�. */
		String userid = "c##madang";
		String pwd = "c##madang";
		
		try { //����̹��� ã�� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try { //�����ͺ��̽��� �����ϴ� ����
			System.out.println("�����ͺ��̽� ���� �غ�...");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (Exception e) {
			
		}
	}
	
	void printBook() {
		String query = "SELECT * FROM BOOK"; //SQL��
		try { //�����ͺ��̽��� ���� ����� �������� ����
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("BOOK NO \tBOOK NAME \t\tPUBLISHER \tPRICE");
			while(rs.next()) 
			{
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.println("\t" + rs.getInt(4));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BookList so = new BookList();
		so.printBook();
	}

}