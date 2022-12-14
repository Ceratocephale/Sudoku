package be.technifutur.sudoku;

import be.technifutur.sudoku.Interface.SudokuModel;

import java.util.*;

public class Cell {
    private char value = SudokuModel.empty;
    private boolean lock = false;

    private Map<String, Set<Character>> zones = new HashMap();

    public char getValue() {
        return this.value;
    }

    public boolean setValue(char value) {
        if (isLock()) return false;
        else {
            this.value = value;
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

    public boolean clear() {
        if (isLock()) return false;
        else {
            this.value = SudokuModel.empty;
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
