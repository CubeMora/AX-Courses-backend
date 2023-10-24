package com.cubemora.ax_courses.controllers;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cubemora.ax_courses.models.testimonialRepository;
import com.cubemora.ax_courses.models.testimonials;



@RestController
@RequestMapping("/api/testimonials")
public class testController {

    @Autowired
    private testimonialRepository testimonialRepository;

    // CREATE
    @PostMapping("/")
    public ResponseEntity<testimonials> createTestimonial(@RequestBody testimonials testimonial) {
        testimonials newTestimonial = testimonialRepository.save(testimonial);
        return new ResponseEntity<>(newTestimonial, HttpStatus.CREATED);
    }

    // GET
    @GetMapping("/")
    public ResponseEntity<List<testimonials>> getAllTestimonials() {
        List<testimonials> testimonials = testimonialRepository.findAll();
        return new ResponseEntity<>(testimonials, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<testimonials> updateTestimonial(@PathVariable Long id,
            @RequestBody testimonials updatedTestimonial) {
        Optional<testimonials> existingTestimonial = testimonialRepository.findById(id);
        if (existingTestimonial.isPresent()) {
            testimonials testimonial = existingTestimonial.get();
            testimonial.setNameTestimonial(updatedTestimonial.getNameTestimonial());
            testimonial.setImgUrl(updatedTestimonial.getImgUrl());
            testimonial.setDescriptionTestimonial(updatedTestimonial.getDescriptionTestimonial());
            testimonial.setProfessionTestimonial(updatedTestimonial.getProfessionTestimonial());
            testimonials updated = testimonialRepository.save(testimonial);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestimonial(@PathVariable Long id) {
        testimonialRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> headTestimonial(@PathVariable Long id) {
        // ID Exists?
        Optional<testimonials> testimonial = testimonialRepository.findById(id);
        if (testimonial.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            // HEADERS goes here
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> optionsTestimonial(@PathVariable Long id) {
        // ID allowed options
        HttpHeaders headers = new HttpHeaders();
        // HEADERS for the ID
        headers.add("Allow", "GET, POST, PUT, DELETE, HEAD, OPTIONS, PATCH"); 
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<testimonials> patchTestimonial(@PathVariable Long id,
            @RequestBody Map<String, Object> partialUpdates) {
        Optional<testimonials> existingTestimonial = testimonialRepository.findById(id);

        if (existingTestimonial.isPresent()) {
            testimonials testimonial = existingTestimonial.get();
            
            if (partialUpdates.containsKey("nameTestimonial")) {
                testimonial.setNameTestimonial((String) partialUpdates.get("nameTestimonial"));
            }
            if (partialUpdates.containsKey("imgUrl")) {
                testimonial.setImgUrl((String) partialUpdates.get("imgUrl"));
            }
            if (partialUpdates.containsKey("descriptionTestimonial")) {
                testimonial.setDescriptionTestimonial((String) partialUpdates.get("descriptionTestimonial"));
            }
            if (partialUpdates.containsKey("professionTestimonial")) {
                testimonial.setProfessionTestimonial((String) partialUpdates.get("professionTestimonial"));
            }
            testimonials updated = testimonialRepository.save(testimonial);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
