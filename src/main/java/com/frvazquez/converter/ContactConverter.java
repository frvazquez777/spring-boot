package com.frvazquez.converter;

import org.springframework.stereotype.Component;

import com.frvazquez.entity.ContactEntity;
import com.frvazquez.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {
	// Entity --> Model
	public ContactModel entityToModel(ContactEntity contact) {
		ContactModel contactModel = new ContactModel();
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephone(contact.getTelephone());
		contactModel.setCity(contact.getCity());
		contactModel.setSu(false);
		return contactModel;
	}

	// Model --> Entity
	public ContactEntity ModelToEntity(ContactModel contactModel) {
		ContactEntity contact = new ContactEntity();
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setTelephone(contactModel.getTelephone());
		contact.setCity(contactModel.getCity());
		return contact;
	}
	
}
