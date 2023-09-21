package com.chiiiplow.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.ware.entity.PurchaseEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 采购信息
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:23:19
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

