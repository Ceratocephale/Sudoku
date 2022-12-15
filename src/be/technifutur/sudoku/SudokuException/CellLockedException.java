package be.technifutur.sudoku.SudokuException;

public class CellLockedException extends SudokuException{
    public CellLockedException(String message){
        super(message);
    }
}
