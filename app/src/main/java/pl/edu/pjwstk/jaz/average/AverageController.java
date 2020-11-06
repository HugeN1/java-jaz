package pl.edu.pjwstk.jaz.average;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

@RestController
public class AverageController {

    @GetMapping("average")
    public String getAverage(@RequestParam(value = "numbers", required = false) String numbers){
        if (numbers.isEmpty()){
            return "Please put parameters";
        }
        else {
            List<String> partsString = Arrays.asList(numbers.split("\\s*,\\s*"));
            int sumNumbers = 0;
            for (String partString : partsString) {
                sumNumbers += Integer.parseInt(partString);
            }
            double avg = (double) sumNumbers / partsString.size();
            if (sumNumbers / partsString.size() == avg) {
                return "Average equals: " + (int) avg;
            } else {
                DecimalFormat twoPlaces = new DecimalFormat("##.00");
                return "Average equals: " + twoPlaces.format(avg);

            }
        }

    }
}

