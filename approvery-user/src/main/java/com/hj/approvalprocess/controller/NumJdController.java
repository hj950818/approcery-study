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
import com.hj.approvalprocess.generator.entity.NumJd;
import com.hj.approvalprocess.generator.service.NumJdService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 节点表
 *
 * @author 胡剑
 * @date 2020-08-11 17:40:31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/numjd" )
@Api(value = "numjd", tags = "节点表管理")
public class NumJdController {

    private final  NumJdService numJdService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param numJd 节点表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getNumJdPage(Page page, NumJd numJd) {
        return R.ok(numJdService.page(page, Wrappers.query(numJd)));
    }


    /**
     * 通过id查询节点表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(numJdService.getById(id));
    }

    /**
     * 新增节点表
     * @param numJd 节点表
     * @return R
     */
    @ApiOperation(value = "新增节点表", notes = "新增节点表")
    @SysLog("新增节点表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('generator_numjd_add')" )
    public R save(@RequestBody NumJd numJd) {
        return R.ok(numJdService.save(numJd));
    }

    /**
     * 修改节点表
     * @param numJd 节点表
     * @return R
     */
    @ApiOperation(value = "修改节点表", notes = "修改节点表")
    @SysLog("修改节点表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('generator_numjd_edit')" )
    public R updateById(@RequestBody NumJd numJd) {
        return R.ok(numJdService.updateById(numJd));
    }

    /**
     * 通过id删除节点表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除节点表", notes = "通过id删除节点表")
    @SysLog("通过id删除节点表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('generator_numjd_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(numJdService.removeById(id));
    }

}
