package org.dsi.entity;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data @AllArgsConstructor @NoArgsConstructor
public class Photo {
	private Long id;
	private String dateCreation;
	private String dateModification;
}
