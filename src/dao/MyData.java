package dao;

import lombok.Data;

@Data
public class MyData {
    private final int  firstNumber;
    private final int lastNumber;
    private final char operator;
    private int answer;

    public MyData(int firstNumber, int lastNumber, char operator) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "firstNumber=" + firstNumber +
                ", lastNumber=" + lastNumber +
                ", operator=" + operator +
                '}';
    }
}
