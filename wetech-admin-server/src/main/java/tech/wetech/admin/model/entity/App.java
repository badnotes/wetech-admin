package tech.wetech.admin.model.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_app")
@Data
public class App {

    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Long id;

    private String appKey;

    private String appName;
}
