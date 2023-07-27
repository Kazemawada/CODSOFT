import java.util.HashMap;
import java.util.Map;

public class wordcount {
	
	String inputString ;
	wordcount(String inputString ){
		this.inputString = inputString ;
		}
	
	
	public String output() {
		String out = "";
		int i=0;
		     Map<String, Integer> wordCountMap = countWords(inputString);

      // Print the word count
      for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
    	  
         out=out+entry.getKey() + ": " + entry.getValue()+" ";
      }
		
      String[] words = inputString.toLowerCase().split("\\W+");


      
      for (String word : words) {
          i++;
      }
		
		return out+"\n total words number : "+i;
		
		
	}
	
	
	

  private static Map<String, Integer> countWords(String inputString) {
      // Convert the inputString to lowercase and split it into words
      String[] words = inputString.toLowerCase().split("\\W+");

      // Create a Map to store word counts
      Map<String, Integer> wordCountMap = new HashMap<>();

      // Count the occurrences of each word
      for (String word : words) {
          // If the word is already in the map, increment its count
          // Otherwise, add the word to the map with count 1
          wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
      }

      return wordCountMap;
  }
	
	
	
	
	

}
