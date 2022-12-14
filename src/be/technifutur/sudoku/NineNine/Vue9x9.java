package be.technifutur.sudoku.NineNine;

import be.technifutur.sudoku.Abstract.AbstractVue;
import be.technifutur.sudoku.Interface.SudokuModel;
import be.technifutur.sudoku.Interface.SudokuVue;

public class Vue9x9 extends AbstractVue implements SudokuVue {


    public Vue9x9(Model9x9 m) {
        this.m = m;
        this.dim = m.dim;
    }

    public void afficherGrille() {

        String s = """
                +-----------+-----------+-----------+
                |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                +-----------+-----------+-----------+
                |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                +-----------+-----------+-----------+
                |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                |  %c  %c  %c  |  %c  %c  %c  |  %c  %c  %c  |
                +-----------+-----------+-----------+
                """;

        System.out.printf(s, valuesList().toArray());
    }

}
