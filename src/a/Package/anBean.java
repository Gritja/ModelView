package a.Package;

public class anBean {
	private String name,password;
	public boolean validationCheck = false;
	public String[][] listOfUsers = {
            {"user1", "user1"},
            {"user2", "user2"}
        };
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validate() {
		for (int i = 0; i < listOfUsers.length; i++) {
			if (name.contentEquals(listOfUsers[i][0]) && password.contentEquals(listOfUsers[i][1])){
				validationCheck = true;
				
			}
		}
		
		if (validationCheck) {
			return true;
		 }else {
				return false;
			} 
		
	}
	
}
