package study.cli;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.h2.command.ddl.DropView;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Data
@AllArgsConstructor
public class ConnectionFactory implements InitializingBean, DisposableBean {

    private String url;
    private String user;
    private String password;
    private String driverClass;
    private Connection connection = null;

    public ConnectionFactory(String url, String user, String password, String driverClass) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.driverClass = driverClass;
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

    private void init() throws SQLException {
        this.connection = createConnection();

    }

    @Override
    public void destroy() throws Exception {


        if(this.connection != null){

            this.connection.close();
        }

    }
}
