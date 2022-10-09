package util;

import dao.MyData;

import java.util.Random;

public class CalculateUtils {
    //	100以内加减法练习小软件（用户目标：小学1年级学生）
    /**
     * 随机生成加减法题目和答案，封装在MyData
     * @return  加减法题目和答案
     */
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
}
