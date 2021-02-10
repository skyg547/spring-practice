package study.cli;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.sql.Connection;

//@ComponentScan(basePackageClasses = AppConfig.class)
//@ComponentScan(basePackages = "study.cli")// 컴포넌트를 스캔을 한다 패키지에서
@Configuration// 스프링 관련 빈이다, 빈 설정과 동시에
@PropertySource("classpath:application-default.properties") //설정에서 정한 값 가지고 오기 @value 로 사용
@Profile("default") // 기본적으로 설정 실행
public class AppDeafaultConfig {


    @Bean // xml 빈설정 대신 자바 어노테이션으로 설정
    @Primary // 같은 타입  우선적 주입
    @Qualifier("b")
    public B appBeanb1() {

        return new B();

    }

    @Qualifier("b2")
    @Bean // xml 빈설정 대신 자바 어노테이션으로 설정
    public B b2() {

        return new B();

    }

    //설정은 보통 외부에서 A 클래스가 아닌
    // 같은 클래스지만 한쪽은 비즈니스 클래스(a,b), 한쪽을 설정 클래스(appconfig) 구분하여 사용하기
    @Bean(initMethod = "init", destroyMethod = "destroy")
//    @Description("의존성 주입") // 설명
    public A a(B b) {
        return new A(b);

    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ConnectionFactory connectionFactory(
            @Value("${jdbc.driver-class}") String driveClass, //@value 값 주입
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.username}") String username,
            @Value("${jdbc.password}") String pwd
            ) {
        return new ConnectionFactory(url, username,pwd,driveClass);

    }

    @Bean
    public Connection connection(ConnectionFactory connectionFactory) {

        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection) {
        return new Dao(connection);
    }
}
