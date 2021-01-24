package study.cli.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MAin {
    public static void main(String[] args) {

        boolean condoiton =  false;

        //IOC 컨테이너를 이용한 의존성 주입, 컨터이네에 등록해서 사용하기
        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        A a = context.getBean("a", A.class);
        a.print();

//        B b = new B(condoiton);
//        //b라는걸 a에 주입해서 b 상태를 알필요가 없다, di 의존성 주입입
//        A a  new A(b);
//        a.print();
    }
}
