package com.FEPS.utility;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptDecryptHelper {

    /**
     * Encrypts the input String and returns encrypted value
     */
    public String encryptString(String input){
        byte[] encodedString = Base64.getEncoder().encode(input.getBytes(StandardCharsets.UTF_8));
        return new String(encodedString);
    }

    /**
     * Decrypts the input String and returns encrypted value
     */
    public String decryptString(String input){
        byte[] decodedPassword = Base64.getDecoder().decode(input);
        return new String(decodedPassword);
    }
}
