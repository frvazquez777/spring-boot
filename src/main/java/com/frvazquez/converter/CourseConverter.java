package com.frvazquez.converter;

import org.springframework.stereotype.Component;

import com.frvazquez.entity.CourseEntity;
import com.frvazquez.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {

	// Entity --> Model
	public CourseModel entityToModel(CourseEntity course) {
		CourseModel courseModel = new CourseModel();
		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getPrice());
		courseModel.setHours(course.getHours());
		courseModel.setSu(false);
		return courseModel;

	}

	// Model --> Entity
	public CourseEntity ModelToEntity(CourseModel courseModel) {
		CourseEntity course = new CourseEntity();
		course.setName(courseModel.getName());
		course.setDescription(courseModel.getDescription());
		course.setPrice(courseModel.getPrice());
		course.setHours(courseModel.getHours());
		return course;
	}
	
}
