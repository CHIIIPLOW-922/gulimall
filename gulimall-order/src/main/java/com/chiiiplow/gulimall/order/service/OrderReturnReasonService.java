package com.chiiiplow.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.order.entity.OrderReturnReasonEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 退货原因
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:19:20
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

