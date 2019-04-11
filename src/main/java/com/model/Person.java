package com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private Date birthDate;
    
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
	private List<ProcessInstanceFlow> processInstanceFlows;

    public Person() {
    }

    public Person(String username, String firstName, String lastName, Date birthDate) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

	public List<ProcessInstanceFlow> getProcessInstanceFlows() {
		return processInstanceFlows;
	}

	public void setProcessInstanceFlows(List<ProcessInstanceFlow> processInstanceFlows) {
		this.processInstanceFlows = processInstanceFlows;
	}
}