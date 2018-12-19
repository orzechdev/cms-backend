
package com.hello;

import javax.persistence.*;

@Entity
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
