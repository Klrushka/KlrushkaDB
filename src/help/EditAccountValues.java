package help;

public enum EditAccountValues {
    CHANGE_USERNAME("Change user name"),
    CHANGE_FIRSTNAME("Change firstname"),
    CHANGE_SECONDNAME("Change secondname"),
    CHANGE_GENDER("Change gender"),
    CHANGE_BIRTHDAY("Change birthday"),
    CHANGE_MAIL("Change mail"),
    CHANGE_PASSWORD("Change password");

    private String value;

    EditAccountValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
