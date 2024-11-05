package practicum1.easter;

public class Easter {
    
    private int year;
    private int month;
    private int day;

    public Easter(int year) {
        this.year = year;
        findOutEasterDate();
    }

    public void findOutEasterDate() {
        int a = year % 19;

        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8 * b + 13) / 25;
        int h = (19 * a + b - d - g + 15) % 30;
        
        int j = c / 4;
        int k = c % 4;


        int m = (a + 11 * h) / 319;
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        int n = (h - m + r + 90) / 25;
        
        int p = (h - m + r + n + 19) % 32;

        this.month = n;
        this.day = p;
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);
        // System.out.println(d);
        // System.out.println(e);

        // System.out.println(g);
        // System.out.println(h);
        // System.out.println(j);
        // System.out.println(k);

        // System.out.println(m);

        // System.out.println(n);
        // System.out.println(p);
        // System.out.println(a);

    }

    public int getEasterMonth() {
        return month;
    }

    public int getEasterDay() {
        return day;
    }
}
