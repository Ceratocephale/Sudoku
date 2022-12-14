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

        Set<Character>[] lines = new Set[gdim * 5];
        Set<Character>[] cols = new Set[gdim * 5];
        Set<Character>[] squares = new Set[gdim * 5];


        for (int i = 0; i < gdim * 5; i++) {
            lines[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        Cell[][] values = new Cell[dim][dim];
        int[][] tab = new int[][]{{0, 0}, {0, 12}, {6, 6}, {12, 0}, {12, 12}};
        for (int k = 0; k < tab.length; k++) {
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    int OriginLig = tab[k][0];
                    int OriginCol = tab[k][1];
                    int l = i - OriginLig;
                    int c = j - OriginCol;
                    if ((l >= 0 && l < 9) && (c >= 0 && c < 9)) {
                        values[i][j] = new Cell();
                        values[i][j].addZone("line" + l + (gdim * k), lines[l + (gdim * k)]);
                        values[i][j].addZone("col" + c + (gdim * k), cols[c + (gdim * k)]);
                        values[i][j].addZone("square" + ((c / sqrt + ((l / sqrt) * sqrt)) + (gdim * k)), squares[((c / sqrt + ((l / sqrt) * sqrt)) + (gdim * k))]);
                    }
                }
            }
        }
        return values;
    }

    @Override
    public boolean isPositionValid(int lig, int col) {
        return (!(((((lig >= 0 && lig <= 5) || (lig >= 15 && lig <= 20)) && (col >= 9 && col <= 11)) || ((lig >= 9 && lig <= 11) && (((col >= 0 && col <= 5)) || (col >= 15 && col <= 20)))) || (lig < 0 || col < 0 || lig > 20 || col > 20)));
    }


}

