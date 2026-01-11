import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VocabTrainer
{

    private List<VocabWord> vocabWords;
    private Scanner scanner;
    private int maxQuestions = 10;

    public VocabTrainer()
    {
        this.scanner = new Scanner(System.in);
        this.vocabWords = createDefaultVocabulary();
    }

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

    private List<VocabWord> createDefaultVocabulary() {
        List<VocabWord> list = new ArrayList<>();

        list.add(new VocabWord("bil", List.of("car")));
        list.add(new VocabWord("hus", List.of("house")));
        list.add(new VocabWord("springa", List.of("run")));
        list.add(new VocabWord("skola", List.of("school")));
        list.add(new VocabWord("koka", List.of("cook")));
        list.add(new VocabWord("hoppa", List.of("jump")));
        list.add(new VocabWord("simma", List.of("swim")));
        list.add(new VocabWord("dator", List.of("computer")));
        list.add(new VocabWord("väg", List.of("road")));
        list.add(new VocabWord("läsa", List.of("read")));

        return list;
    }
}

