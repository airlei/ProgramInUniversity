package form;
import dao.UserDao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private UserDao dao = new UserDao();

//设置按钮组件
    private  JButton jb=new JButton("登录"); //添加一个登录按钮
    private JButton button=new JButton("重置"); //添加一个确定按钮
    //设置文本框组件
    private JTextField username = new JTextField();//用户名框
    private JPasswordField password = new JPasswordField();//密码框：为加密的***
    JLabel user_name=new JLabel("账号：");//设置左侧用户名文字
    JLabel pass_word=new JLabel("密码：");//设置左侧密码文字


    public void init()
    {
        /* 组件绝对位置  */
        user_name.setBounds(50, 70, 300, 25);
        pass_word.setBounds(50, 130, 200, 25);
        username.setBounds(110, 70, 300, 25);//设置用户名框的宽，高，x值，y值
        password.setBounds(110, 130, 300, 25);//设置密码框的宽，高，x值，y值
        button.setBounds(315, 225, 90, 20);//设置确定按钮的宽，高，x值，y值
        jb.setBounds(95, 225, 90, 20);//设置确定按钮的宽，高，x值，y值
        /* 组件透明化*/
        user_name.setOpaque(false);
        pass_word.setOpaque(false);
        //监听事件
        jb.addActionListener(new ActionListener(){ //为确定按钮添加监听事件
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent arg0) {
                validate(username.getText().trim(),password.getText().trim());
            }
        });
//重置按钮
        button.addActionListener(new ActionListener(){ //为重置按钮添加监听事件
//同时清空name、password的数据
            public void actionPerformed(ActionEvent arg0) {
// TODO 自动生成方法存根
                username.setText("");
                password.setText("");
            }
        });
    }



    public void display()
    {
        JFrame f =new JFrame();
        f.setTitle("登录页面");
        //窗口退出行为
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可变
        f.setResizable(false);
        //设置窗口打开居中
        f.setLocationRelativeTo(null);
        //窗口大小
        f.setSize(500, 300);
        init();
        //添加组件
        Container contentPanel= new Container();//添加一个contentPanel容器
        contentPanel.setLayout(null);//设置添加的contentPanel容器为流布局管理器
        contentPanel.add(user_name);
        contentPanel.add(pass_word);
        contentPanel.add(username);
        contentPanel.add(password);
        contentPanel.add(jb);
        contentPanel.add(button);
        f.add(contentPanel);
        //展示窗口
        f.setVisible(true);
    }





    public  void  validate(String username,String password)
    {
        if(username.trim().length()==0||password.trim().length()==0){
            JOptionPane.showMessageDialog(null, "用户名,密码不允许为空");
            return;
        }
        if(dao.findUser(username, password))
        {
            JOptionPane.showMessageDialog(null, "登录成功！");
        }else {
            JOptionPane.showMessageDialog(null, "用户名或密码错误");
        }
    }
}