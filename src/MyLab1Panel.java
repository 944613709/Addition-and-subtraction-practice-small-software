import Main.Calculate;
import Main.MyData;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class MyLab1Panel extends JFrame {
    String[] s = {"7","8","9","下一题","4","5","6","-","1","2","3","+","0","AC","确定","="};

    public MyLab1Panel() {
        MyData myData = Calculate.getMyData();
        int firstNumber = myData.getFirstNumber();
        String firstNumberStr = Integer.toString(firstNumber);
        int lastNumber = myData.getLastNumber();
        String lastNumberStr = Integer.toString(lastNumber);
        char operator = myData.getOperator();
        String operatorStr = String.valueOf(operator);
        setSize(450,350);   // 设置窗口大小
        JTextArea jt = new  JTextArea(2,1); ///new 一个文本框
        //new 一个面板 设置为网格布局并指定为 5行4列 水平间隔为4 垂直间隔为5
//        JPanel panel = new JPanel(new GridLayout(4,4,4,5));
        JPanel panel = new JPanel(new GridLayout(4,4));

        JPanel jPanelForNorth = new JPanel();
        jPanelForNorth.setLayout(new GridLayout(5,1));

        JPanel jp1 = new JPanel();
        JLabel jlb1 = new JLabel("数1");

        JTextField jtf1 = new JTextField(firstNumberStr);
        jp1.add(jlb1);
        jp1.add(jtf1);
        jPanelForNorth.add(jp1);

        JPanel jp2 = new JPanel();
        JLabel jlb2 = new JLabel("操作数");
        JTextField jtf2 = new JTextField(operatorStr);
        jp1.add(jlb2);
        jp1.add(jtf2);
        jPanelForNorth.add(jp2);

        JPanel jp3 = new JPanel();
        JLabel jlb3 = new JLabel("数2");
        JTextField jtf3 = new JTextField(lastNumberStr);
        jp1.add(jlb3);
        jp1.add(jtf3);
        jPanelForNorth.add(jp3);


        JPanel jp4 = new JPanel();
        JLabel jlb4 = new JLabel("你的输入计算结果");
        JTextField jtf4 = new JTextField("20");
        jp1.add(jlb4);
        jp1.add(jtf4);
        jPanelForNorth.add(jp4);


        JPanel jp5 = new JPanel();
        JLabel jlb5 = new JLabel("是否正确");
        JTextField jtf5 = new JTextField("True");
        jp1.add(jlb5);
        jp1.add(jtf5);
        jPanelForNorth.add(jp5);



        setLayout(new BorderLayout());
        for(int i = 0; i< this.s.length ; i++) {  //加入计算器按钮 按窗口大小平均分配
            panel.add(new JButton(this.s[i]));
        }
        getContentPane().add(jPanelForNorth,BorderLayout.NORTH); ///将文本框放在窗口 NORTH
        getContentPane().add(jt,BorderLayout.SOUTH); ///将文本框放在窗口 NORTH
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


