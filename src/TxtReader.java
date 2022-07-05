import java.util.Scanner;
import java.io.File;

public class TxtReader {
    private Scanner sc;
    private String nextWord;

    // Create a file reader object to access file with filepath
    public TxtReader(String filepath) {
        try {
            sc = new Scanner(new File(filepath));
        } catch (Exception e) {
            System.out.print("ERROR:  ");
            System.out.println(e);
            return;
        }
        setNext();
    }

    // Returns true if text file continues (i.e there are more words left)
    public boolean hasNextWord() {
        return nextWord != null;
    }

    // Gets the next word in the text file
    public String getNextWord() {
        String ret = nextWord;
        setNext();
        return ret;
    }

    // Sets the nextWord that should be given back
    private void setNext(){
        if (!sc.hasNext()){
            nextWord = null;
            sc.close();
            return;
        }
        // Make string lower case, and remove most punctuation characters except ' and -
        String word = sc.next().toLowerCase();
        word.replaceAll("[!“”\"\\#$%&()*+,./:;<=>?@\\[\\\\\\]^_‘{|}~]", "" );
        
        // If word isn't empty, set to next word to word
        if (!word.equals(""))
        {
            nextWord = word;
        }
        else {
            setNext();
        }
    }
}
