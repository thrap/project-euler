package problems;

import utils.Rational;

import java.util.HashSet;
import java.util.Set;

public class Problem155 {

	public static void main(String[] args) {
		int n = 18;
        Set<Rational>[] subunits = new HashSet[n+1];
        for(int i = 0; i<subunits.length; i++) {
            subunits[i] = new HashSet<Rational>();
        }

        subunits[1].add(new Rational(60,1));

        for(int i = 2; i < subunits.length; i++) {
            System.out.println(i);
            for(int a = 1; a < i && i-a >= a; a++) {
                int b = i-a;
                for(Rational sub1 : subunits[a]) {
                    for (Rational sub2 : subunits[b]) {
                        subunits[i].add((sub1.multiply(sub2)).divide(sub1.add(sub2)));
                        subunits[i].add(sub1.add(sub2));
                    }
                }
            }
        }

        Set<Rational> values = new HashSet<Rational>();
        for(int i = 0; i<subunits.length; i++) {
            values.addAll(subunits[i]);
        }

        System.out.println(values.size());
    }

}
