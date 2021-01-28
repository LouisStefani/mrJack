package mrjack;

import java.util.*;

public class Partie {
    private int currentTurn;
    private ArrayList<Jeton> jetons;
    private ArrayList<Jeton> jetonsRestants;
    private static ArrayList<PersonnagePlateau> carteAlibisRestantes;
    private static MrJack mrJack;
    private static ArrayList<Detective> detective;  
    private Plateau plateau;
    private static String joueur;

    public Partie() {
        this.detective = new ArrayList<>(Arrays.asList(Detective.values()));
        this.plateau = new Plateau();
        plateau.initialisation();
        this.currentTurn = 1;
        this.jetons = new ArrayList<>(Arrays.asList(Jeton.values()));
        this.carteAlibisRestantes = new ArrayList<>(Arrays.asList(PersonnagePlateau.values()));
        initialisationCarteAlibi();
        initialisationJack();
    }

    public static ArrayList<Detective> getDetective() {
        return detective;
    }

    public static void setDetective(ArrayList<Detective> detective) {
        Partie.detective = detective;
    }

    public void initialisationJack(){
        mrJack = new MrJack(0, PersonnagePlateau.ROSE);
        PersonnagePlateau coupable = carteAlibisRestantes.get(0);
        carteAlibisRestantes.remove(0);
        mrJack.setCoupable(coupable);
        int sablier = coupable.getSablier() ;
        mrJack.setNbSabliers(sablier);
    }

    public void initialisationCarteAlibi(){
        Collections.shuffle(carteAlibisRestantes);
    }


    public int getCurrentTurn() {
        return currentTurn;
    }

    public ArrayList<Jeton> getJetons() {
        return jetons;
    }

    public ArrayList<PersonnagePlateau> getCarteAlibisRestantes() {
        return carteAlibisRestantes;
    }

    public static void tirerCarteAlibi() {
        PersonnagePlateau carteAlibi = carteAlibisRestantes.get(0);
        carteAlibisRestantes.remove(0);
        if (joueur.equals("MrJack")){
            int nbSablier = mrJack.getNbSabliers();
            nbSablier = nbSablier + carteAlibi.getSablier();
            mrJack.setNbSabliers(nbSablier);
        }

    }

