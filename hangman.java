import java.util.*;
public class hangman {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        String wordGuess;
        int wordLenght;
        int livesLost = 0;
        int livesTotal = 7;
        int lettersLeft;
        boolean wordLetters;
        char letter;
        StringBuffer lettersErvoor;
        int positie;
        //----------------------------------------------------

        String[] stringLijst = new String[]{"Russia","China","Canada","Germany","Liquid","Communism","Capitalism","AlahuAkbar"};

        System.out.println("Welcome to my game, Hang Man. You will have to guess the letters in the word. You'll see how many letters there are in a word and you have 7 lives!");
        wordGuess = stringLijst[(int)(Math.random()* stringLijst.length)];
        wordLenght = wordGuess.length();

        System.out.println("The word you're guessing has " + wordLenght + " letters in it.");
        lettersLeft = wordLenght;

        for (positie = 0; positie<wordLenght; positie++){
            buffer.append("_ ");
        }
        System.out.println(buffer.toString());
        //------------------------------------------------------

        while (lettersLeft > 0 && livesTotal < 7){
        System.out.println("Take a guess!");
        letter = scanner.findWithinHorizon(".",0).charAt(0);

        wordLetters = (wordGuess.indexOf(letter))!= -1;

        if (wordLetters == false){
            livesLost++;
            System.out.println("Sorry, you have lost a life.");
            System.out.println(livesTotal - livesLost + " left");
        } else {
            System.out.println("That was correct!");

            for (positie = 0; positie<wordLenght; positie++){
                if (wordGuess.charAt(positie) == letter){
                    System.out.println(letter);
                    lettersLeft--;
                } else {
                    System.out.println("_ ");
                }
            }
        }

            lettersErvoor = buffer2.append(letter);
            System.out.println("Letters guessed before: ");
            System.out.println(lettersErvoor);
            System.out.println("Letters remaining: ");
            System.out.println(lettersLeft);
        }
        //----------------------------------------------------------------------
        if (livesLost == livesTotal){
            System.out.println("Sorry you have lost!");
        } else {
            System.out.println("Congratulations, you have won! The word was: ");
            System.out.println(wordGuess);
        }


    }
}
