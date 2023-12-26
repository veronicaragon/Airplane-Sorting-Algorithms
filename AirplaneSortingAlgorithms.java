import java.util.Random;

class AirplaneSortingAlgorithms {
  public static void main(String[] args) {
    Airplane[] airplanes = createAirplaneArray();
    System.out.println("-----------------------------------------------------");
    System.out.println("The number of airplanes in the array: " + airplanes.length);
    System.out.println("Printing the Airplane information [Not sorted]");
    System.out.println();
    showAirplaneInfo(airplanes);
    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Selection Sort based on duration");
    System.out.println("-----------------------------------------------------");
    long start = System.nanoTime();
    SelectionSortByDuration(airplanes);
    long end = System.nanoTime();
    long timeSelectionSortDuration = (end - start);
    System.out.println("Printing the sorted array.....");
    System.out.println();
    showAirplaneInfo(airplanes);

    // Restoring the array to its initial state
    airplanes = createAirplaneArray();

    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Selection Sort based on capacity");
    airplanes = createAirplaneArray();
    System.out.println("-----------------------------------------------------");
    start = System.nanoTime();
    SelectionSortByCapacity(airplanes);
    end = System.nanoTime();
    long timeSelectionSortCapacity = (end - start);
    System.out.println("Printing the sorted array.....");
    System.out.println();
    showAirplaneInfo(airplanes);

    // Restoring the array to its initial state
    airplanes = createAirplaneArray();

    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Merge Sort based on duration");
    airplanes = createAirplaneArray();
    System.out.println("-----------------------------------------------------");
    start = 0;
    end = 0;
    start = System.nanoTime();
    MergeSortByDuration(airplanes);
    end = System.nanoTime();
    long timeMergeSortDuration = (end - start);
    System.out.println("Printing the sorted array.....");
    System.out.println();
    showAirplaneInfo(airplanes);

    // Restoring the array to its initial state
    airplanes = createAirplaneArray();

    System.out.println("-----------------------------------------------------");

    System.out.println("Sorting the array using Merge Sort based on capacity");
    airplanes = createAirplaneArray();
    System.out.println("-----------------------------------------------------");
    start = 0;
    end = 0;
    start = System.nanoTime();
    MergeSortByCapacity(airplanes);
    end = System.nanoTime();
    long timeMergeSortCapacity = (end - start);
    System.out.println("Printing the sorted array.....");
    System.out.println();
    showAirplaneInfo(airplanes);

    System.out.println("-----------------------------------------------------");
    System.out.println("************ Runtime Statistics **************");
    System.out.println();
    System.out.println("Selection sort - duration: " + timeSelectionSortDuration + " ns");
    System.out.println("Selection sort - capacity: " + timeSelectionSortCapacity + " ns");
    System.out.println("Merge sort - duration: " + timeMergeSortDuration + " ns");
    System.out.println("Merge sort - capacity: " + timeMergeSortCapacity + " ns");
  }

  /*this method uses Selection Sort to arrange the Airplane objects in ascending order of duration*/
  public static void SelectionSortByDuration(Airplane[] allAirplane) {
    for (int i = 0; i < allAirplane.length - 1; i++) {
      int minIndex = i;

      //find the index of minimum element in unsorted array
      for (int j = i + 1; j < allAirplane.length; j++) {
        if (allAirplane[j].getDuration() < allAirplane[minIndex].getDuration()) {
          minIndex = j;
        }
      }
      //swap the minimum element with first element
      Airplane temp = allAirplane[minIndex];
      allAirplane[minIndex] = allAirplane[i];
      allAirplane[i] = temp;
    }
  }

  /*this method uses Selection Sort to arrange the Airplane objects in ascending order of capacity*/
  public static void SelectionSortByCapacity(Airplane[] allAirplane) {
    for (int i = 0; i < allAirplane.length - 1; i++) {
      int minIndex = i;

      //find the index of minimum element in unsorted array
      for (int j = i + 1; j < allAirplane.length; j++) {
        if (allAirplane[j].getCapacity() < allAirplane[minIndex].getCapacity()) {
          minIndex = j;
        }
      }
      //swap the minimum element with first element
      Airplane temp = allAirplane[minIndex];
      allAirplane[minIndex] = allAirplane[i];
      allAirplane[i] = temp;
    }
  }

  /*this method uses Merge Sort to arrange the Airplane objects in ascending order of duration*/
  public static void MergeSortByDuration(Airplane[] allAirplane) {
    mergeSort(allAirplane, 0, allAirplane.length - 1);
  }

  static void mergeSort(Airplane[] allAirplane, int left, int right) {
  	if (left < right) {
      int middle = (left + right) / 2;

      // Sort first and second halves
      mergeSort(allAirplane, left, middle);
      mergeSort(allAirplane, middle + 1, right);

      // Merge the sorted halves
      merge(allAirplane, left, middle, right);
    }
  }

