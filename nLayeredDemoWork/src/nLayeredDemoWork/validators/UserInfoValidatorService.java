package nLayeredDemoWork.validators;

import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.Result;

public interface UserInfoValidatorService {

	Result userInfoValidate(User user);
	Result emailValidate(String email);
	
}
