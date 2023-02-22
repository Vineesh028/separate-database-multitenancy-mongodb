package com.mongo.multitenancy.util;

public class Constant {
	
	public static final String TENANT_HEADER = "Tenant-Id";
	public static final String CONNECTION_STRING = "mongodb://localhost:27017/TENANT?readPreference=primary";
	public static final String TENANT_REPLACEMENT = "TENANT";

}
