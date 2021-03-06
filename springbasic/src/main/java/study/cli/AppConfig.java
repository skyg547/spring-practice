package study.cli;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import study.cli.service.MyService;

import java.sql.Connection;

@EnableAspectJAutoProxy // aop porxy 사용게 만드는 aop

//@asprct - aop 적용하는 클래스
//@pointcut - 실행하는메서드
//@arount - advice
@PropertySource("classpath:application-${spring.profiles.active}.properties") // 프로필의 속성으로 값을 동적으로 가지고 온다
@Configuration
@Profile("default| dev")// 디폴트 이거나 dev 일때 실행 //{"defalut","dev"} 로 대체해서 사용가능
public class AppConfig {

    @Bean
    public Connection connection(ConnectionFactory connectionFactory){

        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection){
        return new Dao(connection);
    }


    @Bean // xml 빈설정 대신 자바 어노테이션으로 설정
    @Primary // 같은 타입  우선적 주입
    @Qualifier("b")
    public B appBeanb1(){

        return  new B();

    }

    @Qualifier("b2")
    @Bean // xml 빈설정 대신 자바 어노테이션으로 설정
    public B b2(){

        return  new B();

    }

    //설정은 보통 외부에서 A 클래스가 아닌
    // 같은 클래스지만 한쪽은 비즈니스 클래스(a,b), 한쪽을 설정 클래스(appconfig) 구분하여 사용하기
    @Bean(initMethod = "init", destroyMethod = "destroy")
//    @Description("의존성 주입") // 설명
    public A a(B b){
        return new A(b);

    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();

    }

    @Bean
    public MyService myService(){
        return new MyService();
    }
}
