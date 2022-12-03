package AudiTicketBook;

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Wrong Username/Password");
    }
}

class UserExistsException extends Exception {
    public UserExistsException() {
        super("User already exists");
    }
}

class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException() {
        super("User already exists");
    }
}

class InvalidFileException extends Exception {
    public InvalidFileException() {
        super("File not formatted properly");
    }
}
