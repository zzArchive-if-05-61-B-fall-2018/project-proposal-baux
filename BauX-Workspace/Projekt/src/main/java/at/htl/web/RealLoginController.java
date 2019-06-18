package at.htl.web;

import at.htl.facades.SecretaryFacade;
import org.hibernate.validator.constraints.NotEmpty;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

@Model
@Named
public class RealLoginController {

    @Inject
    private SecretaryFacade secretaryFacade;

    @Size(min=4, max=20)
    @NotEmpty
    private String username;

    @Size(min=4, max=20)
    @NotEmpty
    private String password;


    public void setUsername(String name) {
        this.username = name;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @PostConstruct
    public void init() {
    }

    public void login() {

        if (secretaryFacade.validUser(username, password)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Congratulations! You've successfully logged in.");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);

            FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "index.xhtml");

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "That's the wrong password. Hint: BootsFaces rocks!");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
        }
    }

    public void forgotPassword() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default user name: BootsFaces");
        FacesContext.getCurrentInstance().addMessage("loginForm:username", msg);
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default password: rocks!");
        FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
    }
}
