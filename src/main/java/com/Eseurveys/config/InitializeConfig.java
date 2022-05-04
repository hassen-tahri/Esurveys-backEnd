package com.Eseurveys.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.Eseurveys.model.entity.User;
import com.Eseurveys.service.UserService;

@Configuration
public class InitializeConfig implements InitializingBean {

	@Autowired
	private UserService userService;

	@Autowired
	private Environment env;

	@Bean
	public void initVitrineAndUser() {
		User user = new User();
		long i = 1;
		user.setId(i);
		user.setPseudo(env.getProperty("defaultUserName"));
		user.setMpd(env.getProperty("defaultUserPassword"));
		user.setRole(env.getProperty("defaultUserRole"));
		userService.updateUser(user, i);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}
}
