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

        int foundIndex;
        int firstIndex;
        int lastIndex;

        System.out.println("Begin binary search");
        do {
            mid = (low + high) / 2;
            System.out.println("Recalculated the mid");
            if (searchTerm.compareTo(list.get(mid)) == 0) { // searchTerm IS FOUND AT INDEX 4
                message = "'" + searchTerm + "' found at index " + mid + ":";
                foundIndex = mid;
                message += "\n------------------------------";
                message += "\n" + String.format("%-6s", foundIndex) + "  " + list.get(foundIndex);
                message += "\n------------------------------";
                message += "\n";
                break;
            }
            else if (searchTerm.compareTo(list.get(mid)) > 0) { //    returns 1, which means the searchTerm comes AFTER the mid...
                low = mid + 1;                                  // ...so we  change the low to the index above the mid...
                                                                // ...so now we'll be searching above the mid
                System.out.println("Comes after the mid..");
            }
            else {              //    returns -1, which means the searchTerm comes BEFORE the mid...
                high = mid - 1; // ...so we change the high to the index below the mid...
                                // ...so now we'll be searching below the mid
                System.out.println("Comes before the mid..");
            }
        }while(low <= high);

        if(low > high) {
            message = "'" + searchTerm + "' not found.\nWould be at index " + low + "\n";
        }
        return message;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
