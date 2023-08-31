//package service.impl;
//
//import com.itheima.mapper.HbaseMapper;
//import com.itheima.pojo.Hbase;
//import com.itheima.pojo.PageBean;
//import com.itheima.service.HbaseService;
//import com.itheima.util.SqlSessionFactoryUtils;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import pojo.Hbase;
//import pojo.PageBean;
//import service.HbaseService;
//
//import java.util.List;
//
//public class HbaseServiceImpl implements HbaseService {
//    //1. 创建SqlSessionFactory 工厂对象
////    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();//
//
//
//    @Override
//    public List<Hbase> selectAll() {
////        //2. 获取SqlSession对象
////        SqlSession sqlSession = factory.openSession();
////        //3. 获取HbaseMapper
////        HbaseMapper mapper = sqlSession.getMapper(HbaseMapper.class);
////
////        //4. 调用方法
////        List<Hbase> hbases = mapper.selectAll();
////
////        //5. 释放资源
////        sqlSession.close();
//
//        if ()
//
//
//        return null;
//    }
//
//
//
////
////    @Override
////    public void add(Hbase hbase) {
////        //2. 获取SqlSession对象
////        SqlSession sqlSession = factory.openSession();
////        //3. 获取HbaseMapper
////        HbaseMapper mapper = sqlSession.getMapper(HbaseMapper.class);
////
////        //4. 调用方法
////        mapper.add(hbase);
////        sqlSession.commit();//提交事务
////
////        //5. 释放资源
////        sqlSession.close();
////    }
////
////    @Override
////    public void deleteByIds(int[] ids) {
////        //2. 获取SqlSession对象
////        SqlSession sqlSession = factory.openSession();
////        //3. 获取HbaseMapper
////        HbaseMapper mapper = sqlSession.getMapper(HbaseMapper.class);
////
////        //4. 调用方法
////        mapper.deleteByIds(ids);
////
////        sqlSession.commit();//提交事务
////
////        //5. 释放资源
////        sqlSession.close();
////    }
////
////    @Override
////    public PageBean<Hbase> selectByPage(int currentPage, int pageSize) {
////        //2. 获取SqlSession对象
////        SqlSession sqlSession = factory.openSession();
////        //3. 获取HbaseMapper
////        HbaseMapper mapper = sqlSession.getMapper(HbaseMapper.class);
////
////
////        //4. 计算开始索引
////        int begin = (currentPage - 1) * pageSize;
////        // 计算查询条目数
////        int size = pageSize;
////
////        //5. 查询当前页数据
////        List<Hbase> rows = mapper.selectByPage(begin, size);
////
////        //6. 查询总记录数
////        int totalCount = mapper.selectTotalCount();
////
////        //7. 封装PageBean对象
////        PageBean<Hbase> pageBean = new PageBean<>();
////        pageBean.setRows(rows);
////        pageBean.setTotalCount(totalCount);
////
////
////        //8. 释放资源
////        sqlSession.close();
////
////        return pageBean;
////    }
////
////    @Override
////    public PageBean<Hbase> selectByPageAndCondition(int currentPage, int pageSize, Hbase hbase) {
////        //2. 获取SqlSession对象
////        SqlSession sqlSession = factory.openSession();
////        //3. 获取HbaseMapper
////        HbaseMapper mapper = sqlSession.getMapper(HbaseMapper.class);
////
////
////        //4. 计算开始索引
////        int begin = (currentPage - 1) * pageSize;
////        // 计算查询条目数
////        int size = pageSize;
////
////        // 处理hbase条件，模糊表达式
////        String hbaseName = hbase.getHbaseName();
////        if (hbaseName != null && hbaseName.length() > 0) {
////            hbase.setHbaseName("%" + hbaseName + "%");
////        }
////
////        String companyName = hbase.getCompanyName();
////        if (companyName != null && companyName.length() > 0) {
////            hbase.setCompanyName("%" + companyName + "%");
////        }
////
////
////        //5. 查询当前页数据
////        List<Hbase> rows = mapper.selectByPageAndCondition(begin, size, hbase);
////
////        //6. 查询总记录数
////        int totalCount = mapper.selectTotalCountByCondition(hbase);
////
////        //7. 封装PageBean对象
////        PageBean<Hbase> pageBean = new PageBean<>();
////        pageBean.setRows(rows);
////        pageBean.setTotalCount(totalCount);
////
////
////        //8. 释放资源
////        sqlSession.close();
////
////        return pageBean;
////    }
//
//
//}
