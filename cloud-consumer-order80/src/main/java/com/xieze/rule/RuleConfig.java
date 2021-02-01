package com.xieze.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/22 14:25
 */
@Configuration
public class RuleConfig {

    @Bean
    public IRule myRule(){
        return new MyRule();
    }
}
