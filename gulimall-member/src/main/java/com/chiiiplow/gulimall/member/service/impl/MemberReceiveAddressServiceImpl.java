package com.chiiiplow.gulimall.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chiiiplow.gulimall.member.dao.MemberReceiveAddressDao;
import com.chiiiplow.gulimall.member.entity.MemberReceiveAddressEntity;
import com.chiiiplow.gulimall.member.service.MemberReceiveAddressService;
import com.joji.common.utils.PageUtils;
import com.joji.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("memberReceiveAddressService")
public class MemberReceiveAddressServiceImpl extends ServiceImpl<MemberReceiveAddressDao, MemberReceiveAddressEntity> implements MemberReceiveAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberReceiveAddressEntity> page = this.page(
                new Query<MemberReceiveAddressEntity>().getPage(params),
                new QueryWrapper<MemberReceiveAddressEntity>()
        );

        return new PageUtils(page);
    }

}