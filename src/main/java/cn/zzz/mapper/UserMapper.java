package cn.zzz.mapper;

import org.apache.ibatis.annotations.Param;

import cn.zzz.entity.User;

public interface UserMapper {

	User getUser(@Param("id") int id);
}
 