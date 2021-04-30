package com.library.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetailsDto {

	private int status;
	private String title;
	private String description;
	
	public ErrorDetailsDto(int status, String title, String description) {
		super();
		this.status = status;
		this.title = title;
		this.description = description;
	}
}