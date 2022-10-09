import Main.CalculateUtils;
import Main.MyData;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
public class MyLab1Panel extends JFrame {
    String[] s = {"7","8","9","下一题","4","5","6","请按键输入1","1","2","3","请按键输入2","0","AC","确定","请按键输入3"};
           //index 0   1   2   3      4   5   6   7    8   9   10  11  12  13   14   15

    StringBuffer sum=new StringBuffer();

    public static void next()
    {

    }
    public MyLab1Panel() {
        MyData myData = CalculateUtils.getMyData();
        int firstNumber = myData.getFirstNumber();
        String firstNumberStr = Integer.toString(firstNumber);
        int lastNumber = myData.getLastNumber();
        String lastNumberStr = Integer.toString(lastNumber);
        char operator = myData.getOperator();
        String operatorStr = String.valueOf(operator);
        setSize(700,500);   // 设置窗口大小
//        JTextArea jt = new  JTextArea(2,1); ///new 一个文本框
        //new 一个面板 设置为网格布局并指定为 5行4列 水平间隔为4 垂直间隔为5
//        JPanel panel = new JPanel(new GridLayout(4,4,4,5));
        JPanel panel = new JPanel(new GridLayout(4,4));

        JPanel jPanelForNorth = new JPanel();
        jPanelForNorth.setLayout(new GridLayout(3,1));

        JPanel jp1 = new JPanel();
        JLabel jlb1 = new JLabel(firstNumberStr);
        jp1.add(jlb1);
        jPanelForNorth.add(jp1);

        JPanel jp2 = new JPanel();
        JLabel jlb2 = new JLabel(operatorStr);
        jp1.add(jlb2);
        jPanelForNorth.add(jp2);

        JPanel jp3 = new JPanel();
        JLabel jlb3 = new JLabel(lastNumberStr);
        jp1.add(jlb3);
        jPanelForNorth.add(jp3);


        JPanel jp4 = new JPanel();
        JLabel jlb4 = new JLabel("请输入你的计算结果：");
        JLabel jlbAnswer = new JLabel("");
        jp4.add(jlb4);
        jp4.add(jlbAnswer);
        jPanelForNorth.add(jp4);


        JPanel jp5 = new JPanel();
        JLabel jlb5 = new JLabel("是否正确");
        jp5.add(jlb5);
        jPanelForNorth.add(jp5);



        ArrayList<JButton> jButtons = new ArrayList<>();
        for(int i = 0; i< this.s.length ; i++) {
            JButton jButton = new JButton(this.s[i]);
            jButtons.add(jButton);
        }
        setLayout(new BorderLayout());
        for(int i = 0; i< this.s.length ; i++) {  //加入计算器按钮 按窗口大小平均分配
            panel.add(jButtons.get(i));
        }
        //设置按钮监听事件

//        String[] s = {"7","8","9","下一题","4","5","6","-","1","2","3","+","0","AC","确定","="};
        //index         0   1   2   3      4   5   6   7    8   9   10  11  12  13   14   15

        //构建映射关系
        //Integer是index
        //String是真实含义
        HashMap<Integer, String> indexValueMap = new HashMap<>();
        indexValueMap.put(0,"7");
        indexValueMap.put(1,"8");
        indexValueMap.put(2,"9");
        indexValueMap.put(3,"下一题");
        indexValueMap.put(4,"4");
        indexValueMap.put(5,"5");
        indexValueMap.put(6,"6");
        indexValueMap.put(7,"-");
        indexValueMap.put(8,"1");
        indexValueMap.put(9,"2");
        indexValueMap.put(10,"3");
        indexValueMap.put(11,"+");
        indexValueMap.put(12,"0");
        indexValueMap.put(13,"AC");
        indexValueMap.put(14,"确定");
//        indexValueMap.put(15,"请按键");



        //赋值答案输入功能
        //监听jb0-对应数字应该是7
        for(int i = 0; i <=14;i++)
        {
            if(i!=3 &&i!=7 &&i!=11 &&i!=13 &&i!=14)
            {
                //排除特殊按钮
                String addNum = indexValueMap.get(i);
                jButtons.get(i).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sum.append(String.valueOf(addNum));
                        System.out.println("sum = " + sum);
                        jlbAnswer.setText(String.valueOf(sum));
                    }
                });
            }
        }

        //实现确定功能
        jButtons.get(14).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int answerTrue = myData.getAnswer();//正确答案
                int answerInput = Integer.parseInt(jlbAnswer.getText());//用户输入的答案
                if(answerTrue == Integer.parseInt(jlbAnswer.getText()))
                {
                    System.out.println("输入答案正确 ");
                    jlb5.setText("你输入的:"+myData.getAnswer()+"-----答案正确!");
                }
            }
        });

        //实现AC清0功能
        jButtons.get(13).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jlbAnswer.setText("");
                System.out.println("请0");
            }
        });

        //实现下一题功能
        jButtons.get(3).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("下一题");
            }
        });

        getContentPane().add(jPanelForNorth,BorderLayout.NORTH); ///将文本框放在窗口 NORTH
//        getContentPane().add(jt,BorderLayout.SOUTH); ///将文本框放在窗口 NORTH
        getContentPane().add(panel,BorderLayout.CENTER); //将面板放在窗口 CENTER
        setTitle("一百以内加减法随机出题--练习小软件");///标题
        setLocationRelativeTo(null);/// 设置窗口将置于屏幕的中央
        setDefaultCloseOperation(EXIT_ON_CLOSE);///设置关闭窗口界面则结束程序
        setVisible(true); /// 设置为可视(true)  若为false则不可视
    }
    public static void main(String[] args) {
        MyLab1Panel win = new MyLab1Panel();

    }
}


