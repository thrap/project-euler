package Java.problem237;

public class Column {
    public Cell[] column;
    public final int ID;

    public Column(Cell[] column, int id) {
        this.column = column;
        this.ID = id;
    }

    public int leftCount() {
        int count = 0;
        for(Cell c : column) {
            if (c.draw[0].charAt(0) == '_')
                count++;
        }
        return count;
    }

    public int rightCount() {
        int count = 0;
        for(Cell c : column) {
            if (c.draw[0].charAt(2) == '_')
                count++;
        }
        return count;
    }

    public boolean fitsRightOf(Column left) {
        for(int i = 0; i < 4; i++) {
            if (column[i].draw[0].charAt(0) != left.column[i].draw[0].charAt(2))
                return false;
        }


        Column right = this;
        if (left.ID == 2) {
            return right.ID != 1 && right.ID != 8 && right.ID != -2;
        } else if (left.ID == 6) {
            return right.ID != 4;
        } else if (left.ID == 14) {
            return right.ID != 1 && right.ID != 8 && right.ID != -2;
        }
        return true;
    }
}
