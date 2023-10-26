import java.io.*;
import java.util.*;
public class DFACollapse {
    public static void main(String[] args) throws FileNotFoundException {
        int size = checkSize(); //return # of states
        String[][] dfa = addDFA(size); //return dfa in 2d array
        List<String> pairs = addPair(dfa, size); //return valid pairs into arraylist
        pairs = iteratePairs(dfa, pairs, size);
    }

    public static int checkSize() throws FileNotFoundException {
        Scanner file = new Scanner(new File("dfa.txt"));
        int i = 0;
        while (file.hasNextLine()) {
            i++;
            file.nextLine();
        }
        file.close();
        return i - 1;
    }

    public static String[][] addDFA(int i) throws FileNotFoundException {
        String[][] dfa = new String[3][i];
        Scanner file = new Scanner(new File("dfa.txt"));
        file.nextLine();
        int j = 0;
        while (file.hasNextLine()) {
            dfa[0][j] = file.next();
            dfa[1][j] = file.next();
            dfa[2][j] = file.next();
            j++;
        }
        file.close();
        return dfa;
    }

    public static List<String> addPair(String[][] dfa, int size) {
        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                String x = dfa[0][i] + " " + dfa[0][j];
                if (x.length() == 3 || x.length() == 5) {
                    pairs.add(x);
                }
            }
        }
        return pairs;
    }

    public static List<String> iteratePairs(String[][] dfa, List<String> pairs, int size) {
        int i = 0;
        while (pairs.iterator().hasNext()) {
            String pair = pairs.iterator().next();
            Scanner token = new Scanner(pair);

            i++;
        }
        return pairs;
    }
}
