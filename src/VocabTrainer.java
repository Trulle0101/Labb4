import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Huvudlassen {@code VocabTrainer} ansvarar för att köra ett
 * glosförhör i engelska.
 * <p>
 * Programmet visar ett svenskt ord och användaren ska skriva
 * motsvarande engelska ord. Resultatet bedöms och statistik
 * visas löpande tills programmet är slut.
 */
public class VocabTrainer
{
    /** Lista med glosor som används i övningsprogrammet**/
    private List<VocabWord> vocabWords;
    /** Skanner för att läsa in användarens input**/
    private Scanner scanner;
    /** Maximalt antal glosor som ställs under övningsprogrammet**/
    private int maxQuestions = 10;

    /**
     * Skapar ett nytt {@code VocabTrainer}-objekt.
     * <p>
     * Initierar scanner samt laddar en uppsättning av glosor.
     */
    public VocabTrainer()
    {
        this.scanner = new Scanner(System.in);
        this.vocabWords = new WorldList(). getList();

    }

    /**
     * Startar och kör glosövningen.
     * <p>
     * Metoden itererar igenom gloslistan, tar emot användarens svar,
     * utvärderar svarer och visar feedback. Programmet avslutas om
     * användaren skriver {@code Q} eller när max antal frågor har ställts.
     */
    public void run()
    {
        System.out.println("** GLOSÖVNING - ENGELSKA **");
        System.out.println("Skriv det engelska ordet. Avsluta programmet genom att skriva Q.\n");

        int asked = 0;
        int correctCount = 0;

        for (VocabWord item : vocabWords)
        {
            if (asked >= maxQuestions)
            {
                break;
            }

            System.out.print(item.getSwedishWord() + " : ");
            String userInput = scanner.nextLine();

            AnswerResult result = AnswerEvaluator.evaluate(userInput, item);

            if (result == AnswerResult.QUIT)
            {
                break;
            }

            asked++;

            if (result == AnswerResult.CORRECT)
            {
                correctCount++;
                System.out.println("Korrekt! " + correctCount + " rätt av " + asked + " ord.");
            }
            else if (result == AnswerResult.ALMOST)
            {
                String correct = String.join(", ", item.getEnglishTranslations());
                System.out.println("Nästan rätt. Korrekt svar är " + correct + ".");
            }
            else if (result == AnswerResult.WRONG)
            {
                String correctWrong = String.join(", ", item.getEnglishTranslations());
                System.out.println("Fel. Korrekt svar är " + correctWrong + ".");
            }

            System.out.println();
        }

        System.out.println("Du svarade på totalt " + asked + " glosor och hade " + correctCount + " rätt. Välkommen åter!");
    }


}

