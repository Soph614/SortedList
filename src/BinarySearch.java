public class BinarySearch
{
    /**
     *
     * @author Tom.Wulf@uc.edu
     *
     * A simple implementation of the Binary Search on an Array
     */


    public static void main(String[] args)
    {
        // CODE UPDATED FROM @author Tom.Wulf@uc.edu
        String[] data = {"apple", "blackberry", "cherry", "dog", "egg", "fig", "grape", "hair"};

        String target = "egg"; // 3 is not in the array...try different values to see how it works

        int low = 0;
        int mid = 0;
        int high = data.length - 1;

        do {
            mid = (low + high) / 2;
            if (target.compareTo(data[mid]) == 0) { // TARGET IS FOUND AT INDEX 4
                System.out.println("Target: " + target + " found at index: " + mid);
                break;
            }
            else if (target.compareTo(data[mid]) > 0) { //    returns 1, which means it comes AFTER the target...
                low = mid + 1;                          // ...so we  change the low to the index above the mid...
                                                        // ...so now we'll be searching above the mid
            }
            else {              //    returns -1, which means it comes BEFORE the target...
                high = mid - 1; // ...so we change the high to the index below the mid...
                                // ...so now we'll be searching below the mid
            }
        }while(low <= high); // loop must end here to allow the code to move on to the next statement,
                             // which will double-check that 'low' is greater than 'high' and act accordingly

        if(low > high) { // this will happen if 'mid' continues to come after the target
                         // because 'low' will continue to be incremented and 'high' will
                         // continue to stay stagnant, so eventually 'low' will become
                         // higher than 'high'
            System.out.println("Value: " + target + " not found in the array");
        }
    }
}

