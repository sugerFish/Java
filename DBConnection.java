/**
 * 
 */
package mysqlConnectTest;
import java.sql.*;

/**
 * @author ADMIN
 *
 */
public class DBConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����������//���̶�����������
		  String driver = "com.mysql.jdbc.Driver";
		  // URLָ��Ҫ���ʵ����ݿ���******
		  String url = "jdbc:mysql://localhost:3306/DBConnTest";
		  // MySQL����ʱ���û���
		  String user = "root";
		  // Java����MySQL����ʱ������******
		  String password = "root";
		  
		  try{
			// ������������
			  Class.forName(driver);
			  
			  // �������ݿ�
			  Connection conn = DriverManager.getConnection(url, user, password);
			  if(!conn.isClosed())
			   System.out.println("Succeeded connecting to the Database!");
			  
			  // statement����ִ��SQL���
			  Statement statement = conn.createStatement();
			  // Ҫִ�е�SQL���id��content�Ǳ�review�е��
			  String sql = "select * from person";
			  ResultSet rs = statement.executeQuery(sql);  
			  
			  //���idֵ��contentֵ
			  while(rs.next()) {
			   System.out.println(rs.getString("id") + "\t" + rs.getString("name")); 
			   } 
			  
			  rs.close(); 
			  conn.close();  
		  } catch(ClassNotFoundException e) {  
			   System.out.println("Sorry,can`t find the Driver!");  
			   e.printStackTrace();  
		  } catch(SQLException e) {
			   e.printStackTrace();
			   System.out.println(e.getMessage());
		  } catch(Exception e){
			   e.printStackTrace();
			   System.out.println(e.getMessage());
		  }
	}

}
