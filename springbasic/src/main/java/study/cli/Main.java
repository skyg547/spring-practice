package study.cli;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.*;
//
//public class Main {
//
//    private static Logger logger = LoggerFactory.getLogger(Main.class);
//
//    public static void main(String[] args){
//        //로그 찍기
//        logger.info("Hello world!!");
//        // 디비 연결
//        Connection connection = null;
//        Statement statement = null;
//
//        try {
//            Class.forName("org.h2.Driver");
//            //제이디비씨 유알엘
//            String url = "jdbc:h2:mem:test;MODE=MySQL;";
//            connection = DriverManager.getConnection(url, "sa", "");
//            statement = connection.createStatement();
//
//            connection.setAutoCommit(false);
//
//            //크레이트 쿼리 날리기
//            statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(2555) not null. primary key(id);)");
//
//            //업데이트 쿼리 날리기
//            statement.executeUpdate("insert into member(username, password) values ('boojongmin', '1234')");
//
//            connection.setAutoCommit(false);
//
//            //셀렉트 쿼리 날리고 받기
//            ResultSet resultSet = statement.executeQuery("select * from member");
//
//            // 와일문으로 넘겨받기
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String username = resultSet.getString("username");
//                String pwd = resultSet.getString("password");
//                Member member = new Member(id,username,pwd);
//
//
//
//                logger.info(member.toString());
//
//            }
//
//
//        }catch (ClassNotFoundException e){
//
//            e.printStackTrace();
//
//        }catch (SQLException e){
//            e.printStackTrace();
//
//        } finally {
//            try {
//                statement.close();
//
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//            try {
//                connection.close();
//
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//
//        }
//
//
//
//    }
//
//}

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

//@ComponentScan(basePackageClasses = Main.class, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "study.cli.b"))// 클래 스 있는 패키지 스캐닝 경로  b 를 제외하고 스캐닝

//@ComponentScan(basePackageClasses = Main.class, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = B.class))// 클래스 있는 패키지 스캐닝 클래스 b 를 제외하고 스캐닝
//@Configuration 설정 파일 어노테이션
@Slf4j
public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();  // 레지스터 방식으로 컨테이너 설정
//        context.scan("study.cli"); // 스캐닝으로 ComponetScan 사용하기
//        context.register(AppConfig.class); // 레지스터 등록
//        context.refresh(); // 리프레시로 재가동?
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class); //  설정파일 클래스를 사용하여 콘텍스트 만들기
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml", "bean.xml"); // xml 파일로 클래스 경로로 콘텍스트 만들기
        // ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("study.cli"); // 경로를 사용하요xml 없이 어노테이션만으로 실행시키기
//
//        B b = context.getBean(B.class);
//        log.info("" + b);
        Dao dao = context.getBean(Dao.class);
        dao.run();
        context.close();

        // 라이프사이클
//        Lifecycle lifecycle = context.getBean(Lifecycle.class);
//
//        log.info(">>" + lifecycle.isRunning());


//
//        dao.run();
//


//        A a1 = context.getBean("A",A.class);
//        A a2 = context.getBean("A",A.class);
//        동일성 실험 ,
//        log.info("result : "+ (a1 == a2));

//
//        ConnectionFactory factory = context.getBean(ConnectionFactory.class);
//        Connection connection = factory.getConnection();
//        log.info(""+ (factory.getConnection()!= null));
//        스프링 종료 시키기
//        context.close();

        // 컨터이너 상태 체크
//        log.info(">>" + lifecycle.isRunning());
    }
}
