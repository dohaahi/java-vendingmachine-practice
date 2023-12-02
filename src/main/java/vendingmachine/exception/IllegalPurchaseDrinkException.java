package vendingmachine.exception;

public class IllegalPurchaseDrinkException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "유효하지 않은 구매 상품입니다. 다시 입력해 주세요.";

    public IllegalPurchaseDrinkException() {
        super(EXCEPTION_MESSAGE);
    }

    public IllegalPurchaseDrinkException(final String message) {
        super(message);
    }
}