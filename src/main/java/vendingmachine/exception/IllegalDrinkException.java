package vendingmachine.exception;

public class IllegalDrinkException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 상품입니다. 다시 입력해 주세요.";

    public IllegalDrinkException() {
        super(EXCEPTION_MESSAGE);
    }

    public IllegalDrinkException(final String message) {
        super(message);
    }
}