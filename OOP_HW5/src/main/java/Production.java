public enum Production {
    _NULL(0),
    PorkBurger(1),
    BeefBurger(2),
    FishBurger(3),
    Frenchfries(4),
    Nugget(5),
    Salad(6),
    Cola(7),
    Spirit(8),
    CaramelMilktea(9),
    Latte(10);

    private final int code;

    Production(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
