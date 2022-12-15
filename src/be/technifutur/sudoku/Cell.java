package be.technifutur.sudoku;

import be.technifutur.sudoku.Abstract.AbstractModel;
import be.technifutur.sudoku.Interface.SudokuModel;
import be.technifutur.sudoku.SudokuException.CellLockedException;
import be.technifutur.sudoku.SudokuException.SudokuDuplicateDetection;
import be.technifutur.sudoku.SudokuException.SudokuException;

import java.util.*;

public class Cell {
    private char value = SudokuModel.empty;
    private boolean lock = false;

    private Map<String, Set<Character>> zones = new HashMap();

    public char getValue() {
        return this.value;
    }

    /*
    si cellule lock
        si new values != value
    si new values != empty
    tester si la valeur est dans les zones

    enlever ancienne valeur des zones si ancienne != empty
    ajouter new value dans les zones si new values != empty

    value <- new Value

     */
    public boolean setValue(char value) throws SudokuException {
        if (isLock()) throw new CellLockedException("Cell is locked!");
        else {
            if (value != this.value) {
                for (Set<Character> set : this.zones.values()) {
                    if (!set.contains(value)) {
                        set.remove(this.value);
                        set.add(value);
                    } else throw new SudokuDuplicateDetection("Doublon detected, fdp");
                }
                this.value = value;

            }
            return true;
        }
    }

    public void lock() {
        if (this.value != SudokuModel.empty)
            this.lock = true;
    }

    public void unlock() {
        this.lock = false;
    }

    public boolean isLock() {
        return lock;
    }

    public boolean isEmpty() {
        return value == SudokuModel.empty;
    }

    public boolean clear() throws SudokuException {
        if (isLock()) throw new CellLockedException("Cell is locked");
        else {
            if (!this.isEmpty()) {
                for (Set<Character> set : this.zones.values()) {
                    set.remove(this.value);
                }
                this.value = SudokuModel.empty;
            }
            return true;
        }
    }

    public void addZone(String name, Set<Character> zone) {
        this.zones.put(name, zone);

    }

    public Set<Character> getZone(String name) {
        return this.zones.get(name);
    }

//    public static void main(String[] args) {
//        Cell cell = new Cell();
//        Set<Character> zone = new HashSet<>();
//        zone.add('c');
//        cell.addZone("haha", zone);
//        Set<Character> zone2 = cell.getZone("haha");
//        System.out.println(zone == zone2);
//    }

}
