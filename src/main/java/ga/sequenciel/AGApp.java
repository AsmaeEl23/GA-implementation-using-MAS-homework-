import java.util.Arrays;
import java.util.Random;

public class AGApp {
    private static final int MAX_IT=50;
    private  static final int MAX_FITNESS=10;
    public static void main(String[] args) {
        Population population=new Population();
        population.initializePopulation();
        population.calculateIndividualFitness();
        population.sortPopulation();
        //show fitness
        int it=0;
        System.out.println("Chromosome : "+ Arrays.toString(population.getBestFitnessInd().getGenes())+" fitness : "+population.getBestFitnessInd());

        while (it<MAX_IT&& population.getBestFitnessInd().getFitness()<MAX_FITNESS){
            population.selection();
            population.crossover();
            Random random=new Random();
            if(random.nextInt(101)<50)
                population.mutation();
            population.calculateIndividualFitness();
            population.sortPopulation();
            System.out.println("Chromosome : "+ Arrays.toString(population.getBestFitnessInd().getGenes())+" fitness : "+population.getBestFitnessInd());
            it++;
        }
    }
}
