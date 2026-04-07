package transactionProcessor;
class InSufficientFundsException extends Exception {
    private static final long serialVersionUID = 1L;

    public InSufficientFundsException(String message) {
        super(message);
    }
}



