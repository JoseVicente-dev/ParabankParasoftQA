package co.com.sofka.util.enums;

public enum Login {

    USERNAME("username"),
    PASSWORD("password");

    private final String value;

    Login(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
