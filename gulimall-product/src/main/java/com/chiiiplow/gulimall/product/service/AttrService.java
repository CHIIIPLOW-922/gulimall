package com.chiiiplow.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.product.entity.AttrEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 商品属性
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 12:43:27
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

