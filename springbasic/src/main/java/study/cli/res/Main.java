package study.cli.res;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {


        // 상대경로 설정 파일 읽기
        InputStream is = Main.class.getClassLoader().getResourceAsStream("dao.xml");

        // 스프링 이전 방식 설정 파일 읽기 1
//        String path = "D:\\bit\\workspace\\spring-practice\\springbasic\\src\\main\\resources\\dao.xml";
//        File file = new File(path);
//        InputStream is = new FileInputStream(file);
        byte[] bytes = is.readAllBytes();
        String daoStr = new String(bytes);
        System.out.println(daoStr);

    }
}
