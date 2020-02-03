package com.example.demospringsecurityform.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Account
 */
@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String username;

    private String password;

    private String role;

	public void encodePassword() {
        this.password = "{noop}" + this.password;
	}
}