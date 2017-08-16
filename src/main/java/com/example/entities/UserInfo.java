package com.example.entities;



import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity

public class UserInfo implements Serializable {

    /**

     * 

     */

    private static final long serialVersionUID = 1L;

    public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String role, String username, String password, String passwordConfirm) {
		super();
		this.role = role;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}

	@Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idUser;

    public UserInfo(String role, String username, String password) {
		super();
		this.role = role;
		this.username = username;
		this.password = password;
	}

	private String role;

    private String username;

    private String password;

    private String passwordConfirm;

    public int getIdUser() {

        return idUser;

    }

    public void setIdUser(int idUser) {

        this.idUser = idUser;

    }

    public String getRole() {

        return role;

    }

    public void setRole(String role) {

        this.role = role;

    }

    public String getUsername() {

        return username;

    }

    public void setUsername(String username) {

        this.username = username;

    }

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {

        this.password = password;

    }

    public String getPasswordConfirm() {

        return passwordConfirm;

    }

    public void setPasswordConfirm(String passwordConfirm) {

        this.passwordConfirm = passwordConfirm;

    }

}