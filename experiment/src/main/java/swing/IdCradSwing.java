package swing;

import bean.IdCardBean;
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

public class IdCradSwing extends JFrame {

    private JPanel contentPane;
    private static JLabel lblNewLabel;  //图片展示区域
    private JButton btnNewButton ;//上传图片按钮
    private JButton upButton;  //上传网络验证
    private  JLabel jLabel ;
    private  JLabel jLabel2 ;
    private  JLabel jLabel3 ;

    private static String path = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IdCradSwing frame = new IdCradSwing();
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
    public IdCradSwing() {     //页面布局
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
//        setBounds(100, 100, 622, 421);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文本框
        jLabel = new JLabel("请选择要识别的身份证图片");
        jLabel.setFont(new Font("宋体", Font.BOLD, 15));
        jLabel.setBounds(450,200,800,100);
        contentPane.add(jLabel);

        jLabel2 = new JLabel("");
        jLabel2.setFont(new Font("宋体", Font.BOLD, 15));
        contentPane.add(jLabel2);

        jLabel3 = new JLabel("");
        jLabel3.setFont(new Font("宋体", Font.BOLD, 15));
        contentPane.add(jLabel3);


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
                    IdCardBean res = verify();

                    if (null==(res.getId())) {
                        jLabel.setText("选择的图片不是身份证或身份证有损坏");
                    }
                    else {
                        jLabel.setText("姓名："+ res.getName()+"  性别："+res.getSex()+"  民族："+res.getNationality()+"");
                        jLabel2.setText("家庭住址："+res.getAddress());
                        jLabel3.setText("身份证号码："+res.getId());




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

                lblNewLabel.setBounds(whidth/5, height/4, 200, 200);
                jLabel.setBounds(whidth*3/5,height/8,800,100);
                btnNewButton.setBounds(whidth/5, height*4/5, 141, 46);//上传
                jLabel2.setBounds(whidth*3/5,height/2,800,100);
                jLabel3.setBounds(whidth*3/5,height/4,800,100);
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
    public static IdCardBean verify() {
        IdCardBean idCardBean = new IdCardBean();
        String res = Function.idCard(path);
        JSONObject jsonObject = JSON.parseObject(res);//转为对象类型
        System.out.println(jsonObject);

        JSONObject words_result = (JSONObject)jsonObject.get("words_result");


        JSONObject name = (JSONObject)words_result.get("姓名");
        String nameRes = name.getString("words");
        JSONObject nationality = (JSONObject)words_result.get("民族");
        String nationalityRes = nationality.getString("words");
        JSONObject address = (JSONObject)words_result.get("住址");
        String addressRes = address.getString("words");
        JSONObject id = (JSONObject)words_result.get("公民身份号码");
        String idRes = id.getString("words");
        JSONObject birthday = (JSONObject)words_result.get("出生");
        String birthdayRes = birthday.getString("words");
        JSONObject sex = (JSONObject)words_result.get("性别");
        String sexRes = sex.getString("words");

        idCardBean.setName(nameRes);
        idCardBean.setAddress(addressRes);
        idCardBean.setId(idRes);
        idCardBean.setBirthday(birthdayRes);
        idCardBean.setNationality(nationalityRes);
        idCardBean.setSex(sexRes);





        return idCardBean;


    }



}
