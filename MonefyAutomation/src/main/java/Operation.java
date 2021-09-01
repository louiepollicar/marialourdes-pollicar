public enum Operation {
    PLUS("Plus"),
    MINUS("Minus"),
    MULTIPLY("Multiply"),
    DIVIDE("Divide"),
    EQUALS("Equals");

    private String value;

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
