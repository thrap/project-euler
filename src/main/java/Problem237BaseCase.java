import problem237.Column;
import problem237.ColumnGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Problem237BaseCase {

    public static List<Column> starts = new ArrayList<Column>();
    public static List<Column> middles = new ArrayList<Column>();
    public static List<Column> ends = new ArrayList<Column>();

    public static void main(String[] args) {
        Map<String, List<Column>> lists = new ColumnGenerator().getColumns();
        starts = lists.get("starts");
        middles = lists.get("middles");
        ends = lists.get("ends");
        System.out.println(starts.size() + " " + middles.size() + " " + ends.size());

        for(Column start : starts) {
            addColumn(start, Arrays.asList(start));
        }
    }


    static int count = 0;
    private static void addColumn(Column last, List<Column> columns) {
        if (columns.size() == 9) {
            addBoards(last, columns);
        } else {
            for(Column middle : middles) {
                if (middle.fitsRightOf(last)) {
                    List<Column> newColumns = new ArrayList<Column>(columns);
                    newColumns.add(middle);
                    addColumn((middle.ID == 0 ? last : middle), newColumns);
                }
            }
        }
    }

    private static void addBoards(Column last, List<Column> columns) {
        for(Column end : ends) {
            if (end.fitsRightOf(last)) {
                List<Column> newColumns = new ArrayList<Column>(columns);
                newColumns.add(end);
                print(newColumns);
                System.out.println(++count);
                System.out.println("++++++++++++++");
            }
        }
    }

    private static void print(List<Column> board) {
        for(int j = 0; j < 4; j++) {
            for(int k = 0; k <= 1; k++) {
                for(int i = 0; i < board.size(); i++) {
                    System.out.print(board.get(i).column[j].draw[k]);
                }
                System.out.println();
            }
        }
    }
}
