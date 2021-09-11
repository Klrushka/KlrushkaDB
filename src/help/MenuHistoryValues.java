package help;

public enum MenuHistoryValues {
    DISPLAY_HISTORY("Display history"),
    CLEAR_HISTORY("Clear history");

    private String value;

    MenuHistoryValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
