package com.hj.approvalprocess.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hj.approvalprocess.entity.User;
import com.hj.approvalprocess.mapper.UserMapper;
import com.hj.approvalprocess.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
