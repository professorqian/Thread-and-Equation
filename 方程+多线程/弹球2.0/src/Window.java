import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame{
    public static final int WIDTH=700;
    public static final int HEIGHT=500;
    public static Circle []circles=new Circle[5];
    private static Thread []thread=new Thread[5];
    public static int num=0;

    public Window(){

    }
    public void create_window(String title){
        setTitle(title);
        setBounds(500,200,WIDTH,HEIGHT);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e ) {
                super.mouseClicked(e);
                if(num<5) {
                    Circle temp = new Circle(e.getX(), e.getY(), Math.random() * 180);
                    circles[num] = temp;
                    send_Graphics(temp);
                    thread[num]=new Thread(temp);
                    thread[num].start();
                    num++;
                }
                else{
                    JOptionPane.showMessageDialog(null, "qjk祝你新年快乐!", "彩蛋",JOptionPane.PLAIN_MESSAGE);
                    for (int i=0;i<num;i++){
                        circles[i].clear();
                        thread[i].stop();
                    }
                    num=0;
                }
            }
        });
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void send_Graphics(Circle circle){
        circle.get_Graphics(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

}
