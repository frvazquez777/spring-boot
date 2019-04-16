package com.frvazquez.service;

import java.util.List;

import com.frvazquez.model.ContactModel;

public interface ContactService {

	public abstract Boolean addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> allContacts();
	
	public abstract ContactModel findByTelephone(String telephone);
	
	public abstract ContactModel updateContact(ContactModel contactModel);
		
	public abstract void removeContact(String telephone);
	
}
