package my;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boggle {
    static int sizeRow = 8;
    static int sizeCol = 8;
    static List<List<Integer>> neighbours = new ArrayList<>();

    static {
        for (int Y= 0; Y < sizeCol  ; Y++) {
            for (int X = 0;X<sizeRow;X++){
                var neighs = new ArrayList<Integer>();
                //8 squares
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int x = X + i;
                        var y = Y + j;
                        if (i*j==0 && i+j!=0 && x >= 0 && x < sizeCol && y >= 0 && y < sizeRow) { // on the board
                            int neighbour = y * sizeCol + x;
                            neighs.add(neighbour);
                        }
                    }
                }
                //in one dimension store their neighbours
                neighbours.add(neighs);
            }
        }
    }

    public static void findWordsHelper(int node, Set<Integer> visited) {
        visited.add(node);
        for (var neighbour : neighbours.get(node)) {
            //System.out.println(neighbour);
            if (!visited.contains(neighbour)) {
                findWordsHelper(neighbour, visited);
            }
        }
        //when finish, release it
        visited.remove(node);
    }


    public static void main(String[] args) {
        var visited = new HashSet<Integer>();
        findWordsHelper(3,visited);
    }
}
