package com.tm.common.config;

import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.tm.api.controller.ApiController;
import com.tm.pojo.TestPojo;

/**
 * @author fuwei
 * 配置入口
 */
public class MyInit {
	/**
	 * @param me
	 * 配置控制器路由
	 */
	public static void configRoute(Routes me){ 
		me.add("api/api", ApiController.class);
	}
	/**
	 * @param arp
	 * 配置数据库实例
	 */
	public static void addMapping(ActiveRecordPlugin arp){
		arp.addMapping("test", TestPojo.class);
	}
	/**
	 * 全局初始化处理
	 */
	public static void init(){ 
		//
	}
}
