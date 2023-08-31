package service;



import pojo.HBase;
import pojo.PageBean;

import java.util.List;

public interface HbaseService {

    /**
     * 查询所有
     * @return
     */
    List<HBase> selectAll();

    /**
     * 添加数据
     * @param hbase
     */
    void add(HBase hbase);


   /* *//**
     * 批量删除
     * @param ids
     *//*
    void deleteByIds( int[] ids);*/

  /*  *//**
     * 分页查询
     * @param currentPage  当前页码
     * @param pageSize   每页展示条数
     * @return
     *//*
    PageBean<Hbase>  selectByPage(int currentPage,int pageSize);
*/
    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param hbase
     * @return
     */
    PageBean<HBase> selectByPageAndCondition(int currentPage, int pageSize, HBase hbase);

}
