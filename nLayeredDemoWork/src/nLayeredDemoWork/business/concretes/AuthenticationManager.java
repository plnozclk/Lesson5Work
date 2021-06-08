package nLayeredDemoWork.business.concretes;

import nLayeredDemoWork.business.abstracts.AuthenticationService;
import nLayeredDemoWork.dataAccess.abstracts.UserDao;
import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.DataResult;
import nLayeredDemoWork.results.ErrorDataResult;

public class AuthenticationManager implements AuthenticationService {

	UserDao userDao;
	
	public AuthenticationManager(UserDao userDao) {
		this.userDao=userDao;
	}

	

	@Override
	public DataResult<User> auDataResult(User user) {
		DataResult<User>dresult = userDao.getByEmail(user.getePosta());
		if(dresult.data==null) {
			return new ErrorDataResult<User>(user, "[AuthenticationManager]> User not found!");
		}
		if(dresult.data.getPassword()==user.getePosta()) {
			return new ErrorDataResult<User>(user, "[AuthenticationManager]> User authenticated...Welcome"
					+dresult.data.getFirstName()+""+dresult.data.getLastName());
		}
		return new ErrorDataResult<User>(user, "[AuthenticationManager]> Invalid password, please try again!");
	}



	public Object authenticateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
	
	
}
