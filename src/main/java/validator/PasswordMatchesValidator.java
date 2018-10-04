package validator;


import controller.PersonController;
import model.Person;
import util.BeanUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("PasswordMatchesValidator")
public class PasswordMatchesValidator implements Validator{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String pw = o.toString();
        PersonController personController = BeanUtil.getBean("personController");
        if(!pw.matches(personController.getPerson().getPassword())){
            FacesMessage msg =
                    new FacesMessage("Die eingegebenen Passwörter stimmen nicht überein","Die eingegebenen Passwörter stimmen nicht überein");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
