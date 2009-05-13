// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 2008-5-4 ÉÏÎç 10:10:14
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SafeEngine.java

package shecasafeapi;

import java.io.PrintStream;

public class SafeEngine
{

    public SafeEngine()
    {
        intHSE = -3;
        intReturned = -1;
        intDllHandle = -1;
    }

    public native int shecaInitEnviroment(int i, String s, String s1, int j, int k, String s2, String s3);

    public native int shecaInitEnviromentByte(int i, byte abyte0[], byte abyte1[], int j, int k, byte abyte2[], byte abyte3[]);

    public native int shecaClearEnviroment();

    public native String shecaDigest(String s, int i);

    public native byte[] shecaDigestByte(byte abyte0[], int i);

    public native String shecaSignData(String s, int i);

    public native byte[] shecaSignDataByte(byte abyte0[], int i);

    public native int shecaVerifySignData(String s, int i, String s1, String s2);

    public native int shecaVerifySignDataByte(byte abyte0[], int i, byte abyte1[], byte abyte2[]);

    public native String shecaEnvelope(int i, String s, String s1);

    public native byte[] shecaEnvelopeByte(int i, byte abyte0[], byte abyte1[]);

    public native String shecaGetSelfCertificate(int i, String s, String s1);

    public native byte[] shecaGetSelfCertificateByte(int i, byte abyte0[], byte abyte1[]);

    public native String shecaGetCertificate(String s, String s1);

    public native byte[] shecaGetCertificateByte(byte abyte0[], byte abyte1[]);

    public native int shecaVerifyCertificate(String s);

    public native int shecaVerifyCertificateByte(byte abyte0[]);

    public native int shecaVerifyCertificateOnline(String s);

    public native int shecaVerifyCertificateOnlineByte(byte abyte0[]);

    public native int shecaChangePassword(int i, String s, String s1, String s2);

    public native int shecaChangePasswordByte(int i, byte abyte0[], byte abyte1[], byte abyte2[]);

    public native String shecaGetCertDetail1(String s, int i);

    public native byte[] shecaGetCertDetailByte(byte abyte0[], int i);

    public native int shecaSetConfiguration(int i);

    public native int shecaShowVersion();

    public native String shecaGetCertUniqueID(String s);

    public native byte[] shecaGetCertUniqueIDByte(byte abyte0[]);

    public native long shecaGetCertUsage(String s);

    public native long shecaGetCertUsageByte(byte abyte0[]);

    public native long shecaGetCertClass(String s);

    public native long shecaGetCertClassByte(byte abyte0[]);

    public native String shecaGetCertInfoByOID(String s, String s1);

    public native byte[] shecaGetCertInfoByOIDByte(byte abyte0[], byte abyte1[]);

    public native long shecaGetCertValidDate(String s);

    public native long shecaGetCertValidDateByte(byte abyte0[]);

    public native byte[] shecaPEMEncode(byte abyte0[]);

    public native byte[] shecaPEMDecode(byte abyte0[]);

    public native long shecaGetModuleNo();

    public native long shecaGetVersion();

    public native String shecaEnvelopeEx(int i, String s, String s1, int j);

    public native byte[] shecaEnvelopeExByte(int i, byte abyte0[], byte abyte1[], int j);

    public native long shecaInitEnvironmentEx(String s, String s1, String s2);

    public native String shecaGenRandom(int i);

    public native byte[] shecaGenRandomBytes(int i);

    public native String shecaEncryptData(byte abyte0[], String s);

    public native byte[] shecaEncryptDataBytes(byte abyte0[], byte abyte1[]);

    public native String shecaDecryptData(String s, String s1);

    public native byte[] shecaDecryptDataBytes(byte abyte0[], byte abyte1[]);

    public native String shecaEncryptDataEx(byte abyte0[], String s, int i);

    public native byte[] shecaEncryptDataExBytes(byte abyte0[], byte abyte1[], int i);

    public native String shecaDecryptDataEx(String s, String s1, int i);

    public native byte[] shecaDecryptDataExBytes(byte abyte0[], byte abyte1[], int i);

    public native String shecaGenRSAKeyPair(String s, String s1, int i);

    public native byte[] shecaGenRSAKeyPairBytes(String s, String s1, int i);

    public native String shecaGetPubkeyFromPrikey(String s);

    public native byte[] shecaGetPubkeyFromPrikeyBytes(byte abyte0[]);

    public native String shecaGetCertFromPKCS12(String s, String s1);

    public int getErrorCode()
    {
        return intReturned;
    }

    public int getCode()
    {
        return intHSE;
    }

    String native2unicode(String s)
    {
        if(s == null || s.length() == 0)
            return "";
        byte buffer[] = new byte[s.length()];
        for(int i = 0; i < s.length(); i++)
            buffer[i] = (byte)s.charAt(i);

        return new String(buffer);
    }

    public String shecaGetCertDetail(String strCert, int intItemNo)
    {
        String strItem = shecaGetCertDetail1(strCert, intItemNo);
        return native2unicode(strItem);
    }

    int intHSE;
    public int intReturned;
    int intDllHandle;

    static 
    {
        try
        {
            System.loadLibrary("javasafeengine");
        }
        catch(Exception e)
        {
            System.out.println("Load dll error");
        }
        finally { }
    }
}