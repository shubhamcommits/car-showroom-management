import java.io.*;
import java.sql.*;
public class file_reader {
 private static final String file ="C:\\Users\\SHUBHAM\\Desktop\\Biotech\\microbial_name.txt";
 public static void main(String args[]){
	 try{
		 BufferedReader br = new BufferedReader(new FileReader(file));
		 String sCurrentLine = null;
		 Class.forName("java.sql.Driver");
                 int s=0;
		 Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost/biotech","root","shubham3597");
		 Statement stmt= conn1.createStatement();
		 
			while ((sCurrentLine = br.readLine()) != null) {
				String qry="insert into microbial_name values('"+sCurrentLine+"')";
				int rs=stmt.executeUpdate(qry);
                                s++;
				}
                        System.out.println(s);
	 }
	 catch(IOException | ClassNotFoundException | SQLException e){
		 e.printStackTrace();
	 }
 }
}
