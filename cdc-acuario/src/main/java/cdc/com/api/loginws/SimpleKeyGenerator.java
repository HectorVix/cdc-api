/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.com.api.loginws;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
/**
 *
 * @author Héctor Vix
 */
public class SimpleKeyGenerator implements KeyGenerator {
    
    @Override
    public Key generateKey() {
        String keyString = "cdc56up7345";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
        return key;
    }
}
