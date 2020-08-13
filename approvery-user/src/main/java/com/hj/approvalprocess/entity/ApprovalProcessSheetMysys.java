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

package com.hj.approvalprocess.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 流程表
 *
 * @author 胡剑
 * @date 2020-08-11 17:41:04
 */
@Data
@TableName("approval_process_sheet_mysys")
@ApiModel(value = "流程表")
public class ApprovalProcessSheetMysys {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    @ApiModelProperty(value="id")
    private Integer id;
    /**
     * 审批人
     */
    @ApiModelProperty(value="审批人")
    private String approvedName;
    /**
     * 审批人id
     */
    @ApiModelProperty(value="审批人id")
    private Integer approvedId;
    /**
     * 审批时间
     */
    @ApiModelProperty(value="审批时间")
    private LocalDateTime approvedDate;
    /**
     * 审批意见
     */
    @ApiModelProperty(value="审批意见")
    private String approcedOpinions;
    /**
     * 审批状态
     */
    @ApiModelProperty(value="审批状态")
    private Integer approvalStatus;
    /**
     * 审批节点
     */
    @ApiModelProperty(value="审批节点")
    private String approvalNode;
    /**
     * pid
     */
    @ApiModelProperty(value="pid")
    private Integer pid;
    }
