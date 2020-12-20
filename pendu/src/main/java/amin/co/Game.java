package amin.co;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    String enonce;
    String randomMotString;
    String[] motCacher;
    String[] motNormal;
    int error;
    int errorMax;

    public String genererMots() {
        this.enonce = enonce;
        enonce = " Bonjour a toi  compagnons tu connais les regle du pendu tu doit deviner le mots sans fair plus de 7 fautes en tapant une lettre a la fois ";
        System.out.println(enonce);
        ArrayList<String> mots = new ArrayList<String>();
        mots.add("losanges");
        mots.add("rectangle");
        mots.add("kiwi");
        mots.add("portable");
        mots.add("poulet");
        mots.add("froid");
        Random random = new Random();
        // Trouver un mots aux hasard
        int randomMots = (int) (Math.random() * mots.size());
        //System.out.println("Random mots: " + mots.get(randomMots));
        // Convertions en String
        this.randomMotString = mots.get(randomMots);
        return randomMotString;
    }
    // retourn un String random

    public String[] genererMotNormal() {
        this.motNormal = randomMotString.split("");
        return motNormal;
    }

    public String[] genererMotsCacher() {

        // cacher le mots
        this.motCacher = randomMotString.split("");

        // String a = randomMotString.replaceAll("*",decompose);
        // remplace chaque lettre par *

        for (int i = 0; i < motCacher.length; i++) {
            motCacher[i] = "*";
            // System.out.print(motCacher[i]);
        }
        return motCacher;
    }

    // retourn un string[] random transformer *

    public void checkerLetter() {

        // checking
        String[] motDecomposesansEtoile = randomMotString.split("");

        List<String> sansEtoile = Arrays.asList(motDecomposesansEtoile);
        this.error = 0;
        this.errorMax = 8;

        List<String> avecEtoile = Arrays.asList(motCacher);

        System.out.println(avecEtoile);
        // System.out.println(sansEtoile);

        for (int i = 0; i < errorMax; i++) {
            Scanner scan = new Scanner(System.in);
            String entreeLettres = scan.next();

            char a = entreeLettres.charAt(0);

            boolean lettreChecking = sansEtoile.contains(entreeLettres);
            // String[] tabMotsFinal = new String[motDecomposesansEtoile.length];
            // int positionLettre = entreeLettres.indexOf(sansEtoile.toString());

            int position = sansEtoile.indexOf(entreeLettres);

            if (lettreChecking) {

                avecEtoile.set(position, entreeLettres);

                System.out.println(avecEtoile);
                System.out.println("sa match");

            } else {

                System.out.println("non cette lettre n'est pas dans le mot");
                error++;

                if (errorMax == error) {
                    System.out.println("GAME OVEEEER");
                }

                if(avecEtoile == sansEtoile){
                    System.out.println("YOU WIN");
                }

            }

        }
    }

}
