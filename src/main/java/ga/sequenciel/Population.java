import java.util.*;

public class Population {
    List<Individual> individuals = new ArrayList<>();
    Individual firstFinest;
    Individual secondFinest;
    Random random = new Random();

    public void initializePopulation() {
        for (int i = 0; i < 100; i++) {
            individuals.add(new Individual());
        }
    }

    public void calculateIndividualFitness() {
        for (int i = 0; i < 100; i++) {
            individuals.get(i).calculateFitness();
        }
    }

    public void selection() {
        firstFinest = individuals.get(0);
        secondFinest = individuals.get(1);
    }

    public void sortPopulation() {
        Collections.sort(individuals, Collections.reverseOrder());
    }

    //croisement
    public void crossover() {
        int pointCroisement = random.nextInt(5);
        pointCroisement++;
        Individual individual1 = new Individual();
        Individual individual2 = new Individual();
        for (int i = 0; i < individual2.getGenes().length; i++) {
            individual1.getGenes()[i] = firstFinest.getGenes()[i];
            individual2.getGenes()[i] = secondFinest.getGenes()[i];
        }

        for (int i = 0; i < pointCroisement; i++) {
            individual1.getGenes()[i] = secondFinest.getGenes()[i];
            individual2.getGenes()[i] = firstFinest.getGenes()[i];
        }
        individuals.set(individuals.size() - 1, individual1);
        individuals.set(individuals.size() - 2, individual2);
        individual1.calculateFitness();
        individual2.calculateFitness();
    }

    public void mutation() {
        int index = random.nextInt(6);
        if (individuals.get(individuals.size() - 1).getGenes()[index] == 1)
            individuals.get(individuals.size() - 1).getGenes()[index] = 0;
        else
            individuals.get(individuals.size() - 1).getGenes()[index] = 1;
    }

    public Individual getBestFitnessInd() {
        return individuals.get(0);
    }
}
