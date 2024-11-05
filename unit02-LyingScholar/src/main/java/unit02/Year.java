package unit02;

//2/18

//2/22
/**
 * Tis class is used in GCIS124 to show some features of JAVVA
 * specifically some methids, This class determines if an year is leap or not leap
 */
import java.util.Arrays;
import java.util.Random;

public class Year {
    //2/18 - 2.20 aDDED FINAL

    /**
     * Constnts for n. of days in most years
     */
    public static final int DAYS_IN_YEAR = 365;

    //2/24
    private static final Random RNG = new Random();

    private static final int START_YEAR = 1900;
    private static final int END_YEAR = 2023;


    //2/18 - 2.20 aDDED FINAL
    private final int yearNumber;

    //2/19
    public Year(int yearNumber){
        this.yearNumber = yearNumber;
    }

    //2/19
    public int getYearNumber(){
        return yearNumber;
    }
    
    //2/19
    public int numberOfDays(){
        return daysInYear(yearNumber);
    }

    //2/18

    /**
     * Computes number of days in a specific year.
     * @param year, the year to find number of days in
     * @return, the number of days.
     */
    public static int daysInYear(int year){
        if(year % 400 ==0){
            return DAYS_IN_YEAR + 1;
        }else if(year%4==0 && year%100 !=0){
            return DAYS_IN_YEAR + 1;
        }else{
            return DAYS_IN_YEAR;
        }
    }

    //2//21
    @Override
    public String toString(){
        return "Year{yearNumber=" + yearNumber +
        ", days= " + daysInYear(yearNumber) +
        "}";
    }
    
    //2/21

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Year){
            Year other = (Year)obj;
            return yearNumber == other.yearNumber;
        }else{
            return false;
        }
    }

    //2/23
    public static Year[] parseYears(String years){
        String[] tokens = years.split(" ");
        Year[] array = new Year[tokens.length];
        for (int i=0; i < tokens.length; i++){
            int yearNumber = Integer.parseInt(tokens[i]);
            array[i] = new Year(yearNumber);
        }
        return array;
    }

    //2/24
    public static Year getRandomYear(){
        int bound = 1 - START_YEAR + END_YEAR;
        int yearNumber = RNG.nextInt(bound) + START_YEAR;
        return new Year(yearNumber);


    }


    public static void main(String[] args) {
        //2/18
        System.out.println();
        System.out.println("Days in 2000: " + Year.daysInYear(2000));
        System.out.println("Days in 2023: " + Year.daysInYear(2023));
        // DAYS_IN_YEAR = 200;
        System.out.println("Days in 2024: " + Year.daysInYear(2024));
        System.out.println("Days in 2100: " + Year.daysInYear(2100));

        //2/19
        System.out.println();
        Year y2000 = new Year(2000);
        System.out.println(y2000.numberOfDays());
        Year y2023 = new Year(2023);
        System.out.println(y2023.numberOfDays());
        Year y2024 = new Year(2024);
        System.out.println(y2024.numberOfDays());
        Year y2100 = new Year(2100);
        System.out.println(y2100.numberOfDays());

        System.out.println();

        //2/21
        System.out.println();
        System.out.println(y2000);
        System.out.println(y2023);
        System.out.println(y2024);
        System.out.println(y2100);

        Year yTest = new Year(2000);
        System.out.println("Compare test year to 2000: "+ yTest.equals(y2000));
        System.out.println("Compare test year to 2024: "+ yTest.equals(y2024));

        //2/23
        System.out.println();
        Year[] years = parseYears("2000 2023 2024 2100");
        System.out.println(Arrays.toString(years));

        //2/24
        System.out.println();
        System.out.println(getRandomYear());
        System.out.println(getRandomYear());
        System.out.println(getRandomYear());

    }
}
