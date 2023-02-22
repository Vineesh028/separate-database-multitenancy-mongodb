package com.mongo.multitenancy.util;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TenantFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String tenantHeader = request.getHeader(Constant.TENANT_HEADER);
		if (tenantHeader == null || tenantHeader.trim().isEmpty()) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		} else {

			String dbConnectionString = Constant.CONNECTION_STRING.replace(Constant.TENANT_REPLACEMENT, tenantHeader);
			ConnectionStorage.setConnection(dbConnectionString);
			filterChain.doFilter(request, response);
			ConnectionStorage.clear();
		}
	}
}