    public void choixJetons (){
        if (this.currentTurn % 2 == 1){
            Scanner sc = new Scanner(System.in);
            System.out.println("le detective choisit un jeton");
            joueur = "detective";
            String jetonChoisi1 = sc.nextLine();
            Jeton jeton1 = this.jetons.get(1);
            for (Jeton jeton : this.jetons) {
                if (jeton.getNom().toLowerCase().equals(jetonChoisi1.toLowerCase())) {
                    jeton1 = jeton;
                }
            }
            if(jeton1.getCotePiece().equals("face")){
                jeton1.actionFace(plateau);
            }
            else{
                jeton1.actionPile(plateau);
            }
            jetonsRestants.remove(jeton1);
            System.out.println("Mrjack choisit deux jetons");
            joueur = "MrJack";
            sc = new Scanner(System.in);
            String jetonChoisi2 = sc.nextLine();
            Jeton jeton2 = this.jetons.get(1);
            for (Jeton jeton : this.jetons) {
                if (jeton.getNom().toLowerCase().equals(jetonChoisi2.toLowerCase())) {
                    jeton2 = jeton;
                }
            }
            if(jeton2.getCotePiece().equals("face")){
                jeton2.actionFace(plateau);
            }
            else{
                jeton2.actionPile(plateau);
            }
            jetonsRestants.remove(jeton2);
            sc = new Scanner(System.in);
            String jetonChoisi3 = sc.nextLine();
            Jeton jeton3 = this.jetons.get(1);
            for (Jeton jeton : this.jetons) {
                if (jeton.getNom().toLowerCase().equals(jetonChoisi3.toLowerCase())) {
                    jeton3 = jeton;
                }
            }
            if(jeton3.getCotePiece().equals("face")){
                jeton3.actionFace(plateau);
                jetonsRestants.remove(jeton3);
            }
            else if (jeton3.getCotePiece().equals("pile")){
                jeton3.actionPile(plateau);
                jetonsRestants.remove(jeton3);
            }
            if (jetonsRestants.get(0).getCotePiece().equals("face")){
                joueur = "detective";
                jetonsRestants.get(0).actionFace(plateau);
            }
            if(jetonsRestants.get(0).getCotePiece().equals("pile")){
                joueur = "detective";
                jetonsRestants.get(0).actionPile(plateau);
            }
            System.out.println("le detective prend le dernier jeton");

        }
        else if (this.currentTurn % 2 == 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("Mr.Jack choisit un jeton");
            joueur = "MrJack";
            String jetonChoisi1 = sc.nextLine();
            Jeton jeton1 = this.jetons.get(1);
            for (Jeton jeton : this.jetons) {
                if (jeton.getNom().toLowerCase().equals(jetonChoisi1.toLowerCase())) {
                    jeton1 = jeton;
                }
            }
            if(jeton1.getCotePiece().equals("face")){
                jeton1.actionFace(plateau);
            }
            else{
                jeton1.actionPile(plateau);
            }
            jetonsRestants.remove(jeton1);
            System.out.println("le detective choisit deux jetons");
            joueur = "detective";
            String jetonChoisi2 = sc.nextLine();
            Jeton jeton2 = this.jetons.get(1);
            for (Jeton jeton : this.jetons) {
                if (jeton.getNom().toLowerCase().equals(jetonChoisi2.toLowerCase())) {
                    jeton2 = jeton;
                }
            }
            if(jeton2.getCotePiece().equals("face")){
                jeton2.actionFace(plateau);
            }
            else{
                jeton2.actionPile(plateau);
            }
            jetonsRestants.remove(jeton2);
            String jetonChoisi3 = sc.nextLine();
            Jeton jeton3 = this.jetons.get(1);
            for (Jeton jeton : this.jetons) {
                if (jeton.getNom().toLowerCase().equals(jetonChoisi3.toLowerCase())) {
                    jeton3 = jeton;
                }
            }
            if(jeton3.getCotePiece().equals("face")){
                jeton3.actionFace(plateau);
                jetonsRestants.remove(jeton3);
            }
            else if (jeton3.getCotePiece().equals("pile")){
                jeton3.actionPile(plateau);
                jetonsRestants.remove(jeton3);
            }
            if (jetonsRestants.get(0).getCotePiece().equals("face")){
                joueur = "MrJack";
                jetonsRestants.get(0).actionFace(plateau);
            }
            if(jetonsRestants.get(0).getCotePiece().equals("pile")){
                joueur = "MrJack";
                jetonsRestants.get(0).actionPile(plateau);
            }
            System.out.println("Mr.Jack prend le dernier jeton");

        }
    }

    public MrJack getMrJack() {
        return mrJack;
    }

    public void playTurn() {
        if (this.currentTurn % 2 == 1) {
            this.generateJetons();
        } else {
            this.flipJetons();
        }
    }


