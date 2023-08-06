package JavaCore.HW4.exceptions;

public class AmountException extends Exception {
    public AmountException() {
        super("Указано неверное количество товаров");
    }

    public AmountException(String message) {
        super(message);
    }
}
