package com.frvazquez.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.frvazquez.converter.CourseConverter;
import com.frvazquez.entity.CourseEntity;
import com.frvazquez.model.CourseModel;
import com.frvazquez.repository.CourseJpaRepository;
import com.frvazquez.repository.QueryDSLExampleRepo;
import com.frvazquez.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;

	@Autowired
	@Qualifier("queryDSLExampleRepo")
	private QueryDSLExampleRepo queryDSLExampleRepo;

	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;

	@Override
	public List<CourseModel> listAllCourses() {
		LOG.info("Call: List Courses");
		// obtenemos la lista de coursos
		List<CourseEntity> courses = courseJpaRepository.findAll();
		List<CourseModel> list = new ArrayList<CourseModel>();
		for (CourseEntity course : courses) {
			CourseModel model = courseConverter.entityToModel(course);
			list.add(model);
		}

		return list;
	}

	@Override
	public CourseModel AddCourse(CourseModel courseModel) {
		LOG.info("Call: Save Update -- " + courseModel);
		CourseEntity course = queryDSLExampleRepo.findByName(courseModel.getName());
		CourseEntity courseTemp = courseConverter.ModelToEntity(courseModel);
		if (course != null) {
			courseTemp.setId(course.getId());
		}

		if (courseModel.isSu()) {
			LOG.info("Update Course: " + courseTemp);
			course = courseJpaRepository.saveAndFlush(courseTemp);
		} else {
			LOG.info("Save Course: " + courseTemp);
			course = courseJpaRepository.save(courseTemp);
		}
		courseModel = courseConverter.entityToModel(course);
		return courseModel;
	}

	@Override
	public int removeCourse(String name) {
		int value = 0;
		CourseEntity course = queryDSLExampleRepo.findByName(name);
		try {
			courseJpaRepository.delete(course);
			value = 1;
		} catch (Exception e) {
			value = -1;
		}
		return value;
	}

	@Override
	public CourseModel updateCourse(String name) {
		CourseEntity course = queryDSLExampleRepo.findByName(name);
		return courseConverter.entityToModel(course);
	}

}
