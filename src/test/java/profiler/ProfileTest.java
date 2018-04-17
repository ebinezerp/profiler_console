package profiler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.niit.profiler.model.Profile;
import com.niit.profiler.service.ProfileRepository;

public class ProfileTest {

	ProfileRepository profileRepository;
	Profile profile;
	
	@Before
	public void setUp() throws Exception {
		
		profileRepository=new ProfileRepository();
		if(profile!=null)
		{
			profileRepository.delete(profile.getProfile_Id());
		}
		
		profile=new Profile(32057, "ebinezer", "ebinezer.p87@gmail.com", "9494216610", "M@nojTkumar123", "mentor", false);
		profileRepository.insert(profile);
	}

	@After
	public void tearDown() throws Exception {
		profileRepository.delete(profile.getProfile_Id());
		profile=null;
	}

	/*@Test
	public void testProfileRepository() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testInsert() {
		Profile newProfile=new Profile(32051, "sudhkar", "sudhakar.p87@gmail.com", "9087654321", "M@nojTkumar123", "mentor", false);
		assertEquals("Insert Test Case is failed for"+profile,true,profileRepository.insert(newProfile));
		profileRepository.delete(newProfile.getProfile_Id());
	}

	@Test
	public void testInsertFailure()
	{
		Profile newProfile=new Profile(32057, "ebinezer", "ebinezer.p87@gmail.com", "9494216610", "M@nojTkumar123", "mentor", false);
		assertNotEquals("InsertFailure Test Case is failed for"+profile,true,profileRepository.insert(newProfile));
		profileRepository.delete(newProfile.getProfile_Id());
	}
	@Test
	public void testInsertFailureWithLargeProfileId()
	{
		Profile newProfile=new Profile(3205790876l, "ebinezer", "ebinezer.p87@gmail.com", "9494216610", "M@nojTkumar123", "mentor", false);
		assertNotEquals("InsertFailure Test Case is failed for"+profile,true,profileRepository.insert(newProfile));
		profileRepository.delete(newProfile.getProfile_Id());
	}
	
	
	@Test 
	public void testInsertFailureRegExperssion()
	{
		Profile newProfile=new Profile(32051, "sudhkar", "sudhakar.p87@gmail.com", "2087654321", "M@nojTkumar123", "mentor", false);
		assertNotEquals("Insert Test Case is failed for"+profile,true,profileRepository.insert(newProfile));
		profileRepository.delete(newProfile.getProfile_Id());
	}
	
	
	@Test
	public void testProfileAccept()
	{
		assertEquals("Profile Accept Test Case is failed for"+profile,true,profileRepository.profileAccept(profile.getProfile_Id()));
	}
	
	
	
	
	@Test
	public void testUpdateProfile()
	{
		profile.setPassword("Abcd@12345");
		assertEquals("Update profile test failed",true,profileRepository.update(profile));
	}
	
	
	
	@Test
	public void testUpdateFailed()
	{
		Profile newProfile=new Profile(32051, "sudhkar", "sudhakar.p87@gmail.com", "8087654321", "M@nojTkumar123", "mentor", false);
		assertEquals("Update failer test case failed",false,profileRepository.update(newProfile));
	}
}
