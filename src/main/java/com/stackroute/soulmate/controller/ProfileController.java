package com.stackroute.soulmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.soulmate.domain.Profile;
import com.stackroute.soulmate.service.ProfileService;

@RestController
@RequestMapping("api/v1")
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@PostMapping("/profile")
	public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
		try {
			return new ResponseEntity<Profile>(service.addProfile(profile),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Profile>(HttpStatus.CONFLICT);
		}
		
	}
	
	@PutMapping("/profile/{id}")
	public ResponseEntity<Profile> updateProfile(@PathVariable Integer id , @RequestBody Profile profile) {
		try {
			return new ResponseEntity<Profile>(service.updateProfile(id,profile),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/profile/{id}")
	public ResponseEntity<?>  deleteById(@PathVariable int id) {
		try {
			service.deleteProfileById(id);
			return new ResponseEntity<Profile>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
		}		 
	}
	
	@GetMapping("/profile")
	public ResponseEntity<List<Profile>> getAll() {
		try {
			return new ResponseEntity<List<Profile>>((List<Profile>) service.getAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Profile>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/profile/name/{name}")
	public ResponseEntity<List<Profile>>  getAllProfileByName(@PathVariable("name") String name) {
		try {
			return new ResponseEntity<List<Profile>>(service.getAllProfilesByName(name),HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<List<Profile>>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@GetMapping("/profile/gender/{gender}")
	public ResponseEntity<List<Profile>>  getAllProfileByGender(@PathVariable("gender") String gender) {
		try {
			return new ResponseEntity<List<Profile>>(service.getAllProfilesByGender(gender) ,HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<List<Profile>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/profile/age/{age}")
	public ResponseEntity<List<Profile>>  getProfileByAge(@PathVariable("age") int age) {
		try {
			return new ResponseEntity<List<Profile>>(service.getAllProfilesByAge(age),HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<List<Profile>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/profile/gender/age/{gender}/{age}")
	public ResponseEntity<List<Profile>> getAllProfileByAgeAndGender(@PathVariable("gender") String gender,@PathVariable("age") int age) {
		try {
			return new ResponseEntity<List<Profile>>(service.getAllProfilesByAgeAndGender(gender, age),HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<List<Profile>>(HttpStatus.NOT_FOUND);
		}
	}
}
