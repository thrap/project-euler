package problems.problem237;

public enum Cell {
    A(" | ",
            " | "),

    B("_ _",
            "   "),

    C("_| ",
            "   "),

    D(" |_",
            "   "),

    E("_  ",
            " | "),

    F("  _",
            " | ");

    public String[] draw;
    Cell(String... draw) {
        this.draw = draw;
    }

    public boolean fitsAbove(Cell o) {
        return this.draw[1].charAt(1) == o.draw[0].charAt(1);
    }

    public boolean fitsBelow(Cell o) {
        return o.fitsAbove(this);
    }
}
