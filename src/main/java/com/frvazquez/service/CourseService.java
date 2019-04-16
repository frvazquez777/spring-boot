package com.frvazquez.service;

import java.util.List;

import com.frvazquez.model.CourseModel;

public interface CourseService {

	public abstract List<CourseModel> listAllCourses();

	public abstract CourseModel AddCourse(CourseModel courseModel);

	public abstract int removeCourse(String name);

	public abstract CourseModel updateCourse(String name);
	
}
