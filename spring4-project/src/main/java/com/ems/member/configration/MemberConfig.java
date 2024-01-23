package com.ems.member.configration;

import com.ems.member.DataBaseConnectionInfo;
import com.ems.member.dao.StudentDao;
import com.ems.member.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MemberConfig {
	// 참조는 Argument 로 전달
	//	<bean id="registerService" class="com.ems.member.service.StudentRegisterService">
	//		<constructor-arg ref="studentDao"></constructor-arg>
	//	</bean>
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}

	//  클래스 반환형 타입, id = 메서드 이름
	//		<bean id="studentDao" class="com.ems.member.dao.StudentDao"></bean>
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
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

	@Bean
	public EMSInformationService informationService() {
		List<String> developers = Arrays.asList("Cheney", "Eloy", "Jasper", "Dillon", "Kian");


		Map<String, String> administrators = new HashMap<>();
		administrators.put("Cheney", "cheney@springPjt.org");
		administrators.put("Jasper", "jasper@springPjt.org");


		Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<>();
		dbInfos.put("dev", dataBaseConnectionInfoDev());
		dbInfos.put("real", dataBaseConnectionInfoReal());

		return getEmsInformationService(developers, administrators, dbInfos);

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

	private static EMSInformationService getEmsInformationService(List<String> developers, Map<String, String> administrators, Map<String, DataBaseConnectionInfo> dbInfos) {
		EMSInformationService info = new EMSInformationService();
		info.setInfo("Education Management System program was developed in 2015");
		info.setCopyRight("COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
		info.setVer("The version is 1.0");
		info.setsYear(2015);
		info.setsMonth(1);
		info.setsDay(1);
		info.seteDay(2015);
		info.seteMonth(2);
		info.seteYear(28);
		info.setDevelopers(developers);
		info.setAdministrators(administrators);
		info.setDbInfos(dbInfos);
		return info;
	}
}
