package com.chiiiplow.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.product.entity.ProductAttrValueEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * spu属性值
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 12:43:26
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

