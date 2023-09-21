package com.chiiiplow.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.product.entity.SkuImagesEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * sku图片
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 12:43:26
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

