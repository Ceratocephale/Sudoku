package be.technifutur.sudoku.samourai;

import be.technifutur.sudoku.Abstract.AbstractModel;
import be.technifutur.sudoku.Cell;
import be.technifutur.sudoku.Interface.SudokuModel;

import java.util.HashSet;
import java.util.Set;

public class ModelSamourai extends AbstractModel implements SudokuModel {

    public ModelSamourai() {
        super(21);
    }

    @Override
    public Cell[][] constructionTableau(int dim) {
        int gdim = 9;
        int sqrt = (int) Math.sqrt(gdim);

        Set<Character>[] lines = new Set[gdim];
        Set<Character>[] cols = new Set[gdim];
        Set<Character>[] squares = new Set[gdim];

        for (int i = 0; i < gdim; i++) {
            lines[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        Cell[][] values = new Cell[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                values[i][j] = new Cell();
                values[i][j].addZone("line" + i, lines[i]);
                values[i][j].addZone("col" + j, cols[j]);
                values[i][j].addZone("square" + j / sqrt + ((i / sqrt) * sqrt), squares[j / sqrt + ((i / sqrt) * sqrt)]);
            }
        }
        return values;
    }

    @Override
    public boolean isPositionValid(int lig, int col) {
        return (!((
                (((lig >= 0 && lig <= 5) || (lig >= 15 && lig <= 20)) && (col >= 9 && col <= 11)) ||
                        ((lig >= 9 && lig <= 11) && (((col >= 0 && col <= 5)) || (col >= 15 && col <= 20)))
        ) || (lig < 0 || col < 0 || lig > 20 || col > 20))
        );
    }
}
