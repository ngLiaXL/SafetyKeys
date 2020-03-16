package com.ngliaxl.safetykeys;

import android.util.Base64;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class DES {


    public static String encrypt(String str, String key) {
        String encrypt = null;
        try {
            encrypt = jdkBase64String(encrypt2(str, key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypt;
    }

    public static String decrypt(String str, String key) {
        String decrypt = null;
        try {
            decrypt = decrypt2(jdkBase64Decoder(str), key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypt;
    }


    /**
     * 使用DES对字符串加密
     *
     * @param str utf8编码的字符串
     * @param key 密钥（56位，7字节）
     */
    public static byte[] encrypt2(String str, String key) throws Exception {
        if (str == null || key == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "DES"));
        byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
        return bytes;
    }

    /**
     * 使用DES对数据解密
     *
     * @param bytes utf8编码的二进制数据
     * @param key   密钥（16字节）
     * @return 解密结果
     * @throws Exception
     */
    public static String decrypt2(byte[] bytes, String key) throws Exception {
        if (bytes == null || key == null)
            return null;
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "DES"));
        bytes = cipher.doFinal(bytes);
        return new String(bytes, "utf-8");
    }

    /**
     * 使用base64解决乱码
     *
     * @param secretKey 加密后的字节码
     */
    public static String jdkBase64String(byte[] secretKey) {
        return Base64.encodeToString(secretKey, Base64.DEFAULT);
    }

    /**
     * 使用jdk的base64 解密字符串 返回为null表示解密失败
     *
     * @throws IOException
     */
    public static byte[] jdkBase64Decoder(String str) throws IOException {
        return Base64.decode(str, Base64.DEFAULT);
    }

}