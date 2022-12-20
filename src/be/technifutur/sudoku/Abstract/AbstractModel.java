package be.technifutur.sudoku.Abstract;

import be.technifutur.sudoku.Cell;
import be.technifutur.sudoku.FourFour.Model4x4;
import be.technifutur.sudoku.Interface.SudokuModel;
import be.technifutur.sudoku.SudokuException.CellLockedException;
import be.technifutur.sudoku.SudokuException.SudokuException;
import be.technifutur.sudoku.SudokuException.SudokuPositionException;
import be.technifutur.sudoku.SudokuException.SudokuValueException;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void setValue(char value, int lig, int col) throws SudokuException {
        if (!isValueValid(value)) throw new SudokuValueException("La valeur " + value + " n'est pas bonne!");
        else if (!isPositionValid(lig, col))
            throw new SudokuPositionException("La position " + (lig + 1) + "." + (col + 1) + " n'existe pas");
        else if (values[lig][col].isLock()) throw new CellLockedException("Cell is locked");
        else {
            values[lig][col].setValue(value);

        }
    }

    public void deleteValue(int lig, int col) throws SudokuException {
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

    public BigInteger getMemento() {
        Stream<Cell> cellStream = Arrays.stream(values).flatMap(v -> Arrays.stream(v));
        BigInteger big;
        big = cellStream.filter(v -> (!v.isLock()) && (v != null))
                .map(v -> v.isEmpty() ? BigInteger.ZERO : new BigInteger(String.valueOf(v.getValue())))
                .peek(x -> System.out.printf("avant reduce : %s\n", x))
                .reduce((old, neo) -> old.shiftLeft(4).add(neo)).orElse(BigInteger.ZERO);

        return big;
    }

    //    public Object setMemento() {
//
//    }
    public static void main(String[] args) throws SudokuException {
        Model4x4 mod = new Model4x4();
        mod.setValue('1', 0, 0);
        mod.setValue('2', 1, 1);
        mod.setValue('3', 2, 2);
        mod.setValue('1', 3, 3);

        System.out.println((mod.getMemento()).toString(2));
    }
}
