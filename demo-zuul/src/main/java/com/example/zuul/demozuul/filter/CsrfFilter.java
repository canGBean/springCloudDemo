package com.example.zuul.demozuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * 可以集成oauth2等认证进行校验
 */
@Slf4j
public class CsrfFilter extends ZuulFilter {


	@Override
	public String filterType() {
		return "pre";//具体看ZuulFilter内的注解
	}

	@Override
	public int filterOrder() {
		return 20;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String referer = request.getHeader("referer");
		String appId = request.getHeader("appId");
		log.info("referer is {}. appid is {}",referer,appId);

		if (referer.equals(appId)) {
			ctx.setSendZuulResponse(true);
			ctx.setResponseStatusCode(200);
			ctx.set("isSuccess", true);
		}else {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(400);
			ctx.setResponseBody("token is empty");
			ctx.set("isSuccess", false);
		}
		return null;
	}
}
