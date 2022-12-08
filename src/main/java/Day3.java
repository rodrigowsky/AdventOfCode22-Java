import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Day3 {

    public static void main(String[] args) {

        HashMap<Character, Integer> itemsPriority = new HashMap<Character, Integer>();
        populateHashMap(itemsPriority);
        List<String> data = readFileInList("src\\main\\resources\\input3.txt");

        System.out.println(priorityBadgeCalculation(itemsPriority,data));
    }

    public static Integer priorityBadgeCalculation(HashMap<Character, Integer> priorityMap, List<String> dataInput) {

        Integer sum = 0;
        for (int i = 0; i < dataInput.size(); i = i + 3) {

            List<Character> list1 = convertStringToCharList(dataInput.get(i));
            List<Character> list2 = convertStringToCharList(dataInput.get(i + 1));
            List<Character> list3 = convertStringToCharList(dataInput.get(i + 2));


            ArrayList retain = list1.stream().filter(list2::contains).filter(list3::contains).collect(Collectors.toCollection(ArrayList::new));
            sum += priorityMap.get(retain.get(0));
        }
        return sum;
    }

    public static List<Character>  convertStringToCharList(String str)
    {

        // Create an empty List of character
        List<Character> chars = new ArrayList<>();

        // For each character in the String
        // add it to the List
        for (char ch : str.toCharArray()) {

            chars.add(ch);
        }

        // return the List
        return chars;
    }


    public static Integer priorityCalculation(HashMap<Character, Integer> priorityMap, List<String> dataInput) {
        String startHalf = null;
        String finalHalf = null;
        Integer sum = 0;
        for (int i = 0; i < dataInput.size(); i++) {


            startHalf = dataInput.get(i).substring(0, (dataInput.get(i).length() / 2));
            finalHalf = dataInput.get(i).substring(dataInput.get(i).length() / 2);

            Set<Character> listUnique= new HashSet<Character>();
            for (int x = 0; x < startHalf.length(); x++) {
                for (int b = 0; b < finalHalf.length(); b++) {
                    if (startHalf.charAt(x) == finalHalf.charAt(b)) {
                        listUnique.add(startHalf.charAt(x));
                    }

                }
            }

            for (Character ch:listUnique) {
                sum += priorityMap.get(ch);
            }

        }
        return sum;
    }


    public static void populateHashMap(HashMap<Character, Integer> rusakPriorities){

        char[] alphabetLower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetUpper = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        for (int i = 0; i < alphabetLower.length; i++) {
            rusakPriorities.put(alphabetLower[i],i + 1);
        }
        for (int i = 0; i < alphabetUpper.length; i++) {
            rusakPriorities.put(alphabetUpper[i],27 + i);
        }

    }

    public static List<String> readFileInList(String fileName)
    {
        List<String> lines = Collections.emptyList();
        try
        {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            // do something
            e.printStackTrace();
        }
        return lines;
    }
}
