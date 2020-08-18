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

package com.hj.approvalprocess.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hj.approvalprocess.entity.ApprovalProcessSheetMysys;
import com.hj.approvalprocess.entity.Page;
import org.springframework.stereotype.Component;

/**
 * 申请表
 *
 * @author 胡剑
 * @date 2020-08-11 17:40:44
 */

public interface PageService extends IService<Page> {

    /**
     * 新增申请表
     * @param page 申请表
     * @return R
     */
    Object saveNewDate(Page page);
    /**
     * 申请表审批
     * @param approvalProcessSheetMysys 申请表
     * @return R
     */
    Object approveryData(ApprovalProcessSheetMysys approvalProcessSheetMysys,Integer id);
}
