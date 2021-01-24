package study.cli;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.h2.command.ddl.DropView;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
@AllArgsConstructor
public class ConnectionFactory implements InitializingBean {

    private String url;
    private String user;
    private String password;
    private String driverClass;
    private Connection connection = null;

    public ConnectionFactory(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection createConnection() throws SQLException {


        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(url,user,password);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        this.connection = createConnection();
    }
}
