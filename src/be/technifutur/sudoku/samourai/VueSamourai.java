package be.technifutur.sudoku.samourai;


import be.technifutur.sudoku.Abstract.AbstractVue;
import be.technifutur.sudoku.Interface.SudokuModel;
import be.technifutur.sudoku.Interface.SudokuVue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class VueSamourai extends AbstractVue implements SudokuVue {


        public VueSamourai(ModelSamourai m) {
            this.m = m;
            this.dim = m.dim;
        }

        public void afficherGrille() {

            String s = """
                     +-----------+-----------+-----------+           +-----------+-----------+-----------+
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     +-----------+-----------+-----------+           +-----------+------------+----------+
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     +-----------+-----------+-----------+-----------+-----------+-----------+-----------+
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     +-----------+-----------+-----------+-----------+-----------+-----------+-----------+
                                             |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                                             |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                                             |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     +-----------+-----------+-----------+-----------+-----------+-----------+-----------+
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     +-----------+-----------+-----------+-----------+-----------+-----------+-----------+
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     +-----------+-----------+-----------+           +-----------+-----------+-----------+
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |           |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                     +-----------+-----------+-----------+           +-----------+-----------+-----------+
                    """;


           System.out.printf(s, valuesList().toArray());
        }

}

