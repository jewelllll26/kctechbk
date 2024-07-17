package com.kctech.kctechbk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kctech.kctechbk.Model.User;



public interface UserRepository extends JpaRepository <User, Long>{

}