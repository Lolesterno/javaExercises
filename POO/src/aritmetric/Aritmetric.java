package aritmetric;

public class Aritmetric {
    private int operating1;
    private int operating2;

    // Constructor
    public Aritmetric(int number1, int number2) {
        this.operating1 = number1;
        this.operating2 = number2;
    }

    public int getOperating1() {
        return operating1;
    }

    public void setOperating1(int operating1) {
        this.operating1 = operating1;
    }

    public int getOperating2() {
        return operating2;
    }

    public void setOperating2(int operating2) {
        this.operating2 = operating2;
    }

    public int sumar() {
        int result = operating1 + operating2;
        return result;
    }

    public int restar() {
        int result = operating1 - operating2;
        return  result;
    }
}
