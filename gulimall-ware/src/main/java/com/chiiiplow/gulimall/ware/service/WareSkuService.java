package com.chiiiplow.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.ware.entity.WareSkuEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 商品库存
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:23:18
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

