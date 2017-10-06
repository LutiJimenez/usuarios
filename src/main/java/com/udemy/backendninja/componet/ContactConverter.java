package com.udemy.backendninja.componet;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	public Contact convertContactModelToContact(ContactModel contactModel){
		Contact contact = new Contact();
		contact.setCity(contactModel.getCity());
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setTelephone(contactModel.getTelephone());
		contact.setId(contactModel.getId());
		return contact;
	}
	
	public ContactModel convertContactToContactModel(Contact contact){
		ContactModel contactModel = new ContactModel();
		contactModel.setCity(contact.getCity());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setId(contact.getId());
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephone(contact.getTelephone());
		return contactModel;
	}
	
}
