package com.github.jacekprucia.mapstruct.spring.mapper;

import com.github.jacekprucia.mapstruct.spring.dto.OutputDto;
import com.github.jacekprucia.mapstruct.spring.entity.InputEntity;
import com.github.jacekprucia.mapstruct.spring.entity.InputEnum;
import java.util.List;
import java.util.Locale;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.context.MessageSource;

@Mapper(componentModel = "spring")
public interface ExampleMapper {

	List<OutputDto> toOutputDtoList(List<InputEntity> inputEntityList);

	@Mapping(source = "propB", target = "description", qualifiedByName = "InputEnumToString")
	OutputDto toOutputDto(InputEntity inputEntity, @Context MessageSource messageSource, @Context Locale locale);

	@Named("InputEnumToString")
	default String inputEnumToString(InputEnum inputEnum, @Context MessageSource messageSource, @Context Locale locale) {
		return messageSource.getMessage(inputEnum.name(), new Object[] {}, locale);
	}

}
