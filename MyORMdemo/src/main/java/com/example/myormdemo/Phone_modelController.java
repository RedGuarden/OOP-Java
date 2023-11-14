package com.example.myormdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/phone_model")
public class Phone_modelController {
    @Autowired
    private PhoneModelRepository phoneModelRepository;

    @GetMapping("/phone_model")
    public List<Phone> getAllphoneModel(){
        return phoneModelRepository.findAll();
    }

    @GetMapping("/phone_model/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable(value = "id") Long phoneId)
            throws Exception {
        Phone phone = phoneModelRepository.findById(phoneId)
                .orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));
        return ResponseEntity.ok().body(phone);
    }

    @PostMapping("/phone_model")
    public Phone createPhone(@Valid @RequestBody Phone phone) {
        return phoneModelRepository.save(phone);
    }

    // PUT method to update a phone's details
    @PutMapping("/phone_model/{id}")
    public ResponseEntity<Phone> updatePhone(
            @PathVariable(value="id") Long phoneId, @Valid @RequestBody Phone phoneDetails
    ) throws Exception {
        Phone phone = phoneModelRepository.findById(phoneId)
                .orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));

        phone.setPhoneName(phoneDetails.getPhoneName());
        phone.setOs(phoneDetails.getOs());

        final Phone updatedPhone = phoneModelRepository.save(phone);
        return ResponseEntity.ok(updatedPhone);
    }

    // DELETE method to delete a phone
    @DeleteMapping("/phone_model/{id}")
    public Map<String, Boolean> deletePhone(@PathVariable(value="id") Long phoneId) throws Exception {
        Phone phone = phoneModelRepository.findById(phoneId)
                .orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));

        phoneModelRepository.delete(phone);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
