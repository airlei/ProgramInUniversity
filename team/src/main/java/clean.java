import java.io.IOException;
import java.sql.*;


public class clean {//清洗mysql中的数据将ip地址转化成城市
    public static void main(String[] args) throws IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");//注册JDBC驱动
            Connection connection = DriverManager.getConnection("jdbc:mysql://linux-centos7-03:3306/cmy","root", "123456");
            String sql ="select * from data";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                if(rs.getString(1).length()>=7){//判断是否是ip地址，因为ip地址最少为7 length（）
                    //获取IP地址
                    String hostAddress = rs.getString(1);
                    //工具类
                    String address = IPUtil.getCityInfo(hostAddress);//中国|0|北京|北京市|联通
                    int i=3;

                    while(true){
                        if(address.split("\\|")[i].equals("0")){
                            i--;
                        }else{
                            break;
                        }
                    }
                    String address1=address.split("\\|")[i];//不正确切割字符串，在分割字符前加转义字符\\

                    String sql1 ="update data set ip=? where ip=?";
                    PreparedStatement ps1 = connection.prepareStatement(sql1);
                    ps1.setString(1,address1);
                    ps1.setString(2,rs.getString(1));
                    ps1.executeUpdate();
                    System.out.println("修改成功！");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
