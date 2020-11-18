package test;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

@ManagedBean
@SessionScoped
@FacesValidator("EmailValidator")
public class EmailValidator implements Validator {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    @Override
    public void validate(FacesContext facesContext,
                         UIComponent uiComponent,
                         Object o)
            throws ValidatorException {

        if (o == null) {
            return;
        }

        String email = (String) o;
        boolean matches = EMAIL_PATTERN.matcher(email)
                .matches();
        if (!matches) {
            FacesMessage msg = new FacesMessage(
                    FacesMessage.SEVERITY_FATAL,
                    "Email is invalid",
                    null);
            throw new ValidatorException(msg);
        }

    }
}