    public void affichageTableau(){
        String[] ligne1demiHaut = {"\t\t\t", "\t\t\t","\t\t\t", "\t\t\t","\t\t\t"};
        String[] ligne1demiBas = {"\t\t\t", "\t\t\t","\t\t\t", "\t\t\t","\t\t\t"};
        String[] ligne2demiHaut ={"\t\t\t", "\t\t\t","\t\t\t", "\t\t\t","\t\t\t"};
        String[] ligne2demiBas = {"\t\t\t", "\t\t\t","\t\t\t", "\t\t\t","\t\t\t"};
        String[] ligne3demiHaut = {"\t\t\t", "\t\t\t","\t\t\t", "\t\t\t","\t\t\t"};
        String[] ligne3demiBas = {"\t\t\t", "\t\t\t","\t\t\t", "\t\t\t","\t\t\t"};
        String [][] tableauPlateau = {{"\t\t\t", "\t\t\t","\t\t\t", "\t\t\t","\t\t\t"},{"\t\t\t", "\t\t\t","\t\t\t", "\t\t\t","\t\t\t"},{"\t\t\t", "\t\t\t","\t\t\t", "\t\t\t","\t\t\t"},{"\t\t\t", "\t\t\t","\t\t\t", "\t\t\t","\t\t\t"},{"\t\t\t", "\t\t\t","\t\t\t", "\t\t\t","\t\t\t"}};
        for (int i = 0; i<9 ; i++){
            int positiontuile = plateau.districts.get(i).getPosition();
            //tuile 1
            if(positiontuile == 1){
                //nord
                if (plateau.districts.get(i).getOrientation() == 1 ){
                    tableauPlateau[1][1] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur()+ "\t";
                    ligne1demiBas[1] = "\t --- \t";
                }
                //est
                else if (plateau.districts.get(i).getOrientation() == 2){
                    tableauPlateau[1][1] = "|" +plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur()+"\t";
                }
                //sud
                else if (plateau.districts.get(i).getOrientation() == 3){
                    tableauPlateau[1][1] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t";
                    ligne1demiHaut[1] =  "\t --- \t";
                }
                //ouest
                else if (plateau.districts.get(i).getOrientation() == 4){
                    tableauPlateau[1][1] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "|"+"\t";
                }
            }
            //tuile 2
            else if(positiontuile == 2){
                //nord
                if (plateau.districts.get(i).getOrientation() == 1 ){
                    tableauPlateau[1][2] =plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t";
                    ligne1demiBas[2] = "\t --- \t";
                }
                //est
                else if (plateau.districts.get(i).getOrientation() == 2){
                    tableauPlateau[1][2] = "|"+ plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur()+"\t";
                }
                //sud
                else if (plateau.districts.get(i).getOrientation() == 3){
                    tableauPlateau[1][2] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t";
                    ligne1demiHaut[2] =  "\t --- \t";
                }
                //ouest
                else if (plateau.districts.get(i).getOrientation() == 4){
                    tableauPlateau[1][2] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "|"+"\t";
                }
            }
            //tuile 3
            else if(positiontuile == 3){
                //nord
                if (plateau.districts.get(i).getOrientation() == 1 ){
                    tableauPlateau[1][3] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t\t";
                    ligne1demiBas[3] = "\t --- \t";
                }
                //est
                else if (plateau.districts.get(i).getOrientation() == 2){
                    tableauPlateau[1][3] = "|" +plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur()+"\t\t";
                }
                //sud
                else if (plateau.districts.get(i).getOrientation() == 3){
                    tableauPlateau[1][3] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t\t";
                    ligne1demiHaut[3] =  "\t --- \t";
                }
                //ouest
                else if (plateau.districts.get(i).getOrientation() == 4){
                    tableauPlateau[1][3] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "|"+"\t\t";
                }
            }
            //tuile 4
            else if(positiontuile == 4){
                //nord
                if (plateau.districts.get(i).getOrientation() == 1 ){
                    tableauPlateau[2][1] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t";
                    ligne2demiBas[1] = "\t --- \t";
                }
                //est
                else if (plateau.districts.get(i).getOrientation() == 2){
                    tableauPlateau[2][1] = "|" + plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur()+"\t";
                }
                //sud
                else if (plateau.districts.get(i).getOrientation() == 3){
                    tableauPlateau[2][1] =plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t";
                    ligne2demiHaut[1] =  "\t --- \t";
                }
                //ouest
                else if (plateau.districts.get(i).getOrientation() == 4){
                    tableauPlateau[2][1] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "|"+"\t";
                }
            }
            //tuile 5
            else if(positiontuile == 5){
                //nord
                if (plateau.districts.get(i).getOrientation() == 1 ){
                    tableauPlateau[2][2] =plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t";
                    ligne2demiBas[2] = "\t --- \t";
                }
                //est
                else if (plateau.districts.get(i).getOrientation() == 2){
                    tableauPlateau[2][2] = "|" + plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur()+"\t";
                }
                //sud
                else if (plateau.districts.get(i).getOrientation() == 3){
                    tableauPlateau[2][2] =plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t";
                    ligne2demiHaut[2] =  "\t --- \t";
                }
                //ouest
                else if (plateau.districts.get(i).getOrientation() == 4){
                    tableauPlateau[2][2] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "|"+"\t";
                }
            }
            //tuile 6
            else if(positiontuile == 6){
                //nord
                if (plateau.districts.get(i).getOrientation() == 1 ){
                    tableauPlateau[2][3] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t\t";
                    ligne2demiBas[3] = "\t --- \t";
                }
                //est
                else if (plateau.districts.get(i).getOrientation() == 2){
                    tableauPlateau[2][3] = "|" +plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur()+"\t\t";
                }
                //sud
                else if (plateau.districts.get(i).getOrientation() == 3){
                    tableauPlateau[2][3] =plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t\t";
                    ligne2demiHaut[3] =  "\t --- \t";
                }
                //ouest
                else if (plateau.districts.get(i).getOrientation() == 4){
                    tableauPlateau[2][3] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "|"+"\t\t";
                }
            }
            //tuile 7
            else if(positiontuile == 7){
                //nord
                if (plateau.districts.get(i).getOrientation() == 1 ){
                    tableauPlateau[3][1] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t";
                    ligne3demiBas[1] = "\t --- \t";
                }
                //est
                else if (plateau.districts.get(i).getOrientation() == 2){
                    tableauPlateau[3][1] = "|" + plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur()+"\t";
                }
                //sud
                else if (plateau.districts.get(i).getOrientation() == 3){
                    tableauPlateau[3][1] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t";
                    ligne3demiHaut[1] =  "\t --- \t";
                }
                //ouest
                else if (plateau.districts.get(i).getOrientation() == 4){
                    tableauPlateau[3][1] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "|"+"\t";
                }
            }
            //tuile 8
            else if(positiontuile == 8){
                //nord
                if (plateau.districts.get(i).getOrientation() == 1 ){
                    tableauPlateau[3][2] =plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t";
                    ligne3demiBas[2] = "\t --- \t";
                }
                //est
                else if (plateau.districts.get(i).getOrientation() == 2){
                    tableauPlateau[3][2] = "|" + plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur()+"\t";
                }
                //sud
                else if (plateau.districts.get(i).getOrientation() == 3){
                    tableauPlateau[3][2] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t";
                    ligne3demiHaut[2] =  "\t --- \t";
                }
                //ouest
                else if (plateau.districts.get(i).getOrientation() == 4){
                    tableauPlateau[3][2] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "|"+"\t";
                }
            }
            //tuile 9
            else if(positiontuile == 9){
                //nord
                if (plateau.districts.get(i).getOrientation() == 1 ){
                    tableauPlateau[3][3] =plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t\t";
                    ligne3demiBas[3] = "\t --- \t";
                }
                //est
                else if (plateau.districts.get(i).getOrientation() == 2){
                    tableauPlateau[3][3] = "|" + plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur()+"\t\t";
                }
                //sud
                else if (plateau.districts.get(i).getOrientation() == 3){
                    tableauPlateau[3][3] = plateau.districts.get(i).getPersonnagePlateau().getInnocence() +plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "\t\t";
                    ligne3demiHaut[3] =  "\t --- \t";
                }
                //ouest
                else if (plateau.districts.get(i).getOrientation() == 4){
                    tableauPlateau[3][3] =plateau.districts.get(i).getPersonnagePlateau().getInnocence() + plateau.districts.get(i).getPersonnagePlateau().getCouleur() + "|"+"\t\t";
                }
            }
        }
        for (int k = 0; k<3 ; k++){
            Detective detectiveActuel = detective.get(k);
            int positionActuelle = detectiveActuel.getPosition();
            if (positionActuelle == 1){
                tableauPlateau[0][1] = detectiveActuel.getName()+"\t\t";
            }
            else if (positionActuelle == 2){
                tableauPlateau[0][2] = detectiveActuel.getName()+"\t\t";
            }
            else if (positionActuelle == 3){
                tableauPlateau[0][3] = detectiveActuel.getName()+"\t\t";
            }
            else if (positionActuelle == 4){
                tableauPlateau[1][4] = detectiveActuel.getName()+"\t\t";
            }
            else if (positionActuelle == 5){
                tableauPlateau[2][4] = detectiveActuel.getName()+"\t\t";
            }
            else if (positionActuelle == 6){
                tableauPlateau[3][4] = detectiveActuel.getName()+"\t\t";
            }
            else if (positionActuelle == 7){
                tableauPlateau[4][3] = detectiveActuel.getName()+"\t\t";
            }
            else if (positionActuelle == 8){
                tableauPlateau[4][2] = detectiveActuel.getName()+"\t\t";
            }
            else if (positionActuelle == 9){
                tableauPlateau[4][1] = detectiveActuel.getName()+"\t\t";
            }
            else if (positionActuelle == 10){
                tableauPlateau[3][0] = detectiveActuel.getName()+"\t\t";
            }
            else if (positionActuelle == 11){
                tableauPlateau[2][0] = detectiveActuel.getName()+"\t\t";
            }
            else if (positionActuelle == 12){
                tableauPlateau[1][0] = detectiveActuel.getName()+"\t\t";
            }
        }
        System.out.println();
        System.out.println(Arrays.deepToString(tableauPlateau[0]));
        System.out.println(Arrays.deepToString(ligne1demiHaut));
        System.out.println(Arrays.deepToString(tableauPlateau[1]));
        System.out.println(Arrays.deepToString(ligne1demiBas));
        System.out.println(Arrays.deepToString(ligne2demiHaut));
        System.out.println(Arrays.deepToString(tableauPlateau[2]));
        System.out.println(Arrays.deepToString(ligne2demiBas));
        System.out.println(Arrays.deepToString(ligne3demiHaut));
        System.out.println(Arrays.deepToString(tableauPlateau[3]));
        System.out.println(Arrays.deepToString(ligne3demiBas));
        System.out.println(Arrays.deepToString(tableauPlateau[4]));
        System.out.println();
    }

