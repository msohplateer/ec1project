package com.plateer.ec1.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
    public static String getEncryptData(String value) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(value.getBytes());

        return bytesToHex(md.digest());
    }

    public static String bytesToHex(byte[] byteValues){
        StringBuilder sb = new StringBuilder();
        for(byte b : byteValues){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
