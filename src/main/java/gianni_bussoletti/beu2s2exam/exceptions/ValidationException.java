package gianni_bussoletti.beu2s2exam.exceptions;

import java.util.List;

public class ValidationException extends RuntimeException {

    private List<String> errorsList;

    public ValidationException(List<String> errorsList) {
        super("Errori di validazione");
        this.errorsList = errorsList;
    }

    public ValidationException(String message) {
        super(message);
    }
}
