import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI extends JFrame {
    public static final int WIDTH=320;
    public static final int HEIGHT=210;

    public UI(String title){
        super(title);
        setBounds(500,200,0,0);
        setLayout(new FlowLayout(FlowLayout.LEFT,25,15));
        Font font=new Font("宋体",Font.BOLD, 16);
        setResizable(false);
        JLabel label1=new JLabel("请输入系数a:");
        label1.setFont(font);
        JLabel label2=new JLabel("请输入系数b:");
        label2.setFont(font);
        JLabel label3=new JLabel("请输入系数c:");
        label3.setFont(font);
        JTextField textfield1=new JTextField(15);
        textfield1.setFont(font);
        JTextField textfield2=new JTextField(15);
        textfield2.setFont(font);
        JTextField textfield3=new JTextField(15);
        textfield3.setFont(font);
        JButton button1=new JButton("求根");
        button1.setFont(font);
        JButton button2=new JButton("清空");
        button2.setFont(font);
        JButton button3=new JButton("退出");
        button3.setFont(font);
        add(label1);
        add(textfield1);
        add(label2);
        add(textfield2);
        add(label3);
        add(textfield3);
        add(button1);
        add(button2);
        add(button3);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                String a=textfield1.getText();
                String b=textfield2.getText();
                String c=textfield3.getText();
                new Main().inputABC(a,b,c);
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textfield1.setText("");
                textfield2.setText("");
                textfield3.setText("");
            }
        });
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
    }
}
