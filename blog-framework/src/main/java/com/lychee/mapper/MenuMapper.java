package com.lychee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lychee.domain.entity.Menu;

import java.util.List;

/**
 * 菜单权限表(Menu)表数据库访问层
 * @author lee
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long id);

}
