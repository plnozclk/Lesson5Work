package nLayeredDemoWork;

import nLayeredDemoWork.adapters.authorizationProviderServices.googleAuthorizationService.GoogleAuthorizationAdapter;

import nLayeredDemoWork.business.concretes.ConfirmationLinkService1;
import nLayeredDemoWork.business.concretes.UserManager;
import nLayeredDemoWork.dataAccess.concrete.HibetnateUserDao;
import nLayeredDemoWork.entities.concrete.User;
import nLayeredDemoWork.validators.UserInfoValidator;

public class Main {


	
	public static void main(String[] args) {

		HibetnateUserDao hibernateUserDao = new HibetnateUserDao(); //InMermory data Acces
		UserManager userManager = new UserManager(hibernateUserDao, new UserInfoValidator(),
				new ConfirmationLinkService1(), new GoogleAuthorizationAdapter());
		
		User user1 = new User("deneme.mail@cabuk.com", "Mehmet", "Çabuk", "123456", 0);
		User user2 = new User("deneme.mail@cabuk.com", "Mehmet", "Çabuk", "123456", 0);
		
		System.out.println(userManager.add(user1).message); // success
		System.out.println(userManager.add(user1).message); // same user > User already exists! Error
		System.out.println(userManager.add(user2).message); // same info another user > User already exists! Error
/*/invalid emails error >> Email is NOT valid!
		System.out.println(userManager.add(new User("Ayþe", "Bilir", "0000:)", "deneme@")).message);
		System.out.println(userManager.add(new User("Ayþe", "Bilir", "0000:)", "deneme@bilir")).message);
		System.out.println(userManager.add(new User("Ayþe", "Bilir", "0000:)", ".denemedene@bilir")).message);
		System.out.println(userManager.add(new User("Ayþe", "Bilir", "0000:)", "deneme.dene@bilir.")).message);
		System.out.println(userManager.add(new User("Ayþe", "Bilir", "0000:)", "ç.öç.öe.dene@bilir.com")).message);
		System.out.println(userManager.add(new User("Ayþe", "Bilir", "0000:)", "@bilir.com")).message); //*/
//invalid password error>> Password field can not be less 6 digits..		
		System.out.println(userManager.add(new User("Ayþe", "Bilir", "", "dene@bilir.com", 0)).message);
		System.out.println(userManager.add(new User("dene@bilir.com", "Ayþe", "", "123456", 0)).message);
		System.out.println(userManager.add(new User("Ayþe", "Bilir", "0000:)", "ç.öç.öe.dene@bilir.com", 0)).message);
		System.out.println(userManager.add(new User("Ayþe", "Bilir", "12345", "dene@bilir.com", 0)).message); //*/
/*/invalid user first last name error>> User First Name and Last Name; can not be Emty or less 2 letters...
		System.out.println(userManager.add(new User("Ayþe", "", "123456", "dene@bilir.com")).message);
		System.out.println(userManager.add(new User("", "Bilir", "123456", "dene@bilir.com")).message);
		System.out.println(userManager.add(new User("Ayþe", "B", "123456", "dene@bilir.com")).message);
		System.out.println(userManager.add(new User("A", "Bilir", "123456", "dene@bilir.com")).message);
		System.out.println(userManager.add(new User("A", "Bi", "123456", "dene@bilir.com")).message); //*/
		
		System.out.println(userManager.add(new User("Ayþe", "Bilir", "123456", "dene@bilir.com", 0)).message);
		System.out.println(userManager.add(new User("Ayla", "Bilir", "123456", "adene@gmail.com", 0)).message);
		System.out.println(userManager.add(new User("Ömer", "Halisdemir", "123456", "omerhalisdemir@sehit.com", 0)).message);
		
//GoogleAuthorizationService 
		System.out.println(userManager.addFromService().message);
		
		
//List InMemory Database
		System.out.println("\n<> -----------------<> InMemory Db Member List <>------------------------");
		System.out.println("id\tName\t\t\tPassword\tEmail");
		for (User user : userManager.getAll().data) { 
			System.out.println(user.getId() + "\t" + user.getFirstName() + " " + user.getLastName()+ "\t\t" +
					user.getPassword() + "\t\t" + user.getePosta());
		}
		System.out.println("\n<> Authentication <>--------------------------------");
System.err.println(userManager.delete(user1).message);
// update user
		User _user = userManager.getById(3).data;
		_user.setLastName("Nebilir");
		System.out.println(userManager.update(_user).message);
		
//Last situation in List InMemory Database 
				System.out.println("\n<> -----------------<> InMemory Db Member List <>------------------------");
				System.out.println("id\tName\t\t\tPassword\tEmail");
				for (User user : userManager.getAll().data) { 
					System.out.println(user.getId() + "\t" + user.getFirstName() + " " + user.getLastName()+ "\t\t" +
							user.getPassword() + "\t\t" + user.getePosta());
				}
	}

}
