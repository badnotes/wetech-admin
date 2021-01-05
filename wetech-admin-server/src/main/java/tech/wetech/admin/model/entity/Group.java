package tech.wetech.admin.model.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_group")
@Data
public class Group {

    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Long id;

    private String groupName;

    private Integer groupLevel;

    private Long parentId;
}
