package com.chiiiplow.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.product.entity.SpuInfoDescEntity;
import com.chiiiplow.common.utils.PageUtils;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 12:43:26
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

