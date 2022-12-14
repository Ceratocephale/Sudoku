package be.technifutur.sudoku.Abstract;

import be.technifutur.sudoku.Cell;
import be.technifutur.sudoku.Interface.SudokuModel;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractVue {
    public SudokuModel m;
    public int dim;

    public List<Character> valuesList() {
        List<Character> tab = new ArrayList<>();
        for (int i = 0, lig = 0, col = 0; i < dim * dim; i++) {
            lig = i / dim;
            col = i % dim;

            if (m.isPositionValid(lig, col)) {
                tab.add(m.getValue(lig, col));
            }

        }
        return tab;
    }
}
