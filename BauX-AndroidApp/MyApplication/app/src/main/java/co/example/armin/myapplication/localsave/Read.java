package co.example.armin.myapplication.localsave;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read {

    public static Context context;
    public static int id;



    private static String getStringFromFile(String filePath) throws Exception {
        File fl = new File(filePath);
        if (!fl.exists()) {
            fl.createNewFile();
        }
        FileInputStream fin = new FileInputStream(fl);
        String ret = convertStreamToString(fin);
        fin.close();
        return ret;
    }

    private static String convertStreamToString(FileInputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    public static WorkerList readWorkerList(){
        String jsonString = null;
        try {
            jsonString = getStringFromFile(context.getFilesDir().getPath().toString()+"/"+id+"workerlist.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(jsonString.equals("")){
            return new WorkerList();
        }
        Gson gson = new Gson();
        WorkerList list = gson.fromJson(jsonString, WorkerList.class);
        return list;
    }
}
