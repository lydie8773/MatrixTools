package com.decathlon.common.util.mapper.account;

import com.decathlon.persistence.model.account.User;
import com.decathlon.web.model.account.UserUI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DengYuanqin on 3/24/2016.
 */
public class UserMapper {

    public UserUI toUIBean(User data){
        UserUI ui = new UserUI();
        if(data != null){
            ui.setUserid(data.getUserid());
            ui.setUsername(data.getUsername());
            ui.setLoginname(data.getLoginname());
            ui.setPassword(data.getPassword());
            ui.setEmail(data.getEmail());
            ui.setRole(data.getRole());
        }
        return ui;
    }

    public List<UserUI> toUIBean(List<User> data){
        List<UserUI> ui = new ArrayList<UserUI>();
        for (User u:data){
            ui.add(toUIBean(u));
        }
        return ui;
    }

    public Page<UserUI> toUIBean(Page<User> users, Pageable pageable){
        Page<UserUI> uiBeans = new PageImpl<UserUI>(toUIBean(users.getContent()),pageable,users.getTotalElements());
        return uiBeans;
    }

    public User toPersistenceBean(UserUI ui){
        User data= new User();
        if(ui !=null){
            data.setUserid(ui.getUserid());
            data.setLoginname(ui.getLoginname());
            data.setUsername(ui.getUsername());
            data.setPassword(ui.getPassword());
            data.setEmail(ui.getEmail());
            data.setRole(ui.getRole());
        }
        return data;
    }

    public List<User> toPersistenceBean(List<UserUI> ui){
        List<User> data = new ArrayList<User>();
        for(UserUI u:ui){
            data.add(toPersistenceBean(u));
        }
        return data;
    }
}
















