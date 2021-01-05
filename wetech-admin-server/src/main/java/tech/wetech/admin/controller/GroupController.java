package tech.wetech.admin.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin.model.PageWrapper;
import tech.wetech.admin.model.Result;
import tech.wetech.admin.model.entity.Group;
import tech.wetech.admin.model.query.PageQuery;
import tech.wetech.admin.model.vo.BatchDeleteVO;
import tech.wetech.admin.service.impl.GroupServiceImpl;

import javax.annotation.Resource;
import java.util.Arrays;

@RequestMapping("group")
@RestController
@Validated
public class GroupController {

    @Resource
    private GroupServiceImpl groupService;

    @GetMapping
    @RequiresPermissions("group:view")
    public Result<PageWrapper<Group>> queryList(PageQuery query) {
        return Result.success(groupService.queryPage(query));
    }

    @PostMapping
    @RequiresPermissions("group:create")
    public Result create(@RequestBody Group data) {
        groupService.create(data);
        return Result.success();
    }

    @PutMapping
    @RequiresPermissions("group:update")
    public Result update(@RequestBody Group data) {
        groupService.updateNotNull(data);
        return Result.success();
    }

    @DeleteMapping
    @RequiresPermissions("group:delete")
    public Result deleteBatchByIds(@RequestBody @Validated BatchDeleteVO batchDeleteVO) {
        Long[] ids = batchDeleteVO.getIds();
        Arrays.stream(ids).forEach(groupService::deleteById);
        return Result.success();
    }

}
