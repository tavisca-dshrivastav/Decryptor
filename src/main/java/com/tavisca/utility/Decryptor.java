package com.tavisca.utility;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Decryptor {
    public static String decrypt(String token) {
        String keys[] = new String[] {
                "SGhqUytIbDRqYThnVWgra2ozd05qNGhJMzVvTEtzVT0=",
                "UkJTSHViQnJpZ2h0c3RhclN1cHBsaWVyQUVTS2V5NzE=",
                "UkJTSHViU3VwcGxpZXJUZXN0QUVTRW5jcnlwdEtleTI=",
                "V1JIRU8vNjFvMHdHL2hGekRDVFRpTy90QXB4M2liQT0=",
                "ZYEbr9bfvgkbcdJN52mWyCK0x7b9i8PHpFkuoZNvtic="
        };
        String algorithWithPadding = "AES/CBC/PKCS5Padding";
        // String algorithWithPadding = "Blowfish/ECB/NoPadding";

        for (String key : keys) {
            try{
                SecretKeySpec skeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
                Cipher cipher = Cipher.getInstance(algorithWithPadding);
                cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(Base64.getDecoder().decode("Lg03CWQYZ6MSbnQUSsgYEQ==".getBytes())));
                String plaintext = new String(cipher.doFinal(Base64.getDecoder().decode(token)), "UTF-8");
                return plaintext.replace("&", "\n");
            }
            catch(Exception e){}
        }
        return "Failed To Decrypt";
    }
}
