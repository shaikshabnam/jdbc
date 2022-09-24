package jdbc_prc;

public class IdDoesntExist extends Exception {

	public String getMessage() {
		return " enter a correct id which exist in database";
	
	} 
}
