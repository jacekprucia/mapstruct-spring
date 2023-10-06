package com.github.jacekprucia.mapstruct.spring.configuration;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocaleConfiguration {

	@Bean
	public Locale defaultLocale() {
		return Locale.US;
	}

}
