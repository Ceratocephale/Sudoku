package be.technifutur.sudoku;

import be.technifutur.sudoku.Interface.SudokuModel;
import be.technifutur.sudoku.Interface.SudokuVue;
import be.technifutur.sudoku.SudokuException.SudokuException;
import be.technifutur.sudoku.SudokuException.SudokuPositionException;
import be.technifutur.sudoku.SudokuException.SudokuValueException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class SudokuController {

    SudokuVue v;
    SudokuModel m;


    public SudokuController(SudokuModel m, SudokuVue v) {

        this.m = m;
        this.v = v;

    }

    public void init(String fileName) {
        File myFile = new File(fileName);
        try (Scanner scan = new Scanner(myFile)) {
            int lig = 0;
            while (scan.hasNextLine()) {
                int col = 0;
                for (String val : scan.nextLine().split(",")) {
                    char value = val.charAt(0);
                    if (m.isValueValid(value) && m.isPositionValid(lig, col))
                        this.m.setValue(value, lig, col);
                    col++;
                }
                lig++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SudokuPositionException e) {
            System.out.println(e.getMessage());
        } catch (SudokuValueException e) {
            System.out.println(e.getMessage());
        }

    }

    public void start() {

        boolean exit = false;

        String reponse;
        String subStr;
        int rep;

        char valeur;
        int lig;
        int col;

        Scanner sc = new Scanner(System.in);

        while (!exit) {
            v.afficherGrille();

            System.out.println("""
                        Choisi ce que tu veux:
                        1. Entrer une valeur
                        2. Supprimer une valeur
                        3. Sortir
                    """);
            try {
                reponse = sc.nextLine();
                rep = Integer.parseInt(reponse);

                switch (rep) {

                    case 1: {

                        System.out.println("Entre la ligne, la colonne et la valeur en format \"n°Ligne.n°Colonne.Valeur(1-9)\"");

                        reponse = sc.nextLine();
                        if (Pattern.matches("[1-2]?[0-9]\\.[1-2]?[0-9]\\.[1-9]", reponse)) {

                            subStr = reponse.substring(0, reponse.indexOf('.'));
                            lig = Integer.parseInt(subStr);

                            subStr = reponse.substring(reponse.indexOf('.') + 1, reponse.indexOf('.', reponse.indexOf('.') + 1));
                            col = Integer.parseInt(subStr);

                            valeur = reponse.charAt(reponse.length() - 1);

                            try {
                                m.setValue(valeur, lig - 1, col - 1);
                            } catch (SudokuPositionException e) {
                                System.err.println(e.getMessage());
                            } catch (SudokuValueException e) {
                                System.err.println(e.getMessage());
                            }

                        } else {
                            System.err.println("Mauvais format!");

                        }
                        break;
                    }

                    case 2: {

                        System.out.println("Entre la ligne et la colonne en format \"n°Ligne.n°Colonne");

                        reponse = sc.nextLine();
                        if (Pattern.matches("[1-2]?[0-9]\\.[1-2]?[0-9]", reponse)) {

                            subStr = reponse.substring(0, reponse.indexOf('.'));
                            lig = Integer.parseInt(subStr);

                            subStr = reponse.substring(reponse.indexOf('.') + 1);
                            col = Integer.parseInt(subStr);

                            try {
                                m.deleteValue(lig - 1, col - 1);
                            } catch (SudokuPositionException e) {
                                System.err.println(e.getMessage());
                            }
                        } else
                            System.err.println("Mauvais format!");
                        break;
                    }

                    case 3: {
                        exit = true;
                        break;
                    }
                    default:
                        System.out.println("Mauvais input!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Mauvais input!");
            }

        }

    }

}