    public void generateJetons() {
        Random random = new Random();
        for ( Jeton jeton : this.jetons) {

            if (random.nextInt() % 2 == 0) {
                jeton.setCotePiece("pile");
            } else {
                jeton.setCotePiece("face");
            }
        }
    }

    public void flipJetons(){
        for (Jeton jeton : this.jetons) {
            if (jeton.getCotePiece().equals("pile")) {
                jeton.setCotePiece("face");
            } else {
                jeton.setCotePiece("pile");
            }
        }
    }

    public void nextTurn() {
        this.currentTurn++;
    }

    public void afficherCoteJetons() {
        for (Jeton jeton : this.jetons) {
            if (jeton.getCotePiece().equals("face")) {
                System.out.println("Le jeton " + jeton + " est tombé sur " + jeton.getCotePiece() + " : " + jeton.getActionJetonFace() );
            }
            else{
                System.out.println("Le jeton " + jeton + " est tombé sur " + jeton.getCotePiece() + " : " + jeton.getActionJetonPile() );
            }
        }
    }

    public boolean isGameOver (Plateau plateau, MrJack mrJack){
        if (mrJack.getNbSabliers() >= 6){
            System.out.println("Mr.Jack a gagné");
            System.out.println("le coupable était "+mrJack.getCoupable());
            return (true);
        }
        else if (plateau.visionDetective(plateau).contains(mrJack.coupable)){
            System.out.println("Le détective a gagné");
            System.out.println("le coupable était "+mrJack.getCoupable());
            return (true);
        }
        else{
            return (false);
        }
    }

    public static void main(String[] args) {
        Partie partie = new Partie();
        while (!partie.isGameOver(partie.plateau, partie.getMrJack())) {
            partie.nextTurn();
            partie.playTurn();
            partie.affichageTableau();
            partie.jetonsRestants = (ArrayList<Jeton>) partie.jetons.clone();
            partie.afficherCoteJetons();
            partie.choixJetons();
            partie.getMrJack().setNbSabliers(partie.getMrJack().getNbSabliers() + 1);
            System.out.println("------------------------------------------------------");
        }
    }
}
