package javnangcao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// do mình dung mysql nen se su dung drever nay
		String driverName="com.mysql.cj.jdbc.Driver";
		// Sau do se tao URL cuar DB
		String jdbcUrl="jdbc:mysql://localhost:3306/mydb?useSSL=false";
		//accout cua mysql
		String user="hdstudent";
		String pass="hdstudent";
		//cac buoc ket noi csdl voi java
		//khai bao 1 arraylist chua cac bien cua student
		ArrayList<Student> myList = new ArrayList<>();
		//1. load drive xuong
		try {
			Class.forName(driverName);
			//2. tao connection voi database
			Connection myConn=DriverManager.getConnection(jdbcUrl, user, pass);
			//3. tao doi tuong statement
			String sql="SELECT * FROM mydb.studentdau;";
			PreparedStatement stmt=myConn.prepareStatement(sql);
			//4. thuc hien cau lenh try van
			ResultSet result=stmt.executeQuery();
			//5. lay du lien tu database ra man hinh
			while (result.next()) {
				int idTmp = result.getInt(1);
				String fnTmp = result.getString(2);
				String lnTmp = result.getString(3);
				String eTmp = result.getString(4);
				Student stuTmp = new Student(idTmp, fnTmp, lnTmp, eTmp);
				myList.add(stuTmp);
			}
			//6. dong ket noi(quang trong)
			result.close();
			stmt.close();
			myConn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//in myList ra nam hinh
		for (Student student : myList) {
			System.out.println("The student is: "+student.toString());
		}
	}

}
