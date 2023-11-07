package com.lychee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService extends IService<Menu> {
    ResponseResult<?> getInfo();

    List<String> selectPermsByUserId(Long id);

}
