package AudiTicketBook;

class WrongPasswordException extends Exception {
    public WrongPasswordException(String s) {
        super(s);
    }
}