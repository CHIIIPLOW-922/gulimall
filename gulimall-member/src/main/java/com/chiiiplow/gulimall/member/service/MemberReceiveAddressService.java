package com.chiiiplow.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.member.entity.MemberReceiveAddressEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 会员收货地址
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:06:39
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

