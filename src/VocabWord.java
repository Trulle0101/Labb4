import java.util.List;

public class VocabWord
{
    private final String swedishWord;
    private final List<String> englishTranslations;

    public VocabWord(String swedishWord, List<String> englishTranslations)
    {
        this.swedishWord = swedishWord;
        this.englishTranslations = englishTranslations;
    }

    public String getSwedishWord()
    {
        return swedishWord;
    }

    public List<String> getEnglishTranslations()
    {
        return englishTranslations;
    }

}
