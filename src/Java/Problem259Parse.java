package Java;

import utils.BigRational;
import utils.Rational;
import utils.T;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem259Parse {
    private static final int NUMBERS = 9;
    private static class ListGenerator {
        private List<String> list = new ArrayList<>();

        public List<List<Integer>> generate() {
            populateList("1", 2);

            Function<String, List<Integer>> stringToIntList = s ->
                    Arrays.asList(s.split(" ")).stream()
                    .map(Integer::parseInt).collect(Collectors.toList());

            return list.stream().map(stringToIntList).collect(Collectors.toList());
        }

        private void populateList(String s, int n) {
            if (n > NUMBERS) {
                list.add(s);
            } else {
                populateList(s + n, n + 1);
                populateList(s+" "+n, n+1);
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        Set<Long> set = new TreeSet<>();
        for (List<Integer> arr : new ListGenerator().generate()) {
            System.out.println(arr);
            set.addAll(new Parser(arr).getReachableNumbers());
        }
        long sum = set.stream().reduce(0L, (a, b) -> a + b);
        System.out.println(sum + " " + t);
    }

    private static class Parser {
        private List<Integer> arr;
        public Parser(List<Integer> arr) {
            this.arr = arr;
        }

        public Set<Long> getReachableNumbers() {
            return parse(0, arr.size()-1).stream()
                    .filter(r -> r.d == 1 && r.n >= 1)
                    .map(r -> r.n).collect(Collectors.toSet());
        }

        public Set<Rational> parse(int start, int end) {
            if (start == end)
                return new HashSet<>(Arrays.asList(new Rational(arr.get(start), 1)));

            Set<Rational> ret = new HashSet<>();

            for (int i = start; i < end; i++) {
                Set<Rational> left = parse(start, i);
                Set<Rational> right = parse(i+1, end);

                for(Rational a : left) {
                    for(Rational b : right) {
                        ret.add(a.add(b));
                        ret.add(a.subtract(b));
                        ret.add(a.multiply(b));
                        ret.add(a.divide(b));
                    }
                }
            }

            return ret;
        }
    }


}
