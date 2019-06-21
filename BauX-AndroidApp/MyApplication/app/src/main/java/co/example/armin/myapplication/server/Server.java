package co.example.armin.myapplication.server;

import android.app.Activity;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import co.example.armin.myapplication.activitys.LoginActivity;

public class Server {

    private static Server instance;
    String hostip;
    HttpConnection http;

    public static Server getInstance(){
        if(instance == null){
            try {
                instance = new Server();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private Server() throws Exception{
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {  }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {  }

                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

        try {
            Field field = Class.forName("BuildConfig").getDeclaredField("HOST_IP");
            hostip = (String) field.get(null);
            hostip = hostip.split("[:]")[0];
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
       http = new HttpConnection();
    }

    public String deleteRequest(String header){
        HttpRequest request = new HttpRequest(http, LoginActivity.getInstance());
        request.execute("DELETE", header);

        String result = "";
        try {
            result = request.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String postRequest(String header, String body){
        HttpRequest request = new HttpRequest(http, LoginActivity.getInstance());
        request.execute("POST", header, body);

        String result = "";
        try {
            result = request.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String getRequest(String header){
        HttpRequest request = new HttpRequest(http, LoginActivity.getInstance());
        request.execute("GET", header);

        String result = "";
        try {
            result = request.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean userExists(String worker, Activity caller){
        HttpRequest request = new HttpRequest(http, caller);
        request.execute("GET", "/users?worker="+worker);
        String result = "";
        try {
            result = request.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return !result.equals("");
    }

    private String hashPassword(String pw){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(pw.getBytes());
        String passwordHash = new String(messageDigest.digest());
        return passwordHash;
    }

    public boolean isConnected(Activity caller){
        HttpRequest request = new HttpRequest(http, caller);
        request.execute("CON");
        boolean result = false;
        try {
            result = Boolean.valueOf(request.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
