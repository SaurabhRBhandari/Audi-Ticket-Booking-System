package AudiTicketBook;

import java.io.FileWriter;
import java.io.IOException;

class WrongPasswordException extends Exception {
    public WrongPasswordException(String s) {
        super(s);
    }
}

public class User {
    protected String password;
    protected String userid;

    private boolean is_verified;

    public User( String userid, String password) {
        this.password = password;
        this.userid = userid;
        this.is_verified = false;
    }

    public boolean verify(String pass) throws WrongPasswordException {
        if (pass.equals(password)) {
            this.is_verified = true;
            return true;
        }
        throw new WrongPasswordException("Incorrect UserName / Password");
    }

    public String getName() {
        return null;
    }



}
