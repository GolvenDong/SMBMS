package com.golven.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.golven.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
