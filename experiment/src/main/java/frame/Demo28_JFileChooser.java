package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo28_JFileChooser {

    private JLabel label=new JLabel("选择图片：");

    private JLabel label2 = new JLabel("",JLabel.CENTER);

    private JTextField jtf=new JTextField(25);

    private JButton button=new JButton("浏览");

    public static void main(String[] args){

        new Demo28_JFileChooser();

    }

    public Demo28_JFileChooser() {

        JFrame jf=new JFrame("动植物识别");

        JPanel panel=new JPanel();

        panel.add(label);

        panel.add(jtf);

        panel.add(button);

        label2.setFont(new Font("宋体", 1, 25));

        jf.add(panel, BorderLayout.NORTH);

        jf.add(label2);

        SwingUtils.setCenter(jf);//设置窗体大小600*800并居中

        jf.setVisible(true);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new MyActionListener());

    }

    //Action事件处理

    class MyActionListener implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent arg0){

            JFileChooser fc=new JFileChooser("D:\\");

            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);  //可以选择文件和文件夹

            int val=fc.showOpenDialog(null);    //文件打开对话框

//          int val=fc.showSaveDialog(null); //弹出保存文件对话框。

            if(val==fc.APPROVE_OPTION){

                //正常选择文件

                jtf.setText(fc.getSelectedFile().toString());

                label2.setText("选择了文件：【"+fc.getSelectedFile().getAbsolutePath()+"】");

            }else{

                //未正常选择文件，如选择取消按钮

                jtf.setText("未选择文件");

            }

        }

    }

}