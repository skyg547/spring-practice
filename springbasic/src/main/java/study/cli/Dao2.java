package study.cli;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import study.cli.Member;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class Dao2 {
    private Connection connection;

    @Autowired
    public Dao2(Connection connection) {
        this.connection = connection;
    }

    public Dao2() {

    }

    void init() {
        log.info("dao init");
    }

    void destroy() {
        log.info("dao destroy");
    }

    public void run() throws SQLException {
        var statement = connection.createStatement();
        connection.setAutoCommit(false);
        statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
        try {
            statement.executeUpdate("insert into member(username, password) values('boojongmin', '1234')");
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        }

        var resultSet = statement.executeQuery("select id, username, password from member");
        while(resultSet.next()) {
//				var member = new Member(resultSet);
            var member = new Member("boojongmin", "1234");
            log.info(member.toString());
        }
    }
}
