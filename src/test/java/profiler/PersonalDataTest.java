package profiler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.niit.profiler.model.PersonalData;
import com.niit.profiler.model.Profile;
import com.niit.profiler.service.PersonalDataRepository;
import com.niit.profiler.service.ProfileRepository;

public class PersonalDataTest {
	
	private PersonalData personalData;
	private PersonalDataRepository personalDataRepository;
	private Profile profile;
	private ProfileRepository profileRepository;

	@Before
	public void setUp() throws Exception {
		
		profileRepository=new ProfileRepository();
		profile=new Profile(32057, "ebinezer", "ebinezer.p87@gmail.com", "9494216610", "M@nojTkumar123", "mentor", false);
		profileRepository.insert(profile);
		
		
		
		personalDataRepository=new PersonalDataRepository();
		personalData=new PersonalData(profile.getProfile_Id(),"ebinezer","perumala","male",new Date("1993/08/08"),false,"hyderabad",30370);
		personalDataRepository.insert(personalData);
	}

	@After
	public void tearDown() throws Exception {
		
		if(profile!=null)
		{
			profileRepository.delete(profile.getProfile_Id());
		}
		
		if(personalData!=null)
		{
			personalDataRepository.delete(personalData.getProfile_Id());
		}
		
		
		profile=null;
		personalData=null;
	}

	@Test
	public void testInsert() {
		
		profile=profileRepository.loginValidate("ebinezer", "M@nojTkumar123");
		
		PersonalData personalData=new PersonalData(profile.getProfile_Id(),"sudhakar","perumala","male",new Date("2000/12/01"),false,"kurnool",30370);
		assertEquals("Insert Personal Data Test case is failed", true,personalDataRepository.insert(personalData));
		personalDataRepository.delete(personalData.getProfile_Id());
	}
	
	
	@Test 
	public void testInsertFailed()
	{
		profile=profileRepository.loginValidate("ebinezer", "M@nojTkumar123");
		//  informat data for city
		PersonalData personalData=new PersonalData(profile.getProfile_Id(),"sudhakar","perumala","male",new Date("2000/12/01"),false,"kur123nool",30370);
		assertEquals("Insert Personal Data Test case is failed", false,personalDataRepository.insert(personalData));
		personalDataRepository.delete(personalData.getProfile_Id());
	}

}
