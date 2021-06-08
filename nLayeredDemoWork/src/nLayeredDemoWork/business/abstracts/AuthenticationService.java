package nLayeredDemoWork.business.abstracts;

import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.DataResult;

public interface AuthenticationService {
  public DataResult<User> auDataResult (User user);
}
