package zhenzhen.calculate.view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import zhenzhen.calculate.expressions.*;
import zhenzhen.calculate.parsers.FunctionParser;

import java.awt.Color;
import java.awt.Font;
import java.lang.reflect.*;

public class CalcFrame extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8957162949350515957L;
	public CalcFrame() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        memory=null;
        lastAnswer = new ConstantExpression(0.0);
        VariableExpression.difine(answerKey, 0.0);
    }

    private Expression lastAnswer;
    private Expression memory;
    private final String answerKey = "ans";
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    JPanel jPanel5 = new JPanel();
    GridLayout gridLayout1 = new GridLayout();
    JPanel jPanel6 = new JPanel();
    JPanel jPanel7 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JTextField jTextField1 = new JTextField();
    JTextArea jTextArea1 = new JTextArea();
    JScrollPane jScrollPane1=new JScrollPane();
    TitledBorder titledBorder1 = new TitledBorder("");
    TitledBorder titledBorder2 = new TitledBorder("");
    GridLayout gridLayout2 = new GridLayout();
    JPanel jPanel8 = new JPanel();
    JPanel jPanel9 = new JPanel();
    JPanel jPanel10 = new JPanel();
    JPanel jPanel11 = new JPanel();
    JPanel jPanel12 = new JPanel();
    JPanel jPanel13 = new JPanel();
    JPanel jPanel14 = new JPanel();
    JPanel jPanel15 = new JPanel();
    GridLayout gridLayout3 = new GridLayout();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    JButton jButton4 = new JButton();
    JButton jButton5 = new JButton();
    JButton jButton6 = new JButton();
    JButton jButton7 = new JButton();
    TitledBorder titledBorder3 = new TitledBorder("");
    GridLayout gridLayout4 = new GridLayout();
    JButton jButton8 = new JButton();
    JButton jButton9 = new JButton();
    JButton jButton10 = new JButton();
    JButton jButton11 = new JButton();
    JButton jButton12 = new JButton();
    JButton jButton13 = new JButton();
    JButton jButton14 = new JButton();
    GridLayout gridLayout5 = new GridLayout();
    JButton jButton15 = new JButton();
    JButton jButton16 = new JButton();
    JButton jButton17 = new JButton();
    JButton jButton18 = new JButton();
    JButton jButton19 = new JButton();
    GridLayout gridLayout6 = new GridLayout();
    JButton jButton20 = new JButton();
    JButton jButton21 = new JButton();
    JButton jButton22 = new JButton();
    JButton jButton23 = new JButton();
    JButton jButton24 = new JButton();
    GridLayout gridLayout7 = new GridLayout();
    JButton jButton25 = new JButton();
    JButton jButton26 = new JButton();
    JButton jButton27 = new JButton();
    JButton jButton28 = new JButton();
    JButton jButton29 = new JButton();
    GridLayout gridLayout8 = new GridLayout();
    JButton jButton30 = new JButton();
    JButton jButton31 = new JButton();
    JButton jButton32 = new JButton();
    JButton jButton33 = new JButton();
    JButton jButton34 = new JButton();
    GridLayout gridLayout9 = new GridLayout();
    JButton jButton35 = new JButton();
    JButton jButton36 = new JButton();
    JButton jButton37 = new JButton();
    JButton jButton38 = new JButton();
    JButton jButton39 = new JButton();
    ButtonListener buttonListener=new ButtonListener();
    /**初始化函数
     * @throws Exception
     */
    private void jbInit() throws Exception {
        this.setSize(350,600);
        this.setTitle("计算器  Version 1.0");
        this.setResizable(false);
        this.getContentPane().setBackground(SystemColor.control);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(borderLayout1);
        jPanel2.setLayout(gridLayout1);
        gridLayout1.setColumns(1);
        gridLayout1.setHgap(5);
        gridLayout1.setRows(2);
        gridLayout1.setVgap(5);
        jPanel6.setBackground(Color.lightGray);
        jPanel6.setLayout(borderLayout2);
        jPanel7.setBackground(Color.lightGray);
        jPanel7.setBorder(null);
        jPanel7.setLayout(gridLayout2);
        jTextField1.setText("");
        jTextField1.setFocusable(true);
        jTextArea1.setBorder(BorderFactory.createLineBorder(Color.black));
        jTextArea1.setEditable(false);
        jTextArea1.setText("");
        jTextArea1.setLineWrap(true);
        jTextArea1.setFont(new java.awt.Font("宋体", Font.PLAIN, 13));
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        borderLayout2.setHgap(5);
        borderLayout2.setVgap(5);
        gridLayout2.setColumns(1);
        gridLayout2.setRows(8);
        gridLayout2.setVgap(5);
        jPanel8.setBackground(Color.lightGray);
        jPanel8.setLayout(gridLayout3);
        jPanel9.setBackground(Color.lightGray);
        jPanel9.setLayout(gridLayout4);
        jPanel10.setBackground(Color.lightGray);
        jPanel11.setBackground(Color.lightGray);
        jPanel11.setLayout(gridLayout5);
        jPanel12.setBackground(Color.lightGray);
        jPanel12.setLayout(gridLayout6);
        jPanel13.setBackground(Color.lightGray);
        jPanel13.setLayout(gridLayout7);
        jPanel14.setBackground(Color.lightGray);
        jPanel14.setLayout(gridLayout8);
        jPanel15.setBackground(Color.lightGray);
        jPanel15.setLayout(gridLayout9);
        gridLayout3.setColumns(7);
        gridLayout3.setHgap(5);
        gridLayout3.setVgap(5);
        jButton1.setBackground(Color.gray);
        jButton1.setForeground(Color.white);
        jButton1.setBorder(BorderFactory.createEtchedBorder());
        jButton1.setText("sin");
        jButton2.setBackground(Color.gray);
        jButton2.setForeground(Color.white);
        jButton2.setBorder(BorderFactory.createEtchedBorder());
        jButton2.setText("cos");
        jButton3.setBackground(Color.gray);
        jButton3.setForeground(Color.white);
        jButton3.setBorder(BorderFactory.createEtchedBorder());
        jButton3.setText("tan");
        jButton4.setBackground(Color.gray);
        jButton4.setForeground(Color.white);
        jButton4.setBorder(BorderFactory.createEtchedBorder());
        jButton4.setText("x2");
        jButton5.setBackground(Color.gray);
        jButton5.setForeground(Color.white);
        jButton5.setBorder(BorderFactory.createEtchedBorder());
        jButton5.setText("x^y");
        jButton6.setBackground(Color.gray);
        jButton6.setForeground(Color.white);
        jButton6.setBorder(BorderFactory.createEtchedBorder());
        jButton6.setText("ln");
        jButton7.setBackground(Color.gray);
        jButton7.setForeground(Color.white);
        jButton7.setBorder(BorderFactory.createEtchedBorder());
        jButton7.setText("log");
        gridLayout4.setColumns(7);
        gridLayout4.setHgap(5);
        gridLayout4.setVgap(5);
        jButton8.setBackground(Color.gray);
        jButton8.setForeground(Color.white);
        jButton8.setBorder(BorderFactory.createEtchedBorder());
        jButton8.setText("asin");
        jButton9.setBackground(Color.gray);
        jButton9.setForeground(Color.white);
        jButton9.setBorder(BorderFactory.createEtchedBorder());
        jButton9.setText("acos");
        jButton10.setBackground(Color.gray);
        jButton10.setForeground(Color.white);
        jButton10.setBorder(BorderFactory.createEtchedBorder());
        jButton10.setText("atan");
        jButton11.setBackground(Color.gray);
        jButton11.setForeground(Color.white);
        jButton11.setBorder(BorderFactory.createEtchedBorder());
        jButton11.setText("x");
        jButton12.setBackground(Color.gray);
        jButton12.setForeground(Color.white);
        jButton12.setBorder(BorderFactory.createEtchedBorder());
        jButton12.setText("d/dx");
        jButton13.setBackground(Color.gray);
        jButton13.setForeground(Color.white);
        jButton13.setBorder(BorderFactory.createEtchedBorder());
        jButton13.setText("pi");
        jButton14.setBackground(Color.gray);
        jButton14.setForeground(Color.white);
        jButton14.setBorder(BorderFactory.createEtchedBorder());
        jButton14.setText("e");
        gridLayout5.setColumns(5);
        gridLayout5.setHgap(10);
        gridLayout5.setVgap(10);
        jButton15.setForeground(Color.red);
        jButton15.setBorder(BorderFactory.createEtchedBorder());
        jButton15.setText("OFF");
        jButton16.setBorder(BorderFactory.createEtchedBorder());
        jButton16.setText("C");
        jButton17.setBorder(BorderFactory.createEtchedBorder());
        jButton17.setText("M+");
        jButton18.setBorder(BorderFactory.createEtchedBorder());
        jButton18.setText("MR");
        jButton19.setBorder(BorderFactory.createEtchedBorder());
        jButton19.setText("MC");
        gridLayout6.setColumns(5);
        gridLayout6.setHgap(10);
        jButton20.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton20.setText("7");
        jButton21.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton21.setText("8");
        jButton22.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton22.setText("9");
        jButton23.setBorder(BorderFactory.createEtchedBorder());
        jButton23.setText("(");
        jButton24.setBorder(BorderFactory.createEtchedBorder());
        jButton24.setText(")");
        gridLayout7.setColumns(5);
        gridLayout7.setHgap(10);
        jButton25.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton25.setText("4");
        jButton26.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton26.setText("5");
        jButton27.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton27.setText("6");
        jButton28.setFont(new java.awt.Font("宋体", Font.PLAIN, 15));
        jButton28.setBorder(BorderFactory.createEtchedBorder());
        jButton28.setText("*");
        jButton29.setFont(new java.awt.Font("宋体", Font.PLAIN, 15));
        jButton29.setBorder(BorderFactory.createEtchedBorder());
        jButton29.setText("/");
        gridLayout8.setColumns(5);
        gridLayout8.setHgap(10);
        jButton30.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton30.setText("1");
        jButton31.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton31.setText("2");
        jButton32.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton32.setText("3");
        jButton33.setFont(new java.awt.Font("宋体", Font.PLAIN, 15));
        jButton33.setBorder(BorderFactory.createEtchedBorder());
        jButton33.setText("+");
        jButton34.setFont(new java.awt.Font("宋体", Font.PLAIN, 15));
        jButton34.setBorder(BorderFactory.createEtchedBorder());
        jButton34.setText("-");
        gridLayout9.setColumns(5);
        gridLayout9.setHgap(10);
        jButton35.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton35.setText("0");
        jButton36.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton36.setText(".");
        jButton37.setFont(new java.awt.Font("宋体", Font.PLAIN, 15));
        jButton37.setBorder(BorderFactory.createRaisedBevelBorder());
        jButton37.setText("+/-");
        jButton38.setFont(new java.awt.Font("宋体", Font.PLAIN, 15));
        jButton38.setBorder(BorderFactory.createEtchedBorder());
        jButton38.setText("=");
        jButton39.setBorder(BorderFactory.createEtchedBorder());
        jButton39.setText("ANS");
        this.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
        jPanel2.add(jPanel6);
        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTextArea1);
        jPanel6.add(jTextField1, java.awt.BorderLayout.SOUTH);
        jPanel2.add(jPanel7);
        jPanel7.add(jPanel8);
        jPanel8.add(jButton1);
        jPanel8.add(jButton2);
        jPanel8.add(jButton3);
        jPanel8.add(jButton4);
        jPanel8.add(jButton5);
        jPanel8.add(jButton6);
        jPanel8.add(jButton7);
        jPanel7.add(jPanel9);
        jPanel9.add(jButton8);
        jPanel9.add(jButton9);
        jPanel9.add(jButton10);
        jPanel9.add(jButton11);
        jPanel9.add(jButton12);
        jPanel9.add(jButton13);
        jPanel9.add(jButton14);
        jPanel7.add(jPanel10);
        jPanel7.add(jPanel11);
        jPanel11.add(jButton15);
        jPanel11.add(jButton16);
        jPanel11.add(jButton17);
        jPanel11.add(jButton18);
        jPanel11.add(jButton19);
        jPanel7.add(jPanel12);
        jPanel12.add(jButton20);
        jPanel12.add(jButton21);
        jPanel12.add(jButton22);
        jPanel12.add(jButton23);
        jPanel12.add(jButton24);
        jPanel7.add(jPanel13);
        jPanel13.add(jButton25);
        jPanel13.add(jButton26);
        jPanel13.add(jButton27);
        jPanel13.add(jButton28);
        jPanel13.add(jButton29);
        jPanel7.add(jPanel14);
        jPanel14.add(jButton30);
        jPanel14.add(jButton31);
        jPanel14.add(jButton32);
        jPanel14.add(jButton33);
        jPanel14.add(jButton34);
        jPanel7.add(jPanel15);
        jPanel15.add(jButton35);
        jPanel15.add(jButton36);
        jPanel15.add(jButton37);
        jPanel15.add(jButton38);
        jPanel15.add(jButton39);
        jPanel4.setBackground(SystemColor.control);
        jPanel5.setBackground(SystemColor.control);
        jPanel3.setBackground(SystemColor.control);
        jPanel2.setBackground(Color.lightGray);
        jPanel2.setBorder(BorderFactory.createEtchedBorder());
        jPanel1.setBackground(SystemColor.control);
        this.getContentPane().add(jPanel3, java.awt.BorderLayout.WEST);
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);
        this.getContentPane().add(jPanel4, java.awt.BorderLayout.EAST);
        this.getContentPane().add(jPanel5, java.awt.BorderLayout.NORTH);
        this.addMyListener();
    }
    private void addMyListener(){
    	this.jTextField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				super.keyPressed(arg0);
				switch (arg0.getKeyCode()) {
				case KeyEvent.VK_ESCAPE:
					jButton16.doClick();//ClearButton
					break;
				case KeyEvent.VK_ENTER:
					jButton38.doClick();//EqualButton
					break;
				default:
					break;
				}
			}
		});
    	for(int i=1;i<=39;i++){
    		Class<?> classMe=this.getClass();
    		try {//利用反射取得内部控件对象
				Field fieldButton=classMe.getDeclaredField("jButton"+i);
				fieldButton.setAccessible(true);
				JButton button=(JButton)fieldButton.get(this);
				button.addActionListener(buttonListener);
				button.setFocusable(false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    private void appendText(String text){
    	String buffer=this.jTextField1.getText();
    	if ( text.length()== 0 )
        {
            return;
        }
        if ( buffer.length()== 0 )
        {
            if ( text == "+" || text == "-" || text == "*" || text == "/" )
            {
                text = answerKey + text;
            }
        }
        buffer += text;
        this.jTextField1.setText(buffer);
    }
    private void memoryAppend()
    {
        if (computeAnswer())
        {
            if ( lastAnswer.getClass().equals(ConstantExpression.class) )
            {
                if ( memory == null )
                {
                    memory = lastAnswer;
                }
                else
                {
                    memory = new AddExpression( memory, lastAnswer );
                    memory = memory.simplify();
                }
                this.jTextArea1.append(memory.toString() + "\n");
            }
            else
            {
                this.jTextArea1.append("Cannot store this value in memory\n");
            }
        }
    }
    private void memoryRecall()
    {
        if ( memory != null )
        {
            appendText( memory.toString() );
        }
    }
    private void memoryClear()
    {
        memory = null;
    }
    /**
     * 求表达式的导函数
     */
    private void differentiate()
    {
    	String buffer=this.jTextField1.getText().trim();
        this.jTextArea1.append("> d/dx(" + buffer+ ")\n");

        try
        {
            Expression exp = FunctionParser.parse( buffer );
            exp = exp.differentiate("x").simplify();
            this.jTextArea1.append(exp.toString() + "\n");
            this.jTextField1.setText("");
        }
        catch (Exception e)
        {
            this.jTextArea1.append("Error!\n");
            this.jTextField1.setText("");
        }
    }
    private boolean computeAnswer()
    {
        String buffer =this.jTextField1.getText().trim();

        if (buffer.length()== 0)
        {
            buffer = answerKey;
            this.jTextField1.setText(buffer);
        }
        this.jTextArea1.append("> " + buffer.trim() + "\n");

        try
        {
            Expression exp = FunctionParser.parse( buffer );
            lastAnswer = exp.simplify();
            if ( lastAnswer.getClass()==ConstantExpression.class )
            {
                VariableExpression.difine( answerKey, ((ConstantExpression)lastAnswer).value );
            }
            return true;
        }
        catch (Exception e)
        {
            this.jTextArea1.append("Error!\n");
            lastAnswer = new ConstantExpression( 0 );
            VariableExpression.difine(answerKey, 0.0);
            this.jTextField1.setText("");
            return false;
        }
    }
    private void clear(){
    	if(this.jTextField1.getText().length()==0){
    		this.jTextArea1.setText("");
    	}
    	this.jTextField1.setText("");
    }
    public class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	jTextField1.setFocusable(true);
        	JButton button=(JButton)e.getSource();
        	//----------
        	if(button.getText()=="sin")	appendText("sin");
        	if(button.getText()=="cos")	appendText("cos");
        	if(button.getText()=="tan")	appendText("tan");
        	if(button.getText()=="asin")	appendText("asin");
        	if(button.getText()=="acos")	appendText("acos");
        	if(button.getText()=="atan")	appendText("atan");
        	if(button.getText()=="x2")	appendText("^2");
        	if(button.getText()=="x^y")	appendText("^");
        	if(button.getText()=="ln")	appendText("ln");
        	if(button.getText()=="log")	appendText("log");
        	if(button.getText()=="x")	appendText("x");
        	if(button.getText()=="d/dx")	differentiate();
        	if(button.getText()=="pi")	appendText("pi");
        	if(button.getText()=="e")	appendText("e");
        	//----------
        	if(button.getText()=="OFF")	System.exit(0);
        	if(button.getText()=="C")	clear();
        	if(button.getText()=="M+")	memoryAppend();
        	if(button.getText()=="MR")	memoryRecall();
        	if(button.getText()=="MC")	memoryClear();
        	if(button.getText()=="(")	appendText("(");
        	if(button.getText()==")")	appendText(")");
        	if(button.getText()=="*")	appendText("*");
        	if(button.getText()=="/")	appendText("/");
        	if(button.getText()=="+")	appendText("+");
        	if(button.getText()=="-")	appendText("-");
        	if(button.getText()=="0")	appendText("0");
        	if(button.getText()==".")	appendText(".");
        	if(button.getText()=="1")	appendText("1");
        	if(button.getText()=="2")	appendText("2");
        	if(button.getText()=="3")	appendText("3");
        	if(button.getText()=="4")	appendText("4");
        	if(button.getText()=="5")	appendText("5");
        	if(button.getText()=="6")	appendText("6");
        	if(button.getText()=="7")	appendText("7");
        	if(button.getText()=="8")	appendText("8");
        	if(button.getText()=="9")	appendText("9");
        	if(button.getText()=="ANS")	appendText(answerKey);
        	if(button.getText()=="+/-"){
        		String buffer=jTextField1.getText();
        		if(buffer.length()==0){
        			appendText("-");
        		}
        		else if(buffer.charAt(buffer.length()-1)!='-'){
        			appendText("-");
        		}
        		else{
        			buffer=buffer.substring(0, buffer.length()-1);
        			jTextField1.setText(buffer);
        		}
        	}
        	if(button.getText()=="="){
        		if(computeAnswer()){
        			jTextArea1.append(lastAnswer.toString() + "\n");
        			jTextField1.setText("");
        		}
        	}
        }
    }

}