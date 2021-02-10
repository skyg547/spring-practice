package study.cli;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import java.sql.Connection;

@Profile("dev") // 프로필 설정
//@ComponentScan(basePackageClasses = AppConfig.class)
//@ComponentScan(basePackages = "study.cli")// 컴포넌트를 스캔을 한다 패키지에서
@Configuration// 스프링 관련 빈이다, 빈 설정과 동시에
@PropertySource("classpath:application.properties") //설정에서 정한 값 가지고 오기
public class AppDevConfig {



    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ConnectionFactory connectionFactory(){
        return new ConnectionFactory("jdbc:h2:file:~/test","sa","","org.h2.Driver");

    }


}
