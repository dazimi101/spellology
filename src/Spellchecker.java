public class Spellchecker {
  private String str;
  public SpellcheckDatabase dic;
  private int frequency;
  private String autocorrectWord;

  public Spellchecker() {
    dic = new SpellcheckDatabase();
  }

  public String spellCheckStatus(String userWord) {
    // pre: receives user's inputted word
    // post: returns String indicating whether or not a spell check is need
    str = userWord;
    // Check to see if user's word is already correctly spelled (i.e already in
    // Zarathustra), and if so, print appropriate statement
    if (dic.doesWordExist(str)) {
      return "NO_CHECK_NEEDED";
    } else if (findReplacement().equals("")) {
      return "NO_CHECK_FOUND";
    } else {
      return "CHECK_NEEDED";
    }
  }

  public String findReplacement() {
    // pre: recieves nothing
    // post: returns most probable word that the user input word should have been
    // based on frequency
    SpellcheckMachine permutations = new SpellcheckMachine(str);
    autocorrectWord = "";
    frequency = 0;
    for (int i = 0; i < permutations.permutationList.size(); i++) {
      String trackedStr = permutations.permutationList.get(i);
      // Check to see if the permutation exists
      if (dic.doesWordExist(trackedStr)) {
        int wordFrequency = dic.getFrequency(trackedStr);
        // Keep track of which permutation has the highest frequency and update
        // autocorrectWord accordingly
        if ((dic.doesWordExist(trackedStr) == true) && (wordFrequency > frequency)) {
          frequency = wordFrequency;
          autocorrectWord = trackedStr;
        }
      }
    }
    // Print out appropriate statement if Zarathustra couldn't find a
    // replacement/autocrrect permutation
    if (autocorrectWord.equalsIgnoreCase("")) {
      return "";
    }
    return autocorrectWord;
  }

}