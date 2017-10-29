package service;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import entities.Employees;

/**
 * Created by deep on 6/20/16.
 */
public class EmployeesDataService extends AsyncTask<Void, Void, String> {

    public ArrayList<Employees> getEmployeesJSON() {

        String response = "";
        String restUrl = "http://api.backendless.com/v1/data/Employees";
        //String restUrl = "http://rest-service.guides.spring.io/greeting";
        try {
            URL url = new URL(restUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            List<NameValuePair> reqParams = new ArrayList<NameValuePair>();
            reqParams.add(new BasicNameValuePair("secret-key", "5ED9AED1-B49A-8D54-FF23-279C9218C000"));
            reqParams.add(new BasicNameValuePair("application-id", "A45CF3F9-9B5C-4BDA-FF8A-0317EEDA6600"));

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(reqParams));
            writer.flush();
            writer.close();
            os.close();

            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = br.readLine()) != null) {
                    response += line;
                }
            } else {
                response = "";
            }

            Log.w(EmployeesDataService.class.getSimpleName(), response);
            System.out.println(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params)
        {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }

    @Override
    protected String doInBackground(Void... voids) {
        //getEmployeesJSON();
        getEmployeesJSONHttpClient();
        return null;
    }

    public ArrayList<Employees> getEmployeesJSONHttpClient() {

        String restUrl = "http://api.backendless.com/v1/data/Employees";
        //String restUrl = "http://rest-service.guides.spring.io/greeting";
        String hostName = "api.backendless.com";
        String userAgent = System.getProperty("http.agent");
        try {

            AndroidHttpClient client = AndroidHttpClient.newInstance(userAgent);

            HttpHost host = new HttpHost(hostName,80);

            HttpRequest request = new BasicHttpRequest("GET",restUrl);

            request.setHeader("secret-key", "5ED9AED1-B49A-8D54-FF23-279C9218C000");
            request.setHeader("application-id", "A45CF3F9-9B5C-4BDA-FF8A-0317EEDA6600");

            HttpResponse resp = client.execute(host,request);
            String respo = EntityUtils.toString(resp.getEntity());

            /*Gson gson = new Gson();
            String respJSON = gson.toJson(resp.getEntity().toString());*/

            Log.w(EmployeesDataService.class.getSimpleName(), respo);
            System.out.println(respo);

            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
        return null;
    }


}
