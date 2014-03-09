package Java.problem237;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnGenerator {
    public Map<String, List<Column>> getColumns() {
        List<Column> starts = new ArrayList<Column>();
        List<Column> middles = new ArrayList<Column>();
        List<Column> ends = new ArrayList<Column>();
        int endId = -1;
        int id = 0;
        for(Cell a : Cell.values()) {
            if (!a.fitsBelow(Cell.B))
                continue;
            for(Cell b : Cell.values()) {
                if (!b.fitsBelow(a))
                    continue;
                for(Cell c : Cell.values()) {
                    if (!c.fitsBelow(b))
                        continue;
                    for(Cell d : Cell.values()) {
                        if (!d.fitsBelow(c) || !d.fitsAbove(Cell.B))
                            continue;
                        if ((a == Cell.F && b == Cell.D && c == Cell.E && d == Cell.C) || (a == Cell.E && b == Cell.C && c == Cell.F && d == Cell.D))
                            continue; // Special case

                        Column col = new Column(new Cell[] {a, b, c, d}, id);
                        int right = col.rightCount();
                        int left = col.leftCount();
                        if ((left == 2 || left == 4) && (right == 2 || right == 4)) {
                            middles.add(col);
                            id++;
                        }
                        if (right == 0) {
                            ends.add(new Column(new Cell[]{a, b, c, d}, endId--));
                        }
                        if (left == 2 && (right == 2 || right == 4) && a.draw[0].charAt(0) == '_' && d.draw[0].charAt(0) == '_') {
                            starts.add(col);
                        }
                    }
                }
            }
        }

        Map<String, List<Column>> result = new HashMap<String, List<Column>>();
        result.put("starts", starts);
        result.put("middles", middles);
        result.put("ends", ends);
        return result;
    }
}
