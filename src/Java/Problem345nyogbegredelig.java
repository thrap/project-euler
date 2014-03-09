package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem345nyogbegredelig {
//	static final int [][] MATRIX = {
//			  {  7,  53, 183, 439, 863},
//			  {497, 383, 563,  79, 973},
//			  {287,  63, 343, 169, 583},
//			  {627, 343, 773, 959, 943},
//			  {767, 473, 103, 699, 303}};
	static final int [][] MATRIX = {
		{007,053,183,439,863,497,383,563, 79,973,287,063,343,169,583},
		{627,343,773,959,943,767,473,103,699,303,957,703,583,639,913},
		{447,283,463, 29,023,487,463,993,119,883,327,493,423,159,743},
		{217,623,003,399,853,407,103,983, 89,463,290,516,212,462,350},
		{960,376,682,962,300,780,486,502,912,800,250,346,172,812,350},
		{870,456,192,162,593,473,915,045,989,873,823,965,425,329,803},
		{973,965,905,919,133,673,665,235,509,613,673,815,165,992,326},
		{322,148,972,962,286,255,941,541,265,323,925,281,601, 95,973},
		{445,721,011,525,473,065,511,164,138,672, 18,428,154,448,848},
		{414,456,310,312,798,104,566,520,302,248,694,976,430,392,198},
		{184,829,373,181,631,101,969,613,840,740,778,458,284,760,390},
		{821,461,843,513,017,901,711,993,293,157,274, 94,192,156,574},
		{034,124,004,878,450,476,712,914,838,669,875,299,823,329,699},
		{815,559,813,459,522,788,168,586,966,232,308,833,251,631,107},
		{813,883,451,509,615,077,281,613,459,205,380,274,302,035,805},
	};
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Set<Integer> columns = new TreeSet<Integer>();
		Set<Integer> rows = new TreeSet<Integer>();
		for (int i = 0; i < MATRIX.length; i++) {
			columns.add(i);
			rows.add(i);
		}
		long max = 0;
		for (Integer row : rows) {
			for (Integer column : columns) {
				System.out.println(column);
				Set<Integer> newColumns = newSetWithout(columns, column);
				Set<Integer> newRows = newSetWithout(rows, row);
				max = Math.max(max, biggest(newColumns, newRows) + MATRIX[row][column]);
			}
		}
		System.out.println(max + " ("+(System.currentTimeMillis()-start)+"ms)");
		System.out.println(memoize.size());
	}
	
	static Map<String, Long> memoize = new HashMap<String, Long>();
	
	public static long biggest(Set<Integer> columns, Set<Integer> rows) {
		String memo = columns.toString() + " " + rows.toString();
		if (columns.size() == 10) {
			System.out.print(10+" ");
		} else if (columns.size() > 10) {
			System.out.println(columns.size());
		}
		if (memoize.containsKey(memo))
			return memoize.get(memo);
		
		long max = 0;
		for (Integer row : rows) {
			for (Integer column : columns) {
				if (MATRIX[row][column] <= 500)
					continue;
				Set<Integer> newColumns = newSetWithout(columns, column);
				Set<Integer> newRows = newSetWithout(rows, row);
				max = Math.max(max, biggest(newColumns, newRows) + MATRIX[row][column]);
			}
		}
		memoize.put(memo, max);
		
		return max;
	}
	
	public static Set<Integer> newSetWithout(Set<Integer> set, Integer remove) {
		Set<Integer> newSet = new TreeSet<Integer>(set);
		newSet.remove(remove);
		return newSet;
	}
}
