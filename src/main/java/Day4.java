import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Day4 {
    public static void main(String[] args) {
        List<String> data = readFileInList("src\\main\\resources\\input4.txt");
        System.out.println(equalAssignsmentsSum(data));
        System.out.println(overlapSum(data));
    }

    public static Integer overlapSum(List<String> inputData) {

        Integer max1 = null;
        Integer max2 = null;
        Integer min1 = null;
        Integer min2 = null;
        Integer sum = 0;

        for (String group: inputData
        ) {
            String[] splitComma = group.split(",");
            String[] group1 = splitComma[0].split("-");
            String[] group2 = splitComma[1].split("-");
            max1 = Integer.parseInt(group1[1]);
            max2 = Integer.parseInt(group2[1]);
            min1 = Integer.parseInt(group1[0]);
            min2 = Integer.parseInt(group2[0]);
//            System.out.println(min1 + " - " + max1);
//            System.out.println(min2 + " - " + max2);
//            sum++;
            if(min2 <= max1 && min1 <= max2){
                sum++;
            }

        }

        return sum;
    }

    public static Integer equalAssignsmentsSum(List<String> inputData) {
        Integer max1 = null;
        Integer max2 = null;
        Integer min1 = null;
        Integer min2 = null;
        Integer sum = 0;

        for (String group: inputData
             ) {
            String[] splitComma = group.split(",");
            String[] group1 = splitComma[0].split("-");
            String[] group2 = splitComma[1].split("-");
            max1 = Integer.parseInt(group1[1]);
            max2 = Integer.parseInt(group2[1]);
            min1 = Integer.parseInt(group1[0]);
            min2 = Integer.parseInt(group2[0]);
//            System.out.println(min1 + " - " + max1);
//            System.out.println(min2 + " - " + max2);
//            sum++;
            if(min1 <= min2 && max1 >= max2 || min2 <= min1 && max2 >= max1){
                sum++;
            }

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
