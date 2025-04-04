package uni.cs.tradingclient.model;

/**
 *
 * @author lucakoelzsch
 */
public class User {
    private int userID;
    private String email, iban;
    private String firstname, lastname;

    public User(int userID, String email, String iban, String firstname, String lastname) {
        this.userID = userID;
        this.email = email;
        this.iban = iban;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getIban() {
        return iban;
    }

    public String getLastname() {
        return lastname;
    }

    public int getUserID() {
        return userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
