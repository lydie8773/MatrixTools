package com.decathlon.web.controller.knowledgetree;

import com.decathlon.common.util.extjs.ResponseMap;
import com.decathlon.persistence.model.knowledgetree.Subdomain;
import com.decathlon.service.knowledgetree.SubdomainService;
import com.decathlon.web.model.knowledgetree.SubdomainUI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by DengYuanqin on 5/18/2016.
 */

@Controller
@RequestMapping("/subdomain")
public class SubdomainController {
    @Autowired
    private SubdomainService subdomainService;

    @Autowired
    private ResponseMap<SubdomainUI> subdomainResponse;

    private Logger logger = Logger.getLogger(SubdomainController.class);

    /*List of subdomains*/
    //Page admin for all subdomains.
    @RequestMapping(value = "/admin/subdomain/list")
    public String listSubdomainAdmin(){
        return "admin/subdomain/list";
    }

    //Page user for all subdomains.
    public String listSubdomainUser(){
        return "user/subdomain/list";
    }

    //Retrieve all subdomains from database
    @RequestMapping(value = "/listSubdomain")
    public @ResponseBody
    Map<String,? extends Object> listSubdomain(@RequestParam(value = "searchText",required = false) String search) throws Exception{
        try {
            List<SubdomainUI> subdomains = subdomainService.findAllBySearch(search);
            return subdomainResponse.mapOK(subdomains);
        }catch (Exception e){
            return subdomainResponse.mapError("Error retrieving subdomains from database.");
        }
    }

    /*One subdoamin*/
    //Page admin for one subdomain
    @RequestMapping(value = "/admin/subdomain/view/{subdomainid}")
    public String getSubdomainAdmin(@PathVariable String subdomainid, Model model) throws Exception{
        SubdomainUI subdomain = subdomainService.findBySubdomainid(new Long(subdomainid).longValue());
        model.addAttribute("subdoaminBean",subdomain);
        return  "admin/subdomain/view";
    }

    @RequestMapping(value = "/user/subdomain/view/{subdomainid}")
    public String getSubdomainUser(@PathVariable String subdomainid, Model model) throws Exception{
        SubdomainUI subdomain = subdomainService.findBySubdomainid(new Long(subdomainid).longValue());
        model.addAttribute("subdoaminBean",subdomain);
        return  "user/subdomain/view";
    }
}



















