package com.reserpadel;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class Messages {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("classpath:messages.properties");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	/*
	@Bean
	public String validateTime(String time) {
		try {
			LocalTime.parse(time);
			System.out.println("Valid time string: " + time);
		} catch (DateTimeParseException | NullPointerException e) {
			System.out.println("Invalid time string: " + time);
		}
		return time;
	}
	*/
}