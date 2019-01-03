package com.cms.entity;

import javax.persistence.*;

@Entity
@Table(name = "sqltest", schema="dbo")
public class SQLTest {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

	private String name;
	
	public String getName() {
        return name;
    }
	
	public void setName(String name) {
        this.name=name;
    }
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}

}
