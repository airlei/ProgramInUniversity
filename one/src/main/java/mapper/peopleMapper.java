package mapper;

import org.apache.ibatis.annotations.Param;

public interface peopleMapper {

    String Search(@Param("id") String id,@Param("phone") String phone);


}
