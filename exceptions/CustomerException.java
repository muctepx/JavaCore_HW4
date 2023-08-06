package JavaCore.HW4.exceptions;

public class CustomerException extends Exception {
    public CustomerException() {
        super("Покупатель не найден");
    }

    public CustomerException(String message) {
        super(message);
    }
}
