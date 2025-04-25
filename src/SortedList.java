import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    // Add in sorted order using manual binary search
    public void add(String item) {
        int index = findInsertIndex(item);
        list.add(index, item);
    }

    // Manual binary search for insertion
    private int findInsertIndex(String item) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = item.compareToIgnoreCase(list.get(mid));

            if (comparison == 0) {
                return mid; // Already exists
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low; // Position where it would go
    }

    // Search for item or return insert position
    public String search(String item) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = item.compareToIgnoreCase(list.get(mid));

            if (comparison == 0) {
                return "Found: " + list.get(mid) + " at index " + mid;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return "Not found. Would be inserted at index " + low;
    }

    public String toString() {
        return String.join("\n", list);
    }
}
