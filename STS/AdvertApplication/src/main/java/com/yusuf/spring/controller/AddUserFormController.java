package com.yusuf.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yusuf.spring.pojo.User;
import com.yusuf.spring.dao.DAO;
import com.yusuf.spring.dao.UserDAO;
import com.yusuf.spring.exception.AdException;

@Controller
@RequestMapping("/adduser.htm")
public class AddUserFormController{

	@Autowired
	@Qualifier("userValidator")
	UserValidator userVal;
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(userVal);
	}
	
	@RequestMapping(method=RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("user") User user,BindingResult result) throws Exception
    {
		userVal.validate(user, result);
		if(result.hasErrors()){
			return "addUserForm";
		}
		
        try
        {
            UserDAO userDao = new UserDAO();
            userDao.create(user.getName(), user.getPassword(),user.getEmail().getEmailId());
            //DAO.close();
        }
        catch (AdException e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
        
        return "addedUser";
    }
    
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("user")User user, BindingResult result) { 
   
        return "addUserForm"; 
    } 
}