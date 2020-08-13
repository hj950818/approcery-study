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

package com.hj.approvalprocess.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hj.approvalprocess.service.PageService;
import com.hj.approvalprocess.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 申请表
 *
 * @author 胡剑
 * @date 2020-08-11 17:40:44
 */
@RestController
@AllArgsConstructor
@RequestMapping("/page" )
public class PageController {

    private final PageService pageService;

    /**
     * 新增申请表
     * @param page 申请表
     * @return R
     */
    @ApiOperation(value = "新增申请表", notes = "新增申请表")
    @SysLog("新增申请表" )
    @PostMapping
//    @PreAuthorize("@pms.hasPermission('generator_page_add')" )
    public R save(@RequestBody Page page) {
        return R.ok(pageService.save(page));
    }


}
