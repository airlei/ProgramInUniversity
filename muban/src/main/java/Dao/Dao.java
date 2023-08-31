//增删改查操作
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBUtil.DBUtil;

import Bean.Bean;

 class dao {
    //增
    public boolean add(Bean bean)
    {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;
        int a=0;
        try {
            String sql = "insert into teacher(one,two,three) value(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.get_one());
            pstmt.setString(2, bean.get_two());
            pstmt.setString(3, bean.get_three());

            a = pstmt.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(pstmt, conn);
        }
        if(a>0)
            f=true;

        return f;
    }



    //删

    public boolean delete(Bean bean ) {
        Connection conn = DBUtil.getConn();
        PreparedStatement pstmt = null;
        boolean f = false;

        try {

            String sql="delete from school where classname=  xxxx";
            pstmt = conn.prepareStatement(sql);
            int i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            if(i>0) f = true;
        }catch(SQLException e) {
            System.out.println("删除失败");
            e.printStackTrace();
        }

        return f;

    }







    //改

    public boolean update (Bean bean) {
        String sql = "update teacher set one='" + bean.get_one() + "', two='" + bean.get_two()
                + "', three='" +bean.get_three() + "'where tpid='" + bean.get_one() + "'";//双引号里面的单引号里面的双引号就是需要修改的
        Connection conn = DBUtil.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;
        try {
            state = conn.createStatement();

            a = state.executeUpdate(sql);
            System.out.println(a);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }
        System.out.println(f);
        return f;
    }











    ///查
    public  int searchPid(String username,String password)
    {
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        int pid=0;
        try {
            String sql="select pid from user where username= '"+username+"' and password='"+password+"'";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while(rs.next()){
                pid = rs.getInt("pid");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(state, conn);
        }
        return pid;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
