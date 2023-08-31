package mapper;

import pojo.Brand;
import pojo.hetong;

import java.util.List;

public interface hetongMapper {


    void addHetong(hetong hetong);

    public List<hetong> selectall();
}
