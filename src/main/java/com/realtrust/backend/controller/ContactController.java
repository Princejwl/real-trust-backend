package com.realtrust.backend.controller;

import com.realtrust.backend.model.Contact;
import com.realtrust.backend.repository.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // SAVE CONTACT
    @PostMapping
    public Contact saveContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    // GET ALL CONTACTS (Admin panel)
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
