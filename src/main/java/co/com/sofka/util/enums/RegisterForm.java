package co.com.sofka.util.enums;

public enum RegisterForm {
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    ADDRESS("address"),
    CITY("city"),
    STATE("state"),
    ZIP_CODE("zipCode"),
    PHONE_NUMBER("phoneNumber"),
    SSN("ssn"),
    USERNAME("username"),
    PASSWORD("password"),
    CONFIRM_PASSWORD("confirmPassword");

    private final String value;

    RegisterForm(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}