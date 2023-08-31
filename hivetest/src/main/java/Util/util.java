package Util;


import java.sql.*;


/**
 * JDBC��������
 */
public class util {
    public static Connection getConnection() throws  SQLException {//创建了一个方法后面会调用
        System.out.println("1111111111111");
        Connection con = null;//创建连接对象
        PreparedStatement ps = null;////创建载体
        ResultSet rs = null;//创建结果集对象
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("mysql-con!!");
            e.printStackTrace();
        }
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/text?serverTimezone=UTC&useSSL=false","root","2316811443");//数据库的名称和自己的账号密码记得改！！！
        System.out.println(con);
        return con;
    }

//    public static void main(String[] args) {
//        try {
//            System.out.println(getConnection());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    public static void close(Connection connection ) {
        try {
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void close(PreparedStatement preparedStatement ) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void close(ResultSet resultSet ) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
