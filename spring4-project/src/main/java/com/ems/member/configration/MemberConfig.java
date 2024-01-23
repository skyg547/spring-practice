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

}
