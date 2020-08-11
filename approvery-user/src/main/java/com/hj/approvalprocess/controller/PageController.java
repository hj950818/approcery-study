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
import com.bbibm.common.core.util.R;
import com.bbibm.common.log.annotation.SysLog;
import com.hj.approvalprocess.generator.entity.Page;
import com.hj.approvalprocess.generator.service.PageService;
import org.springframework.security.access.prepost.PreAuthorize;
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
@Api(value = "page", tags = "申请表管理")
public class PageController {

    private final  PageService pageService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param page 申请表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getPagePage(Page page, Page page) {
        return R.ok(pageService.page(page, Wrappers.query(page)));
    }


    /**
     * 通过id查询申请表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(pageService.getById(id));
    }

    /**
     * 新增申请表
     * @param page 申请表
     * @return R
     */
    @ApiOperation(value = "新增申请表", notes = "新增申请表")
    @SysLog("新增申请表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('generator_page_add')" )
    public R save(@RequestBody Page page) {
        return R.ok(pageService.save(page));
    }

    /**
     * 修改申请表
     * @param page 申请表
     * @return R
     */
    @ApiOperation(value = "修改申请表", notes = "修改申请表")
    @SysLog("修改申请表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('generator_page_edit')" )
    public R updateById(@RequestBody Page page) {
        return R.ok(pageService.updateById(page));
    }

    /**
     * 通过id删除申请表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除申请表", notes = "通过id删除申请表")
    @SysLog("通过id删除申请表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('generator_page_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(pageService.removeById(id));
    }

}
