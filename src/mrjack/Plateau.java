package mrjack;

import java.util.*;



public class Plateau {
    public ArrayList<District> districts;
    public ArrayList<Detective> detectives;
    public ArrayList<PersonnagePlateau> personnagePlateau;

    public Plateau() {
        initialisation();

    }

    public void initialisation() {
        this.districts = new ArrayList<District>(Arrays.asList(District.values()));
        this.detectives = new ArrayList<Detective>(Arrays.asList(Detective.values()));
        this.personnagePlateau = new ArrayList<PersonnagePlateau>(Arrays.asList(PersonnagePlateau.values()));
        for (District persoPlateau : districts){
            persoPlateau.getPersonnagePlateau().setInnocence("\u001B[35m");
        }

        ArrayList<Integer> stockPos = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            stockPos.add(i);
        }

        Collections.shuffle(stockPos);
        for (int i = 0; i < districts.size(); i++) {
            this.districts.get(i).setPosition(stockPos.get(i));

        }

        for (int i = 0; i < districts.size(); i++) {
            Random random = new Random();
            int orientation;
            orientation = random.nextInt(4)+1;
            this.districts.get(i).setOrientation(orientation);
        }
    }

    public void permute(String district1, String district2) {
        District distr1 = this.districts.get(1);
        District distr2 = this.districts.get(1);
        for (District district : this.districts) {
            if (district.getPersonnagePlateau().getCouleur().toLowerCase().equals(district1.toLowerCase())) {
                distr1 = district;
            }
            if (district.getPersonnagePlateau().getCouleur().toLowerCase().equals(district2.toLowerCase())) {
                distr2 = district;
            }
        }
        int positionTemp = distr1.getPosition();
        distr1.setPosition(distr2.getPosition());
        distr2.setPosition(positionTemp);
        System.out.println("Permutation done");
    }

    public void rotate(String district1, int orientation) {
        District distr1 = this.districts.get(1);
        for (District district : this.districts) {
            if (district.getPersonnagePlateau().getCouleur().toLowerCase().equals(district1.toLowerCase())) {
                distr1 = district;
            }
        }
        distr1.setOrientation(orientation);
    }

    public void avancementJoker(String deplacerDetective) {
        Detective detective1 = this.detectives.get(1);
        for (Detective detective : this.detectives) {
            if (detective.getName().toLowerCase().equals(deplacerDetective.toLowerCase())) {
                detective1 = detective;
            }
        }
        int positionInitial = detective1.getPosition();
        int positionFinale = (positionInitial+1) % 12;
        detective1.setPosition(positionFinale);
    }

    public void avancement(int avancement, Detective detective1) {
        int positionInitial = detective1.getPosition();
        int positionFinale = (positionInitial+avancement) % 12;
        detective1.setPosition(positionFinale);
    }


    public ArrayList<PersonnagePlateau> visionDetective(Plateau plateau) {
        ArrayList<PersonnagePlateau> suspectVisibles = new ArrayList<PersonnagePlateau>();
        int positionD = 0;
        for (int i =0; i<3; i++){
            if (i == 0){positionD = detectives.get(0).getPosition();}
            if (i == 1){positionD = detectives.get(1).getPosition();}
            if (i == 2){positionD = detectives.get(2).getPosition();}

            //cas où Holmes est sur la tranche du haut
            if (positionD < 4 && positionD > 0) {
                if (positionD == 1) {
                    District tuile1 = plateau.districts.get(0);
                    if (tuile1.getOrientation() == 2 || tuile1.getOrientation() == 4) {
                        suspectVisibles.add(tuile1.getPersonnagePlateau());
                        tuile1.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile4 = plateau.districts.get(3);
                        if (tuile4.getOrientation() == 2 || tuile4.getOrientation() == 4) {
                            suspectVisibles.add(tuile4.getPersonnagePlateau());
                            tuile4.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile7 = plateau.districts.get(6);
                            if (tuile7.getOrientation() == 2 || tuile7.getOrientation() == 4 || tuile7.getOrientation() == 1) {
                                suspectVisibles.add(tuile7.getPersonnagePlateau());
                                tuile7.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile4.getOrientation() == 1) {
                            suspectVisibles.add(tuile4.getPersonnagePlateau());
                            tuile4.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile1.getOrientation() == 1) {
                        suspectVisibles.add(tuile1.getPersonnagePlateau());
                        tuile1.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
                if (positionD == 2) {
                    District tuile2 = plateau.districts.get(1);
                    if (tuile2.getOrientation() == 2 || tuile2.getOrientation() == 4) {
                        suspectVisibles.add(tuile2.getPersonnagePlateau());
                        tuile2.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile5 = plateau.districts.get(4);
                        if (tuile5.getOrientation() == 2 || tuile5.getOrientation() == 4) {
                            suspectVisibles.add(tuile5.getPersonnagePlateau());
                            tuile5.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile8 = plateau.districts.get(7);
                            if (tuile8.getOrientation() == 2 || tuile8.getOrientation() == 4 || tuile8.getOrientation() == 1) {
                                suspectVisibles.add(tuile8.getPersonnagePlateau());
                                tuile8.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile5.getOrientation() == 1) {
                            suspectVisibles.add(tuile5.getPersonnagePlateau());
                            tuile5.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile2.getOrientation() == 1) {
                        suspectVisibles.add(tuile2.getPersonnagePlateau());
                        tuile2.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
                if (positionD == 3) {
                    District tuile3 = plateau.districts.get(2);
                    if (tuile3.getOrientation() == 2 || tuile3.getOrientation() == 4) {
                        suspectVisibles.add(tuile3.getPersonnagePlateau());
                        tuile3.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile6 = plateau.districts.get(5);
                        if (tuile6.getOrientation() == 2 || tuile6.getOrientation() == 4) {
                            suspectVisibles.add(tuile6.getPersonnagePlateau());
                            tuile6.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile9 = plateau.districts.get(8);
                            if (tuile9.getOrientation() == 2 || tuile9.getOrientation() == 4 || tuile9.getOrientation() == 1) {
                                suspectVisibles.add(tuile9.getPersonnagePlateau());
                                tuile9.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile6.getOrientation() == 1) {
                            suspectVisibles.add(tuile6.getPersonnagePlateau());
                            tuile6.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile3.getOrientation() == 1) {
                        suspectVisibles.add(tuile3.getPersonnagePlateau());
                        tuile3.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
            }

            // cas où Holmes est sur la tranche de droite
            if (positionD < 7 && positionD > 3) {
                if (positionD == 4) {
                    District tuile3 = plateau.districts.get(2);
                    if (tuile3.getOrientation() == 1 || tuile3.getOrientation() == 3) {
                        suspectVisibles.add(tuile3.getPersonnagePlateau());
                        tuile3.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile2 = plateau.districts.get(1);
                        if (tuile2.getOrientation() == 1 || tuile2.getOrientation() == 3) {
                            suspectVisibles.add(tuile2.getPersonnagePlateau());
                            tuile2.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile1 = plateau.districts.get(0);
                            if (tuile1.getOrientation() == 1 || tuile1.getOrientation() == 3 || tuile1.getOrientation() == 2) {
                                suspectVisibles.add(tuile1.getPersonnagePlateau());
                                tuile1.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile2.getOrientation() == 2) {
                            suspectVisibles.add(tuile2.getPersonnagePlateau());
                            tuile2.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile3.getOrientation() == 2) {
                        suspectVisibles.add(tuile3.getPersonnagePlateau());
                        tuile3.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
                if (positionD == 5) {
                    District tuile6 = plateau.districts.get(5);
                    if (tuile6.getOrientation() == 1 || tuile6.getOrientation() == 3) {
                        suspectVisibles.add(tuile6.getPersonnagePlateau());
                        tuile6.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile5 = plateau.districts.get(4);
                        if (tuile5.getOrientation() == 1 || tuile5.getOrientation() == 3) {
                            suspectVisibles.add(tuile5.getPersonnagePlateau());
                            tuile5.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile4 = plateau.districts.get(3);
                            if (tuile4.getOrientation() == 1 || tuile4.getOrientation() == 3 || tuile4.getOrientation() == 2) {
                                suspectVisibles.add(tuile4.getPersonnagePlateau());
                                tuile4.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile5.getOrientation() == 2) {
                            suspectVisibles.add(tuile5.getPersonnagePlateau());
                            tuile5.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile6.getOrientation() == 2) {
                        suspectVisibles.add(tuile6.getPersonnagePlateau());
                        tuile6.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
                if (positionD == 6) {
                    District tuile9 = plateau.districts.get(8);
                    if (tuile9.getOrientation() == 1 || tuile9.getOrientation() == 3) {
                        suspectVisibles.add(tuile9.getPersonnagePlateau());
                        tuile9.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile8 = plateau.districts.get(7);
                        if (tuile8.getOrientation() == 1 || tuile8.getOrientation() == 3) {
                            suspectVisibles.add(tuile8.getPersonnagePlateau());
                            tuile8.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile7 = plateau.districts.get(6);
                            if (tuile7.getOrientation() == 1 || tuile7.getOrientation() == 3 || tuile7.getOrientation() == 2) {
                                suspectVisibles.add(tuile7.getPersonnagePlateau());
                                tuile7.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile8.getOrientation() == 2) {
                            suspectVisibles.add(tuile8.getPersonnagePlateau());
                            tuile8.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile9.getOrientation() == 2) {
                        suspectVisibles.add(tuile9.getPersonnagePlateau());
                        tuile9.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
            }
            //cas où Holmes est sur la tranche du bas
            if (positionD < 10 && positionD > 6) {
                if (positionD == 7) {
                    District tuile9 = plateau.districts.get(8);
                    if (tuile9.getOrientation() == 2 || tuile9.getOrientation() == 4) {
                        suspectVisibles.add(tuile9.getPersonnagePlateau());
                        tuile9.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile6 = plateau.districts.get(5);
                        if (tuile6.getOrientation() == 2 || tuile6.getOrientation() == 4) {
                            suspectVisibles.add(tuile6.getPersonnagePlateau());
                            tuile6.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile3 = plateau.districts.get(2);
                            if (tuile3.getOrientation() == 2 || tuile3.getOrientation() == 4 || tuile3.getOrientation() == 3) {
                                suspectVisibles.add(tuile3.getPersonnagePlateau());
                                tuile3.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile6.getOrientation() == 3) {
                            suspectVisibles.add(tuile6.getPersonnagePlateau());
                            tuile6.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile9.getOrientation() == 3) {
                        suspectVisibles.add(tuile9.getPersonnagePlateau());
                        tuile9.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
                if (positionD == 8) {
                    District tuile8 = plateau.districts.get(7);
                    if (tuile8.getOrientation() == 2 || tuile8.getOrientation() == 4) {
                        suspectVisibles.add(tuile8.getPersonnagePlateau());
                        tuile8.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile5 = plateau.districts.get(4);
                        if (tuile5.getOrientation() == 2 || tuile5.getOrientation() == 4) {
                            suspectVisibles.add(tuile5.getPersonnagePlateau());
                            tuile5.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile2 = plateau.districts.get(1);
                            if (tuile2.getOrientation() == 2 || tuile2.getOrientation() == 4 || tuile2.getOrientation() == 3) {
                                suspectVisibles.add(tuile2.getPersonnagePlateau());
                                tuile2.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile5.getOrientation() == 3) {
                            suspectVisibles.add(tuile5.getPersonnagePlateau());
                            tuile5.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile8.getOrientation() == 3) {
                        suspectVisibles.add(tuile8.getPersonnagePlateau());
                        tuile8.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
                if (positionD == 9) {
                    District tuile7 = plateau.districts.get(6);
                    if (tuile7.getOrientation() == 2 || tuile7.getOrientation() == 4) {
                        suspectVisibles.add(tuile7.getPersonnagePlateau());
                        tuile7.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile4 = plateau.districts.get(3);
                        if (tuile4.getOrientation() == 2 || tuile4.getOrientation() == 4) {
                            suspectVisibles.add(tuile4.getPersonnagePlateau());
                            tuile4.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile1 = plateau.districts.get(0);
                            if (tuile1.getOrientation() == 2 || tuile1.getOrientation() == 4 || tuile1.getOrientation() == 3) {
                                suspectVisibles.add(tuile1.getPersonnagePlateau());
                                tuile1.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile4.getOrientation() == 3) {
                            suspectVisibles.add(tuile4.getPersonnagePlateau());
                            tuile4.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile7.getOrientation() == 3) {
                        suspectVisibles.add(tuile7.getPersonnagePlateau());
                        tuile7.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
            }

            //cas où Holmes est sur la tranche de gauche
            if (positionD < 13 && positionD > 9) {
                if (positionD == 10) {
                    District tuile7 = plateau.districts.get(6);
                    if (tuile7.getOrientation() == 1 || tuile7.getOrientation() == 3) {
                        suspectVisibles.add(tuile7.getPersonnagePlateau());
                        tuile7.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile8 = plateau.districts.get(7);
                        if (tuile8.getOrientation() == 1 || tuile8.getOrientation() == 3) {
                            suspectVisibles.add(tuile8.getPersonnagePlateau());
                            tuile8.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile9 = plateau.districts.get(8);
                            if (tuile9.getOrientation() == 1 || tuile9.getOrientation() == 3 || tuile9.getOrientation() == 4) {
                                suspectVisibles.add(tuile9.getPersonnagePlateau());
                                tuile9.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile8.getOrientation() == 4) {
                            suspectVisibles.add(tuile8.getPersonnagePlateau());
                            tuile8.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile7.getOrientation() == 4) {
                        suspectVisibles.add(tuile7.getPersonnagePlateau());
                        tuile7.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
                if (positionD == 11) {
                    District tuile4 = plateau.districts.get(3);
                    if (tuile4.getOrientation() == 1 || tuile4.getOrientation() == 3) {
                        suspectVisibles.add(tuile4.getPersonnagePlateau());
                        tuile4.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile5 = plateau.districts.get(4);
                        if (tuile5.getOrientation() == 1 || tuile5.getOrientation() == 3) {
                            suspectVisibles.add(tuile5.getPersonnagePlateau());
                            tuile5.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile6 = plateau.districts.get(5);
                            if (tuile6.getOrientation() == 1 || tuile6.getOrientation() == 3 || tuile6.getOrientation() == 4) {
                                suspectVisibles.add(tuile6.getPersonnagePlateau());
                                tuile6.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile5.getOrientation() == 4) {
                            suspectVisibles.add(tuile5.getPersonnagePlateau());
                            tuile5.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile4.getOrientation() == 4) {
                        suspectVisibles.add(tuile4.getPersonnagePlateau());
                        tuile4.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
                if (positionD == 12) {
                    District tuile1 = plateau.districts.get(0);
                    if (tuile1.getOrientation() == 1 || tuile1.getOrientation() == 3) {
                        suspectVisibles.add(tuile1.getPersonnagePlateau());
                        tuile1.getPersonnagePlateau().setInnocence("\u001B[32m");
                        District tuile2 = plateau.districts.get(1);
                        if (tuile2.getOrientation() == 1 || tuile2.getOrientation() == 3) {
                            suspectVisibles.add(tuile2.getPersonnagePlateau());
                            tuile2.getPersonnagePlateau().setInnocence("\u001B[32m");
                            District tuile3 = plateau.districts.get(2);
                            if (tuile3.getOrientation() == 1 || tuile3.getOrientation() == 3 || tuile3.getOrientation() == 4) {
                                suspectVisibles.add(tuile3.getPersonnagePlateau());
                                tuile3.getPersonnagePlateau().setInnocence("\u001B[32m");
                            }
                        }
                        if (tuile2.getOrientation() == 4) {
                            suspectVisibles.add(tuile2.getPersonnagePlateau());
                            tuile2.getPersonnagePlateau().setInnocence("\u001B[32m");
                        }
                    }
                    if (tuile1.getOrientation() == 4) {
                        suspectVisibles.add(tuile1.getPersonnagePlateau());
                        tuile1.getPersonnagePlateau().setInnocence("\u001B[32m");
                    }
                }
            }
        }
        return (suspectVisibles);
    }
}
