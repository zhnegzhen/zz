package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.dao.UserMapper;
import com.example.models.User;
import com.example.utils.WebSecurityConfig;

@Controller
public class LoginController {
	@Autowired
	private UserMapper userMapper;
    
	
	   @GetMapping("/")
	    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String username, Model model) {
	        model.addAttribute("username", username);
	        return "index";
	    }
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/loginPost",method=RequestMethod.POST)
	public String loginPost(String username,String password,HttpSession session){
		   User user=userMapper.getUserID(1);
		    String password1=user.getPassword();
		  if (!password1.equals(password)) {
			  
	            return "error";
	        }

	        // 设置session
	        session.setAttribute(WebSecurityConfig.SESSION_KEY,username);

	        return "index";
	    }
		

	
	
	
	    }
	
	    	

