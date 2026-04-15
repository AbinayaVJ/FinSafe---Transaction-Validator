package transactionProcessor;
class InSuffFundsException extends Exception {
    private static final long serialVersionUID = 1L;
    public InSuffFundsException(String msg) {
        super(msg);
    }
}
