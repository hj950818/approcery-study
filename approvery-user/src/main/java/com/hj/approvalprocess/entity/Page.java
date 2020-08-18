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

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 申请表
 *
 * @author 胡剑
 * @date 2020-08-11 17:40:44
 */
@Data
@TableName("page")
//@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "申请表")
public class Page {
private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value="id")
    private Integer id;
    /**
     * 用户姓名
     */
    @ApiModelProperty(value="用户姓名")
    private String userName;
    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id")
    private Integer userId;
    /**
     * 内容
     */
    @ApiModelProperty(value="内容")
    private String page;
    /**
     * 审批状态 1：待提交 2：待审核 3：已审核 
     */
    @ApiModelProperty(value="审批状态 1：待提交 2：待审核 3：已审核 ")
    private String status;
    /**
     * 审批人
     */
    @ApiModelProperty(value="审批人")
    @TableField(exist = false)
    private List<User> userList=new ArrayList<>();
    }
