package com.lychee.service;

import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.User;

public interface BlogLoginService {

    ResponseResult login(User user);

}
