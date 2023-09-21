package com.chiiiplow.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.coupon.entity.CouponSpuCategoryRelationEntity;
import com.chiiiplow.common.utils.PageUtils;

import java.util.Map;

/**
 * 优惠券分类关联
 *
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 13:55:18
 */
public interface CouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

