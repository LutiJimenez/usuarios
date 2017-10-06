package com.udemy.backendninja.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.componet.ContactConverter;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));

		return contactConverter.convertContactToContactModel(contact);
	}
	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts =  contactRepository.findAll();
		List<ContactModel> contacsModel = new ArrayList<ContactModel>();
		for(Contact contact : contacts){
			contacsModel.add(contactConverter.convertContactToContactModel(contact));
		}
	
		return contacsModel;
	}
	@Override
	public Contact findContactByID(int id) {
		return contactRepository.findById(id);
		
	}
	@Override
	public ContactModel findContactModelByID(int id){
		return contactConverter.convertContactToContactModel(findContactByID(id));
	}
	
	@Override
	public void removeContact(int id) {
		Contact contact = findContactByID(id);
		if(contact != null){
			contactRepository.delete(contact);
		}
	}
	
	

}
