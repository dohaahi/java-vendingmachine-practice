package vendingmachine.domain;

public enum VendingMachineStatus {
    AVAILABLE_PURCHASE("구매 가능"),
    NOT_AVAILABLE_PURCHASE("구매 불가능");
    private final String status;

    VendingMachineStatus(String status) {
        this.status = status;
    }
}
