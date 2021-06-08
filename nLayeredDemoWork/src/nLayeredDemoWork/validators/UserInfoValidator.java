package nLayeredDemoWork.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.ErrorResult;
import nLayeredDemoWork.results.Result;
import nLayeredDemoWork.results.SuccessResult;

public class UserInfoValidator implements UserInfoValidatorService {

	@Override
	public Result userInfoValidate(User user) {
		//names not empty & min 2 char
		if((user.getFirstName().length() < 2 ) ||(user.getLastName().length()<2))
		{
			return new ErrorResult("[Validation]> User First Name and/or Last Name can not be Emty or less 2 letters...");	
		}
		//password not empty & min 6 char
		if(user.getPassword().length() <6 )
		{
			return new ErrorResult("[Validation]> Password field can not be less 6 digits..");
		}
		if(emailValidate(user.getePosta()).isSuccess)
		{
			return new SuccessResult("[Validation]> User's informations validated");
		}
		return new ErrorResult("[Validation]> Email is NOT valid!");
	}

	@Override
	public Result emailValidate(String email) {
		String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches() ? new SuccessResult("[Validation]> Email is valid.") : new ErrorResult("[Validation]> Email is NOT valid!");
	}


	

	
}
