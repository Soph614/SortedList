import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String whatToAdd) {
        if (list.isEmpty()) {
            list.add(whatToAdd);
        } else {
            // CODE UPDATED FROM @author Tom.Wulf@uc.edu
            int low = 0;
            int mid;
            int high = list.size() - 1;

            do {
                mid = (low + high) / 2;
                if (whatToAdd.compareTo(list.get(mid)) == 0) { // whatToAdd IS FOUND AT INDEX 4
                    return; // leave here, nothing else is needed
                } else if (whatToAdd.compareTo(list.get(mid)) > 0) {    //    returns 1, which means it comes AFTER the whatToAdd...
                    low = mid + 1;                                      // ...so we  change the low to the index above the mid...
                    // ...so now we'll be searching above the mid

                } else {            //    returns -1, which means it comes BEFORE the whatToAdd...
                    high = mid - 1; // ...so we change the high to the index below the mid
                    //    so now we'll be searching below the mid
                }
            } while (low <= high);  // loop must end here to allow the code to move on to the next statement,
            // which will double-check that 'low' is greater than 'high' and act accordingly

            list.add(low, whatToAdd); // add the item at index low, which will be the point after
        }
    }
    
    public String performBinarySearch(String searchTerm) {
        String message = "";
        // CODE UPDATED FROM @author Tom.Wulf@uc.edu
        int low = 0;
        int mid = 0;
        int high = list.size() - 1;

        do {
            mid = (low + high) / 2;
            if (searchTerm.compareToIgnoreCase(list.get(mid)) == 0) { // searchTerm IS FOUND AT INDEX 4
                message = "'" + searchTerm + "' found at index " + mid;
                break;
            }
            else if (searchTerm.compareToIgnoreCase(list.get(mid)) > 0) { //    returns 1, which means it comes AFTER the searchTerm...
                low = mid + 1;                                  // ...so we  change the low to the index above the mid...
                                                                // ...so now we'll be searching above the mid
            }
            else {              //    returns -1, which means it comes BEFORE the searchTerm...
                high = mid - 1; // ...so we change the high to the index below the mid...
                                // ...so now we'll be searching below the mid
            }
        }while(low <= high); // loop must end here to allow the code to move on to the next statement,
                             // which will double-check that 'low' is greater than 'high' and act accordingly

        if(low > high) { // this will happen if 'mid' continues to come after the searchTerm
                         // because 'low' will continue to be incremented and 'high' will
                         // continue to stay stagnant, so eventually 'low' will become
                         // higher than 'high'
            message = "'" + searchTerm + "' was not found!";
        }
        return message;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}