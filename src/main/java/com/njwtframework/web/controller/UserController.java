package com.njwtframework.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njwtframework.web.common.Pager;

@Controller
public class UserController {
	protected static Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/")
	public String index(Map<String, Object> map) {

		map.put("name", "[Angel -- 守护天使]");

		map.put("gender", 1);// gender:性别，1：男；0：女；

		List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();

		Map<String, Object> friend = new HashMap<String, Object>();

		friend.put("name", "张三");

		friend.put("age", 20);

		friends.add(friend);

		friend = new HashMap<String, Object>();

		friend.put("name", "李四");

		friend.put("age", 22);

		friends.add(friend);

		map.put("friends", friends);

		return "/index";

	}

	@RequestMapping("/hello/{name}")
	public String hellName(@PathVariable String name) {
		logger.info("Hello " + name);
		return "Hello " + name;
	}

	@RequestMapping("/helloftl")
	public String hello(Map<String, Object> map) {
		map.put("name", "[Angel -- 守护天使]");
		return "hello";
	}
	@RequestMapping("/myerror")
	public String myerror(){
		return "error/404";
	}
	@RequestMapping("/user/tolist")
	public String toUserList() {
		return "/user/list";
	}
	
	/**
	 * 
	* @Title: getUserPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return List<Map<String,String>>    返回类型 
	* @author xxf
	* @throws
	 */
	@RequestMapping("/user/list")
	@ResponseBody
	public Pager<Map<String,Object>> getUserPage(@RequestParam Integer pageSize, @RequestParam Integer pageNumber,@RequestParam String sortOrder){
	
		Pager<Map<String,Object>> pager = new Pager<Map<String,Object>>();
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		int[] ints={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		for(int i : ints) {
			Map<String,Object> map=new HashMap<String,Object>();
					map.put("Tid", i);
					map.put("First", "姓名"+i);
					map.put("sex", i%2==1?1:0);
					map.put("Score", 100+i);
					list.add(map);
		}
		pager.setRows(list);
		pager.setPageSize(pageSize);
		pager.setPageNumber(pageNumber);
		pager.setTotal(list.size());
		return pager;
	}
	
	
}