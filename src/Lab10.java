import java.util.*;

public class Lab10 {
    public static void main(String[] args) {
        List<String> stopWords = Arrays.asList("a", "an", "the", "is", 
        "this", "to", "of", "and", "you", "that", "he", "she", "it", "with", "they", "I");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        input = input.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = input.split(" ");

        Map<String, Integer> wordCountMap = new HashMap<>();
        Map<String, Integer> stopWordCountMap = new HashMap<>(); 

        for(String word : words) {
            if(stopWords.contains(word)) {
                stopWordCountMap.put(word, stopWordCountMap.getOrDefault(word, 0) + 1);
            } else {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        
        System.out.println("Word Count:");
        displayWordCount(wordCountMap);
        
        
        System.out.println("\nStop Word Count:");
        displayWordCount(stopWordCountMap);
    }
    
    private static void displayWordCount(Map<String, Integer> countMap) {
        Iterator<Map.Entry<String, Integer>> iter = countMap.entrySet().iterator();
        
        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}