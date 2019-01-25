import fileReder.FileReader;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        List<String> aliceAdventures = reader.asStream("alice.txt")
                .map(String::toLowerCase)
                .map(App::cleanText)
                .collect(Collectors.toList());

        Long wordCount = aliceAdventures.stream()
                .map(e -> e.split(" "))
                .flatMap(Stream::of)
                .filter(e -> !e.isEmpty())
                .count();
        System.out.println(wordCount);


        Long distinctWords = aliceAdventures.stream()
                .map(e -> e.split(" "))
                .flatMap(Stream::of)
                .filter(e -> !e.isEmpty())
                .distinct()
                .count();
        System.out.println(distinctWords);


         String  mostAppearingWord = aliceAdventures.stream()
                .map(e -> e.split(" "))
                .flatMap(Stream::of)
              .filter(e -> !" ".equals(e))
                 .filter(e -> !e.isEmpty())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(e -> e.getKey() + " | " + e.getValue() + "\n")
                .limit(5)
                .collect(Collectors.joining());
        System.out.println(mostAppearingWord);


         String  mostAppearingLetter = aliceAdventures.stream()
                .map(e -> e.split(" "))
                .flatMap(Stream::of)
                .filter(e -> !e.equals(" "))
                .map(e -> e.split(""))
                .flatMap(Stream::of)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(e -> e.getKey() + " | " + e.getValue() + "\n")
                .limit(5)
                .collect(Collectors.joining());
        System.out.println(mostAppearingLetter);


    }

    public static String cleanText(String text) {
        text = text.replaceAll(",", " ");
        text = text.replaceAll(";", " ");
        text = text.replaceAll("’s", " ");
        text = text.replaceAll("’", " ");
        text = text.replaceAll("‘", " ");
        text = text.replaceAll(":", " ");
        text = text.replaceAll("#", " ");
        text = text.replaceAll("/", " ");
        text = text.replaceAll("-", " ");
        text = text.replaceAll("\\.", " ");
        text = text.replaceAll("\\*", " ");
        text = text.replaceAll("\\(", " ");
        text = text.replaceAll("\\)", " ");
        text = text.replaceAll("\\[", " ");
        text = text.replaceAll("]", " ");


        return text;
    }
}







