package frame;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.*;

public class index extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String args[])  {

        JFrame f = new JFrame("第一个swing程序，welcome to java教程网");

        f.setSize(400,200);

        f.setBackground(Color.RED);

//设置窗口可见

        f.setVisible(true);


}
}
