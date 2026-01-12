import java.util.List;

/**
 * Klassen {@code VocabWord} representerar ett glosord i programmet.
 * <p>
 * Glosord består av ett svenskt ord och engelsk översättning.
 */
public class VocabWord
{
    /** Det svenska ordet. */
    private final String swedishWord;
    /** Lista med engelsk översättning till de svenska orden. */
    private final List<String> englishTranslations;

    /**
     * Skapar ett nytt {@code VocabWord}-objekt.
     *
     * @param swedishWord det svenska ordet
     * @param englishTranslations en lista med engelska översättningar.
     */
    public VocabWord(String swedishWord, List<String> englishTranslations)
    {
        this.swedishWord = swedishWord;
        this.englishTranslations = englishTranslations;
    }

    /**
     * Returnerar det svenska ordet.
     *
     * @return det svenska ordet.
     */
    public String getSwedishWord()
    {
        return swedishWord;
    }

    /**
     * Returnerar en lista med engelska översättningar.
     *
     * @return en lista med engelska översättningar.
     */
    public List<String> getEnglishTranslations()
    {
        return englishTranslations;
    }

}
