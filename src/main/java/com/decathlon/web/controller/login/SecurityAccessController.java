package com.decathlon.web.controller.login;

import com.decathlon.service.account.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dengyuanqin on 16/3/28.
 */

@Controller
@RequestMapping
public class SecurityAccessController {
    @Autowired
    private UserService userService;
    protected static Logger logger = Logger.getLogger("controller");

    //handle and retrieve the login jsp page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(value = "error", required = false) boolean error, ModelMap model){
        logger.debug("Received request to show login page");

        // Add an error message to the model if login is unsuccessful
        // The 'error' parameter is set to true based on the when the authentication has failed.
        // We declared this under the authentication-failure-url attribute inside the spring-security.xml
		/* See below:
		 <form-login
				login-page="/login"
				authentication-failure-url="/login?error=true"
				default-target-url="/main/common"/>
		 */
        if(error == true){
            model.put("message","You have entered an invalid username or password !");
        }else {
            model.put("message","");
        }
        return "login/login";
    }

    //if page isn't right, it would jump to denied
    @RequestMapping(value = "/denied")
    public String denied(){
        return "login/denied";
    }

    @RequestMapping(value = "/logout/success")
    public String logoutSuccess(ModelMap model){
        model.put("message","Logout Success !");
        return "redirect: /login";
    }
}
