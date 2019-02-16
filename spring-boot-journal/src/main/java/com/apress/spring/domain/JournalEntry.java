package com.apress.spring.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.apress.spring.utils.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="entry")	// 하이버네이트는 @Table 애너테이션을 보고 entry라는 테이블을 생성한다.
public class JournalEntry {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	// pk필드 명시
	private Long id;
	private String title;
	private Date created;
	private String summary;
	
	@Transient	// 해당 멤버(필드)는 제외
	private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public JournalEntry(String title, String summary, String date) throws ParseException {
		this.title = title;
		this.summary = summary;
		this.created = format.parse(date);
	}
	
	public JournalEntry() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonSerialize(using=JsonDateSerializer.class)	// JsonDateSerializer <- 커스텀 클래스로 직렬화 (날짜를 특정형식으로 나타낼때)  
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@JsonIgnore	// json 문자열로 나타낼 때 대상에서 제외하라는 뜻임.
	public String getCreatedAsShort() {
		return format.format(created);
	}
	
	@Override
	public String toString() {
		StringBuilder value = new StringBuilder("* JournalEntry(");
		value.append("Id: ");
		value.append(id);
		value.append(",제목: ");
		value.append(title);
		value.append(",요약: ");
		value.append(summary);
		value.append(",작성일자: ");
		value.append(format.format(created));
		value.append(")");
		
		return value.toString();
	}
}
