package hr.algebra.java2.milionare.enumMessages;

public enum EndMessages {
    Win_message("YOU ARE A MILIONARE"),
    Not_win_message("You are not a millionare but you did win money!");

    private final String stringValue;

    EndMessages(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
