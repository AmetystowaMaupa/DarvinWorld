package Model.Genome;

import java.util.Random;

public class Genome {
    private Gene head;
    private Gene tail;
    private int len = 0;
    public Genome(){
        this.head = null;
        this.tail = null;
    }

    public Gene getHead() {
        return head;
    }
    public int getLen() {
        return len;
    }

    public void addGene(int gene){
        Gene newGene = new Gene(gene);
        if (head == null){
            head = newGene;
            tail = newGene;
            tail.next = head;
        } else {
            tail.next = newGene;
            tail = newGene;
            tail.next = head;
        }
        len += 1;
    }
}
