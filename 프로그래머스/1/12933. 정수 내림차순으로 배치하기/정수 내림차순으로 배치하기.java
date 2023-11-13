import java.util.*;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class Solution {
    public long solution(long n) {
        char[] charArray = Long.toString(n).toCharArray();
        Arrays.sort(charArray);
        return Long.parseLong(new StringBuilder(new String(charArray)).reverse().toString());
    }
}