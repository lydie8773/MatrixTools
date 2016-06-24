package com.decathlon.web.controller.knowledgetree;

import com.decathlon.common.util.extjs.FilterRequest;
import com.decathlon.common.util.extjs.JsonUtils;
import com.decathlon.common.util.extjs.ResponseMap;
import com.decathlon.service.knowledgetree.DomainService;
import com.decathlon.web.model.knowledgetree.DomainUI;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by DengYuanqin on 4/15/2016.
 */


/**
 * User controller is exchange between model and view.
 * Conroller can have the read,add,update,delete functions.
 */
@Controller
@RequestMapping("/")
public class DomainController {

    @Autowired
    private DomainService domainService;

    @Autowired
    private ResponseMap<DomainUI> responseMap;

    private Logger logger = Logger.getLogger(DomainController.class);

    //Define url the list of domain page for Admin
    @RequestMapping(value = "/admin/domain/list")
    public String domainAdminList(){
        return "admin/domain/list";
    }

    //Define url the list of domain page for user
    @RequestMapping(value = "/user/domain/list")
    public String domainUserList(){
        return "user/domain/list";
    }

    //Retrieve all the domains
    @RequestMapping(value = "/list")
    public @ResponseBody
    Map<String, ? extends Object> list(@RequestParam(value = "searchText", required = false) String search) throws Exception{
        try {
            List<DomainUI> domains = domainService.findAllSearchByPage(search);
            return responseMap.mapOK(domains);
        }catch (Exception e){
            return responseMap.mapError("Error retrieving domains from database");
        }
    }

    //Get the page for the view of one domain information for ADMIN
    @RequestMapping(value = "/admin/domain/view/{domainid}")
    public String viewAdmin(@PathVariable String domainid, Model model) throws Exception{
        DomainUI domain = domainService.findByDomainid(new Long(domainid).longValue());
        model.addAttribute("domainBean",domain);
        return "admin/domain/view";
    }

    //Get the page for the view of one domain information for USER
    @RequestMapping(value = "/user/domain/view/{domainid}")
    public String viewUser(@PathVariable String domainid, Model model) throws Exception{
        DomainUI domain = domainService.findByDomainid(new Long(domainid).longValue());
        model.addAttribute("domainBean", domain);
        return "user/domain/view";
    }

    //Jumping to the ADMIN page for the update
    @RequestMapping(value = "/admin/domain/viewUpdateDomain/{domainid}")
    public String viewUpdateAdminDomain(@PathVariable String domainid, Model model) throws Exception{
        DomainUI domain = domainService.findByDomainid(new Long(domainid).longValue());
        model.addAttribute("domainBean", domain);
        return "admin/domain/viewUpdateDomain";
    }

    //Jumping to the USER page for the update
    @RequestMapping(value = "/user/domain/viewUpdateDomain/{domainid}")
    public String viewUpdateUserDomain(@PathVariable String domainid, Model model) throws Exception{
        DomainUI domain = domainService.findByDomainid(new Long(domainid).longValue());
        model.addAttribute("domainBean", domain);
        return "user/domain/viewUpdateDomain";
    }

    //Methode for the update
    @RequestMapping(value = "/update")
    public @ResponseBody Map<String,? extends Object> update(DomainUI uiBean) throws Exception{
        try {
            DomainUI domain = domainService.update(uiBean);
            if (domain == null){
                return responseMap.mapError("Error for trying to update domain.");
            }else {
                return responseMap.mapOK(domain,"Domain updated Successfully");
            }
        }catch (Exception e){
            return responseMap.mapError("Error for trying to update domain");
        }
    }

    //Page for the ADMIN add
    @RequestMapping(value = "/admin/domain/add", method = RequestMethod.GET)
    public String addAdminDomain() throws Exception{
        return "admin/domain/add";
    }

    //Page for the User add
    @RequestMapping(value = "/user/domain/add", method = RequestMethod.GET)
    public String addUserDomain() throws Exception{
        return "user/domain/add";
    }

    //Method for the add of domain
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody Map<String, ? extends Object> add(@RequestParam String domainname){
        try {
            DomainUI domain = new DomainUI();
            domain.setDomainname(domainname);

            if (domainService.findByDomainname(domain).getDomainname()!=null){
                return responseMap.mapError("Domain already exists.");
            }

            DomainUI saved = domainService.create(domain);
            return responseMap.mapOK(saved,"Domain created Successfully");
        }catch (Exception e){
            return responseMap.mapError("Error trying to create Domain");
        }
    }
}
























