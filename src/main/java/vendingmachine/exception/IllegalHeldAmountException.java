package vendingmachine.exception;

public class IllegalHeldAmountException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 보유 금액입니다. 다시 입력해 주세요.";

    public IllegalHeldAmountException() {
        super(EXCEPTION_MESSAGE);
    }

    public IllegalHeldAmountException(final String message) {
        super(message);
    }
}