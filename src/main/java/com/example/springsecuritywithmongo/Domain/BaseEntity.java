package com.example.springsecuritywithmongo.Domain;

/**
 * created by lovedeep in com.example.springsecuritywithmongo.Domain
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Getter@Setter

public  class BaseEntity{
    @Id
    protected String id;
    protected String parentId;
    protected Date createDate;
    protected Date updateDate;
}
