package PageObject;

public interface SignUpPageElements {
	
	String SignUpButton="//button[@id='signup']";
	String Form = "//form[@id=\'add-user\']";
	String Label = "//h1[text()='Add User']";
	String SenLable = "//p[text()='Sign up to begin adding your contacts!']";
	String FirstName = "//input[@id=\'firstName\']";
	String LastName = "//input[@id=\'lastName\']";
	String Email = "//input[@id=\'email\']";
	String Password = "//input[@id=\'password\']";
	String SubmitBtn = "//button[@id=\'submit\']";
	String CanBtn = "//button[@id=\'cancel\']";

}
