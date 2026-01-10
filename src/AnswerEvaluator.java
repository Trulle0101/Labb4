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

}

