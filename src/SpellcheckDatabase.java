import java.util.ArrayList;

public class SpellcheckDatabase {

  FileReader reader = new FileReader("src/ReferenceText.txt");

  // To keep track of correct words
  private ArrayList<String> validWordList = new ArrayList<String>();
  // To keep track of frequency of each correct word
  private ArrayList<Integer> frequencyList = new ArrayList<Integer>();
  private int var = 0;

  // Construct CorrectWordsList object
  public SpellcheckDatabase() {
    while (reader.hasNextWord()) {
      addWord(reader.getNextWord());
    }
  }

  public void addWord(String word) {
    // pre: recieves word from Reference Text
    // post: returns nothing, and adds word to validWordsList if word is unique
    // and updates frequency list accordingly
    int indexTracker = validWordList.indexOf(word);
    if (indexTracker == -1) {
      validWordList.add(var, word);
      var++;
      frequencyList.add(1);
    } else {
      frequencyList.set(indexTracker, (frequencyList.get(indexTracker) + 1));
    }
  }

  public boolean doesWordExist(String word) {
    // pre: receives a word
    // post: returns boolean indicating whether or not word (in this case,
    // permutation) exists in Zarathustra
    int wordTracker = validWordList.indexOf(word);
    if (wordTracker != -1) {
      return true;
    } else
      return false;
  }

  public int getFrequency(String word) {
    // pre: receives a word
    // post: returns frequency of word (in this case, of permutation)
    int frequency = frequencyList.get(validWordList.indexOf(word));
    return frequency;
  }

}