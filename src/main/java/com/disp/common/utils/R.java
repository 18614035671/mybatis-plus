/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.disp.common.utils;

import com.disp.common.enums.ResultEnum;

import java.util.HashMap;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;


	public R() {
		put("code", ResultEnum.SUCCESS.getCode());
		put("msg", ResultEnum.SUCCESS.getMessage());
	}

	public static R error() {
		return error(ResultEnum.FAILED.getCode(),ResultEnum.FAILED.getMessage());
	}

	public static R error(String msg) {
		return error(ResultEnum.FAILED.getCode(), msg);
	}

	public static R error(ResultEnum result) {
		return error(result.getCode(), result.getMessage());
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Object object) {
		R r = new R();
		if(object!=null){
			r.put("data",object);
		}
		return r;
	}

	public static R ok() {
		return new R();
	}
}
