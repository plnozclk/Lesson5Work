package nLayeredDemoWork.adapters.authorizationProviderServices.providerService;

import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.DataResult;

public interface AuthorizationProviderService {
public DataResult<User>getUserInfo();

}

