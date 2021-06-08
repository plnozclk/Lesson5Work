package nLayeredDemoWork.business.abstracts;



import java.util.List;

import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.DataResult;
import nLayeredDemoWork.results.Result;

public interface UserService {
 
	
	Result add(User user);
	Result addFromService();
	Result update(User user);
	Result delete(User user);
	
	DataResult<User>getById(int id);
	DataResult<User> getByEmail(String email);
	DataResult<List<User>> getAll();
}