  static void merge(Airplane[] allAirplane, int left, int middle, int right) {
    //base case for when array has 1 or fewer elements, it is already sorted
    int length = allAirplane.length;
    if (length < 2) {
    	return;
    }
    
    int leftHalf = middle - left + 1;
    int rightHalf = right - middle;

    Airplane[] leftArray = new Airplane[leftHalf];
    Airplane[] rightArray = new Airplane[rightHalf];
    
    //populate left side of array
    for (int i = 0; i < leftHalf; i++) {
    	leftArray[i] = allAirplane[left + i];
    }
    //populate right side of array
    for (int j = 0; j < rightHalf; j++) {
    	rightArray[j] = allAirplane[middle + 1 + j];
    }
   
    // Initialize iterators for Left and Right arrays
    int i = 0, j = 0;
    int k = left;
    while (i < leftHalf && j < rightHalf) {
      if (leftArray[i].getDuration() <= rightArray[j].getDuration()) {
        allAirplane[k] = leftArray[i];
        i++;
      }
      else {
        allAirplane[k] = rightArray[j];
        j++;
      }
      k++;
    }
    // Copy remaining elements of leftArray[], if there are any
    while (i < leftHalf) {
      allAirplane[k] = leftArray[i];
      i++;
      k++;
    }
    // Copy remaining elements of rightArray[], if there are any
    while (j < rightHalf) {
      allAirplane[k] = rightArray[j];
      j++;
      k++;
    }
  }

  /*this method uses Merge Sort to arrange the Airplane objects in ascending order of capacity*/
  public static void MergeSortByCapacity(Airplane[] allAirplane) {
    mergeSortByCapacity(allAirplane, 0, allAirplane.length - 1);
  }

  static void mergeSortByCapacity(Airplane[] allAirplane, int left, int right) {
    if (left < right) {
      int middle = (left + right) / 2;

      // Sort first and second halves
      mergeSortByCapacity(allAirplane, left, middle);
      mergeSortByCapacity(allAirplane, middle + 1, right);

      // Merge the sorted halves
      mergeByCapacity(allAirplane, left, middle, right);
    }
  }

  static void mergeByCapacity(Airplane[] allAirplane, int left, int middle, int right) {
    //base case for when array has 1 or fewer elements, it is already sorted
    int length = allAirplane.length;
    if (length < 2) {
    	return;
    }
    
    int leftHalf = middle - left + 1;
    int rightHalf = right - middle;

    Airplane[] leftArray = new Airplane[leftHalf];
    Airplane[] rightArray = new Airplane[rightHalf];
    
    //populate left side of array
    for (int i = 0; i < leftHalf; i++) {
    	leftArray[i] = allAirplane[left + i];
    }
    //populate right side of array
    for (int j = 0; j < rightHalf; j++) {
    	rightArray[j] = allAirplane[middle + 1 + j];
    }
   
    // Initialize iterators for Left and Right arrays
    int i = 0, j = 0;
    int k = left;
    while (i < leftHalf && j < rightHalf) {
      if (leftArray[i].getCapacity() <= rightArray[j].getCapacity()) {
        allAirplane[k] = leftArray[i];
        i++;
      }
      else {
        allAirplane[k] = rightArray[j];
        j++;
      }
      k++;
    }
    // Copy remaining elements of leftArray[], if there are any
    while (i < leftHalf) {
      allAirplane[k] = leftArray[i];
      i++;
      k++;
    }
    // Copy remaining elements of rightArray[], if there are any
    while (j < rightHalf) {
      allAirplane[k] = rightArray[j];
      j++;
      k++;
    }
  }

  /************************************************************************************************************************************************
   * Don't change anything below this line
   */
  /**
   * Display all the variables of a
   * Airplane object in the same sequence
   * they appear in the parameter array.
   * 
   * @param allAirplane
   */

  static void showAirplaneInfo(Airplane[] allAirplane) {
    for (int i = 0; i < allAirplane.length; i++) {
      System.out.println(allAirplane[i].toString());
    }
  }

  static Airplane[] createAirplaneArray() {
    Airplane[] airplanes = new Airplane[150];
        Random rand = new Random();
        for (int i = 0; i < 150; i++) {
            int capacity = rand.nextInt(300) + 1; // generates capacity between 1 to 300
            int startTime = rand.nextInt(2300); // generates start time between 0 to 2300
            int endTime = startTime + rand.nextInt(2400 - startTime) + 1; // ensures end time > start time
            airplanes[i] = new Airplane(i+1, "Plane" + (i+1), capacity, startTime, endTime);
        }
        return airplanes;

  }
}