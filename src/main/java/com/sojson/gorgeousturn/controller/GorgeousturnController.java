package com.sojson.gorgeousturn.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sojson.common.controller.BaseController;
import com.sojson.common.model.GorgeousturnM;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.core.shiro.cache.JedisManager;
import com.sojson.core.shiro.token.manager.TokenManager;
import com.sojson.gorgeousturn.service.GorgeousturnService;
/**
 * 
 * wan.dj
 *2017.12.19
 *华丽转身
 * 
 */
@Controller
@Scope(value="prototype")
@RequestMapping("gorgeousturn")
public class GorgeousturnController extends BaseController {
	/***
	 * 用户手动操作Session
	 * */
	@Autowired
	GorgeousturnService gorgeousturnService;
	@Autowired 
	JedisManager redis;
	
	//wan.dj 华丽转身所有会议 begin
	
	@InitBinder  
    public void initBinder(ServletRequestDataBinder binder) {  
        SimpleDateFormat dateFormat = new SimpleDateFormat(  
                "yyyy-MM-dd HH:mm:ss");  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(  
                dateFormat, true));  
    }
	
	
	//wan.dj 华丽转身所有会议 end
	/**
	 * 用户列表管理
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="gorgeousturnlist")
	public ModelAndView gorgeousturnlist(ModelMap map,Integer pageNo,String findContent) throws Exception{
		System.out.println("**************************************************************");
		
		
		
		
		map.put("findContent", findContent);
		Pagination<GorgeousturnM> page = gorgeousturnService.findByPage(map,pageNo,pageSize);
		System.out.println("page.getList-------"+page.getList()); 
		for(int y=0;y<page.getList().size();y++) {
			System.out.println(page.getList().get(y).getId());
		}
		map.put("page", page);
		//Iterator<String> iter = map.keySet().iterator(); 
		for(Entry<String, Object> vo : map.entrySet()){ 
			
          System.out.println(  vo.getKey());
          System.out.println(  vo.getValue() );
          if(vo.getKey() == "page") {
        	  System.out.println(   ((Pagination<GorgeousturnM>) vo.getValue()).getList());
          }
         
           
            System.out.println(vo.getKey()+"  "+vo.getValue()); 
        }
        
		System.out.println("开始打印map-----------************---------");
	  	System.out.println(map);
		System.out.println("开始打印gorgeousturnService-----------************---------");
	  	System.out.println(gorgeousturnService);
		System.out.println("开始打印page-----------************---------");
	  	System.out.println(page);
	  	System.out.println("*******---------------------------------------------------******");
	  	 byte[] key ="会议列表数据pagelist".getBytes() ;//SerializeUtil.serialize(123);
		 byte[] value=page.getList().toString().getBytes();//SerializeUtil.serialize('value_test');
		 redis.saveValueByKey(1,key,value, 5000000);//saveValueByKey();
		 
		 byte[] key1 =("123456").getBytes();//SerializeUtil.serialize(123);
		 byte[] value1=("456789").getBytes();//SerializeUtil.serialize('value_test');
		 redis.saveValueByKey(1,key1,value1, 5000000);//saveValueByKey();
		//可以自己写redis 在JedisManager中写入方法 即可
		byte[] re= redis.getValueByKey(1, key);
		 String tt = new String(re);//bytep[]转换为String
		 //byte[] 转换成string[]
		 String[] ttt=tt.split(",");
		// jedis.hmset("rmap",rmap);

	   
		 
		 
		 //jedisshirocache.put("789","123456789");
		 
		  
		 System.out.println("----------打印value值----------------");
		System.out.println(tt);
		 System.out.println("----------打印value值---end-------------");
		 
		return new ModelAndView("gorgeousturn/gorgeousturnlist");
	}
	
	@RequestMapping("meeting")//c测试代码
	public ModelAndView meeting() {
		List<GorgeousturnM> list = gorgeousturnService.getAllmeeting();
		return new ModelAndView("gorgeousturn/meeting","list",list); 
	}
 
	@RequestMapping(value="addmeeting",method=RequestMethod.POST)
	@ResponseBody
	public   Map<String,Object> addmeeting(GorgeousturnM gorgeousturnm) {
		try{
			
			Long userId = TokenManager.getUserId();
			gorgeousturnm.setCreatetor(userId);
			/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			Date cdate=sdf.parse(dateToString(new Date())); */
			gorgeousturnm.setCreatetime(dateToString(new Date()));
			GorgeousturnM entity=gorgeousturnService.insertmeeting(gorgeousturnm);
			resultMap.put("status", 200);
			resultMap.put("entity", entity);
	
		}catch(Exception e){
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
			
		}
				
		return resultMap;
		
	}
}
