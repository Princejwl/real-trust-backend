package com.realtrust.backend.controller;

import com.realtrust.backend.model.Contact;
import com.realtrust.backend.repository.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://realtrustt.netlify.app/"
})
@RestController
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // ROOT URL
    @GetMapping("/")
    public String home() {
        return "Backend is running successfully";
    }

    // SAVE CONTACT
    @PostMapping("/api/contacts")
    public Contact saveContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    // GET ALL CONTACTS (Admin Panel)
    @GetMapping("/api/contacts")
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
