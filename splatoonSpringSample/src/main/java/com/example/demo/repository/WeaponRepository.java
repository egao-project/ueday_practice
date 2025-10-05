package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Weapon;

public interface WeaponRepository extends JpaRepository<Weapon, Long>, WeaponRepositoryCustom {

}
