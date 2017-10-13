package com.tm.common.base;
  

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.jfinal.core.Controller;

public class BaseController extends Controller {
	 
	protected final Gson gson=new Gson(); 
	/**
	 * @param obj	需要验证格式的字符串
	 * @return  对字符串进行合理性验证，并返回验证处理后的字符串
	 */
	public static String validateParames(Object obj){
		String[] regs=new String[]{"select","*","from","'","\"","\n","\r","delete","update","alert","#","$","(",")","="};
		if(obj!=null){
			String str=obj.toString();
			for(String reg:regs){
				if(str.contains(reg))
					return "";
			}
			return str;
		}
		return "";
	}
	public static void main(String args[]){
		System.out.println(validateParames("delete 你"));
	}
	/**
	 * 获取相对路径
	 */
	public String getpath() {
		return getRequest().getContextPath();
	} 
	/**
	 * 获取绝对路径
	 */
	public String getBasePath() {
		return getRequest().getScheme() + "://" + getRequest().getServerName() + ":" + getRequest().getServerPort();
	}
	 
	/**
	 * 获取客户端ip地址
	 */
	public String getRealAddress(HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	/**
	 * UUID随机主键
	 */
	public String UUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	/**
	 * Timestamp类型时间
	 */
	public Timestamp getTimestamp(){
		return new Timestamp(new Date().getTime());
	}
	
	/**
	 * @param boo
	 * @param message
	 * @return
	 * 操作状态和描述
	 */
	public String toState(boolean boo,String message){
		Map<String,String> map=new HashMap<String,String>(); 
		map.put("state", boo+"");
		map.put("message", message);
		return gson.toJson(map);
	}
	/**
	 * @param obj
	 * @return
	 * 空验证
	 */
	public static boolean isEmpty(Object obj){
		return (obj!=null&&obj.toString().trim().length()>0&&!obj.toString().toUpperCase().equals("NULL"))?false:true;
	}
	/**
	 * 格式化保留三位小数，并四舍五入
	 */
	public static String double3(String data){
		DecimalFormat df = new DecimalFormat("#.###");    
		return df.format(Double.valueOf(data));
	}
	
	/**
	 * 缓存区块索引前缀
	 */
	public static String memCity(String cityNo){
		return "key_"+cityNo+"_";
	}
	
	public static String validate_(Object obj){
		return (obj!=null && !obj.toString().equals("null"))?obj+"":"";
	}
	 
}
