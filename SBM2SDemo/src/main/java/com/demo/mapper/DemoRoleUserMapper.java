package com.demo.mapper;

import com.demo.pojo.DemoRoleUser;
import com.demo.pojo.DemoRoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DemoRoleUserMapper {
    int countByExample(DemoRoleUserExample example);

    int deleteByExample(DemoRoleUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DemoRoleUser record);

    int insertSelective(DemoRoleUser record);

    List<DemoRoleUser> selectByExample(DemoRoleUserExample example);

    DemoRoleUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemoRoleUser record, @Param("example") DemoRoleUserExample example);

    int updateByExample(@Param("record") DemoRoleUser record, @Param("example") DemoRoleUserExample example);

    int updateByPrimaryKeySelective(DemoRoleUser record);

    int updateByPrimaryKey(DemoRoleUser record);
}