package co.example.armin.myapplication.server;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.AutoCompleteTextView;

import co.example.armin.myapplication.R;

public class HttpRequest extends AsyncTask<String, Integer, String> {

    private HttpConnection http;
    private Activity activity;

    public HttpRequest(HttpConnection httpConnection, Activity caller){
        http = httpConnection;
        activity = caller;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {

        AutoCompleteTextView text =  activity.findViewById(R.id.usrusr);

        text.setText("penis");
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        try {
            if (strings[0].equals("GET")) {
                result = http.sendGet(strings[1]);
            } else if (strings[0].equals("POST")) {
                result = http.sendPost(strings[1], strings[2]);
            }
            else if(strings[0].equals("DELETE")){
                result = http.sendDelete(strings[1]);
            }
            else if(strings[0].equals("CON")){
                result = Boolean.toString(http.checkServerConnectivity());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
