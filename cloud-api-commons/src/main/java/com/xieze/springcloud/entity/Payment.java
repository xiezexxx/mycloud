package com.xieze.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/3 17:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{

    private Long id;

    private String orderNo;
}
