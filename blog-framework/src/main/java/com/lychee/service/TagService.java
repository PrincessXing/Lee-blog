package com.lychee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lychee.domain.ResponseResult;
import com.lychee.domain.dto.TagListDto;
import com.lychee.domain.entity.Tag;
import com.lychee.domain.vo.PageVo;
import org.springframework.stereotype.Service;

/**
 * 标签表业务层
 */
@Service
public interface TagService extends IService<Tag> {
    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);
}
