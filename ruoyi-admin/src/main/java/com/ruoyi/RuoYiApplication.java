package com.ruoyi;

import com.ruoyi.common.utils.spring.SpringUtils;
import com.shamisen.domain.entity.BookContent;
import com.shamisen.mapper.BookContentDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RuoYiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuoYiApplication.class, args);
        BookContentDao bookContentDao =  SpringUtils.getBean(BookContentDao.class);
    }
}
