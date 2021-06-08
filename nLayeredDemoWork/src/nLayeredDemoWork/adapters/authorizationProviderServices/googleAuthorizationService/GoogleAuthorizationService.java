package nLayeredDemoWork.adapters.authorizationProviderServices.googleAuthorizationService;

import nLayeredDemoWork.adapters.authorizationProviderServices.providerService.AuthorizationProviderService;
import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.results.DataResult;

public interface GoogleAuthorizationService  extends AuthorizationProviderService{
 public DataResult< User>getUserInfo();
}
