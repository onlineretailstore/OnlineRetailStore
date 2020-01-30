
public class UserInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String secretKey = "ssshhhhhhhhhhh!!!!";
	     
	    String originalString = "Mr. John Doe, CEO , Microsoft , 9987869977";
	    String encryptedString = AdvanceEncryptionStandard.encryptDetails(originalString, secretKey) ;
	    String decryptedString = AdvanceEncryptionStandard.decryptDetails(encryptedString, secretKey) ;
	    
	    System.out.println("Original String is as follows : \n ");
	    
	    System.out.println(originalString);
	    
	    System.out.println("Encryption is as follows : \n ");
	    
	    System.out.println(encryptedString);
	    
	    System.out.println("Decryption is as follows : \n");
	    
	    System.out.println(decryptedString);
	    
	}

}
