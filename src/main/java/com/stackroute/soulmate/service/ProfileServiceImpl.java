package com.stackroute.soulmate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.soulmate.domain.Profile;
import com.stackroute.soulmate.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	ProfileRepository repository;
	
	@Override
	public Profile addProfile(Profile profile) {
		return repository.save(profile);
	}

	@Override
	public Profile updateProfile(Integer id, Profile profile) throws Exception {
		if (repository.existsById(id)) {
			profile.setId(id);
			repository.save(profile);
			return profile;
		}
		throw new Exception("Profile does not Exists!");
	}

	@Override
	public void deleteProfileById(int id) throws Exception {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}
		throw new Exception("Profile does not Exists!");
		
	}

	@Override
	public List<Profile> getAll() {
		return (List<Profile>) repository.findAll();
	}

	@Override
	public List<Profile> getAllProfilesByName(String name) {
		return repository.getAllProfileByName(name);
	}

	@Override
	public List<Profile> getAllProfilesByGender(String gender) {
		return repository.getAllProfileByGender(gender);
	}

	@Override
	public List<Profile> getAllProfilesByAge(int age) {
		return repository.getAllProfileByAge(age);
	}

	@Override
	public List<Profile> getAllProfilesByAgeAndGender(String gender, int age) {
		return repository.getAllProfileByAgeAndGender(gender, age);
	}

}
