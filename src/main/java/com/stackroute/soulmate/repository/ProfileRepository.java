package com.stackroute.soulmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.soulmate.domain.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {

	@Query("select  e  from Profile e  where e.name =?1")
	public  List<Profile>  getAllProfileByName(String name);
	
	@Query("select  e  from Profile e  where e.gender =?1")
	public  List<Profile>  getAllProfileByGender(String gender);
	
	@Query("select  e  from Profile e  where e.age =?1")
	public  List<Profile>  getAllProfileByAge(int age);
	
	@Query("select e from Profile e where e.gender=?1 and e.age=?2")
	public List<Profile> getAllProfileByAgeAndGender(@Param("gender") String gender,@Param("age") int age);
}
