import java.util.Random;

public class Individual implements Comparable {
    //chromosome
    private int genes[]=new int[5];
    private int fitness;

    public Individual(){
        Random rnd=new Random();
        for(int i = 0; i< genes.length; i++){
            genes[i]= rnd.nextInt(2);
        }
    }
    public Individual(int[] genes, int fitness) {
        this.genes = genes;
        this.fitness = fitness;
    }
    public void calculateFitness(){
        fitness=0;
        for(int gene: genes){
            fitness+=gene;
        }
    }

    public int getFitness() {
        return fitness;
    }

    public int[] getGenes() {
        return genes;
    }

    @Override
    public int compareTo(Object o) {
        Individual individual=(Individual) o;

        if(this.fitness>individual.fitness)
            return 1;
        else if (this.fitness<individual.fitness)
            return -1;
        return 0;
    }
}
