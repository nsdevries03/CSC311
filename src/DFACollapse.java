import java.io.*;
import java.util.*;
public class DFACollapse {
    public static void main(String[] args) throws FileNotFoundException {
        int size = checkSize(); //return # of states
        Map<String, String> dfa = addDFA(); //return dfa in 2d array
        List<String> pairs = addPair(dfa, size); //return valid pairs into arraylist
        pairs = removePairs(dfa, pairs, size);
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

    public static Map<String, String> addDFA() throws FileNotFoundException {
        Map<String, String> dfa = new HashMap<>();
        Scanner file = new Scanner(new File("dfa.txt"));
        file.nextLine();
        int j = 0;
        while (file.hasNextLine()) {
            String x = file.next();
            dfa.put(Integer.toString(j), x);
            dfa.put(Integer.toString(j) + "A", file.next());
            dfa.put(Integer.toString(j) + "B", file.next());
            j++;
        }
        file.close();
        return dfa;
    }

    public static List<String> addPair(Map<String, String> dfa, int size) {
        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                String x =  dfa.get(Integer.toString(i)) + " " + dfa.get(Integer.toString(j));
                if (x.length() == 3 || x.length() == 5) {
                    pairs.add(x);
                }
            }
        }
        return pairs;
    }

    public static List<String> removePairs(Map<String, String> dfa, List<String> pairs, int size) {
        Map<String, String> newPairs = new HashMap<>();
        List<String> result = new ArrayList<>();
        while (!pairs.isEmpty()) {
            String pair = pairs.iterator().next();
            Scanner token = new Scanner(pair);
            String x = token.next();
            char y = x.charAt(0);
            String a = dfa.get(Character.toString(y) + "A") + " ";
            String b = dfa.get(Character.toString(y) + "B") + " ";
            x = token.next();
            y = x.charAt(0);
            newPairs.put(pair + "A", a + dfa.get(Character.toString(y) + "A"));
            newPairs.put(pair + "B", b + dfa.get(Character.toString(y) + "B"));

            /*
            if ((newPairs.get(pair + "A").length() == 3 || newPairs.get(pair + "A").length() == 5) &&
                    (newPairs.get(pair + "B").length() == 3 || newPairs.get(pair + "B").length() == 5) &&
                    (newPairs.get(pair + "A").length() == newPairs.get(pair + "B").length()))  {
                result.add(pair);
            }


            for (String z : result) {
                if (result.contains(newPairs.get(z + "A")) && result.contains(newPairs.get(z + "B"))) {
                    result.remove(z);
                }
            }
            */

            pairs.remove(pair);
        }
        return result;
    }
}
