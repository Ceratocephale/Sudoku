package be.technifutur.sudoku.Interface;

import be.technifutur.sudoku.SudokuException.SudokuPositionException;

import java.util.List;

public interface SudokuVue {

    public void afficherGrille();

    public List<Character> valuesList() throws SudokuPositionException;
}
