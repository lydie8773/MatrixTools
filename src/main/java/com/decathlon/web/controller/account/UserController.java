package com.decathlon.web.controller.account;

import com.decathlon.common.util.extjs.FilterRequest;
import com.decathlon.common.util.extjs.JsonUtils;
import com.decathlon.common.util.extjs.ResponseMap;
import com.decathlon.service.account.UserService;
import com.decathlon.web.model.account.UserUI;
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
 * Created by dengyuanqin on 16/3/29.
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseMap<UserUI> responseMap;

    private Logger logger = Logger.getLogger(UserController.class);
    private final String ACCOUNT_TYPE = "Admin";

    @RequestMapping
    public String userAdminList(){
        return "admin/user/list";
    }

    @RequestMapping(value = "/list")
    public @ResponseBody
    Map<String,? extends Object> list(@RequestParam int page,@RequestParam int start,@RequestParam int limit,@RequestParam(required = false) Object filter) throws Exception{
        try {
            Pageable pageable = new PageRequest(page-1,limit);
            Page<UserUI> users = null;

            List<FilterRequest> filters = new ArrayList<FilterRequest>();
            filters.add(new FilterRequest("accountType", ACCOUNT_TYPE));

            if (filter!=null){
                filters.addAll(JsonUtils.getListFromJsonArray((String) filter));
            }

            users = userService.findAll(pageable,filters);
            long total = users.getTotalElements();
            logger.debug("users : "+users.getContent());

            return responseMap.mapOK(users.getContent(),total);
        }catch (Exception e){
            logger.error(e);
            return responseMap.mapError("Error retrieving account from database.");
        }
    }

    //Get one user detail information
    @RequestMapping(value = "/view/{username}")
    public String view(@PathVariable String username, Model model) throws Exception{
        UserUI user = userService.findByUsername(username);

        model.addAttribute("userBean",user);
        model.addAttribute("operationName","update");

        return "admin/user/view";
    }

    //Method to update
    @RequestMapping(value = "/update")
    public @ResponseBody Map<String,? extends Object> update(UserUI data) throws Exception{
        try {
            UserUI user = userService.update(data);

            if(user!=null){
                return responseMap.mapOK(user,"Account Updated Succesfully");
            }else {
                return responseMap.mapError("Error trying to update account");
            }
        }catch (Exception e){
            logger.error(e);
            return responseMap.mapError("Error trying to update account");
        }
    }

    //Add one new user, jump to add page
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add() throws Exception{
        return "admin/user/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody Map<String,? extends Object> add(UserUI data){
        try {
            if (userService.findByUsername(data.getUsername())!=null){
                return responseMap.mapError("Account name already exists");
            }

            UserUI savedUser = userService.create(data);
            if (savedUser != null){
                return responseMap.mapOK(savedUser,"Account created succesfully");
            }else {
                return responseMap.mapError("Error trying to create account");
            }
        }catch (Exception e){
            return responseMap.mapError("Error trying to create account");
        }
    }

    //Delete user
    public @ResponseBody Map<String,? extends Object> delete(@RequestParam(value = "users") String usernames){
        try {
            List<UserUI> deletedUsers = new ArrayList<UserUI>();

            for (String username : usernames.substring(1,usernames.length()-1).replaceAll("\"", "").split(",")){
                UserUI user = userService.findByUsername(username);
                if (user!=null){
                    userService.delete(user);
                    deletedUsers.add(user);
                }
            }
            return responseMap.mapOK(deletedUsers);
        }catch (Exception e){
            e.printStackTrace();
            return responseMap.mapError("Error trying to update account");
        }
    }
}























