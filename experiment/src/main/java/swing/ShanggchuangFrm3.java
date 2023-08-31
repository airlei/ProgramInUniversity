package swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ShanggchuangFrm3 extends JFrame {

    private JPanel contentPane;
    private static JLabel lblNewLabel;
    private JButton btnNewButton ;//上传图片按钮
    private JButton upButton;  //上传网络验证
    private JLabel jLabel ;                 //提示对话框

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShanggchuangFrm3 frame = new ShanggchuangFrm3();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ShanggchuangFrm3() {     //页面布局
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
//        setBounds(100, 100, 622, 421);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(36, 39, 250, 250);
        contentPane.add(lblNewLabel);

        //上传图片按钮
//        btnNewButton = new JButton("\u4E0A\u4F20\u56FE\u7247");
        btnNewButton = new JButton("上传图片");         //设置图片按钮
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
        btnNewButton.addMouseListener(new MouseAdapter() {          //按钮点击事件
            @Override
            public void mouseClicked(MouseEvent e) {
                addPicture(btnNewButton);
            }
        });

//        btnNewButton.setBounds(355, 264, 141, 46);
        btnNewButton.setBounds(250, 350, 141, 46);
        contentPane.add(btnNewButton);



        //上传图片
        upButton = new JButton("上传网络验证");
        upButton.setFont(new Font("宋体", Font.BOLD, 18));
        upButton.addMouseListener(new MouseAdapter() {          //按钮点击事件
            @Override
            public void mouseClicked(MouseEvent e) {
                addPicture(upButton);
            }
        });
        upButton.setBounds(500,350,200,46);
        contentPane.add(upButton);


        //提示文本框
        jLabel = new JLabel("经过测试");
        jLabel.setFont(new Font("宋体", Font.BOLD, 25));

        jLabel.setBounds(750,200,200,100);
        contentPane.add(jLabel);

    }


    //上传图片
    public static void addPicture(JButton button) {
        JFileChooser chooser = new JFileChooser();//文件选择器
        chooser.setMultiSelectionEnabled(true);//是否可以多选文件

        /** 过滤文件类型 * */
        FileNameExtensionFilter filter = new FileNameExtensionFilter("图片","jpg","png"); //筛选结果为文件夹和图片文件
        chooser.setFileFilter(filter);//设置选择器的过滤器
        int returnVal = chooser.showOpenDialog(button);//在容器中选择文件选择器
        if (returnVal == JFileChooser.APPROVE_OPTION) { //如果在选择器中单击“打开”
            /** 得到选择的文件* */
            File[] arrfiles = chooser.getSelectedFiles();   //获取选择器中选中的文件
//            file.getAbsolutePath()
            if (arrfiles == null || arrfiles.length == 0) {
                return;
            }



            //判断是否有文件为jpg或者png
            File  ff = chooser.getSelectedFile();
            //创建一个fileName得到选择文件的名字
            String fileName =ff.getName();
            //lastIndexOf(".") 返回"."在文件名中最后一次出现的下标
            //substring(int index)从指定的index开始截取后面的字符串
            //比如： a.txt 最后一次出现的.下标是 1 substring(1)就是从下标1的位置开始截取 截取后的新字符串为 .txt
            //所以这里需要+1 才能只截取文件类型 txt
            String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
            //判断选择的文件是否是图片文件 必须排除不是的情况 不然后续操作会报错
            if(!(prefix.equals("jpg") || prefix.equals("png"))){
                JOptionPane.showMessageDialog(new JDialog(),":请选择.jpg 或 .png格式的图片");
                return;
            }

            System.out.println("******************************"+ff.getAbsolutePath());//获取图片路径

            FileInputStream input = null;
            FileOutputStream out = null;
            //要上传到的路径，这里可以设你要放图片的路径
            String path = "D:\\Picture";

//            try {
//                for (File f : arrfiles) {
//                    File dir = new File(path);
//                    /** 目标文件夹 * */
//                    File[] fs = dir.listFiles();
//                    HashSet<String> set = new HashSet<String>();
//                    for (File file : fs) {
//                        set.add(file.getName());
//                    }
//
////                    /** 判断是否已有该文件* */
////                    if (set.contains(f.getName())) {
////                        JOptionPane.showMessageDialog(new JDialog(),
////                                f.getName() + ":该文件已存在！");
////                        return;
////                    }
//
//                    //通过文件选择器对象拿到选择的文件.拿到该文件的绝对路径
//                    String absolutePath = chooser.getSelectedFile().getAbsolutePath();
//                    //创建一个ImageIcon对象 传入图片文件的绝对路径
//                    ImageIcon imageIcon = new ImageIcon(absolutePath);
//                    lblNewLabel.setIcon(imageIcon);
//                    lblNewLabel.getIcon();
//                    input = new FileInputStream(f);
//                    byte[] buffer = new byte[1024];
//                    File des = new File(path, f.getName());
//                    out = new FileOutputStream(des);
//                    int len = 0;
//                    while (-1 != (len = input.read(buffer))) {
//                        out.write(buffer, 0, len);
//                    }
//                    out.close();
//                    input.close();
//                }
//                JOptionPane.showMessageDialog(null, "上传成功！", "提示",
//                        JOptionPane.INFORMATION_MESSAGE);
//            } catch (FileNotFoundException e1) {
//                JOptionPane.showMessageDialog(null, "上传失败！", "提示",
//                        JOptionPane.ERROR_MESSAGE);
//                e1.printStackTrace();
//            } catch (IOException e1) {
//                JOptionPane.showMessageDialog(null, "上传失败！", "提示",
//                        JOptionPane.ERROR_MESSAGE);
//                e1.printStackTrace();
//            }

        }
    }
}
