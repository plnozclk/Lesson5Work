package nLayeredDemoWork.adapters.confirmLinkServices;

import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.ErrorResult;
import nLayeredDemoWork.results.Result;
import nLayeredDemoWork.results.SuccessResult;

public class ConfirmationLinkAdapter1 implements ConfirmationLinkService1 {

	@Override
	public Result confirmUser(User user) {
		// Email sent to user... 
				// Sendmail(user.getEmail())
		// wait 3 seconds and approve..
		
		try {
			System.out.println(">> Confirmation Link Service waiting..(2 seconds)..");
			Thread.sleep(1500);
			return new SuccessResult("[ConfirmationLinkService1]> Approved! User clicked the link...");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			return new ErrorResult("[ConfirmationLinkService1]> Could not approved : " + e.getLocalizedMessage());
		}
	}
 
}
