package com.ems.member.configration;

import com.ems.member.DataBaseConnectionInfo;
import com.ems.member.dao.StudentDao;
import com.ems.member.service.*;
import com.sun.media.sound.AbstractMidiDeviceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;

import java.util.*;

@Configuration
public class MemberConfig {
	//  클래스 반환형 타입, id = 메서드 이름
	//		<bean id="studentDao" class="com.ems.member.dao.StudentDao"></bean>
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}

	// 참조는 Argument 로 전달
	//	<bean id="registerService" class="com.ems.member.service.StudentRegisterService">
	//		<constructor-arg ref="studentDao"></constructor-arg>
	//	</bean>
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}

	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}

	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}

	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService(studentDao());
	}

	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDao());
	}


	@Bean // property 는 set method 사용
	public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
		DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
		infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		infoDev.setUserId("scott");
		infoDev.setUserPw("tiger");

		return infoDev;
	}

	@Bean // property 는 set method 사용
	public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
		DataBaseConnectionInfo infoReal = new DataBaseConnectionInfo();
		infoReal.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
		infoReal.setUserId("masterid");
		infoReal.setUserPw("masterpw");

		return infoReal;
	}

}
