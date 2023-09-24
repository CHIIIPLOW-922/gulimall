package com.chiiiplow.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.member.entity.MemberCollectSpuEntity;
import com.chiiiplow.common.utils.PageUtils;

import java.util.Map;

/**
 * 会员收藏的商品
 *
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:06:39
 */
public interface MemberCollectSpuService extends IService<MemberCollectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

