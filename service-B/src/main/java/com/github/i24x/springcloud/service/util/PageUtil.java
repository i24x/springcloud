package com.github.i24x.springcloud.service.util;

public class PageUtil {

	public static int getPosByPageNo(int pageNo, int pageSize){
		return (pageNo - 1) * pageSize;
	}
	
	public static int getLimitByPageSize(int pageSize){
		return pageSize;
	}
}
