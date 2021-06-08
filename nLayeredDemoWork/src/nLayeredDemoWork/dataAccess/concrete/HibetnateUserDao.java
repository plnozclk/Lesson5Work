package nLayeredDemoWork.dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;

import nLayeredDemoWork.dataAccess.abstracts.UserDao;
import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.DataResult;
import nLayeredDemoWork.results.ErrorDataResult;
import nLayeredDemoWork.results.ErrorResult;
import nLayeredDemoWork.results.Result;
import nLayeredDemoWork.results.SuccessDataResult;
import nLayeredDemoWork.results.SuccessResult;

public class HibetnateUserDao implements UserDao{

	private static List<User> InMemoryUsers = new ArrayList<>();
	@Override
	public Result add(User user) {
	 user.setId(InMemoryUsers.size()+1);
	 if(InMemoryUsers.add(user))
	 {
		 return new SuccessResult("[HibernateUserDao]>User added! :"+user.getFirstName()+""+user.getLastName());
	 }
		return new ErrorResult("[HibernateUserDao]>Warning ! User could not add!");
	}

	@Override
	public Result update(User user) {
		for(User _user : InMemoryUsers) {
			if (_user.getId()== user.getId()) {
				InMemoryUsers.remove(_user);
				InMemoryUsers.add(user);
				return new SuccessResult("[HibernateUserDao]>User added: " +user.getFirstName()+ "" + user.getLastName());
				
			}
		}
		return new ErrorResult("[HibernateUserDao]>User not Found");
	}

	@Override
	public Result delete(User user) {
		if(InMemoryUsers.remove(user)) {
			return new SuccessResult("[HibernateUserDao]>User deleted : " + user.getFirstName() + " " +user.getLastName());
			}
		return new  ErrorResult("[HibernateUserDao]>User not found!");
	}

	@Override
	public DataResult<User> getById(int id) {
		for (User user : InMemoryUsers) {
			if(user.getId()==id) {
				return new SuccessDataResult<User>(user, "[HibernateUserDao]> User found : " + user.getFirstName() + " " + user.getLastName());
			}
		}
		
		return new ErrorDataResult<User>(null, "[HibernateUserDao]> User not found!");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		for(User user :InMemoryUsers) {
			if (user.getePosta()==email) {
				return new SuccessDataResult<User>(user, "[HibernateUserDao]> User exists : " );
			}
		}
		return new ErrorDataResult<User>(null, "[HibernateUserDao]> User not found!");
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(InMemoryUsers, "[HibernateUserDao]> All users returned");
	}

	
	
}
