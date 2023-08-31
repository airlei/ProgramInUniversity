package Servlet;

import Bean.bean;
import Dao.select;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "Servletselect", value = "/Servletselect")
public class Servletselect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        ArrayList<bean> book = new ArrayList<bean>();
        select dao=new select();
        try {
            dao.selectjihua0(book);
            System.out.println("1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("2");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("3");
        }
        System.out.println("*****************");
            String json = JSON.toJSONString(book);
            response.getWriter().write(json);
    }
}
