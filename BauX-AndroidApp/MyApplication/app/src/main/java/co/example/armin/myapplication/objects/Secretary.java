package co.example.armin.myapplication.objects;

public class Secretary {
    private int secretaryID;
    private String secretaryName;
    private String secretaryPassword;

    public Secretary(int secretaryID, String secretaryName, String secretaryPassword){
        this.secretaryID = secretaryID;
        this.secretaryName = secretaryName;
        this.secretaryPassword = secretaryPassword;
    }

    public int getSecretaryID() {
        return secretaryID;
    }

    public void setSecretaryID(int secretaryID) {
        this.secretaryID = secretaryID;
    }

    public String getSecretaryName() {
        return secretaryName;
    }

    public void setSecretaryName(String secretaryName) {
        this.secretaryName = secretaryName;
    }

    public String getSecretaryPassword() {
        return secretaryPassword;
    }

    public void setSecretaryPassword(String secretaryPassword) {
        this.secretaryPassword = secretaryPassword;
    }
}
