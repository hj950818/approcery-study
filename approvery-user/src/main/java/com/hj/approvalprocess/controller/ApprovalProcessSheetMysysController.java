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
import com.hj.approvalprocess.entity.ApprovalProcessSheetMysys;
import com.hj.approvalprocess.service.ApprovalProcessSheetMysysService;
import com.hj.approvalprocess.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 流程表
 *
 * @author 胡剑
 * @date 2020-08-11 17:41:04
 */
@RestController
@AllArgsConstructor
@RequestMapping("/approvalprocesssheetmysys" )
@Api(value = "approvalprocesssheetmysys", tags = "流程表管理")
public class ApprovalProcessSheetMysysController {

    private final ApprovalProcessSheetMysysService approvalProcessSheetMysysService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param approvalProcessSheetMysys 流程表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getApprovalProcessSheetMysysPage(Page page, ApprovalProcessSheetMysys approvalProcessSheetMysys) {
        return R.ok(approvalProcessSheetMysysService.page(page, Wrappers.query(approvalProcessSheetMysys)));
    }


    /**
     * 通过id查询流程表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(approvalProcessSheetMysysService.getById(id));
    }

    /**
     * 新增流程表
     * @param approvalProcessSheetMysys 流程表
     * @return R
     */
    @ApiOperation(value = "新增流程表", notes = "新增流程表")
//    @SysLog("新增流程表" )
    @PostMapping
//    @PreAuthorize("@pms.hasPermission('generator_approvalprocesssheetmysys_add')" )
    public R save(@RequestBody ApprovalProcessSheetMysys approvalProcessSheetMysys) {
        return R.ok(approvalProcessSheetMysysService.save(approvalProcessSheetMysys));
    }

    /**
     * 修改流程表
     * @param approvalProcessSheetMysys 流程表
     * @return R
     */
    @ApiOperation(value = "修改流程表", notes = "修改流程表")
//    @SysLog("修改流程表" )
    @PutMapping
//    @PreAuthorize("@pms.hasPermission('generator_approvalprocesssheetmysys_edit')" )
    public R updateById(@RequestBody ApprovalProcessSheetMysys approvalProcessSheetMysys) {
        return R.ok(approvalProcessSheetMysysService.updateById(approvalProcessSheetMysys));
    }

    /**
     * 通过id删除流程表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除流程表", notes = "通过id删除流程表")
//    @SysLog("通过id删除流程表" )
    @DeleteMapping("/{id}" )
//    @PreAuthorize("@pms.hasPermission('generator_approvalprocesssheetmysys_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(approvalProcessSheetMysysService.removeById(id));
    }

}
