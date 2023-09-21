package com.chiiiplow.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.product.entity.CommentReplayEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 12:43:26
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

