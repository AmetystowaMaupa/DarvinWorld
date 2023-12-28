package Model.Genome;

class Gene {
    private int gene;
    public Gene next;
    public Gene(int gene){
        this.gene = gene;
        this.next = null;
    }
}
