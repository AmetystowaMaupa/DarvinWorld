package Model;

import Maps.WorldMap;
import Model.Genome.Genome;

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
}
