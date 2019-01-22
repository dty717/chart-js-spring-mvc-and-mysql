package info.mapper;

import info.domain.Data;
import java.util.List;
import java.util.Date;
import org.apache.ibatis.annotations.Param;

public interface DataMapper {

    public List<Data>getData(@Param("start")Date start,@Param("end")Date end);
    public List<Data>getDataById(@Param("start")long start,@Param("end")long end);

}
