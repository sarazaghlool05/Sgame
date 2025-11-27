public class VerificationTask implements Runnable {

    private final Validator validator;

    public VerificationTask(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void run() {
        validator.validate();
    }
}
