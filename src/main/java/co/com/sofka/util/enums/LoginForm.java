package co.com.sofka.util.enums;

public enum LoginForm {

    USERNAME("username"),
    PASSWORD("password");

    private final String value;

    LoginForm(String value) {
        this.value=value;
    }

    public String getValue() {
        return this.value;
    }
}
