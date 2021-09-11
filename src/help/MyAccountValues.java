package help;

public enum MyAccountValues {
    INFORMATION("Information"),
    EDIT_ACCOUNT("Edit account");

    private String value;

    MyAccountValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
