package com.shamisen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shamisen.domain.entity.BookContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Entity generate.BookContent
 */
@Mapper
@Repository
public interface BookContentDao extends BaseMapper<BookContent> {
}