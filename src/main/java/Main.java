import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(twoStrings("hi", "world"));
    }

    static String twoStrings(String s1, String s2) {
        Set<Integer> s1s = s1.chars().boxed().collect(Collectors.toSet());
        Set<Integer> s2s = s2.chars().boxed().collect(Collectors.toSet());
        s1s.retainAll(s2s);
        return !s1s.isEmpty()? "YES" : "NO";
    }
}
