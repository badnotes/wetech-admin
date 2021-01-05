package tech.wetech.admin.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.admin.model.PageWrapper;
import tech.wetech.admin.model.Result;
import tech.wetech.admin.model.entity.App;
import tech.wetech.admin.model.query.PageQuery;
import tech.wetech.admin.model.vo.BatchDeleteVO;
import tech.wetech.admin.service.impl.AppServiceImpl;

import javax.annotation.Resource;
import java.util.Arrays;

@RequestMapping("app")
@RestController
@Validated
public class AppController {

    @Resource
    private AppServiceImpl appService;

    @GetMapping
    @RequiresPermissions("app:view")
    public Result<PageWrapper<App>> queryList(PageQuery query) {
        return Result.success(appService.queryPage(query));
    }

    @PostMapping
    @RequiresPermissions("app:create")
    public Result create(@RequestBody App data) {
        appService.create(data);
        return Result.success();
    }

    @PutMapping
    @RequiresPermissions("app:update")
    public Result update(@RequestBody App data) {
        appService.updateNotNull(data);
        return Result.success();
    }

    @DeleteMapping
    @RequiresPermissions("app:delete")
    public Result deleteBatchByIds(@RequestBody @Validated BatchDeleteVO batchDeleteVO) {
        Long[] ids = batchDeleteVO.getIds();
        Arrays.stream(ids).forEach(appService::deleteById);
        return Result.success();
    }

}
