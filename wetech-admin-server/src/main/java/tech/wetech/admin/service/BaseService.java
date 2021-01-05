package tech.wetech.admin.service;

import tech.wetech.admin.model.query.PageQuery;
import tech.wetech.mybatis.domain.Sort;
import tech.wetech.mybatis.example.Example;

public class BaseService {

    public <T> Example<T> buildPageExample(PageQuery query, Class<T> tClass) {
        Example<T> example = Example.of(tClass);
        if (query.getSortField() != null && query.getSortOrder() != null) {
            if (query.getSortOrder() == PageQuery.SortOrder.ascend) {
                example.setSort(Sort.by(query.getSortField()).asc());
            }
            if (query.getSortOrder() == PageQuery.SortOrder.descend) {
                example.setSort(Sort.by(query.getSortField()).desc());
            }
        } else {
            example.setSort(Sort.by("id").desc());
        }
        return example;
    }
}
