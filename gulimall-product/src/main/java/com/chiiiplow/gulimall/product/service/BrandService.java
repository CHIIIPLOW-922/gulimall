package com.chiiiplow.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.product.entity.BrandEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 品牌
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 12:43:27
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

