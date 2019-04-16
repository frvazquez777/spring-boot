package com.frvazquez.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.frvazquez.entity.ContactEntity;
import com.frvazquez.entity.QContactEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("contactRepositoryQueryDSL")
public class ContactRepositoryQueryDSL {

private QContactEntity qContact = QContactEntity.contactEntity;
	
	@PersistenceContext
	private EntityManager em;
	
	public ContactEntity findByTelephone(String telephone) {

		JPAQuery<ContactEntity> query = new JPAQuery<ContactEntity>(em);

		Predicate predicate = qContact.telephone.endsWith(telephone);
		BooleanBuilder predicaBuilder = new BooleanBuilder(predicate);

		return query.select(qContact).from(qContact).where(predicaBuilder).fetchOne();
	}
	
}
