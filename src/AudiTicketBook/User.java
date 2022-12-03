package AudiTicketBook;

public class User {
    protected String password;
    protected String userid;


    public User(String userid, String password) {
        this.password = password;
        this.userid = userid;
    }

    public boolean verify(String pass) throws WrongPasswordException {
        if (pass.equals(password)) {
            return true;
        }
        throw new WrongPasswordException();
    }

    public String getName() {
        return null;
    }


}
