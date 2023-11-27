package com.lychee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.constans.SystemConstants;
import com.lychee.domain.entity.Menu;
import com.lychee.mapper.MenuMapper;
import com.lychee.service.MenuService;
import com.lychee.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    // 通过用户id查询用户的菜单权限
    @Override
    public List<String> selectPermsByUserId(Long id) {
        // 如果是超级管理员，查询所有菜单权限
        if (id == 1L) {
            LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
            wrapper.in(Menu::getMenuType, SystemConstants.MENU,SystemConstants.BUTTON);
            wrapper.eq(Menu::getStatus, SystemConstants.STATUS_NORMAL);
            List<Menu> menus = list(wrapper);
            // 将菜单权限转换为字符串
            List<String> perms = menus.stream().map(Menu::getPerms).collect(Collectors.toList());
            return perms;
        }
        //返回用户所具有的权限
        return getBaseMapper().selectPermsByUserId(id);
    }
    // 通过用户id查询用户的菜单路由信息
    @Override
    public List<Menu> selectRouterMenuTreeByUserId(Long userId) {
        MenuMapper menuMapper = getBaseMapper();
        List<Menu> menus = null;
        // 如果是超级管理员，查询所有菜单权限
        if (SecurityUtils.isAdmin()) {
            menus = menuMapper.selectAllRouterMenu();
        } else {
            // 如果不是管理员，查询用户的菜单权限
            menus = menuMapper.selectRouterMenuTreeByUserId(userId);
        }
        //构建tree
        List<Menu> menuTree = buildMenuTree(menus, 0L);
        return menuTree;
    }
    // 构建菜单树
    private List<Menu> buildMenuTree(List<Menu> menus, long parentId) {
        List<Menu> menuTree = menus.stream()
                .filter(menu -> menu.getParentId().equals(parentId))
                .map(menu -> menu.setChildren(getChildren(menu, menus)))
                            .collect(Collectors.toList());
        return menuTree;
    }

    /**
     * 获取存入参数的 子menu集合
     * @return childrenList
     */
    private List<Menu> getChildren(Menu menu, List<Menu> menus){
        List<Menu> childrenList = menus.stream()
                .filter(m -> m.getParentId().equals(menu.getId()))
                .collect(Collectors.toList());
        return childrenList;
    }

}
