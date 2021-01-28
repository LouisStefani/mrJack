package mrjack;




public enum Detective {
    HOLMES("\u001B[31m"+"Holmes"+"\u001B[0m", 12),
    WATSON("\u001B[31m"+"Watson"+"\u001B[0m", 4),
    TOBY("\u001B[31m"+"Toby"+"\u001B[0m", 8);


    private final String name;
    private int position;


    Detective(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


}
