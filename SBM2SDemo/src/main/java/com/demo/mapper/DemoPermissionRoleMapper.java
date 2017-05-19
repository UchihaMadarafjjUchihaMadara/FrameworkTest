package com.demo.mapper;

import com.demo.pojo.DemoPermissionRole;
import com.demo.pojo.DemoPermissionRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoPermissionRoleMapper {
    int countByExample(DemoPermissionRoleExample example);

    int deleteByExample(DemoPermissionRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DemoPermissionRole record);

    int insertSelective(DemoPermissionRole record);

    List<DemoPermissionRole> selectByExample(DemoPermissionRoleExample example);

    DemoPermissionRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemoPermissionRole record, @Param("example") DemoPermissionRoleExample example);

    int updateByExample(@Param("record") DemoPermissionRole record, @Param("example") DemoPermissionRoleExample example);

    int updateByPrimaryKeySelective(DemoPermissionRole record);

    int updateByPrimaryKey(DemoPermissionRole record);
}