package vendingmachine.util;

import java.util.function.Supplier;

public class RetryHandler {
    public static <T> T retryIfFailure(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] " + exception.getMessage());
            }
        }
    }
}