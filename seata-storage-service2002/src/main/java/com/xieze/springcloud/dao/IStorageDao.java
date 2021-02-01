package com.xieze.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 15:56
 */
@Mapper
public interface IStorageDao {

    void update(@Param("productId") Long productId, @Param("count") Integer count);
}
