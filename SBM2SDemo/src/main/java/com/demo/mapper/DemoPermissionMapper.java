package com.demo.mapper;

import com.demo.pojo.DemoPermission;
import com.demo.pojo.DemoPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoPermissionMapper {
    int countByExample(DemoPermissionExample example);

    int deleteByExample(DemoPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DemoPermission record);

    int insertSelective(DemoPermission record);

    List<DemoPermission> selectByExample(DemoPermissionExample example);

    DemoPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemoPermission record, @Param("example") DemoPermissionExample example);

    int updateByExample(@Param("record") DemoPermission record, @Param("example") DemoPermissionExample example);

    int updateByPrimaryKeySelective(DemoPermission record);

    int updateByPrimaryKey(DemoPermission record);
}