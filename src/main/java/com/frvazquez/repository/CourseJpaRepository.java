package com.frvazquez.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frvazquez.entity.CourseEntity;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<CourseEntity, Serializable> {

	
}
