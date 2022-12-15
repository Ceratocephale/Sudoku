package be.technifutur.sudoku.Interface;

import be.technifutur.sudoku.SudokuException.SudokuException;
import be.technifutur.sudoku.SudokuException.SudokuPositionException;
import be.technifutur.sudoku.SudokuException.SudokuValueException;

public interface SudokuModel {

    public static final char empty = 0;

    public char getValue(int lig, int col);

    public void setValue(char value, int lig, int col) throws SudokuException;

    public void deleteValue(int lig, int col) throws SudokuException;

    public boolean isValueValid(char value);

    public boolean isPositionValid(int lig, int col);

    void lock();

}
