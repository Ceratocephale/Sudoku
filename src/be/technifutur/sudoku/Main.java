package be.technifutur.sudoku;


import be.technifutur.sudoku.FourFour.Model4x4;
import be.technifutur.sudoku.FourFour.Vue4x4;
import be.technifutur.sudoku.NineNine.Model9x9;
import be.technifutur.sudoku.NineNine.Vue9x9;
import be.technifutur.sudoku.samourai.ModelSamourai;
import be.technifutur.sudoku.samourai.VueSamourai;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int reponse;
        boolean exit = true;
        while (exit) {
            System.out.println("""
                    Choisi le model de sudoku que tu veux:
                    1. 4x4
                    2. 9x9
                    3. Samourai
                    4. Quitter
                    """);
            try {
                reponse = Integer.parseInt(scan.nextLine());

                switch (reponse) {
                    case 1: {
                        Model4x4 ms = new Model4x4();
                        Vue4x4 s = new Vue4x4(ms);
                        SudokuController cont = new SudokuController(ms, s);
                        cont.init("4x4.txt");
                        cont.start();
                        break;
                    }
                    case 2: {
                        Model9x9 ms = new Model9x9();
                        Vue9x9 s = new Vue9x9(ms);
                        SudokuController cont = new SudokuController(ms, s);
                        cont.init("9x9.txt");
                        cont.start();
                        break;
                    }
                    case 3: {
                        ModelSamourai ms = new ModelSamourai();
                        VueSamourai s = new VueSamourai(ms);
                        SudokuController cont = new SudokuController(ms, s);
                        cont.init("samourai.txt");
                        cont.start();
                        break;
                    }
                    case 4: {
                        exit = false;
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