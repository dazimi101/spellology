import java.util.ArrayList;

public class SpellcheckMachine {

  public ArrayList<String> permutationList = new ArrayList<String>();
  private String wordToPermute;

  // Constructs StringPermutor object
  public SpellcheckMachine(String userWord) {
    wordToPermute = userWord;
    everyPossibleSpot();
    removeLetter();
    replaceLetter();
    swapLetter();
  }

  // Replace every letter in user's inputted word
  public void replaceLetter() {
    String word;
    for (int i = 97; i <= 122; i++) {
      int asciiValue = i;
      // Pull letter from ascii value
      char convertLetter = (char) asciiValue;
      for (int j = 0; j < wordToPermute.length(); j++) {
        StringBuffer str = new StringBuffer(wordToPermute);
        str.setCharAt(j, convertLetter);
        word = str.toString();
        permutationList.add(word);
      }
    }
  }

  // Add a letter in every possible spot
  public void everyPossibleSpot() {
    String word;
    for (int i = 97; i <= 122; i++) {
      for (int j = 0; j <= wordToPermute.length(); j++) {
        int asciiValue = i;
        // Pull letter from ascii value
        char convertASCII = (char) asciiValue;
        StringBuffer str = new StringBuffer(wordToPermute);
        str.insert(j, convertASCII);
        word = str.toString();
        permutationList.add(word);
      }
    }
  }

  // Remove a letter form every possible spot
  public void removeLetter() {
    String word;
    for (int i = 0; i < wordToPermute.length(); i++) {
      StringBuffer str = new StringBuffer(wordToPermute);
      str = str.deleteCharAt(i);
      word = str.toString();
      permutationList.add(word);
    }
  }

  // Swap adjacent letters
  public void swapLetter() {
    String word;
    for (int i = 0; i < wordToPermute.length() - 1; i++) {
      StringBuffer str = new StringBuffer(wordToPermute);
      // Keep track of adjacent letters with seperate variables letterOne and
      // letterTwo
      char letterOne = str.charAt(i);
      char letterTwo = str.charAt(i + 1);
      str.setCharAt(i, letterTwo);
      str.setCharAt(i + 1, letterOne);
      word = str.toString();
      permutationList.add(word);
    }
  }

  public void printStringArrayList(ArrayList<String> print) {
    // pre: receives array list to print
    // post: returns nothing and prints array list
    System.out.println();
    for (String word : print)
      System.out.print(word + " \n");
    System.out.println();
  }
}