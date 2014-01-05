package problems;

import problems.problem237.Column;
import problems.problem237.ColumnGenerator;
import utils.T;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem237 {


    private static class Board {
        private Column left;
        private Column right;
        private final int length;
        long count;

        public Board(Column column) {
            this.count = 1;
            this.length = 0;
            this.left = column;
            this.right = column;
        }

        public Board(Board left, Board right) {
            this.count = (left.count*right.count) % MOD;
            this.length = left.length +right.length;
            this.left = (left.left.ID == 0 ? right.left : left.left);
            this.right = (right.right.ID == 0 ? left.right : right.right);
        }

        public boolean fitsRigthOf(Board left) {
            return this.left.fitsRightOf(left.right);
        }

        @Override
        public boolean equals(Object o) {
            Board other = (Board)o;
            return other.left == this.left && other.right == this.right && this.length == other.length;
        }
    }

    private static Map<String, List<Column>> columns = new ColumnGenerator().getColumns();
    private static long MOD = (long)Math.pow(10, 8);

    public static void main(String[] args) {
        T t = new T();
        System.out.println(T((long)Math.pow(10, 12)) + " "+t);
    }

    private static long T(long n) {
        List<Board> boards = getBoards(n);

        long sum = 0;
        for (Column start : columns.get("starts")) {
            for(Board middle : boards) {
                if (!middle.fitsRigthOf(new Board(start)))
                    continue;
                for (Column end : columns.get("ends")) {
                    if (new Board(end).fitsRigthOf(middle)) {
                        sum += middle.count;
                    }
                }
            }
        }
        return sum % MOD;
    }

    private static List<Board> getBoards(long n) {
        List<Board>[] powBoards = getPowBoards(n);

        List<Board> boards = new ArrayList<Board>(powBoards[0]);

        long columnsLeft = n-3;
        for(int exp = powBoards.length; exp >= 0; exp--) {
            double pow = Math.pow(2, exp);
            if (pow <= columnsLeft) {
                boards = extendBoards(boards, powBoards[exp]);
                columnsLeft -= pow;
            }
        }
        return boards;
    }

    private static List<Board>[] getPowBoards(long n) {
        List<Board>[] powBoards = new ArrayList[(int)(Math.log(n)/Math.log(2))+1];
        powBoards[0] = new ArrayList<Board>();
        for(Column a : columns.get("middles")) {
            powBoards[0].add(new Board(a));
        }

        for (int i = 1; i < powBoards.length; i++) {
            powBoards[i] = extendBoards(powBoards[i-1], powBoards[i-1]);
        }
        return powBoards;
    }

    private static List<Board> extendBoards(List<Board> lefts, List<Board> rights) {
        List<Board> result = new ArrayList<Board>();
        for (Board left : lefts) {
            for (Board right : rights) {
                if (right.fitsRigthOf(left)) {
                    Board board = new Board(left, right);
                    boolean added = false;
                    for(Board savedBoard : result) {
                        if (savedBoard.equals(board)) {
                            savedBoard.count += board.count;
                            added = true;
                            break;
                        }
                    }
                    if (!added)
                        result.add(board);
                }
            }
        }
        return result;
    }
}
