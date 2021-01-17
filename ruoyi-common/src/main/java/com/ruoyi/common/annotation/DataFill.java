package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 这是用来默认填充的注释 value支持spel表达式
 * @author : <a href=mailto:yeqijie@booway.com.cn>yeqijie</a>
 * @version : 1.1.0
 *
 */

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataFill{

     String value() ;

    /**
     * 填充的类型
     * @return
     */
    Class fillClass();


}
