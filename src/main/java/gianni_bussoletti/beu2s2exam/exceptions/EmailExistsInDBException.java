package gianni_bussoletti.beu2s2exam.exceptions;

public class EmailExistsInDBException extends RuntimeException {
    public EmailExistsInDBException(String message) {
        super(message);
    }
}
