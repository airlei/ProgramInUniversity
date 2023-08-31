package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    //查询所有
    public List<Brand> selectAll();

    //查看详情
    public Brand selectById(int id);


    //条件查询
//    List<Brand> selectByCondition(@Param("status")int status,@Param("companyName") String companyName,
//                                  @Param("brandName") String brandName);
//      List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);



    //单条件动态查询
    List<Brand> selectByConditionSingle(Brand brand);


    //添加
    void add(Brand brand);



    //修改
    int update(Brand brand);


    //删除一个
    void deleteById(int  id);

    //批量删除
    void  deleteByIds(@Param("ids") int[] ids);
}


