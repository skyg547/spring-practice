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
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

@Slf4j
public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {



        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml", "bean.xml");
        Dao dao = context.getBean(Dao.class);

//
//        dao.run();
//


//        A a1 = context.getBean("A",A.class);
//        A a2 = context.getBean("A",A.class);
//        동일성 실험 ,
//        log.info("result : "+ (a1 == a2));

    }
}
