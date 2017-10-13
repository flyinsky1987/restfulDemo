package com.tm.api.controller;
import com.google.gson.Gson;
import com.tm.common.base.BaseController;
import com.tm.pojo.TestPojo;

public class ApiController extends BaseController{
	public void index(){
		super.renderText("welcome！");
	}
	public void list(){
		Gson gson=new Gson();
		super.renderText(gson.toJson(TestPojo.dao.list()));
	}
}
