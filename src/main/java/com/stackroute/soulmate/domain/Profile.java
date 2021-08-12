package com.stackroute.soulmate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity @Table
@JacksonXmlRootElement
@RequiredArgsConstructor
@AllArgsConstructor
public @Data class Profile {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JacksonXmlProperty
	private int id;
	@JacksonXmlProperty
	private String name;
	@JacksonXmlProperty
	private String gender;
	@JacksonXmlProperty
	private int age;
	
}
