package Model;

import Maps.WorldMap;
import Model.Genome.Genome;
import Observers.ElementChangeObserver;

import java.util.LinkedList;
import java.util.List;

public class Animal implements WorldElement {
    private Vector2d position;
    private int energy;
    private Directions orientation;
    private Genome genome;
    public Animal(List<Integer> gens){
        for (int i = 0; i < gens.size(); i++){
            genome.addGene(gens.get(i));
        }
    }
    public void move(){
        position.add(orientation.dirToVector());
    }
    @Override
    public String toString(){
        return orientation.toString();
    }

    @Override
    public boolean isAnimal() {
        return true;
    }

    @Override
    public Vector2d getPosition() {
        return null;
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
