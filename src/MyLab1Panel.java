import util.CalculateUtils;
import dao.MyData;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.*;

/**
 * JFrame写的作业
 */
public class MyLab1Panel extends JFrame {
    String[] s = {"7","8","9","放弃此题","4","5","6","确定提交答案","1","2","3","开始计时","0","AC","-","结束计时"};
           //index 0   1   2   3      4   5   6   7    8   9   10  11  12  13   14   15

    StringBuffer sum=new StringBuffer();
    MyData myData;
    int firstNumber;
    String firstNumberStr;
    int lastNumber;
    String lastNumberStr;
    char operator;
    String operatorStr;
    JPanel panel;
    JPanel jPanelForNorth;
    JPanel jp1;
    JLabel jlb1;
    JLabel jlb2 ;
    JLabel jlb3 ;
    JPanel jp4 ;
    JLabel jlb4 ;
    JLabel jlbAnswer ;
    JPanel jp5 ;
    JLabel jlb5 ;
    JPanel jp_time;
    JLabel jlb_timeStart;
    JLabel jlb_timeEnd;
    JPanel jp_count;
    JLabel jlb_finishedCount;
    JLabel jlb_allCount;
    ArrayList<JButton> jButtons;
    HashMap<Integer, String> indexValueMap;

    //已完成题目
    int finishedCount=0;
    //已遇见的题目总数
    int allCount =0;
    //更新下一题
    public void nextQuestion()
    {
        System.out.println("执行下一题");
        myData = CalculateUtils.getMyData();
        firstNumber = myData.getFirstNumber();
        lastNumber = myData.getLastNumber();
        operator = myData.getOperator();
        jlb1.setText(String.valueOf(myData.getFirstNumber()));
        jlb2.setText(String.valueOf(myData.getOperator()));
        jlb3.setText(String.valueOf(myData.getLastNumber()));
        jlb5.setText("等待按下确认检测是否正确");
        jlbAnswer.setText("");
        sum=new StringBuffer("");
        //更新题目总数显示
        jlb_finishedCount.setText("已经正确做对:"+finishedCount);
        jlb_allCount.setText("已经做的题目总数:"+allCount);
    }
    public MyLab1Panel() {
        //初始化数据
        myData = CalculateUtils.getMyData();
        firstNumber = myData.getFirstNumber();
        firstNumberStr = Integer.toString(firstNumber);
        lastNumber = myData.getLastNumber();
        lastNumberStr = Integer.toString(lastNumber);
        operator = myData.getOperator();
        operatorStr = String.valueOf(operator);
        panel = new JPanel(new GridLayout(4,4));
        jPanelForNorth = new JPanel();
        jp1 = new JPanel();
        jlb1 = new JLabel(firstNumberStr);
        jlb2 = new JLabel(operatorStr);
        jlb3 = new JLabel(lastNumberStr);
        jp4 = new JPanel();
        jlb4 = new JLabel("请输入你的计算结果：");
        jlbAnswer = new JLabel("");
        jp5 = new JPanel();
        jlb5 = new JLabel("等待按下确认检测是否正确");
        jp_time = new JPanel();
        jlb_timeStart=new JLabel("卷的开始时间：");
        jlb_timeEnd=new JLabel("卷的停止时间:");
        jp_count = new JPanel();
        jlb_finishedCount=new JLabel("已经正确做对：0");
        jlb_allCount=new JLabel("已经做的题目总数:0");
        jButtons = new ArrayList<>();
        indexValueMap = new HashMap<>();
        setSize(700,500);   // 设置窗口大小

        //new 一个面板 设置为网格布局并指定为 4行1列
        jPanelForNorth.setLayout(new GridLayout(5,1));
        //依次将操作数和操作符号标签加入jPanelForNorth


        jp1.add(jlb1);
        jp1.add(jlb2);
        jp1.add(jlb3);
        jPanelForNorth.add(jp1);

        //将答案标签加入
        jp4.add(jlb4);
        jp4.add(jlbAnswer);
        jPanelForNorth.add(jp4);


        //加入判断正确或者错误标签
        jp5.add(jlb5);
        jPanelForNorth.add(jp5);

        //加入计时器标签:
        jp_time.add(jlb_timeStart);
        jp_time.add(jlb_timeEnd);
        jPanelForNorth.add(jp_time);

        //加入题目统计标签:
        jp_count.add(jlb_finishedCount);
        jp_count.add(jlb_allCount);
        jPanelForNorth.add(jp_count);

        for(int i = 0; i< this.s.length ; i++) {
            JButton jButton = new JButton(this.s[i]);
            jButtons.add(jButton);
        }
        setLayout(new BorderLayout());
        for(int i = 0; i< this.s.length ; i++) {  //加入计算器按钮 按窗口大小平均分配
            panel.add(jButtons.get(i));
        }

        //设置按钮监听事件

//        String[] s = {"7","8","9","下一题","4","5","6","确定","1","2","3","开始计时","0","AC","-","结束计时"};
        //index          0   1   2   3      4   5   6   7    8   9   10  11  12  13   14   15

        //构建映射关系
        //Integer是index
        //String是真实含义
        indexValueMap.put(0,"7");
        indexValueMap.put(1,"8");
        indexValueMap.put(2,"9");
//        indexValueMap.put(3,"下一题");
        indexValueMap.put(4,"4");
        indexValueMap.put(5,"5");
        indexValueMap.put(6,"6");
//        indexValueMap.put(7,"确定");
        indexValueMap.put(8,"1");
        indexValueMap.put(9,"2");
        indexValueMap.put(10,"3");
//        indexValueMap.put(11,"开始计时");
        indexValueMap.put(12,"0");
//        indexValueMap.put(13,"AC");
        indexValueMap.put(14,"-");
//        indexValueMap.put(15,"结束计时");

        //赋值答案输入功能
        //监听jb0-对应数字应该是7
        for(int i = 0; i <=15;i++)
        {
            if(i!=3 &&i!=7 &&i!=11 &&i!=13 &&i!=15)
            {
                //排除特殊按钮
                String addNum = indexValueMap.get(i);
                jButtons.get(i).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sum.append(addNum);
                        System.out.println("sum = " + sum);
                        jlbAnswer.setText(String.valueOf(sum));
                    }
                });
            }
        }

        //实现确定功能
        jButtons.get(7).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int answerTrue = myData.getAnswer();//正确答案
                int answerInput=0;
                try {
                    answerInput = Integer.parseInt(jlbAnswer.getText());//用户输入的答案
                }catch (NumberFormatException w) {
                    answerInput = 0;
                }
                if(answerTrue == answerInput)
                {
                    System.out.println("输入答案正确 ");
                    jlb5.setText("你输入的:"+myData.getAnswer()+"-----答案正确!");
                    finishedCount++;
                    allCount++;
                }
                else {
                    System.out.println("输入答案错误 ");
                    jlb5.setText("你输入的:"+answerInput+"-----答案错误!");
                    allCount++;
                }
//                //点击确定提交之后等待四秒下一题
//                System.out.println("开始睡眠");
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//                System.out.println("结束睡眠");
                nextQuestion();
            }
        });

        //实现AC清0功能
        jButtons.get(13).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sum=new StringBuffer("");
                jlbAnswer.setText("");
                System.out.println("请0");
            }
        });

        //实现下一题功能
        jButtons.get(3).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextQuestion();
            }
        });


        //实现开始计时功能
        jButtons.get(11).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date day=new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("开始时间"+df.format(day));
                jlb_timeStart.setText("卷的开始时间:"+df.format(day));
            }
        });

        //实现结束计时功能
        jButtons.get(15).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date day=new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("结束时间"+df.format(day));
                jlb_timeEnd.setText("卷的结束时间:"+df.format(day));
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


