package nLayeredDemoWork.adapters.authorizationProviderServices.googleAuthorizationService;

import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.DataResult;
import nLayeredDemoWork.results.ErrorDataResult;
import nLayeredDemoWork.results.SuccessDataResult;

public class GoogleAuthorizationAdapter implements GoogleAuthorizationService {
 
	private User user;
	
	 public GoogleAuthorizationAdapter() {
		 this.user = new User( "pelin", "Özçelik", " ", "pelinn.ozcelikk@gmail.com",0);
	 }

	@Override
	public DataResult<User> getUserInfo() {
	try {
		System.out.println(">> Google Authorization Service waiting..(1 second)..");
		//wait 1 second and return users info without password
	Thread.sleep(1000);
	return new SuccessDataResult<User>(user, "[GoogleAuthorizationService]> Returning Google Authorization for user..");
	} catch (InterruptedException e) {
	e.printStackTrace();
	return new ErrorDataResult<User>(null,
			"[GoogleAuthorizationService]> Could not get User's informations :" + e.getLocalizedMessage());
}

}

	

	
}
