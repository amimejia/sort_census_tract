package guilford.edu;

import java.util.Random;

public class CensusTract {
    private int censusTract;
    private String state;
    private String county;
    private double socialVulnerabilityIndex;

    // Constructor with random values
    public CensusTract() {
        String[] states = { "North Carolina", "South Carolina", "Virginia", "Georigia", "Florida", "Alabama",
                "Mississippi", "Tennessee", "Kentucky", "West Virginia" };
        String[] counties = { "Guilford", "Forsyth", "Rockingham", "Randolph", "Davidson", "Caswell", "Pearson",
                "Orange", "Durham", "Wake" };

        Random rand = new Random();
        this.censusTract = rand.nextInt(100000);
        this.state = states[rand.nextInt(states.length)];
        this.county = counties[rand.nextInt(counties.length)];
        this.socialVulnerabilityIndex = rand.nextDouble(.999);
    }

    // getters and setters
    public int getCensusTract() {
        return censusTract;
    }

    public void setCensusTract(int censusTract) {
        this.censusTract = censusTract;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public double getSocialVulnerabilityIndex() {
        return socialVulnerabilityIndex;
    }

    public void setSocialVulnerabilityIndex(double socialVulnerabilityIndex) {
        this.socialVulnerabilityIndex = socialVulnerabilityIndex;
    }

    @Override
    public String toString() {
        return "CensusTract [censusTract=" + censusTract + ", county=" + county + ", socialVulnerabilityIndex="
                + socialVulnerabilityIndex + ", state=" + state + "]";
    }

    // Selection Sort Method
    public static void selectionSort(CensusTract[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j].getCensusTract() < array[minIndex].getCensusTract()) {
                    minIndex = j;
                }
                int stateComparison = array[j].getState().compareTo(array[minIndex].getState());
                if (stateComparison < 0) {
                    minIndex = j;
                } else if (stateComparison == 0) { // If states are the same, compare counties
                    int countyComparison = array[j].getCounty().compareTo(array[minIndex].getCounty());
                    if (countyComparison < 0) {
                        minIndex = j;
                    } else if (countyComparison == 0) { // If counties are the same, compare socialVulnerabilityIndex
                        if (array[j].getSocialVulnerabilityIndex() < array[minIndex].getSocialVulnerabilityIndex()) {
                            minIndex = j;
                        }
                    }
                    // Swap the elements at i and minIndex
                    CensusTract temp = array[i];
                    array[i] = array[minIndex];
                    array[minIndex] = temp;
                }
            }
        }

    }

    // public static void shuffle(CensusTract[] array) {
    //     //loop through array
    //     for (int i = 0; i < array.length; i++) {
    //         //generate random index
    //         int randomIndex = (int) (Math.random() * array.length);
    //         //swap elements
    //         CensusTract temp = array[i];
    //         array[i] = array[randomIndex];
    //         array[randomIndex] = temp;
    //     }
    // }


    // quickSort method that takes an array of integers as a parameter
    //and sorts the array using the quick sort algorithm
    //public static void quickSort
    
}
