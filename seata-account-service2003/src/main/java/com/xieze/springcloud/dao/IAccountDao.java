package com.xieze.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 16:26
 */
@Mapper
public interface IAccountDao {

    void update(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
