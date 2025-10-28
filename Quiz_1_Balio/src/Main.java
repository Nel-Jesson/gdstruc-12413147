//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    int[] numbers = new int[10];

    numbers[0] = 27;
    numbers[1] = 12;
    numbers[2] = 90;
    numbers[3] = 32;
    numbers[4] = 2;
    numbers[5] = 30;
    numbers[6] = 28;
    numbers[7] = 8;
    numbers[8] = 15;
    numbers[9] = 73;

    // Must split nums since Bubble sort nums will be used for selection sort. Plus found out about clone()
    int[] bubbleTestNumbers = numbers.clone();

    System.out.println("Before Bubble sort (Descending):");
    printArrayElements(bubbleTestNumbers);

    bubbleSort(bubbleTestNumbers);

    System.out.println("\n\nAfter Bubble sort:");
    printArrayElements(bubbleTestNumbers);

    int[] selectionTestNumbers = numbers.clone();

    System.out.println("\nBefore selection sort (Descending):");
    printArrayElements(selectionTestNumbers);

    selectionSort(selectionTestNumbers);

    System.out.println("\n\nAfter selection sort:");
    printArrayElements(selectionTestNumbers);

    int[] selectionSmallFirstTestNumbers = numbers.clone();

    System.out.println("\nBefore selection small:");
    printArrayElements(selectionSmallFirstTestNumbers);

    selectionSortSmallFirst(selectionSmallFirstTestNumbers);

    System.out.println("\n\nAfter selection small:");
    printArrayElements(selectionSmallFirstTestNumbers);
}

    private static void bubbleSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            for (int i = 0; i < lastSortedIndex; i++)
            {
                if (arr[i] < arr[i +1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            int smallestIndex = 0;

                for (int i = 1; i <= lastSortedIndex; i++)
                {
                    if (arr[i] < arr[smallestIndex])
                    {
                        smallestIndex = i;
                    }

                    int temp = arr[lastSortedIndex];
                   arr[lastSortedIndex] = arr[smallestIndex];
                   arr[smallestIndex] = temp;
                }
        }
    }

    private static void selectionSortSmallFirst(int[] arr)
    {
    for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
    {
        int smallestIndex = 0;

        for (int i = 1; i <= lastSortedIndex; i++) {
            if (arr[i] < arr[smallestIndex]) {
                smallestIndex = i;
            }
        }

            int temp = arr[lastSortedIndex];
            arr[lastSortedIndex] = arr[smallestIndex];
            arr[smallestIndex] = temp;

    }
}

   private static void printArrayElements(int[] arr)
   {
       for (int j : arr) {
           System.out.println(j + " ");
       }
    }

