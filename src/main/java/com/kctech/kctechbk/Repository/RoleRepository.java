package com.kctech.kctechbk.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kctech.kctechbk.Model.Role;




public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);

}
