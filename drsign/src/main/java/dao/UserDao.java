package dao;

import dbutil.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UserDao {
    public boolean findUser(String username, String password) {
        //准备SQL语句
        String sql = "select * from tb_user where username ='" + username + "'";
        Connection conn= DBUtil.getConn();
    //创建语句传输对象
        Statement state = null;
        ResultSet rs= null;
        int flag=0;
        String c_password=null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while(rs.next()) {
                ++flag;
                c_password=rs.getString("password");
            } if (flag == 0) {
                return false;
            }
            if (!password.equals(c_password)) {   //判断密码
                return false;
            }
        }catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, state, conn);
        }
        return true;
    }
}