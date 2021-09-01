public enum Category {
    DEPOSITS("1", "Deposits"),
    SALARY("2", "Salary"),
    SAVINGS("3", "Savings"),
    BILLS("1", "Bills"),
    CAR("2", "Car"),
    CLOTHES("3", "Clothes"),
    COMMUNICATIONS("4", "Communications"),
    EATINGOUT("5", "Eating out"),
    ENTERTAINMENT("6", "Entertainment"),
    CASH("","Cash"),
    CARD("", "Payment card");


    private String value;
    private String text;

    Category(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getText(){ return this.text;}

    public String getValue() {
        return this.value;
    }
}
