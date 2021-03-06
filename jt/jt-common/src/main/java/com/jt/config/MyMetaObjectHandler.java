package com.jt.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;


@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        this.setInsertFieldValByName("created", date, metaObject);
        this.setInsertFieldValByName("updated", date, metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setUpdateFieldValByName("updated", new Date(), metaObject);
    }
}
