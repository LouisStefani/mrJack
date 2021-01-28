package mrjack;

public enum PersonnagePlateau {
    ROSE("rose\u001B[0m", 2, "\u001B[35m"),
    NOIR("noir\u001B[0m", 0, "\u001B[35m"),
    ORANGE("orange\u001B[0m", 1, "\u001B[35m"),
    VIOLET("violet\u001B[0m", 1, "\u001B[35m"),
    VERT("vert\u001B[0m", 1, "\u001B[35m"),
    JAUNE("jaune\u001B[0m", 1, "\u001B[35m"),
    BLEU("bleu\u001B[0m", 0, "\u001B[35m"),
    BLANC("blanc\u001B[0m", 1, "\u001B[35m"),
    MARRON("marron\u001B[0m", 1, "\u001B[35m");


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private String couleur;
    private int sablier;
    private String innocence;

    PersonnagePlateau(String couleur, int sablier, String innocence) {
        this.couleur = couleur;
        this.sablier = sablier;
        this.innocence = innocence;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getSablier() {
        return sablier;
    }

    public String getInnocence() {
        return innocence;
    }

    public void setInnocence(String innocence) {
        this.innocence = innocence;
    }
}
