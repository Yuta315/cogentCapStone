package com.vending.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vending.entities.*;

@Repository
public interface ContainerRepository  extends JpaRepository<Container, Integer>{

}
