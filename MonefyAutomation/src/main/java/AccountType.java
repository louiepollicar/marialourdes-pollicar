public enum AccountType {

    ALLACCOUNTS("1"),
    CASH("2"),
    CARD("3");

    private String value;

    AccountType(String value){
        this.value = value;
    }

    public String getValue(){ return this.value;}
}
