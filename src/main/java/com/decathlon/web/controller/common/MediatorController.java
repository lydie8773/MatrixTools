package com.decathlon.web.controller.common;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dengyuanqin on 16/3/29.
 */
@Controller
@RequestMapping("/")
public class MediatorController {
    private static final Logger logger = Logger.getLogger(MediatorController.class);

    //Get the admin home page
    @RequestMapping(value = "/admin/common/home")
    public String getAdminHomePage(Locale locale, Model model) {
        logger.debug("Welcome home! The client locale is { "+locale+" }.");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);
        return "admin/common/home";
    }

    //Get the user home page
    @RequestMapping(value = "/user/common/home")
    public String getUserHomePage(){
        return "user/common/home";
    }

    //Get the user help page
    @RequestMapping(value = "/user/common/help")
    public String getUserHelpPage(){
        return "user/common/help";
    }

    //Get the admin help page
    @RequestMapping(value = "/admin/common/help")
    public String getAdminHelpPage(){
        return "admin/common/help";
    }
}
