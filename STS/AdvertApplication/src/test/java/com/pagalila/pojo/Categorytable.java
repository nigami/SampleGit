package com.pagalila.pojo;
// Generated Mar 30, 2016 8:01:48 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categorytable generated by hbm2java
 */
@Entity
@Table(name = "categorytable", catalog = "lab8")
public class Categorytable implements java.io.Serializable {

	private Long id;
	private String title;
	private Set adverttables = new HashSet(0);

	public Categorytable() {
	}

	public Categorytable(String title) {
		this.title = title;
	}

	public Categorytable(String title, Set adverttables) {
		this.title = title;
		this.adverttables = adverttables;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorytable")
	public Set getAdverttables() {
		return this.adverttables;
	}

	public void setAdverttables(Set adverttables) {
		this.adverttables = adverttables;
	}

}
