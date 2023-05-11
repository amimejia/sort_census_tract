package guilford.edu;

public class sortDriver {
    public static void main(String[] args) {
        
        CensusTract[] censusTracts = new CensusTract[10];
        for (int i = 0; i < 10; i++) {
            censusTracts[i] = new CensusTract();
        }

        // Print out the array before sorting
        System.out.println("Before sorting:");
        for (CensusTract censusTract : censusTracts) {
            System.out.println(censusTract);
        }

        long startTime = System.nanoTime();
        // Sort the array through
        CensusTract.selectionSort(censusTracts);
        System.out.println("\nSorted array: ");
        for (CensusTract censusTract : censusTracts) {
            System.out.println(censusTract);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Selection sort took " + (duration / 1.e6) + " milliseconds");

        // Shuffle the array
        shuffle(censusTracts);
        startTime = System.nanoTime();
        quickSort(censusTracts);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Quick sort took " + (duration / 1.e6) + " milliseconds");


        shuffle(censusTracts);
        CensusTract rand_CensusTract = censusTracts[(int) (Math.random() * censusTracts.length)];
        startTime = System.nanoTime();
        int linearSearch_Census = linearSearch(censusTracts, rand_CensusTract);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Linear search took " + (duration / 1.e6) + " milliseconds");
        

        //using binarysearch
        quickSort(censusTracts);
        startTime = System.nanoTime();
        int binarySearch_Census = binarySearch(censusTracts, rand_CensusTract);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Binary search took " + (duration / 1.e6) + " milliseconds");
    }





    //Methods:
    // add a static swap method that takes an array of Puppy objects and two indices
    public static void swap(CensusTract[] censusTracts, int i, int j) {
        CensusTract temp = censusTracts[i];
        censusTracts[i] = censusTracts[j];
        censusTracts[j] = temp;
    }

    // add a shuffle method that shuffles an array of Puppy objects
    public static void shuffle(CensusTract[] censusTracts) {
        // loop through the array
        for (int i = 0; i < censusTracts.length; i++) {
            // generate a random index
            int randomIndex = (int) (Math.random() * censusTracts.length);
            // swap elements
            swap(censusTracts, i, randomIndex);
        }
    }
    public static void quickSort(CensusTract[] censusTracts){
        quickSort(censusTracts, 0, censusTracts.length - 1);
    }

    public static void quickSort(CensusTract[] censusTracts, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(censusTracts, low, high);
            quickSort(censusTracts, low, pivotIndex - 1);
            quickSort(censusTracts, pivotIndex + 1, high);
        }
    }

    public static int partition(CensusTract[] censusTracts, int low, int high) {
        // select the pivot
        CensusTract pivot = censusTracts[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (censusTracts[j].getCensusTract() < pivot.getCensusTract()) {
                i++;
                swap(censusTracts, i, j);
            }
        }
        swap(censusTracts, i + 1, high);
        return i + 1;
    }

    public static int linearSearch(CensusTract[] censusTracts, CensusTract censusTract){
        for (int i = 0; i < censusTracts.length; i++) {
            if (censusTracts[(int) i].getCensusTract() == censusTract.getCensusTract()) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(CensusTract[] censusTracts, CensusTract censusTract){
        int low = 0;
        int high = censusTracts.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (censusTracts[mid].getCensusTract() == censusTract.getCensusTract()) {
                return mid;
            } else if (censusTracts[mid].getCensusTract() < censusTract.getCensusTract()) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; 
    }
}