import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {



    public static void main(String[]args) throws Exception {
        List<String> data = readFileInList("src\\main\\resources\\input1.txt");
        System.out.println("Most Calories: " + findMaxCalories(data));
        System.out.println("Top 3 Sum: " + findTop3(data));
    }

    public static Integer findMaxCalories(List<String> dataCalories){
            Integer max = 0;
            Integer sum = 0;

            for (String dataCalory : dataCalories) {
                if (dataCalory.isEmpty()) {
                    if(sum > max) {
                        max = sum;
                    }
                    sum = 0;
                    continue;
                }
                sum += Integer.parseInt(dataCalory);
            }

            return max;
        }

    public static Integer findTop3(List<String> dataCalories){
        List<Integer> allMax = new ArrayList<>();
        Integer sum = 0;
        Integer totalSumMax = 0;

        for (String dataCalory : dataCalories) {
            if (dataCalory.isEmpty()) {
                allMax.add(sum);
                sum = 0;
                continue;
            }
            sum += Integer.parseInt(dataCalory);
        }

        Collections.sort(allMax);

        totalSumMax = Integer.sum(allMax.get(allMax.size() - 1),allMax.get(allMax.size() - 2));
        totalSumMax = Integer.sum(totalSumMax,allMax.get(allMax.size() - 3));

        return totalSumMax;
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
