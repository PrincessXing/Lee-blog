package com.lychee.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lychee.domain.entity.Tag;
import com.lychee.mapper.TagMapper;
import org.springframework.stereotype.Service;
/**
 * 标签表业务实现层
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> {
}
