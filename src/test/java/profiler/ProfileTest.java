package profiler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.niit.profiler.model.Profile;
import com.niit.profiler.service.ProfileRepository;

public class ProfileTest {

	private ProfileRepository profileRepository;
	private Profile profile;
	
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
	public void testUpdateProfileFailure()
	{
		Profile newProfile=new Profile(32051, "sudhkar", "sudhakar.p87@gmail.com", "8087654321", "M@nojTkumar123", "mentor", false);
		assertEquals("Update failer test case failed",false,profileRepository.update(newProfile));
	}
	
	
	
	
	@Test
	public void testGetProfile()
	{
		Profile newProfile=profileRepository.getProfile(profile.getProfile_Id());
		assertEquals(profile, newProfile);
	}
	
	
	@Test
	public void testGetProfileFailure()
	{
		assertNull("get profile failure test case is failed",profileRepository.getProfile(3000));
	}
	
	
	
	
	@Test
	public void testGetUnApprovedProfiles()
	{
		
		Profile newProfile1=new Profile(32051, "sudhkar1", "sudhakar.p871@gmail.com", "8087654321", "M@nojTkumar121", "mentor", false);
		Profile newProfile2=new Profile(32052, "sudhkar2", "sudhakar.p872@gmail.com", "8087654322", "M@nojTkumar122", "mentor", true);
		Profile newProfile3=new Profile(32053, "sudhkar3", "sudhakar.p873@gmail.com", "8087654323", "M@nojTkumar123", "mentor", false);
		Profile newProfile4=new Profile(32054, "sudhkar4", "sudhakar.p874@gmail.com", "8087654324", "M@nojTkumar124", "mentor", true);
		Profile newProfile5=new Profile(32055, "sudhkar5", "sudhakar.p875@gmail.com", "8087654325", "M@nojTkumar125", "mentor", false);
		
		profileRepository.insert(newProfile1);
		profileRepository.insert(newProfile2);
		profileRepository.insert(newProfile3);
		profileRepository.insert(newProfile4);
		profileRepository.insert(newProfile5);
		
		assertEquals("testGetUnApprovedProfiles... ",4,profileRepository.getUnApprovedProfiles().size());
		
		
		profileRepository.delete(newProfile1.getProfile_Id());
		profileRepository.delete(newProfile2.getProfile_Id());
		profileRepository.delete(newProfile3.getProfile_Id());
		profileRepository.delete(newProfile4.getProfile_Id());
		profileRepository.delete(newProfile5.getProfile_Id());
		
	}
	
	
	
	
	@Test
	public void testLoginValidation()
	{
		assertEquals("Login validation test failed",profile,profileRepository.loginValidate(profile.getUsername(), profile.getPassword()));
	}
	
	
	
	@Test
	public void testLoginValidationFailed()
	{
		assertNull("Login validation failure test failed",profileRepository.loginValidate("ramu", profile.getPassword()));
	}
}
