package com.ruoyi.common.config;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.ruoyi.common.annotation.DataFill;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import io.netty.util.internal.ReflectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldFilter;

/**
 * @author adonis
 */
@Slf4j
@Component
public class AutoFillObjectHandler implements MetaObjectHandler {

    public static final ExpressionParser SPEL_EXPRESSION = new SpelExpressionParser();

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入前开始填充默认数据...");
        setDefaultValue(metaObject,FieldFill.INSERT);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新前开始填充默认数据...");
        setDefaultValue(metaObject,FieldFill.UPDATE);
    }

    private void setDefaultValue(MetaObject metaObject, FieldFill fillType)
    {
        Expression expression;
        List<Field> needFillList = new ArrayList<>();
        //找到所有有DataFill注解的属性
        ReflectionUtils.doWithFields(metaObject.getOriginalObject().getClass(), needFillList::add, getFieldFilter(fillType));

        //将所有的属性进行赋值
        for (Field field : needFillList) {
            DataFill fill = field.getAnnotation(DataFill.class);
            expression = SPEL_EXPRESSION.parseExpression(fill.value());
            Object fillObj = expression.getValue();
            if(fill.fillClass().isInstance(fillObj)) {
                this.setFieldValByName(field.getName(), fillObj, metaObject);
            }else
            {
                throw new RuntimeException(StringUtils.format("默认值填充错误,{}的类型应该为{},传入的类型与其不兼容",field.getName(),fill.fillClass().getName()));
            }
        }
    }

    private FieldFilter getFieldFilter(FieldFill fillType)
    {
        return field -> {
            DataFill fill =  field.getAnnotation(DataFill.class);
            TableField tableField = field.getAnnotation(TableField.class);
            if(null == tableField)
            {
                return false;
            }

            return (fill != null && tableField.fill().equals(fillType) ) || FieldFill.INSERT_UPDATE.equals(tableField.fill());
        };
    }
}
