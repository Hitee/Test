package com.deloitte.trg.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.trg.model.User;

@Controller
@RequestMapping(value="/logc")
public class LoginController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewLogin() {
		return new ModelAndView("login","user",new User());
	}
	
	@RequestMapping(value="/verify", method=RequestMethod.POST)
	public String doLogin( @Valid @ModelAttribute("user") User user,
			BindingResult result, HttpServletRequest request, Model model){
		try {
			if(result.hasErrors()) {
				List<ObjectError> errorList=result.getAllErrors();
				System.out.println(errorList);
				return "login";
			}else {
				if(isValidCredential(user)) {
					HttpSession session= request.getSession();
					session.setAttribute("userid", user.getUserId());
					return "main_menu";
				}else{
					model.addAttribute("message","Invalid Credentials");
					return "status";
				}
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		model.addAttribute("status","Invalid Credentials");
		return "statuslog";
	}

	private boolean isValidCredential(User user) {
		if("admin".equals(user.getUserId()) && "admin@123".equals(user.getPassword())) {
			return true;
		}
		return false;
	}
}
