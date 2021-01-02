import java.awt.*;

public class Circle  implements Runnable{
    private double x;
    private double y;
    private double speed=3;
    private int width=50;
    private int height=50;
    private double degree;
    public boolean alive=true;
    private Color background_color;
    private Graphics g;

    public void draw(){
        g.setColor(background_color);
        g.fillOval((int) x, (int) y, width, height);
        if(alive) {
            x += speed * Math.cos(degree);
            y += speed * Math.sin(degree);

            if (x < 0 || x > Window.WIDTH - width) {
                degree = Math.PI - degree;
            }
            if (y < 30 || y > Window.HEIGHT - height) {
                degree = -degree;
            }
            g.setColor(Color.green);
            g.fillOval((int) x, (int) y, width, height);
        }
    }

    public void clear(){
        g.setColor(background_color);
        g.fillRect(0,0,Window.WIDTH,Window.HEIGHT);
    }

    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }

    public Circle(double x,double y,double degree){
        this.x=x;
        this.y=y;
        this.degree=degree;
    }

    public void get_Graphics(Window window){
        background_color = window.getBackground();
        g=window.getGraphics();
    }

    @Override
    public void run() {
        while(true){
            draw();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
