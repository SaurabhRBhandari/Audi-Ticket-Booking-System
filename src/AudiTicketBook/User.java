package AudiTicketBook;

class WrongPasswordException extends Exception
{
    public WrongPasswordException(String s)
    {
        super(s);
    }
}
public class User {
    protected final String userID;
    protected String password;

    protected String name;

    public User(String userID, String password, String name)
    {
        this.userID=userID;
        this.password=password;
        this.name=name;
    }

    public boolean verify(String pass) throws WrongPasswordException
    {
        if(pass.equals(password)) return true;
        throw new WrongPasswordException("Incorrect UserName / Password");
    }

    public String getName()
    {
        return name;
    }

    public String getUserID()
    {
        return userID;
    }
}
