package com.github.jacekprucia.mapstruct.spring.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputEntity {

	private Long id;
	private Boolean propA;
	private InputEnum propB;
	private String propC;

}
