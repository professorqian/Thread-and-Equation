import javax.swing.*;

public class Main implements RootInterface{
    private double a;
    private double b;
    private double c;
    public static void main(String[] args) {
        UI ui=new UI("求解一元二次方程");
        ui.setVisible(true);
    }

    @Override
    public void inputABC(String astr, String bstr, String cstr) {
        try{
            a=Double.valueOf(astr);
            b=Double.valueOf(bstr);
            c=Double.valueOf(cstr);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "请检查输入!", "提示",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(a==0.0&&b==0.0) JOptionPane.showMessageDialog(null, "输入不合法!", "提示",JOptionPane.WARNING_MESSAGE);
        else {
            root_x1x2();
        }
    }

    @Override
    public double b24ac() {
        return b*b-4*a*c;
    }

    @Override
    public void root_x1x2() {
        double dealt = b24ac();
        if(Math.abs(dealt)<0.000001){
            double x1,x2;
            x1=x2=-b/(2*a);
            JOptionPane.showMessageDialog(null, "x1=x2="+x1, "结果",JOptionPane.PLAIN_MESSAGE);
        }
        else if(dealt>0){
            double x1,x2;
            x1=(-b+Math.sqrt(dealt))/(2*a);
            x2=(-b-Math.sqrt(dealt))/(2*a);
            JOptionPane.showMessageDialog(null,
                    "x1="+x1+"  x2="+x2, "结果",
                    JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "x1="+(-b/(2*a))+"+"+Math.sqrt(-dealt)/(2*a)+"i  x2="+(-b/(2*a))+"-"+Math.sqrt(-dealt)/(2*a)+"i",
                    "结果", JOptionPane.PLAIN_MESSAGE);
        }
    }

}

