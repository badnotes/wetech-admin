package tech.wetech.admin.service.impl;

import org.springframework.stereotype.Service;
import tech.wetech.admin.exception.BusinessException;
import tech.wetech.admin.mapper.AppMapper;
import tech.wetech.admin.model.PageWrapper;
import tech.wetech.admin.model.entity.App;
import tech.wetech.admin.model.query.PageQuery;
import tech.wetech.admin.service.AppService;
import tech.wetech.admin.service.BaseService;
import tech.wetech.mybatis.domain.Page;
import tech.wetech.mybatis.example.Example;

import javax.annotation.Resource;

@Service
public class AppServiceImpl extends BaseService implements AppService  {

    @Resource
    private AppMapper appMapper;

    @Override
    public void create(App app) throws BusinessException {
        appMapper.insertSelective(app);
    }

    @Override
    public PageWrapper<App> queryPage(PageQuery query) {
        Example<App> example = buildPageExample(query, App.class);
        Page<App> users = Page.of(query.getPageNo(), query.getPageSize(), true).list(() -> appMapper.selectByExample(example));
        return new PageWrapper<>(users, users.getTotal(), users.getPageNumber(), users.getPageSize());
    }

    @Override
    public void updateNotNull(App app) {
        appMapper.updateByPrimaryKeySelective(app);
    }

    @Override
    public void deleteById(Long id) {
        appMapper.deleteByPrimaryKey(id);
    }
}
