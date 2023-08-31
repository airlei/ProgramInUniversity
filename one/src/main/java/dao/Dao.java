package dao;

import mapper.BrandMapper;
import mapper.hetongMapper;
import mapper.peopleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Brand;
import pojo.hetong;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao {


    public static void main(String[] args) throws IOException {

    }



    public static boolean Search(String id,String phone) throws IOException {

        boolean i = false;
        //1获取sqlSessionFactory
        String resource = "mybatis-config.xml";                                 //配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);      //传入流
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    //返回对象

        //2 获取sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3 获取Mapper接口的代理对象
        peopleMapper brandMapper = sqlSession.getMapper(peopleMapper.class);
        //4 执行方法
        String pid = brandMapper.Search(id,phone);
        if(pid==""||pid==null)
        {

        }else {i = true;}
        System.out.println(pid);
        //5 释放资源
        sqlSession.close();
        return  i;
    }





    //添加

    public  void addHetong(hetong hetong) throws IOException {

        //1获取sqlSessionFactory
        String resource = "mybatis-config.xml";                                 //配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);      //传入流
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    //返回对象

        //2 获取sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3 获取Mapper接口的代理对象
        hetongMapper brandMapper = sqlSession.getMapper(hetongMapper.class);
        //4 执行方法
       brandMapper.addHetong(hetong);

//        //提交事务 或者第二步参数为true
//        sqlSession.commit();
        //5 释放资源
        sqlSession.close();
    }










    public static List<hetong> selectAll() throws IOException {
        List hetong = new ArrayList();
        //1获取sqlSessionFactory
        String resource = "mybatis-config.xml";                                 //配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);      //传入流
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    //返回对象

        //2 获取sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4 执行方法
        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);
        //5 释放资源
        sqlSession.close();
        return hetong;
    }


}
