package mrjack;

public enum District {
    ROSE(1, PersonnagePlateau.ROSE, 1),
    NOIR(1, PersonnagePlateau.NOIR, 2),
    ORANGE(1, PersonnagePlateau.ORANGE, 3),
    VIOLET(1, PersonnagePlateau.VIOLET, 4),
    VERT(1, PersonnagePlateau.VERT, 5),
    JAUNE(1, PersonnagePlateau.JAUNE, 6),
    BLEU(1, PersonnagePlateau.BLEU, 7),
    BLANC(1, PersonnagePlateau.BLANC, 8),
    MARRON(1, PersonnagePlateau.MARRON ,9);


    private int orientation;
    private final PersonnagePlateau personnagePlateau;
    private int position;

    District(int orientation, PersonnagePlateau personnagePlateau, int position) {
        this.orientation = orientation;
        this.personnagePlateau = personnagePlateau;
        this.position = position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getOrientation() {
        return orientation;
    }

    public PersonnagePlateau getPersonnagePlateau() {
        return personnagePlateau;
    }

    public int getPosition() {
        return position;
    }

    public void changer() {
        System.out.println("I'm going to switch");
    }
}
