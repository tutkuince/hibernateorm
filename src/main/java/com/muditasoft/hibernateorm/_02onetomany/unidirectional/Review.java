package com.muditasoft.hibernateorm._02onetomany.unidirectional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author tutku ince
 *
 *         Oct 29, 2018
 */

@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "comment")
	private String comment;

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String comment) {
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + "]";
	}

}
