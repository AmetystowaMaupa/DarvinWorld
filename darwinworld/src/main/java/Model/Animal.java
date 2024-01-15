package Model;

import Maps.WorldMap;
import Model.Genome.Gene;
import Model.Genome.Genome;
import Observers.ElementChangeObserver;
import Simulations.Settings;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Animal implements WorldElement {
    private Vector2d position;
    private int energy;
    private Directions orientation = Directions.N;
    private Genome genome = new Genome();
    private Gene currGene;
    private Settings settings;
    private int birthday;
    public Animal(Vector2d pos, Settings settings, int day, List<Integer> gens,int energy){
        this.position = pos;
        this.settings = settings;
        this.birthday = day;
        for (int i = 0; i < gens.size(); i++){
            genome.addGene(gens.get(i));
        }
        currGene = genome.getHead();
        this.energy = energy;
    }
    public MoveTuple move(){
        MoveTuple oldnew = new MoveTuple();
        oldnew.oldPosition = position;
        System.out.println(currGene.getGene());
        position = position.add(orientation.dirToVector());
        orientation = orientation.rotation(currGene.getGene());
        currGene = currGene.next;
        System.out.println(currGene.getGene());
        oldnew.newPosition = position;
        return oldnew;
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
        return position;
    }

    @Override
    public Directions getOrientation() {
        return orientation;
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
        return currGene.getGene();
    }
}
