package mrjack;

public class MrJack extends Player {
    public int nbSabliers;
    public PersonnagePlateau coupable;

    public MrJack(int nbSabliers, PersonnagePlateau coupable) {
        super("MrJack");
        this.nbSabliers = nbSabliers;
        this.coupable = coupable;
    }

    public int getNbSabliers() {
        return nbSabliers;
    }

    public PersonnagePlateau getCoupable() {
        return coupable;
    }

    public void setCoupable(PersonnagePlateau coupable) {
        this.coupable = coupable;
    }

    public void setNbSabliers(int nbSabliers) {
        this.nbSabliers = nbSabliers;
    }
}
