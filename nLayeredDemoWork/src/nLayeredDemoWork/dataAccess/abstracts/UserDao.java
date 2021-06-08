package nLayeredDemoWork.dataAccess.abstracts;



import java.util.List;

import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.DataResult;
import nLayeredDemoWork.results.Result;

public interface UserDao {

	
	Result add(User user);
	Result update(User user );
	Result delete (User user);
	
	DataResult<User> getById(int id);
	DataResult<User> getByEmail(String email);
	DataResult<List<User>> getAll();
	
	
	
}
