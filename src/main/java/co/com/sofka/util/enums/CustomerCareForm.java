package co.com.sofka.util.enums;

public enum CustomerCareForm {

    NAME("name"),
    EMAIL("email"),
    PHONE("phone"),
    MESSAGE("message");

    private final String value;

    CustomerCareForm(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
