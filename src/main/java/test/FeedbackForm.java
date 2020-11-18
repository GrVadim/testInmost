package test;

import com.captcha.botdetect.web.jsf.JsfCaptcha;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class FeedbackForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String firstName;

    private String contactText;

    private String email;

    private String repeatEmail;

    private String captchaCode;

    private JsfCaptcha captcha;

    public void submit() {

        if (email == null || !email.equals(repeatEmail)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email does not match", "Validation Error"));
            return;
        }

        if (!captcha.validate(captchaCode)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Captcha validation failed", "Validation Error"));
            return;
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Success"));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getContactText() {
        return contactText;
    }

    public void setContactText(String contactText) {
        this.contactText = contactText;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepeatEmail() {
        return repeatEmail;
    }

    public void setRepeatEmail(String repeatEmail) {
        this.repeatEmail = repeatEmail;
    }

    public String getCaptchaCode() {
        return captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }

    public JsfCaptcha getCaptcha() {
        return captcha;
    }

    public void setCaptcha(JsfCaptcha captcha) {
        this.captcha = captcha;
    }
}