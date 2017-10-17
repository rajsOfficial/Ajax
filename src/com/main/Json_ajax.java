package com.main;

import java.io.IOException;



import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Json_ajax{
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public @ResponseBody String getJson(HttpServletRequest req, HttpServletResponse res) throws IOException, JSONException{
		System.out.println("into Spring");
		
		/*JSONObject jsonObject = null;
	    try {
	        jsonObject = new JSONObject(req.getParameter("jsonObject"));
	    } catch(JSONException e) {
	        System.out.println("Exception while getting json ");
	    }
	    
		String name = jsonObject.getString("name");
		String password = jsonObject.getString("password");
		System.out.println(name);
		System.out.println(password);
		
		
		*/
		String str= Utils.getPostData(req);
		System.out.println("str  :"+str);
		String str1= str.replace("null", "");
		JSONObject obj = new JSONObject(str1);
		
		/* This is one way of getting the data from the json string */
		
		POJO pojo = new POJO();
		pojo.setName(obj.getString("name"));
		pojo.setPassword(obj.getString("password"));
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(pojo);
	 
		// Using object mapper is the better way to get json as it is faster than the json object creation 
		ObjectMapper mapperobj = new ObjectMapper();
		String  jsonStr = mapperobj.writeValueAsString(pojo);
		System.out.println("JSON  :"+jsonStr);
		
	  /*  
		
		String name= req.getParameter("username");
		String password= req.getParameter("password");
		System.out.println(name);
		*/
		return jsonStr;
	}
	
}
