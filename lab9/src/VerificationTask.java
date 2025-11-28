public class VerificationTask implements Runnable {
    private final Validator validator;
    private final Integer index;  // null = validate all, number = validate specific

    // Constructor for Mode 3 (validate ALL)
    public VerificationTask(Validator validator) {
        this.validator = validator;
        this.index = null;
    }

    // Constructor for Mode 27 (validate ONE specific)
    public VerificationTask(Validator validator, int index) {
        this.validator = validator;
        this.index = index;
    }

    @Override
    public void run() {
        if (index == null) {
            // Mode 3: Validate ALL
            validator.performValidation();
        } else {
            // Mode 27: Validate ONE
            validator.performValidation(index);
        }
    }
}