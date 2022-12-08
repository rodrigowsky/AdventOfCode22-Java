import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Day2 {
    public static void main(String[]args) throws Exception {
        List<String> data = readFileInList("src\\main\\resources\\input2.txt");
        System.out.println(findFinalScore(data));
        System.out.println(chooseFinalOutcome(data));

    }

    public static Integer chooseFinalOutcome(List<String> handsStrategy) {
        Integer sum = 0;

        for (String handRound : handsStrategy) {
            String oppHand = String.valueOf(handRound.charAt(0));
            String myHand = String.valueOf(handRound.charAt(2));
            Integer handScore = 0;
            Integer matchScore = 0;

            if(oppHand.equals("A")){
                switch (myHand) {
                    case "X":
                        matchScore = 0;
                        handScore = 3;
                        break;
                    case "Y":
                        matchScore = 3;
                        handScore = 1;
                        break;
                    case "Z":
                        matchScore = 6;
                        handScore = 2;
                        break;
                }
            }

            if(oppHand.equals("B")){
                switch (myHand) {
                    case "X":
                        matchScore = 0;
                        handScore = 1;
                        break;
                    case "Y":
                        matchScore = 3;
                        handScore = 2;
                        break;
                    case "Z":
                        matchScore = 6;
                        handScore = 3;
                        break;
                }
            }

            if(oppHand.equals("C")){
                switch (myHand) {
                    case "X":
                        matchScore = 0;
                        handScore = 2;
                        break;
                    case "Y":
                        matchScore = 3;
                        handScore = 3;
                        break;
                    case "Z":
                        matchScore = 6;
                        handScore = 1;
                        break;
                }
            }


            sum += matchScore + handScore;

        }

        return sum;
    }

    public static Integer findFinalScore(List<String> handsStrategy) {
        Integer sum = 0;

        for (String handRound : handsStrategy) {
            String oppHand = String.valueOf(handRound.charAt(0));
            String myHand = String.valueOf(handRound.charAt(2));
            Integer handScore = 0;
            Integer matchScore = 0;

            if(oppHand.equals("A")){
                switch (myHand) {
                    case "X":
                        matchScore = 3;
                        handScore = 1;
                        break;
                    case "Y":
                        matchScore = 6;
                        handScore = 2;
                        break;
                    case "Z":
                        matchScore = 0;
                        handScore = 3;
                        break;
                }
            }

            if(oppHand.equals("B")){
                switch (myHand) {
                    case "X":
                        matchScore = 0;
                        handScore = 1;
                        break;
                    case "Y":
                        matchScore = 3;
                        handScore = 2;
                        break;
                    case "Z":
                        matchScore = 6;
                        handScore = 3;
                        break;
                }
            }

            if(oppHand.equals("C")){
                switch (myHand) {
                    case "X":
                        matchScore = 6;
                        handScore = 1;
                        break;
                    case "Y":
                        matchScore = 0;
                        handScore = 2;
                        break;
                    case "Z":
                        matchScore = 3;
                        handScore = 3;
                        break;
                }
            }


            sum += matchScore + handScore;

        }

        return sum;
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

