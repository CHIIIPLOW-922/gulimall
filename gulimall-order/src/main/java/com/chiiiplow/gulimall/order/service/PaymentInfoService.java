package com.chiiiplow.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.order.entity.PaymentInfoEntity;
import com.chiiiplow.common.utils.PageUtils;

import java.util.Map;

/**
 * 支付信息表
 *
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:19:20
 */
public interface PaymentInfoService extends IService<PaymentInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

