package com.demo.mapper;

import com.demo.pojo.DemoRole;
import com.demo.pojo.DemoRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoRoleMapper {
    int countByExample(DemoRoleExample example);

    int deleteByExample(DemoRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DemoRole record);

    int insertSelective(DemoRole record);

    List<DemoRole> selectByExample(DemoRoleExample example);

    DemoRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemoRole record, @Param("example") DemoRoleExample example);

    int updateByExample(@Param("record") DemoRole record, @Param("example") DemoRoleExample example);

    int updateByPrimaryKeySelective(DemoRole record);

    int updateByPrimaryKey(DemoRole record);
}