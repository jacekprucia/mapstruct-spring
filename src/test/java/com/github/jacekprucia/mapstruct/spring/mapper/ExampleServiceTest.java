package com.github.jacekprucia.mapstruct.spring.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.github.jacekprucia.mapstruct.spring.dto.OutputEnum;
import com.github.jacekprucia.mapstruct.spring.entity.InputEntity;
import com.github.jacekprucia.mapstruct.spring.entity.InputEnum;
import com.github.jacekprucia.mapstruct.spring.service.ExampleService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExampleServiceTest {

	@Autowired
	private ExampleService exampleService;

	@Test
	void checkMapping() {
		// arrange
		final var inputEntity = InputEntity.builder()
			.id(1L)
			.propA(Boolean.TRUE)
			.propB(InputEnum.FIRST)
			.propC("test")
			.build();
		// act
		final var outputDto = exampleService.getItem(inputEntity);
		// assert
		assertEquals(Boolean.TRUE, outputDto.getPropA());
		assertEquals(OutputEnum.FIRST, outputDto.getPropB());
		assertEquals("test", outputDto.getPropC());
		assertEquals("First option", outputDto.getDescription());
	}

	@Test
	void checkMultipleMapping() {
		// arrange
		final var inputEntityA = InputEntity.builder()
			.id(1L)
			.propA(Boolean.TRUE)
			.propB(InputEnum.FIRST)
			.propC("test A")
			.build();
		final var inputEntityB = InputEntity.builder()
			.id(2L)
			.propA(Boolean.FALSE)
			.propB(InputEnum.SECOND)
			.propC("test B")
			.build();
		// act
		final var outputDto = exampleService.getAllItems(List.of(inputEntityA, inputEntityB));
		// assert
		outputDto.forEach(item -> {
			assertNotNull(item.getDescription());
		});

	}

}
