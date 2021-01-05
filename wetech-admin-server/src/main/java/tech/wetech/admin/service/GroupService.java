package tech.wetech.admin.service;

import tech.wetech.admin.exception.BusinessException;
import tech.wetech.admin.model.PageWrapper;
import tech.wetech.admin.model.entity.App;
import tech.wetech.admin.model.entity.Group;
import tech.wetech.admin.model.query.PageQuery;

public interface GroupService {

    void create(Group group) throws BusinessException;

    PageWrapper<Group> queryPage(PageQuery query);

    void updateNotNull(Group group);

    void deleteById(Long id);
}
