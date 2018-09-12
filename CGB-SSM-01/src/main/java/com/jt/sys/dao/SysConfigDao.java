package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysConfig;

public interface SysConfigDao {

	List<SysConfig> findPageObjects(@Param("name")String name, 
									@Param("startIndex")Integer startIndex, 
									@Param("pageSize")Integer pageSize);
	
	int getRowCount(@Param("name")String name);
}
