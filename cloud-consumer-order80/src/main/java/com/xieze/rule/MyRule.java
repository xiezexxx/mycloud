package com.xieze.rule;

import cn.hutool.core.collection.CollUtil;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/24 9:50
 */
@Slf4j
public class MyRule  extends AbstractLoadBalancerRule {

    public MyRule(){

    }

    public MyRule(ILoadBalancer lb){
        setLoadBalancer(lb);
    }



    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    private Server choose(ILoadBalancer loadBalancer, Object key) {
        if (Objects.isNull(loadBalancer)){
            log.warn("no load balancer");
            return null;
        }
        List<Server> servers = loadBalancer.getReachableServers();
        if (CollUtil.isEmpty(servers)){
            return null;
        }
        log.info(servers.get(0).getHost());
        return servers.get(0);
    }
}
