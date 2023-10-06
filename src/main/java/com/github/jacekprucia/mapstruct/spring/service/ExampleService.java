package com.github.jacekprucia.mapstruct.spring.service;

import com.github.jacekprucia.mapstruct.spring.dto.OutputDto;
import com.github.jacekprucia.mapstruct.spring.entity.InputEntity;
import com.github.jacekprucia.mapstruct.spring.mapper.ExampleMapper;
import java.util.List;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExampleService {

	private final Locale locale;
	private final ExampleMapper exampleMapper;
	private final MessageSource messageSource;

	public List<OutputDto> getAllItems(List<InputEntity> inputList) {
		return exampleMapper.toOutputDtoList(inputList);
	}

	public OutputDto getItem(InputEntity inputEntity) {
		return exampleMapper.toOutputDto(inputEntity, messageSource, locale);
	}

}
