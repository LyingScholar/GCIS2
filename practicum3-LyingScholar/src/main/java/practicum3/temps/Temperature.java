package practicum3.temps;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Temperature {

    public interface TemperatureScale {
        double convert(double temperature);
    }
    

    /**
     * Part A
     * Create and return an anonymous class of type TemperatureScale that
     * converts a temperature given in Celsius to Fahrenheit
     * F = (C * 1.8) + 32
     * @return
     */
    public static TemperatureScale createC2F() {
        TemperatureScale c2F = new TemperatureScale() {
            @Override
            public double convert(double temperatureCelsius)
            { 
                return (temperatureCelsius * 1.8) + 32;
            } 
        };
        ;

        return c2F;
    }

    /**
     * Part B
     * Create and return a lambda of type TempConv that
     * converts a temperature given in Fahrenheit to Celsius
     * C = (F - 32) / 1.8
     * @return
     */
    public static TemperatureScale createF2C() {
        TemperatureScale f2C = (double temperatureFahrenheit) -> (temperatureFahrenheit - 32) / 1.8;;

        return f2C;
    }

    public static void main(String[] args) {
        
        TemperatureScale c2F = createC2F();
        TemperatureScale f2C = createF2C();

        List<Double> temps = Arrays.asList(0.0, 32.0, 22.6, 54.6, -22.0);

        List<Double> celsiusTemps = new ArrayList<>();
        List<Double> fahrenheitTemps = new ArrayList<>();


        

        // Part C
        // For each temperature in temps
            // 1. Use c2F variable to convert the temperature to Fahrenheit and
            //    store result in fahrenheitTemps
            // 2. Use f2C variable to convert the temperature to Celsius and
            //    store result in celciusTemps

            temps.forEach(temp -> fahrenheitTemps.add(createC2F().convert(temp)));
            temps.forEach(temp -> celsiusTemps.add(createF2C().convert(temp)));

            
        // Part D
        // Using stream(), filter(), and forEach(), print on a separate line all
        // elements of fahrenheitTemps that are *above* feezing (32F)
        System.out.println("Fahrenheit Temps *above* freezing:");
        fahrenheitTemps.stream()
            .filter(temp -> temp > 32)
            .forEach(System.out::println);

        System.out.println();

        // Part E
        // Using streams(), filter(), and forEach(), print on a separate line all
        // elements of celsiusTemps that are *below* freezing (0C)
        System.out.println("Celsius Temps *below* freezing:");
        celsiusTemps.stream()
            .filter(temp -> temp < 0)
            .forEach(System.out::println);

        System.out.println();
    }
}
