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

    private String username;

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
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Eingeloggt");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);

            FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "workspace.xhtml");

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Username oder Passwort ist falsch");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
        }
    }
}
