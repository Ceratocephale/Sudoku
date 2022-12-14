package be.technifutur.sudoku.FourFour;

import be.technifutur.sudoku.Abstract.AbstractVue;
import be.technifutur.sudoku.Interface.SudokuModel;
import be.technifutur.sudoku.Interface.SudokuVue;
import be.technifutur.sudoku.SudokuException.SudokuPositionException;

public class Vue4x4 extends AbstractVue implements SudokuVue {

    public Vue4x4(Model4x4 m) {
        this.m = m;
        this.dim = m.dim;
    }

    public void afficherGrille() {

        String s = """
                +-----------------+
                |  %c  %c  |  %c  %c  |
                |  %c  %c  |  %c  %c  |
                +--------+--------+
                |  %c  %c  |  %c  %c  |
                |  %c  %c  |  %c  %c  |
                +--------+--------+
                """;

        System.out.printf(s, valuesList().toArray());
    }


}
