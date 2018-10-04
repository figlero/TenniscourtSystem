package controller;

import model.UserBean;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.util.ArrayList;

@SessionScoped
@ManagedBean
public class UserController {

    private UserBean user;
    private ArrayList<UserBean> userList;

    @PostConstruct
    public void initUser() {
        user = new UserBean();
        UserBean user1 = new UserBean();
        user1.setPassword("password");
        user1.setUsername("username");
        userList = new ArrayList<UserBean>();
        userList.add(user1);
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public void login(AjaxBehaviorEvent e) {
        for (UserBean pointer : userList) {
            if (pointer.getUsername().equals(user.getUsername())) {
                if (pointer.getPassword().equals(user.getPassword())) {
                    PrimeFaces.current().executeScript("window.location='home.xhtml'");
                    return;
                }
            }
        }
        PrimeFaces.current().executeScript("PF('loginDialog').show();");
    }
}
