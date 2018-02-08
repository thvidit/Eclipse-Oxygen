import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Encryption {
	
	public static void main(String [] args) throws Exception {
        KeyPair keyPair = buildKeyPair();
        PublicKey pubKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("Public key: " + pubKey.toString());
        System.out.println("Private key: " + privateKey.toString());
	}



	public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
	    final int keySize = 2048;
	    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
	    keyPairGenerator.initialize(keySize);      
	    return keyPairGenerator.genKeyPair();
	}
}
