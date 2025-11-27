public interface Validator {
    void performValidation();
    void performValidation(int index);
    ValidationResult validate();
}