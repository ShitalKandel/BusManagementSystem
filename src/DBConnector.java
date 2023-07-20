import java.sql.*;

public class DBConnector {



    public static void main(String[] args) {

        Connection conn;


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
                System.out.println("DB connected");

                Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("Select * from testcase ");
                    while(rs.next()){
                        String name = rs.getString(1);
                        System.out.println(name);
                    }

            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException(ex);


        }
    }
}

