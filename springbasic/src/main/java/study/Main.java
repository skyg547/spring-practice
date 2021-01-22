package study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        //로그 찍기
        logger.info("Hello world!!");
        // 디비 연결
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("org.h2.Driver");
            //제이디비씨 유알엘
            String url = "jdbc:h2:mem:test;MODE=MySQL;";
            connection = DriverManager.getConnection(url, "sa", "");
            statement = connection.createStatement();

            connection.setAutoCommit(false);

            //크레이트 쿼리 날리기
            statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(2555) not null. primary key(id))");

            //업데이트 쿼리 날리기
            statement.executeUpdate("insert into member(username, password) values ('boojongmin', '1234')");


            //셀렉트 쿼리 날리고 받기
            ResultSet resultSet = statement.executeQuery("select * from member");

            // 와일문으로 넘겨받기
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String pwd = resultSet.getString("password");

                logger.info("id: "+ id + "userName: " + username + "pwd: " + pwd);

            }


        }catch (ClassNotFoundException e){

            e.printStackTrace();

        }catch (SQLException e){
            e.printStackTrace();

        } finally {
            try {
                statement.close();

            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                connection.close();

            }catch (SQLException e){
                e.printStackTrace();
            }

        }



    }

}
