package cs.vsu.oop1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringLibrary {

    private String value;

    public StringLibrary(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> split(String delimiter) {
        Objects.requireNonNull(delimiter, "Delimiter cannot be null");
        List<String> result = new ArrayList<>();
        for (String part : value.split(delimiter)) {
            result.add(part);
        }
        return result;
    }

    public static String join(List<String> elements, String delimiter) {
        Objects.requireNonNull(elements, "Elements cannot be null");
        Objects.requireNonNull(delimiter, "Delimiter cannot be null");
        return String.join(delimiter, elements);
    }

    public String replace(String target, String replacement) {
        Objects.requireNonNull(target, "Target cannot be null");
        Objects.requireNonNull(replacement, "Replacement cannot be null");
        return value.replace(target, replacement);
    }

    public boolean equalsIgnoreCase(String other) {
        return value.equalsIgnoreCase(other);
    }

    public int indexOf(String substring) {
        Objects.requireNonNull(substring, "Substring cannot be null");
        return value.indexOf(substring);
    }

    public static String format(String format, Object... args) {
        Objects.requireNonNull(format, "Format cannot be null");
        return String.format(format, args);
    }

    @Override
    public String toString() {
        return value;
    }
}