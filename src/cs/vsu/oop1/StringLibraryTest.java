package cs.vsu.oop1;

import cs.vsu.oop1.StringLibrary;

import java.util.List;

public class StringLibraryTest {
    public static void main(String[] args) {
        // Тесты для split
        StringLibrary lib = new StringLibrary("apple,banana,orange");
        List<String> splitResult = lib.split(",");
        System.out.println(splitResult.equals(List.of("apple", "banana", "orange"))); // true

        // Тесты для join
        String joinedResult = StringLibrary.join(List.of("apple", "banana", "orange"), ";");
        System.out.println(joinedResult.equals("apple;banana;orange")); // true

        // Тесты для replace
        String replaceResult = lib.replace("banana", "grape");
        System.out.println(replaceResult.equals("apple,grape,orange")); // true

        // Тесты для equalsIgnoreCase
        boolean equalsIgnoreCaseResult = lib.equalsIgnoreCase("APPLE,BANANA,ORANGE");
        System.out.println(equalsIgnoreCaseResult); // true

        // Тесты для indexOf
        int indexOfResult = lib.indexOf("banana");
        System.out.println(indexOfResult == 6); // true

        // Тесты для format
        String formatResult = StringLibrary.format("Hello, %s! You have %d messages.", "Alice", 5);
        System.out.println(formatResult.equals("Hello, Alice! You have 5 messages.")); // true
    }
}
