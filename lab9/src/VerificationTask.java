public class VerificationTask implements Runnable {
    private final Validator strategy;  // any strategy

    public VerificationTask(Validator strategy) {
        this.strategy = strategy;
    }

    @Override
    public void run() {
        strategy.validate();
    }
}
