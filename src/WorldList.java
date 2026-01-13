import java.util.ArrayList;
import java.util.List;


public class WorldList
{
    private List<VocabWord> list = new ArrayList<>();
    public WorldList()
    {
        createDefaultVocabulary();
    }
    /**
     * Skapar och returnerar en standardlista med svenska och engelska glosor.
     *
     * @return en {@link List} med {@link VocabWord}-objekt
     */
    private void createDefaultVocabulary() {

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

    }

    public List<VocabWord> getList() {
        return list;
    }
}
