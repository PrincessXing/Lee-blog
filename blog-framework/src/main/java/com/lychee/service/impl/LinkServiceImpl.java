package com.lychee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.constans.SystemConstants;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.entity.Link;
import com.lychee.domain.vo.LinkVo;
import com.lychee.mapper.LinkMapper;
import com.lychee.service.LinkService;
import com.lychee.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {
    // 查询所有友链
    @Override
    public ResponseResult getAllLink() {
        LambdaQueryWrapper<Link> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> links = list(wrapper);
        List<LinkVo> linkVos = BeanCopyUtils.copyMultiple(links, LinkVo.class);
        return ResponseResult.okResult(linkVos);
    }
}
