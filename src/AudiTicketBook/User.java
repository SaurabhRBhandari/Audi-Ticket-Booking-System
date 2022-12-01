package AudiTicketBook;

class WrongPasswordException extends Exception {
    public WrongPasswordException(String s) {
        super(s);
    }
}

public class User {
    protected String password;
    protected String name;
    private boolean is_verified;

    public User( String password, String name) {
        this.password = password;
        this.name = name;
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
        return name;
    }


}
