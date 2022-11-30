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

    private boolean is_verified;

    public User(String userID, String password, String name)
    {
        this.userID=userID;
        this.password=password;
        this.name=name;
        this.is_verified=false;
    }

    public boolean verify(String pass) throws WrongPasswordException
    {
        if(pass.equals(password)){this.is_verified=true; return true;}
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
