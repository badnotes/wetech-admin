package tech.wetech.admin.service;

import tech.wetech.admin.exception.BusinessException;
import tech.wetech.admin.model.PageWrapper;
import tech.wetech.admin.model.entity.App;
import tech.wetech.admin.model.query.PageQuery;

public interface AppService {

    void create(App app) throws BusinessException;

    PageWrapper<App> queryPage(PageQuery query);

    void updateNotNull(App app);

    void deleteById(Long id);
}
