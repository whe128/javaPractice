package C03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Boggle {
    final static int SIZE = 4;
    final static String[] DICE = {"AJBBOO","AFFPSK","ANEAGE","APSHCO","QNUMHI","ZNHRLN","TDSTYI","TTWOOA","TLRYET","TUMIOC","EDVLRY","EDRLXI","EEGNHW","EIOTSS","ERHTWV","EENUSI"};
    public static final Set<String> dictionary = new HashSet<>();
    final SearchNode[][] nodeArray = new SearchNode[SIZE][SIZE];
    public ArrayList<String> wordList;

    private static class SearchNode{
        char character;
        int row;
        int col;
        boolean visited;
        ArrayList<Location> neighbourList = new ArrayList<>();

        private static class Location{
            int row;
            int col;
            public Location(int row, int col){
                this.row = row;
                this.col = col;
            }
        }

        SearchNode(int row,int col , char ch){
            this.row = row;
            this.col = col;
            this.character = ch;
            visited = false;


            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (row + j < 0 || col + i < 0) {
                        continue;
                    }
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    neighbourList.add(new Location(row+j,col+i));
                }
            }
        }

        @Override
        public boolean equals(Object obj) {
            SearchNode o = (SearchNode) obj;
            return (row==o.row &&col==o.col);
        }

        @Override
        public String toString() {
            return "["+row+", "+col+"]";
        }
    }

    public Boggle(){
        try{
            //new Scanner(new File(Path))
            //new Scanner(System.in)
            Scanner scanner = new Scanner(new File("Practise/resources/words/dictionary.txt"));
            while(scanner.hasNext()){
                String word = scanner.nextLine();
                if(word.length()>=3){
                    dictionary.add(word.toUpperCase());
                }
            }
            System.out.println("Found " + dictionary.size() + " words in our dictionary");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        shake();
    }

    public void shake(){
        Random random = new Random();
        ArrayList<String> diceList = new ArrayList<>(Arrays.stream(DICE).toList()) ;
        for(int i=0;i<SIZE;i++){
            String str = diceList.remove(random.nextInt(diceList.size()));
            for(int j=0;j<SIZE;j++){
                nodeArray[i][j]=new SearchNode(i,j,str.charAt(random.nextInt(str.length())));
            }
        }
        //use the fixed element
        if(true){
            String[] strings = {"XTLM","EROE","HTAI","NPTT"};
            for(int i=0;i<SIZE;i++){
                for(int j=0;j<SIZE;j++){
                    nodeArray[i][j]=new SearchNode(i,j,strings[i].charAt(j));
                }
            }
        }
    }

    public void findWordUseDFS(HashSet<String> wordSet, SearchNode node,StringBuilder singleWord){

        //if exist word, we can add it into the wordlist
        String currentWord = singleWord.toString();
        if(dictionary.contains(currentWord)){
            wordSet.add(currentWord);
        }


        for(SearchNode.Location location: node.neighbourList){
            int row = location.row;
            int col = location.col;
            if(row<0 || row>=SIZE || col<0 || col>=SIZE){
                continue;
            }

            SearchNode neighbourNode = nodeArray[row][col];
            if(neighbourNode.visited){
                continue;
            }
            neighbourNode.visited=true;
            singleWord.append(neighbourNode.character);
            findWordUseDFS(wordSet,neighbourNode,singleWord);
            singleWord.deleteCharAt(singleWord.length()-1);
            neighbourNode.visited=false;
        }
    }

    public void findWords(){
        //store the word--why use set, it can avoid the repeat
        HashSet<String> wordSet = new HashSet<>();
        StringBuilder singleWord = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                SearchNode node = nodeArray[row][col];
                node.visited = true;
                singleWord.append(node.character);
                findWordUseDFS(wordSet,node,singleWord);
                singleWord.setLength(singleWord.length()-1);
                node.visited = false;
            }
        }

        wordList = new ArrayList<>(wordSet);
        wordList.sort(null);
    }

    public static void main(String[] args) {
        Boggle boggle = new Boggle();
        boggle.shake();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(boggle.nodeArray[i][j].character+ " ");
            }
            System.out.println();
        }
        System.out.println();
        long startTime = System.nanoTime();
        boggle.findWords();
        System.out.println("process time = "+ (System.nanoTime()-startTime)*1e-9);

        System.out.println(boggle.wordList.size() + " " +boggle.wordList);
    }
}
