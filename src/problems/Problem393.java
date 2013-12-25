package problems;

import utils.T;

import java.util.*;

public class Problem393 {

    static final int NORTH = 0;
    static final int SOUTH = 1;
    static final int WEST = 2;
    static final int EAST = 3;

    private static enum Way {
        NORTH(0,-1), SOUTH(0,1), WEST(-1,0), EAST(1,0);

        int x,y;
        Way(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Way getOposite() {
            switch (this) {
            case NORTH: return SOUTH;
            case SOUTH: return NORTH;
            case WEST: return EAST;
            case EAST: return WEST;
            default: throw new RuntimeException("Should only be 4 ways");
            }
        }
    }

    static int n = 4;

    public static void main(String[] args) {
        T t = new T();
        Set<Way>[][] ants = new Set[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                Set<Way> ant = new HashSet<Way>();
                ants[x][y] = ant;
                if (y != 0)
                    ant.add(Way.NORTH);
                if (y != n-1)
                    ant.add(Way.SOUTH);
                if (x != 0)
                    ant.add(Way.WEST);
                if (x != n-1)
                    ant.add(Way.EAST);
            }
        }

        recurse(ants, new boolean[n][n], 0);

        System.out.println(f + " " +t);
    }

    static int f = 0;

    private static void recurse(Set<Way>[][] ants, boolean[][] hasMoved, int count) {
        if (count == n*n) {
            f++;
            if (n == 4 || f % 10000 == 0) {
                System.out.println(f);
                printAnts(ants);
            }
            return;
        }
        int leastX = -1;
        int leastY = -1;
        int moves = Integer.MAX_VALUE;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!hasMoved[x][y] && ants[x][y].size() < moves) {
                    moves = ants[x][y].size();
                    leastX = x;
                    leastY = y;
                }
            }
        }

        for(Way way : ants[leastX][leastY]) {
            move(leastX, leastY, way, deepCopy(ants), deepCopy(hasMoved), count);
        }
    }

    private static void printAnts(Set<Way>[][] ants) {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                System.out.print(ants[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void move(int x, int y, Way way, Set<Way>[][] ants, boolean[][] hasMoved, int count) {
        hasMoved[x][y] = true;
        Set<Way> target = ants[x+way.x][y+way.y];
        target.remove(way.getOposite());
        for(Way targetWay : Way.values()) {
            int dx = way.x+targetWay.x;
            int dy = way.y+targetWay.y;
            if (x + dx >= 0 && x + dx < n && y+dy >= 0 && y+dy < n)
                ants[x+dx][y+dy].remove(targetWay.getOposite());
        }

        ants[x][y] = new HashSet<Way>(Arrays.asList(way));

        recurse(ants, hasMoved, count+1);
    }

    private static Set<Way>[][] deepCopy(Set<Way>[][] arr) {
        Set<Way>[][] copy = new Set[n][n];
        for(int i = 0; i<n; i++)
           for(int j = 0; j<n; j++)
               copy[i][j] = new HashSet<Way>(arr[i][j]);
        return copy;
    }

    private static boolean[][] deepCopy(boolean[][] arr) {
        boolean[][] copy = new boolean[n][n];
        for(int i = 0; i<n; i++)
           for(int j = 0; j<n; j++)
               copy[i][j] = arr[i][j];
        return copy;
    }
}
