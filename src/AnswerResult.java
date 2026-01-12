
/**
 * Klassen {@code AnswerResult} representerar de möjliga resultat
 * av en utvärdering av användarens svar i glosövningsprogrammet.
 * <p>
 * Klassen fungerar innehåller fördefinierade instanser
 * som beskriver olika typer av svar.
 */
public class AnswerResult
{

    /** Indikerar att användarens svar är helt korrekt. */
    public static final AnswerResult CORRECT = new AnswerResult();
    /** Indikerar att användarens svar är nästan korrekt. */
    public static final AnswerResult ALMOST  = new AnswerResult();
    /** Indikerar att användarens svar är felaktigt. */
    public static final AnswerResult WRONG   = new AnswerResult();
    /** Indikerar att användaren valt att avsluta programmet. */
    public static final AnswerResult QUIT    = new AnswerResult();

}
