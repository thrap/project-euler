package problems;

import utils.T;

import java.util.*;

public class Problem393 {

    private static enum Way {
        NORTH(0,-1), SOUTH(0,1), WEST(-1,0), EAST(1,0);

        int dx, dy;
        Way(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
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

    static int n = 8;

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

    /**
     * Er mulig å gjøre noe memoisering på et eller annet vis her as breh
     */
    private static long recurse(Set<Way>[][] ants, boolean[][] hasMoved, int depth) {
        if (depth == n*n) {
            f++;
            if (n == 4 || f % 10000 == 0) {
                System.out.println(f);
                printAnts(ants);
            }
            return 1;
        }
        int leastX = -1;
        int leastY = -1;
        int minMoves = Integer.MAX_VALUE;


        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!hasMoved[x][y] && (ants[x][y].size() < minMoves || (ants[x][y].size() == minMoves && x != 0 && y != 0 && y != n-1 && x != n-1))) {
                    minMoves = ants[x][y].size();
                    leastX = x;
                    leastY = y;
                }
            }
        }

        long count = 0;
        boolean[][] newMoved = deepCopy(hasMoved);
        newMoved[leastX][leastY] = true;

        for(Way way : ants[leastX][leastY]) {
            count += move(leastX, leastY, way, deepCopy(ants), newMoved, depth);
        }
        return count;
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

    private static long move(int x, int y, Way way, Set<Way>[][] ants, boolean[][] hasMoved, int count) {
        ants[x+way.dx][y+way.dy].remove(way.getOposite());

        for(Way targetWay : Way.values()) {
            int dx = way.dx +targetWay.dx;
            int dy = way.dy +targetWay.dy;
            if (x + dx >= 0 && x + dx < n && y+dy >= 0 && y+dy < n)
                ants[x+dx][y+dy].remove(targetWay.getOposite());
        }

        ants[x][y] = new HashSet<Way>(Arrays.asList(way));

        return recurse(ants, hasMoved, count+1);
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
            copy[i] = Arrays.copyOf(arr[i], n);
        return copy;
    }
}
