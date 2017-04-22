package org.ravi.mybrains.messanger.service;


import org.ravi.mybrains.messanger.database.DatabaseClass;
import org.ravi.mybrains.messanger.model.Profile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {
	

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Ravi Teja", new Profile(1L, "Ravi", "Teja", "Papasani"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}



