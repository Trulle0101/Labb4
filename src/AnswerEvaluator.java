import java.util.Locale;

/**
 * Klassen {@code AnswerEvaluator} ansvarar för att utvärdera
 * användarens svar i glosövningsprogrammet.
 * <p>
 * Klassen innehåller endast statiska metoder och används därför
 * som en hjälpklass.
 */
public class AnswerEvaluator
{

    /**
     * Utvärderar användarens inmatning av ett givet glosord.
     * <p>
     * Metoden kontrollerar om användaren:
     * <ul>
     *   <li>vill avsluta programmet, genom att skriva ({@code Q})</li>
     *   <li>har skrivit ett korrekt svar</li>
     *   <li>har skrivit ett nästan korrekt svar</li>
     *   <li> eller har skrivit ett felaktigt svar.</li>
     * </ul>
     *
     * @param userInput användarens inmatade svar
     * @param item glosordet som svaret jämförs mot
     * @return ett {@link AnswerResult} som beskriver resultatet av utvärderingen
     */
    public static AnswerResult evaluate(String userInput, VocabWord item)
    {
        if (userInput == null)
        {
            return AnswerResult.WRONG;
        }

        String trimmed = userInput.trim();

        if (trimmed.equalsIgnoreCase("Q"))
        {
            return AnswerResult.QUIT;
        }

        if (trimmed.isEmpty())
        {
            return AnswerResult.WRONG;
        }

        for (String correct : item.getEnglishTranslations())
        {
            if (trimmed.equalsIgnoreCase(correct))
            {
                return AnswerResult.CORRECT;
            }
        }

        for (String correct : item.getEnglishTranslations())
        {
            double ratio = letterMatchRatio(correct, trimmed);
            if (ratio > 0.5)
            {
                return AnswerResult.ALMOST;
            }
        }

        return AnswerResult.WRONG;

    }

    /**
     * Beräknar hur stor andel av bokstäverna som matchar mellan
     * det korrekta ordet och användarens svar.
     * <p>
     * Jämförelsen sker tecken för tecken
     * från början av orden.
     *
     * @param correct det korrekta engelska ordet
     * @param user användarens inmatade svar
     * @return ett värde mellan {@code 0.0} och {@code 1.0} som anger matchningsgrad.
     */
    private static double letterMatchRatio(String correct, String user) {
        String c = correct.toLowerCase(Locale.ROOT);
        String u = user.toLowerCase(Locale.ROOT);

        int maxLength = Math.max(c.length(), u.length());
        int minLength = Math.min(c.length(), u.length());

        if (maxLength == 0) {
            return 0.0;
        }

        int matches = 0;
        for (int i = 0; i < minLength; i++) {
            if (c.charAt(i) == u.charAt(i)) {
                matches++;
            }
        }

        return (double) matches / maxLength;
    }

}

