package frame2;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Demo extends JFrame {
    public Demo() {

        setTitle("文件选择对话框");
        setBounds(100, 100, 400, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());//设置容器为流布局，防止后控件覆盖前控件

        JLabel label=new JLabel("文件：");
        c.add(label);

        JTextField textField=new JTextField();
        textField.setColumns(20);//文本框宽度
        c.add(textField);

        JButton button=new JButton("上传");
        c.add(button);

        /*单击“上传”，弹出文件选择器（文件选择窗口），单击“打开”，被选中的文件路径显示在文本框中*/
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser=new JFileChooser();//文件选择器
                fileChooser.setMultiSelectionEnabled(true);//是否可以多选文件
                //筛选结果为文件夹和图片文件
                FileFilter fileFilter=new FileNameExtensionFilter("图片","jpg","png","gif");//过滤器
                fileChooser.setFileFilter(fileFilter);//设置选择器的过滤器
                int i=fileChooser.showOpenDialog(c);//在容器中显示文件选择器
                if (i==JFileChooser.APPROVE_OPTION){//如果在选择器中单击“打开”
                    File file=fileChooser.getSelectedFile();//获取选择器中选中的文件
                    textField.setText(file.getAbsolutePath());//文本框中显示绝对路径
                }
            }
        });
    }

    public static void main(String[] args) {
        Demo frame = new Demo();
        frame.setVisible(true);
    }
}