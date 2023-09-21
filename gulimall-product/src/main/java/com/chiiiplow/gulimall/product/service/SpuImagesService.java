package com.chiiiplow.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.product.entity.SpuImagesEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * spu图片
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 12:43:26
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

