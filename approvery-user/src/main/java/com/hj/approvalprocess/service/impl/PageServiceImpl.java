/*
 *    Copyright (c) 2018-2025, bbibm All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the bbibm.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: bbibm
 */
package com.hj.approvalprocess.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.hj.approvalprocess.entity.ApprovalProcessSheetMysys;
import com.hj.approvalprocess.entity.NumJd;
import com.hj.approvalprocess.entity.Page;
import com.hj.approvalprocess.entity.User;
import com.hj.approvalprocess.mapper.ApprovalProcessSheetMysysMapper;
import com.hj.approvalprocess.mapper.NumJdMapper;
import com.hj.approvalprocess.mapper.PageMapper;
import com.hj.approvalprocess.service.PageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 申请表
 *
 * @author 胡剑
 * @date 2020-08-11 17:40:44
 */
@Service
@AllArgsConstructor
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements PageService {

    private final PageMapper pageMapper;

    private final ApprovalProcessSheetMysysMapper approvalProcessSheetMysysMapper;

    private final NumJdMapper numJdMapper;

    /**
     * 新增申请表
     * @param page 申请表
     * @return R
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object saveNewDate(Page page) {
        //新增申请表
        page.setStatus("1");
        pageMapper.insert(page);
        //获取申请表Id
        int PID=page.getId();
        List<User> userList=page.getUserList();
        //获取审批人数
        int PEOPLENUM=userList.size();
        //节点数
        int NUM_JD=1;
        for (User user:userList){
            ApprovalProcessSheetMysys approvalProcessSheetMysys = new ApprovalProcessSheetMysys();
            //审批姓名
            approvalProcessSheetMysys.setApprovedName(user.getUserName());
            //审批人id
            approvalProcessSheetMysys.setApprovedId(user.getUserId());
            //审批节点
            approvalProcessSheetMysys.setApprovalNode(String.valueOf(NUM_JD));
            //pid
            approvalProcessSheetMysys.setPid(PID);
            NUM_JD++;
            approvalProcessSheetMysysMapper.insert(approvalProcessSheetMysys);
        }
        //节点表
        NumJd numJd = new NumJd();
        //pid
        numJd.setPid(PID);
        //节点数
        numJd.setNumT(String.valueOf(NUM_JD));
        numJdMapper.insert(numJd);
        return "成功";
    }
    /**
     * 申请表审批
     * @param approvalProcessSheetMysys
     * @return R
     */
    @Override
    public Object approveryData(ApprovalProcessSheetMysys approvalProcessSheetMysys,Integer id) {
        return null;
    }
}
