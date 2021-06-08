package nLayeredDemoWork.business.concretes;

import java.util.List;

import nLayeredDemoWork.adapters.authorizationProviderServices.googleAuthorizationService.GoogleAuthorizationAdapter;
import nLayeredDemoWork.business.abstracts.UserService;
import nLayeredDemoWork.dataAccess.abstracts.UserDao;
import nLayeredDemoWork.dataAccess.concrete.HibetnateUserDao;
import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.DataResult;
import nLayeredDemoWork.results.ErrorDataResult;
import nLayeredDemoWork.results.Result;
import nLayeredDemoWork.validators.UserInfoValidator;
import nLayeredDemoWork.validators.UserInfoValidatorService;

 public class UserManager implements UserService {


	UserDao userDao;
	UserInfoValidatorService infoValidatorService;
	ConfirmationLinkService1 confirmationLinkService1;
	GoogleAuthorizationAdapter authorizationProviderService;
	
	

		public UserManager(UserDao userDao, UserInfoValidatorService infoValidatorService,
				ConfirmationLinkService1 confirmationLinkService1,
				GoogleAuthorizationAdapter googleAuthorizationAdapter) {
			super();
			this.userDao = userDao;
			this.infoValidatorService = infoValidatorService;
			this.confirmationLinkService1 = confirmationLinkService1;
			this.authorizationProviderService = googleAuthorizationAdapter;
		}



		public UserManager(HibetnateUserDao hibernateUserDao, UserInfoValidator infoValidatorService2,
				ConfirmationLinkService1 confirmationLinkService12,
				GoogleAuthorizationAdapter googleAuthorizationAdapter) {
			// TODO Auto-generated constructor stub
		}



		@Override
		public Result add(User user) {
			// first, info validation   ***business rules
			Result result = infoValidatorService.userInfoValidate(user);
			if (!result.isSuccess) {
				return result;
			}
			
			DataResult< User>dresult = userDao.getByEmail(user.getePosta());
			if(dresult.data !=null) {
				return new ErrorDataResult<User>(user, "[UserManager]> User already exists!");
			}
			// simulate sending email to confirmation link 
			System.out.println("[UserManager]> User information accepted!. Confirmation email sent to: \"" + user.getePosta()
					+ "\". Please click the link to confirm and activate your membership! ");

	// link confirmation and add to db
			result = confirmationLinkService1.confirmUser(user);
			if (result.isSuccess) {
				System.out.println(result.message); //print confirmation result
				return userDao.add(user);
			} else {
				return result;
			}
		}



		@Override
		public Result addFromService() {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public Result update(User user) {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public Result delete(User user) {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public DataResult<User> getById(int id) {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public DataResult<User> getByEmail(String email) {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public DataResult<List<User>> getAll() {
			// TODO Auto-generated method stub
			return null;
		}
}
