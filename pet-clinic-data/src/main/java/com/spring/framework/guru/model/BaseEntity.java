package com.spring.framework.guru.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long Id;

}
