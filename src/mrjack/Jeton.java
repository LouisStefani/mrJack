package mrjack;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum Jeton {
    Watson("watson", "faire avancer Watson", "faire avancer Tobby"){
        @Override
        void actionPile(Plateau plateau){
            System.out.println("De combien voulez-vous faire avancer Watson?");
            Scanner sc = new Scanner(System.in);
            int avancement = sc.nextInt();
            System.out.println("J'avance Watson de "+ avancement);
            plateau.avancement(avancement, Detective.WATSON);
        }
        @Override
        void actionFace(Plateau plateau){
            System.out.println("De combien voulez-vous faire avancer Toby?");
            Scanner sc = new Scanner(System.in);
            int avancement = sc.nextInt();
            System.out.println("J'avance Toby de "+ avancement);
            plateau.avancement(avancement, Detective.TOBY);
        }
    },
    Permutation( "permutation", "permuter deux tuiles","rotation d'une tuile" ){
        @Override
        void actionPile(Plateau plateau){
            Scanner sc = new Scanner(System.in);
                System.out.println("Quels districts voulez-vous permuter?");
                String first_district = sc.nextLine();
                String second_district = sc.nextLine();
                // sc.nextline();
                System.out.println("I'm permuting district " + first_district+ " with District " + second_district);
                plateau.permute(first_district, second_district);
        }
        @Override
        void actionFace(Plateau plateau){
             Scanner sc = new Scanner(System.in);
                System.out.println("Quel district voulez-vous tourner?");
                String first_district = sc.nextLine();
                System.out.println("Dans quelle position souhaitez-vous tourner ce District?");
                int orientation = Integer.parseInt(sc.nextLine()) % 4;
                System.out.println("Je tourne le District " + first_district+ " dans la position " + orientation );
                plateau.rotate(first_district, orientation);

        }
    },
    Holmes("holmes", "faire avancer Holmes", "tirer une carte Alibi"){
        @Override
        void actionPile(Plateau plateau){
            System.out.println("De combien voulez-vous faire avancer Holmes?");
            Scanner sc = new Scanner(System.in);
            int avancement = sc.nextInt();
            System.out.println("J'avance Holmes de "+ avancement);
            plateau.avancement(avancement, Detective.HOLMES);
        }
        @Override
        void actionFace(Plateau plateau){
            System.out.println("vous tirez une carte alibi");
            Partie.tirerCarteAlibi();
        }
    },
    Joker("joker", "Joker détective", "rotation d'une tuile"){
        @Override
        void actionPile(Plateau plateau){
            System.out.println("Qui voulez-vous faire avancer de 1?");
            Scanner sc = new Scanner(System.in);
            String deplacerDetective = sc.nextLine();
            System.out.println("J'avance Watson de 1");
            plateau.avancementJoker(deplacerDetective);
        }
        @Override
        void actionFace(Plateau plateau){
            Scanner sc = new Scanner(System.in);
                System.out.println("Quel district voulez-vous tourner?");
                String first_district = sc.nextLine();
                System.out.println("Dans quelle position souhaitez-vous tourner ce District?");
                int orientation = sc.nextInt();
                System.out.println("Je tourne le District " + first_district+ " dans la position " + orientation );
                plateau.rotate(first_district, orientation);
        }
    };
    public static Logger logger = Logger.getLogger(Jeton.class.getName());

    private final String nom;
    private final String actionJetonFace;
    private final String actionJetonPile;
    private String cotePiece = "pile";
    Jeton(String nom, String actionJetonPile, String actionJetonFace){
        this.nom = nom;
        this.actionJetonFace = actionJetonFace;
        this.actionJetonPile = actionJetonPile;
    }

    public String getActionJetonFace() {
        return actionJetonFace;
    }

    public String getActionJetonPile() {
        return actionJetonPile;
    }

    public String getNom() {
        return nom;
    }

    public String getCotePiece() {
        return cotePiece;
    }

    public void setCotePiece(String cotePiece) {
        this.cotePiece = cotePiece;
    }

    public void action (Plateau plateau, String cotePiece){
        logger.setLevel(Level.WARNING);
        logger.info("Help me!");
        logger.severe(String.format("Executing action with the following jeton: %s", this.name()));
        if (cotePiece.equals("pile")){
            actionPile(plateau);
        } else if (cotePiece.equals("face")){
            actionFace(plateau);
        } else{
            System.out.println("I don't recognize this action");
            logger.log(Level.INFO,"I don't recognize this action\n");
            throw new IllegalArgumentException("Une pièce a seulement deux côtés: pile ou face");
        }
    }

    abstract void actionPile(Plateau plateau);

    abstract void actionFace(Plateau plateau);

    public static void main(String[] args){
        try{
            Jeton.Permutation.action(new Plateau(), "pile");
        } catch (IllegalArgumentException e){
            Jeton.logger.severe(String.format("%s occured with the following message %s", e.getClass(), e.getLocalizedMessage()));
            throw e;
        }
    }

}
