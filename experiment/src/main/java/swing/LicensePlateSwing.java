package swing;

import bean.LicensePlateBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import founction.Function;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class LicensePlateSwing extends JFrame {

    private JPanel contentPane;
    private static JLabel lblNewLabel;  //图片展示区域
    private JButton btnNewButton ;//上传图片按钮
    private JButton upButton;  //上传网络验证
    private  JLabel jLabel ;                 //提示对话框
    private static String path = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LicensePlateSwing frame = new LicensePlateSwing();
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
    public LicensePlateSwing() {     //页面布局
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
//        setBounds(100, 100, 622, 421);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文本框
        jLabel = new JLabel("请选择要识别的车牌图片");
        jLabel.setFont(new Font("宋体", Font.BOLD, 15));
        jLabel.setBounds(450,200,800,100);
        contentPane.add(jLabel);


//      图片区域
        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(225, 80, 200, 200);
        lblNewLabel.setBackground(Color.red);
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






        //验证
        upButton = new JButton("上传网络验证");
        upButton.setFont(new Font("宋体", Font.BOLD, 18));
        upButton.addMouseListener(new MouseAdapter() {          //按钮点击事件
            @Override
            public void mouseClicked(MouseEvent e) {
                if (path == null){
                    jLabel.setText("未选择图片");

                }
                else{
                    LicensePlateBean res = verify();

                    if (null==(res.getNumber())) {
                        jLabel.setText("选择的图片不是车牌照");
                    }
                    else {
                        jLabel.setText("经过识别这个车牌照："+res.getNumber()+"  颜色是"+res.getColor());
                    }
                }
            }
        });
        upButton.setBounds(500,350,200,46);
        contentPane.add(upButton);


        contentPane.addComponentListener(new ComponentAdapter() {//拖动窗口监听
            public void componentResized(ComponentEvent e) {
                int whidth=contentPane.getWidth();//获取窗口宽度
                int height=contentPane.getHeight();//获取窗口高度  你也可以设置高度居中
                //将lable放在 窗口左边的1/3处
//                btnNewButton.setBounds(whidth/3, 63, 61, 16);//(起始点x，起始点y，宽地w，高h)  标签设置宽高不明显
//                //将lable放在 窗口左边的1/2处
//                button.setBounds(whidth/2, 63, 61, 16);//(起始点x，起始点y，宽地w，高h)
//                //宽度始终是窗口的1/2
//                textField.setBounds(81, 110, whidth/2, 26);//(起始点x，起始点y，宽地w，高h)

                lblNewLabel.setBounds(whidth/5, height/4, 200, 200);
                jLabel.setBounds(whidth*3/5,height/4,800,100);
                btnNewButton.setBounds(whidth/5, height*4/5, 141, 46);//上传

                upButton.setBounds(whidth*3/5,height*4/5,200,46);//验证

            }

        });



    }


    //上传图片
    public static void addPicture(JButton button)  {
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
            String absolutePath = ff.getAbsolutePath();
            path=absolutePath;
            //创建一个ImageIcon对象 传入图片文件的绝对路径
            ImageIcon imageIcon = new ImageIcon(absolutePath);
            imageIcon.setImage(imageIcon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));//图片自适应窗口大小
            lblNewLabel.setIcon(imageIcon);

            lblNewLabel.getIcon();


            System.out.println("******************************"+absolutePath);//获取图片路径



        }
    }


    //验证
    public static LicensePlateBean verify() {
        LicensePlateBean licensePlate = new LicensePlateBean();
        String res = Function.licensePlate(path);
        JSONObject jsonObject = JSON.parseObject(res);//转为对象类型
        System.out.println(jsonObject);
        JSONArray words_result = (JSONArray)jsonObject.get("words_result");

        JSONObject results =  (JSONObject)words_result.get(0);
        System.out.println(results);
        String number =  results.getString("number");
        String color = results.getString("color");
        licensePlate.setColor(color);
        licensePlate.setNumber(number);

        return licensePlate;


    }



}
