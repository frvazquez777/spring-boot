package com.frvazquez.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.frvazquez.converter.ContactConverter;
import com.frvazquez.entity.ContactEntity;
import com.frvazquez.model.ContactModel;
import com.frvazquez.repository.ContactRepository;
import com.frvazquez.repository.ContactRepositoryQueryDSL;
import com.frvazquez.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	private static final Log LOG = LogFactory.getLog(ContactServiceImpl.class);

	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	@Autowired
	@Qualifier("contactRepositoryQueryDSL")
	private ContactRepositoryQueryDSL contactRepositoryQueryDSL;

	@Override
	public Boolean addContact(ContactModel contactModel) {
		LOG.info("Call: ContactService ADD");
		boolean valid = false;
		ContactEntity contact = contactRepositoryQueryDSL.findByTelephone(contactModel.getTelephone());
		if (contact != null) {

			LOG.info("Contact Exist!!!");
			valid = true;
		} else {
			LOG.info("Contact Added!!");
			contact = contactConverter.ModelToEntity(contactModel);
			contactRepository.save(contact);
		}
		return valid;
	}

	@Override
	public List<ContactModel> allContacts() {
		List<ContactEntity> listContacts = contactRepository.findAll();
		List<ContactModel> list = new ArrayList<ContactModel>();
		for (ContactEntity contact : listContacts) {
			list.add(contactConverter.entityToModel(contact));
		}
		return list;
	}

	@Override
	public ContactModel findByTelephone(String telephone) {
		LOG.info("FIND CONTACT FOR NUMBER TELEPHONE: " + telephone);
		ContactEntity contact = contactRepositoryQueryDSL.findByTelephone(telephone);
		return contactConverter.entityToModel(contact);
	}

	@Override
	public ContactModel updateContact(ContactModel contactModel) {
		LOG.info("Update Contact : "+ contactModel);
		ContactEntity contact = contactRepositoryQueryDSL.findByTelephone(contactModel.getTelephone());
		ContactEntity contactEntity = contactConverter.ModelToEntity(contactModel);
		contactEntity.setId(contact.getId());
		contact = contactRepository.saveAndFlush(contactEntity);
		return contactConverter.entityToModel(contact);
	}

	@Override
	public void removeContact(String telephone) {
		LOG.info("DELECT CONTACT FOR NUMBER TELEPHONE: " + telephone);
		ContactEntity contact = contactRepositoryQueryDSL.findByTelephone(telephone);
		LOG.info("Contact : " + contact);
		contactRepository.delete(contact);
	}

}
