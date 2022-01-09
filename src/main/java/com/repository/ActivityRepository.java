package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>{

}
