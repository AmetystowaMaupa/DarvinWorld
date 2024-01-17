package Model;

import Maps.MoveValidator;
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
    public MoveTuple move(MoveValidator validator){
        MoveTuple oldnew = new MoveTuple();
        oldnew.oldPosition = position;
        if (validator.moveValidator(position.add(orientation.dirToVector()))) {
            position = position.add(orientation.dirToVector());
        }
        orientation = orientation.rotation(currGene.getGene());
        currGene = getNextGene();
        oldnew.newPosition = position;
        return oldnew;
    }
    private Gene getNextGene(){
        if (settings.getAnimalMoving() == 0) {
            return currGene.next;
        }
        else {
            Random generator = new Random();
            int roll = generator.nextInt(101) + 1;
            if (roll <= 20){
                int geneInd = generator.nextInt(genome.getLen());
                Gene g = currGene;
                for (int i = 0; i < geneInd; i++){
                    g = g.next;
                }
                return g;
            }
            else {
                return currGene.next;
            }
        }
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
