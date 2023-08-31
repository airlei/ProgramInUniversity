package servlet;

import dao.Dao;
import pojo.hetong;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    Dao dao = new Dao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");// 设置字符集，避免乱码
        // 获取jsp界面需要进行的操作，
        String method = request.getParameter("method");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("method----------->"+method);




        if (method!=null && method.equals("add")){
            String name=(String)request.getParameter("name");
            System.out.println(name);
        }else if(method!=null && method.equals("login")){
            login(request,response);
        }else if(method!=null && method.equals("addHetong")){
            addHetong(request,response);

        }



    }

    private void addHetong(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        hetong hetong = new hetong();
        String nameHetong = (String) request.getParameter("nameHetong");
        String nameHuowu = (String) request.getParameter("nameHuowu");
        String selectHuowu = (String) request.getParameter("selectHuowu");
        int color = Integer.parseInt(request.getParameter("color")) ;
        int num = Integer.parseInt(request.getParameter("num")) ;

        String timeQian = (String) request.getParameter("timeQian");
        String timeJiao = (String) request.getParameter("timeJiao");
        int people = Integer.parseInt(request.getParameter("people")) ;
        hetong.setNameHetong(nameHetong);
        hetong.setNameHuowu(nameHuowu);
        hetong.setKind(selectHuowu);
        hetong.setColor(color);
        hetong.setNum(num);
        hetong.setTimeQian(timeQian);
        hetong.setTimeJiao(timeJiao);
        hetong.setPeople(people);
        dao.addHetong(hetong);
        request.setAttribute("message", "添加成功。");
        request.getRequestDispatcher("login.html").forward(request,response);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

    }



    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        String user =  (String)request.getParameter("user");
        String password = (String) request.getParameter("password");

        System.out.println("user"+user);
        if(dao.Search(user,password)){

            String select = request.getParameter("select");

            switch (select) {

                case "1":
                    request.getRequestDispatcher("index1.jsp").forward(request, response);
                    ;
                    break;
                case "2":
                    request.getRequestDispatcher("index2.jsp").forward(request, response);
                    ;
                    break;
                case "3":
                    request.getRequestDispatcher("index3.jsp").forward(request, response);
                    ;
                    break;
                case "4":
                    request.getRequestDispatcher("index4.jsp").forward(request, response);
                    ;
                    break;
                case "5":
                    request.getRequestDispatcher("index5.jsp").forward(request, response);
                    ;
                    break;
                case "6":
                    request.getRequestDispatcher("index6.jsp").forward(request, response);
                    ;
                    break;

                default:
                    break;


            }

        }
        else {
            System.out.println("不存在账号");
        }
    }
}
