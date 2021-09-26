package enums.help;

public enum MenuValues {
    SIGN_UP("Sign up"),
    SIGN_IN("Sign in"),
    DISPLAY_TABLE("Display Table"),
    HISTORY("History"),
    LOGOUT("logout"),
    MY_ACCOUNT("My account");

    private String value;

    MenuValues(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
