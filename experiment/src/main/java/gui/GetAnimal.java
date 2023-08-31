package gui;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import founction.Animal;
import founction.Plant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigDecimal;

public class GetAnimal {

    static boolean fileExist = false;
    static String filepath = "";

    public static void main(String[] args) {
        final JFrame f = new JFrame("识别动植物");
        f.setSize(800, 500);
        f.setLocation(580, 200);
        f.setLayout(null);

        //下拉框出现的条目
        String[] heros = new String[] { "动物识别", "植物识别" };
        final JComboBox cb = new JComboBox(heros);

        cb.setBounds(550, 50, 80, 30);

        final JFileChooser fc = new JFileChooser();

        JButton b = new JButton("上传图片");
        b.setBounds(50, 300, 280, 30);
        JButton b1 = new JButton("上传网络验证");
        b1.setBounds(350, 300, 280, 30);


        final JLabel l = new JLabel();

        //上传图片
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fileExist = true;
                int returnVal =  fc.showOpenDialog(f);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(f, "计划打开文件:" + file.getAbsolutePath());
                    filepath = file.getAbsolutePath();

                    //根据图片创建ImageIcon对象
//                    ImageIcon i = new ImageIcon(file.getAbsolutePath());


                    ImageIcon i = new ImageIcon(filepath);// 加载图片资源
                    Image img = i.getImage();// 获得此图标的Image
                    img = img.getScaledInstance(350, 200, Image.SCALE_AREA_AVERAGING);// 将image压缩后得到压缩后的img
                    i.setImage(img);// 将图标设置为压缩后的图像


                    //设置ImageIcon
                    l.setIcon(i);
                    //label的大小设置为ImageIcon,否则显示不完整
//                    l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
                    l.setBounds(50, 50, 350, 200);
                    f.add(l);
                    SwingUtilities.updateComponentTreeUI(f);
                }
            }
        });

        //上传至网络验证
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String)cb.getSelectedItem();
                String res;
                if(filepath!=null&&filepath!="") {
                    if (selectedItem.equals("动物识别")) {
                        res = Animal.animal(filepath);
                    } else {
                        res = Plant.plant(filepath);
                    }
                    JSONObject jsonObject = JSON.parseObject(res);
                    JSONArray result = (JSONArray) jsonObject.get("result");
                    System.out.println(result);
                    BigDecimal score = new BigDecimal("0");
                    //                score = (BigDecimal)((JSONObject)result.get(0)).get("score");
                    String name = null;
                    //                String name = (String)((JSONObject)result.get(0)).get("name");
                    System.out.println("result.size()=====>" + result.size());
                    for (int i = 0; i < result.size(); i++) {
                        JSONObject object = (JSONObject) result.get(i);
                        System.out.println(object + "======" + i);
                        if (score.compareTo(new BigDecimal(String.valueOf(object.get("score")))) < 0) {
                            score = new BigDecimal(String.valueOf(object.get("score")));
                            name = (String) object.get("name");
                        }
                    }
                    JOptionPane.showMessageDialog(f, "通过网络的得到的结果为:\n" + "名字为：" + name + "\n得分为：" + score);
                }else {
                    JOptionPane.showMessageDialog(f, "还没有上传任何图片");
                }
            }
        });

        f.add(cb);
        f.add(b);
        f.add(b1);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
