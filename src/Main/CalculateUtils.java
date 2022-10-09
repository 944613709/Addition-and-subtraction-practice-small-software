package Main;

import Visualize.MyPanel;

import java.util.Random;
import java.util.Scanner;

public class CalculateUtils {
    //	100以内加减法练习小软件（用户目标：小学1年级学生）
    public static void main(String args[]){
        MyPanel myPanel = new MyPanel();
        getMyData();
    }
    public static MyData getMyData()
    {
        Random random = new Random();
        int firstNumber = random.nextInt(100);
        int lastNumber = random.nextInt(100);
        int operator_index = random.nextInt(2);
        char[] operators = new char[2];
        operators[0]='+';
        operators[1]='-';
        MyData myData = new MyData(firstNumber,lastNumber,operators[operator_index]);
        if(operators[operator_index]=='+')
        {
            myData.setAnswer(firstNumber+lastNumber);
        }
        else {
            myData.setAnswer(firstNumber - lastNumber);
        }
        System.out.println("myData = " + myData);
        return myData;
    }
    public static int calculate(int firstNum,int secondNum,String operator){
        int ans = 0;
        switch(operator){
            case "+":
                ans = firstNum + secondNum;
                break;
            case "-":
                ans = firstNum - secondNum;
                break;
            case "*":
                ans = firstNum * secondNum;
                break;
            case "/":
                ans = firstNum / secondNum;
                break;
            default:
                System.out.println("运算符错误");
        }
        return ans;
    }
}
