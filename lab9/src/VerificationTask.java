public class VerificationTask implements Runnable {
    private final Validator validator;
    private final Integer index;

    public VerificationTask(Validator validator) {
        this.validator = validator;
        this.index = null;
    }

    public VerificationTask(Validator validator, int index) {
        this.validator = validator;
        this.index = index;
    }

    @Override
    public void run() {
        if (index == null) {
            validator.performValidation();
        } else {
            validator.performValidation(index);
        }
    }
}