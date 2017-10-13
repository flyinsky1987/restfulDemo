package com.tm.pojo;
 
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

/**
 * @author fuwei
 * 从测试表查询信息
 */
@SuppressWarnings("serial")
public class TestPojo   extends Model<TestPojo> {
	public static final TestPojo dao=new TestPojo();
	
	/**
	 * 全部信息
	 */
	public List<Record> list(){
		return Db.find("select * from test");
	}
	
}
