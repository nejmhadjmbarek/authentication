package com.example.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.stereotype.Repository;

import com.example.entities.UserInfo;

@Repository

@RepositoryRestResource

public interface UserInfoRepository extends JpaRepository<UserInfo, Serializable> {

   
    UserInfo findByUsername(String username);

}