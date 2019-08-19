package com.example.ribbon.demoribbon.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Slf4j
public class CustomerBRule extends AbstractLoadBalancerRule {

	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		} else {
			Server server = null;

			while(server == null) {
				if (Thread.interrupted()) {
					return null;
				}

				List<Server> upList = lb.getReachableServers();
				List<Server> allList = lb.getAllServers();
				int serverCount = allList.size();
				if (serverCount == 0) {
					return null;
				}

				int index = this.chooseRandomInt(serverCount);
				server = (Server)upList.get(index);
				if (server == null) {
					Thread.yield();
				} else {
					if (server.isAlive()) {
						log.info("custom rule {}{}",server.getHost(),server.getPort());
						return server;
					}

					server = null;
					Thread.yield();
				}
			}
			return server;
		}
	}

	protected int chooseRandomInt(int serverCount) {
		return ThreadLocalRandom.current().nextInt(serverCount);
	}


	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {

	}

	@Override
	public Server choose(Object key) {
		return this.choose(this.getLoadBalancer(), key);
	}
}
