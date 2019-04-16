package com.frvazquez.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.frvazquez.entity.CourseEntity;
import com.frvazquez.entity.QCourseEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	private QCourseEntity qCourse = QCourseEntity.courseEntity;
	
	@PersistenceContext
	private EntityManager em;
	
	public CourseEntity findByName(String name) {

		JPAQuery<CourseEntity> query = new JPAQuery<CourseEntity>(em);

		Predicate predicate = qCourse.name.endsWith(name);
		BooleanBuilder predicaBuilder = new BooleanBuilder(predicate);

		return query.select(qCourse).from(qCourse).where(predicaBuilder).fetchOne();
	}
	
//	public void find(boolean exist) {
		
//		JPAQuery<Course> query = new JPAQuery<Course>(em);
//		
//		Predicate predicate1 = qCourse.description.endsWith("OP");
//		BooleanBuilder predicaBuilder = new BooleanBuilder(predicate1);
//		//agregale opcionalmente los valores
//		if(exist) {
//			Predicate predicate2 = qCourse.id.eq(23);
//			predicaBuilder.and(predicate2);
//		} else {
//			Predicate predicate3 = qCourse.name.endsWith("OP");
//			predicaBuilder.or(predicate3);
//		}

		//consulta especifica con campos especificos
//		Course course = query.select(qCourse).from(qCourse).where(predicaBuilder).fetchOne();
		//consulta especifica de manera manual
//		course = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		
		//consulta de columnas especificas
//		 course = (Course) query.select(qCourse.name, qCourse.description, qCourse.price).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		
		 //coonsulta de lista entre intervalo
//		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
		
//	}
}
