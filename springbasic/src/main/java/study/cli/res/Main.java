package study.cli.res;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {


//        // 상대경로 설정 파일 읽기
//        InputStream is = Main.class.getClassLoader().getResourceAsStream("dao.xml");
//
//        // 스프링 이전 방식 설정 파일 읽기 1
////        String path = "D:\\bit\\workspace\\spring-practice\\springbasic\\src\\main\\resources\\dao.xml";
////        File file = new File(path);
////        InputStream is = new FileInputStream(file);
//        byte[] bytes = is.readAllBytes();
//        String daoStr = new String(bytes);
//        System.out.println(daoStr);

//        클래스 패스 리소스 이용 하여 바ㅇ트 읽기
//        ClassPathResource resource = new ClassPathResource("dao.xml");
//        byte[] bytes = resource.getInputStream().readAllBytes();
//        String daoStr = new String(bytes);
//        System.out.println(daoStr);

//        유알아이 리소스 읽기
        // 절대 경로
//        Resource resource = new UrlResource("D:\\\\bit\\\\workspace\\\\spring-practice\\\\springbasic\\\\src\\\\main\\\\resources\\\\dao.xml");
//        byte[] bytes = resource.getInputStream().readAllBytes();
//        String daoStr = new String(bytes);
//        System.out.println(resource.exists());

        // 파일 시스템 리소르로 읽기
        Resource resource = new FileSystemResource("D:\\\\bit\\\\workspace\\\\spring-practice\\\\springbasic\\\\src\\\\main\\\\resources\\\\dao.xml");
        System.out.println(resource.exists());

    }
}
