# Spellology
*A spell checker powered by philosophy.*

## Table of Contents
- [About](#about)
- [Details](#details)
- [Future Improvements](#future-improvements)
- [Credits](#credits)

## About

Spellology is a Java GUI (Swing) based spell checker that validates a user's inputted word. If the user's word is incorrectly spelled, then spellology replaces the user's word directly in the text field. If spellology thinks the word is spelled incorrectly or can not validate the word, a corresponding pop up appears. The validation process utilizes a database of words and their frequencies based on a certain philosophical text. 

## Details
First version (w/ Swing) complete (July 4 2022) but project still [active](#future-improvements). 

**Spellology.java**

- Houses main as well as all of the Java Swing GUI implementation.

**Spellchecker.java**

- Conducts spell check process and generates spell check word. Also handles whether or not a spell check should take place.

**SpellcheckDatabse.java**

- Holds a list of unique words and a list of their frequencies (read from ReferenceText.txt).

**SpellcheckMachine.java**

- Generates permutations of user's inputted word.

**TxtReader.java**

- Reads from ReferenceText.txt (written with external help).

**ReferenceText.txt**

- Text file transcript of the book used to generate a correct words list. This correct words list is compared to the user's inputted word to help find (or not find) a proper replacement.

## Future Improvements
1. Create executable version of spellology.
2. Add ability to switch between different texts (using tab, dropdown menu, etc).
3. Add functionality for sentences/paragraphs.
4. Implement GUI with JavaFX instead of Swing.
5. Make spell check process more intelligent (e.g take proximity of letters on QWERTY keyboards into proximity)

## Credits
Developed by myself. Book transcripts taken from Project Gutenberg.