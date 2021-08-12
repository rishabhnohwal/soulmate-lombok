package com.stackroute.soulmate.service;

import java.util.List;

import com.stackroute.soulmate.domain.Profile;

public interface ProfileService {
	
	public Profile addProfile(Profile profile);
	public Profile updateProfile(Integer id,Profile profile) throws Exception;
	public void deleteProfileById(int id) throws Exception;
	public Iterable<Profile> getAll();
	public List<Profile> getAllProfilesByName(String name);
	public List<Profile> getAllProfilesByGender(String gender);
	public List<Profile> getAllProfilesByAge(int age);
	public List<Profile> getAllProfilesByAgeAndGender(String gender, int age);
}
