import java.util.*;

public class page {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of frames
        System.out.print("Enter the number of frames: ");
        int numFrames = scanner.nextInt();

        // Input the reference string
        System.out.print("Enter the number of page requests: ");
        int numRequests = scanner.nextInt();
        int[] pageRequests = new int[numRequests];
        
        System.out.println("Enter the page reference string:");
        for (int i = 0; i < numRequests; i++) {
            pageRequests[i] = scanner.nextInt();
        }

        // Initialize frames as empty
        Set<Integer> frames = new HashSet<>(numFrames);
        Map<Integer, Integer> recentUse = new HashMap<>();

        int pageFaults = 0;

        // Process each page request
        for (int i = 0; i < numRequests; i++) {
            int currentPage = pageRequests[i];

            // If the page is not in frames (a page fault)
            if (!frames.contains(currentPage)) {
                pageFaults++;

                // If there is no space left in frames
                if (frames.size() == numFrames) {
                    // Find the least recently used page
                    int lruPage = Collections.min(recentUse.entrySet(), Map.Entry.comparingByValue()).getKey();
                    frames.remove(lruPage); // Remove the LRU page from frames
                    recentUse.remove(lruPage); // Remove from recent usage
                }

                // Add the current page to frames
                frames.add(currentPage);
            }

            // Update the recent usage of the current page
            recentUse.put(currentPage, i);
            
            // Display the current status of frames
            System.out.println("Frames: " + frames + " (Page Faults: " + pageFaults + ")");
        }

        // Display the total number of page faults
        System.out.println("\nTotal Page Faults: " + pageFaults);
    }
}
