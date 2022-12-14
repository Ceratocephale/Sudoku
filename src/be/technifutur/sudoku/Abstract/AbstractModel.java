package be.technifutur.sudoku.Abstract;

import be.technifutur.sudoku.Cell;
import be.technifutur.sudoku.Interface.SudokuModel;
import be.technifutur.sudoku.SudokuException.SudokuPositionException;
import be.technifutur.sudoku.SudokuException.SudokuValueException;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractModel {
    public int dim;
    private Cell[][] values;

    public AbstractModel(int dim) {
        this.values = constructionTableau(dim);
        this.dim = dim;
    }

    public char getValue(int lig, int col) {
        char value = values[lig][col].getValue();
        if (values[lig][col].getValue() == SudokuModel.empty) return '.';
        return value;
    }

    public void setValue(char value, int lig, int col) throws SudokuPositionException, SudokuValueException {
        if (!isValueValid(value)) throw new SudokuValueException("La valeur " + value + " n'est pas bonne!");
        else if (!isPositionValid(lig, col))
            throw new SudokuPositionException("La position " + (lig + 1) + "." + (col + 1) + " n'existe pas");
        else values[lig][col].setValue(value);
    }

    public void deleteValue(int lig, int col) throws SudokuPositionException {
        if (isPositionValid(lig, col))
            values[lig][col].clear();
        else throw new SudokuPositionException("La position " + (lig + 1) + "." + (col + 1) + " n'existe pas");
    }

    public boolean isValueValid(char value) {
        return (value <= 49 + dim - 1 && value >= 49);
    }

    public Cell[][] constructionTableau(int dim) {
        int sqrt = (int) Math.sqrt(dim);

        Set<Character>[] lines = new Set[dim];
        Set<Character>[] cols = new Set[dim];
        Set<Character>[] squares = new Set[dim];

        for (int i = 0; i < dim; i++) {
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


    public boolean isPositionValid(int lig, int col) {
        return !(lig < 0 || col < 0 || lig > dim - 1 || col > dim - 1);
    }

    public void lock() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                values[i][j].lock();
            }
        }
    }
}
