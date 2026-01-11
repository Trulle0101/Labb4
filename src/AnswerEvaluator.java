import java.util.Locale;

public class AnswerEvaluator
{

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

