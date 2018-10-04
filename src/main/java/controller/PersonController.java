package controller;

import common.SessionData;
import model.Person;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;
import util.BeanUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

@SessionScoped
@ManagedBean
public class PersonController {

    Person person;
    PersonDAOImpl personDAO;

    public PersonController(){
        person = new Person();
        personDAO = new PersonDAOImpl();
    }

    public boolean addPersonDS(AjaxBehaviorEvent e){
        personDAO.createPerson(person);
        Person person2 = personDAO.readPerson(person.getId());
        boolean success = person2.equals(person);
        if(success){
            PrimeFaces.current().executeScript("successModal()");
        }
        return success;
    }

    public void login(AjaxBehaviorEvent e){
        Person user = personDAO.getPersonByName(person.getName());
        if(user.getPassword().equals(person.getPassword())){
            SessionData sessionData = BeanUtil.getBean("sessionData");
            sessionData.setActiveUser(user);
            PrimeFaces.current().executeScript("navigate('overview.xhtml')");
        }else{
            PrimeFaces.current().executeScript("showToast('Passwort ist falsch!')");
        }
    }

    public Person getPersonDS(long id){
        return personDAO.readPerson(id);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
