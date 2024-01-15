package Model;


import Observers.ElementChangeObserver;

import java.util.List;

public class Tunnel implements WorldElement{

    private Vector2d entry1;
    private Vector2d entry2;
    private List<Vector2d> entries;

    public Tunnel(Vector2d entry1, Vector2d entry2) {
        this.entry1 = entry1;
        this.entry2 = entry2;
        entries = List.of(entry1,entry2);
    }

    public List<Vector2d> getEntries() {
        return entries;
    }



    public Vector2d getEntry1() {
        return entry1;
    }

    public void setEntry1(Vector2d entry1) {
        this.entry1 = entry1;
    }

    public Vector2d getEntry2() {
        return entry2;
    }

    public void setEntry2(Vector2d entry2) {
        this.entry2 = entry2;
    }



    @Override
    public String toString() {
        return "O";
    }

    @Override
    public boolean isAnimal() {
        return false;
    }

    @Override
    public Vector2d getPosition() {
        return entry1;
    }

    @Override
    public Directions getOrientation() {
        return null;
    }

    @Override
    public int getImageIdx() {
        return 0;
    }

    @Override
    public void setObserver(ElementChangeObserver observer) {

    }
    @Override
    public int getActiveGenome() {
        return 0;
    }
}
