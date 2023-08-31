package Dao;

import Bean.bean;
import Bean.bean4;
import  Util.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class select {

    public void selectjihua0(ArrayList<bean> book) throws ClassNotFoundException, SQLException {
        Connection connection= Util.util.getConnection();
//        String sql1="SELECT day_id,sale_nbr,SUM(cnt) as cnt,SUM(round0) as round FROM text3_1 GROUP BY sale_nbr,day_id limit 10";
        String sql1="SELECT * FROM text3_1 ORDER BY RAND() LIMIT 100";
        PreparedStatement pre=null;
        PreparedStatement ps=connection.prepareStatement(sql1);
        ResultSet rs =  ps.executeQuery();//获取结果集
        if (rs == null) {
            System.out.println("连接数据库成功");
        }
        while(rs.next()) {
            bean A=new bean();
            A.setDay_id(rs.getString(1));
            A.setSale_nbr(rs.getString(2));
            A.setCnt(rs.getString(3));
            A.setRound(rs.getString(4));
            book.add(A);
        }

    }
    public void selectjihua4(ArrayList<bean4> book) throws ClassNotFoundException, SQLException {
        Connection connection= Util.util.getConnection();
//        String sql1="SELECT day_id,sale_nbr,SUM(cnt) as cnt,SUM(round0) as round FROM text3_1 GROUP BY sale_nbr,day_id limit 10";
        String sql1="SELECT * FROM text3_4 where lirun < 1000000 and lirun>-1000000 ORDER BY RAND() LIMIT 10000";
        PreparedStatement pre=null;
        PreparedStatement ps=connection.prepareStatement(sql1);
        ResultSet rs =  ps.executeQuery();//获取结果集
        while(rs.next()) {
            bean4 A=new bean4();
            A.setDay_id(rs.getString(1));
            A.setBuy_nbr(rs.getString(2));
            A.setIncnt(rs.getString(3));
            A.setInround(rs.getString(4));
            A.setOutcnt(rs.getString(5));
            A.setOutround(rs.getString(6));
            A.setLirun(rs.getString(7));
            book.add(A);
        }

    }
}
