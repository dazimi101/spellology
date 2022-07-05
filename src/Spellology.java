import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Spellology {
  public static String name = "Spellology";
  public static String textName = "Thus Spoke Zarathustra by Nietzsche";

  public static void addToPane(Container pane) {
    pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    pane.setLayout(new GridBagLayout());

    GridBagConstraints c = new GridBagConstraints();

    // Label for spellology title and subtitle.
    JLabel title = new JLabel(
        "<html><center><p style='font-size: 45px'><font color='green'>spell<font color='red'>ology<br>"
            + "<p style='font-size: 10px'><font color='black'><center>a spell checker powered by philosophy<br><br><br><br></html>");
    c.ipady = 250;
    c.gridx = 0;
    c.gridy = 0;
    pane.add(title, c);

    // Text field to take user input.
    JTextField input = new JTextField("Type a single word here");
    c.ipady = 10;
    c.ipadx = 23;
    c.gridx = 0;
    c.gridy = 1;
    pane.add(input, c);

    // Button to conduct spell checker when pressed.
    JButton button = new JButton("Check your spelling!");
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String inputWord, spellCheckWord, message;

        inputWord = input.getText().toLowerCase();

        Spellchecker spellologyApp = new Spellchecker();

        /*
         * Check for status of the user's word. If the word needs to be spell checked,
         * then spell check. If the word is already correctly spelled or not recognized,
         * display appropriate pop up.
         */
        if (spellologyApp.spellCheckStatus(inputWord).equalsIgnoreCase("CHECK_NEEDED")) {
          spellCheckWord = spellologyApp.findReplacement();
          input.setText(spellCheckWord);
        } else if (spellologyApp.spellCheckStatus(inputWord).equalsIgnoreCase("NO_CHECK_NEEDED")) {
          message = "<html>Based on the reference text, <em>" + textName + "</em>, <b>" + inputWord
              + "</b> is correctly spelled.";
          JOptionPane.showMessageDialog((Component) null, message, name, JOptionPane.PLAIN_MESSAGE);
        } else if (spellologyApp.spellCheckStatus(inputWord).equalsIgnoreCase("NO_CHECK_FOUND")) {
          message = "<html>Spellcast can not decide whether or not <b>" + inputWord
              + "</b> is correctly spelled based on the reference text, <em>" + textName + "</em>. <br><br><center>Please try a different word.<html>";
          JOptionPane.showMessageDialog((Component) null, message, name, JOptionPane.PLAIN_MESSAGE);
        }
      }
    };
    button.setActionCommand("SpellChecker");
    button.addActionListener(actionListener);

    c.weighty = 1;
    c.ipady = 0;
    c.gridx = 0;
    c.gridy = 2;
    pane.add(button, c);
  }

  private static void createGUI() {
    // Generate the spellcast window
    JFrame f = new JFrame(name);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set up the content pane
    addToPane(f.getContentPane());

    // Show the window
    f.setSize(800, 800);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createGUI();
      }
    });
  }
}