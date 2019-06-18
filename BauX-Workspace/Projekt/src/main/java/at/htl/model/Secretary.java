package at.htl.model;

import  javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "secretary.getAll", query = "select d from Secretary d"),
        @NamedQuery(name = "secretary.findbyusername", query = "select d from Secretary d where d.username like :username")
})

@Table
@Entity
public class Secretary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int secretaryId;
    private String username;
    private String password;

    public Secretary(){ }

    //region Getter & Setter

    public int getSecretaryId() {
        return secretaryId;
    }

    public void setSecretaryId(int secretaryId) {
        this.secretaryId = secretaryId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //endregion
}
