package demo.config;

import demo.controller.ClassesController;
import demo.controller.StudentController;
import demo.model.Classes;
import demo.model.Student;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;

//public class DemoConfig extends JFinalConfig {
//
//    @Override
//    public void configConstant(Constants me) {
//    }
//
//    @Override
//    public void configHandler(Handlers me) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void configInterceptor(Interceptors me) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void configPlugin(Plugins me) {
//        C3p0Plugin cp = new C3p0Plugin("jdbc:oracle:thin:@localhost:1521:orcl",
//                "test", "test");
//        // 配置Oracle驱动
//        cp.setDriverClass("oracle.jdbc.driver.OracleDriver");
//        me.add(cp);
//        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
//        me.add(arp);
//        // 配置Oracle方言
//        arp.setDialect(new OracleDialect());
//        // 配置属性名(字段名)大小写不敏感容器工厂
//        arp.setContainerFactory(new CaseInsensitiveContainerFactory());
//        arp.addMapping("student", "studentid", Student.class);
//        arp.addMapping("classes", "classesid", Classes.class);
//    }
//
//    @Override
//    public void configRoute(Routes me) {
//        me.add("/", StudentController.class);
//        me.add("/student", StudentController.class);
//        me.add("/classes", ClassesController.class);
//    }
//
//}

public class DemoConfig extends JFinalConfig {
    public void configPlugin(Plugins me) {
        C3p0Plugin  cp  =  new  C3p0Plugin("jdbc:mysql://localhost/db_name",
                "userName", "password");
        me.add(cp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
        me.add(arp);
        arp.addMapping("user", User.class);
        arp.addMapping("article", "article_id", Article.class);
    }
}