package common;

import model.Person;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class SessionData {

    private Person activeUser;

    public Person getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Person activeUser) {
        this.activeUser = activeUser;
    }
}
