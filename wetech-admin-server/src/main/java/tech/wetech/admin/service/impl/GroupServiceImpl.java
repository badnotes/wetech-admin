package tech.wetech.admin.service.impl;

import org.springframework.stereotype.Service;
import tech.wetech.admin.exception.BusinessException;
import tech.wetech.admin.mapper.GroupMapper;
import tech.wetech.admin.model.PageWrapper;
import tech.wetech.admin.model.entity.Group;
import tech.wetech.admin.model.query.PageQuery;
import tech.wetech.admin.service.BaseService;
import tech.wetech.admin.service.GroupService;
import tech.wetech.mybatis.domain.Page;
import tech.wetech.mybatis.example.Example;

import javax.annotation.Resource;

@Service
public class GroupServiceImpl extends BaseService implements GroupService {

    @Resource
    private GroupMapper groupMapper;

    @Override
    public void create(Group group) throws BusinessException {
        groupMapper.insertSelective(group);
    }

    @Override
    public PageWrapper<Group> queryPage(PageQuery query) {
        Example<Group> example = buildPageExample(query, Group.class);
        Page<Group> users = Page.of(query.getPageNo(), query.getPageSize(), true).list(() -> groupMapper.selectByExample(example));
        return new PageWrapper<>(users, users.getTotal(), users.getPageNumber(), users.getPageSize());
    }

    @Override
    public void updateNotNull(Group group) {
        groupMapper.updateByPrimaryKeySelective(group);
    }

    @Override
    public void deleteById(Long id) {
        groupMapper.deleteByPrimaryKey(id);
    }
}
