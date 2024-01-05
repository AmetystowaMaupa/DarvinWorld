package Model.Genome;

public class Genome {
    private Gene head;
    private Gene tail;
    public Genome(){
        this.head = null;
        this.tail = null;
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
    }
}
