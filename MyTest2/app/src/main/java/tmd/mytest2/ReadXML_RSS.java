package tmd.mytest2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ReadXML_RSS extends AppCompatActivity {

    TextView txtvRSS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_xml__rss);

        txtvRSS = (TextView)findViewById(R.id.txtvRSS);
        txtvRSS.setText("");


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new readXML().execute("http://www.xvideos.com/rss/rss.xml");
            }
        });
    }

    class readXML extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            String str = "";
            str = docNoiDung_Tu_URL(params[0]);
            return str;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            Toast.makeText(ReadXML_RSS.this, s, Toast.LENGTH_LONG).show();
            XMLDOMParser parser = new XMLDOMParser();
            Document doc = parser.getDocument(s);
            NodeList nodeList = doc.getElementsByTagName("item");
            String kq = "";
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element e = (Element) nodeList.item(i);
                kq = kq + "\n" +parser.getValue(e, "title");
            }
//            Toast.makeText(ReadXML_RSS.this, kq, Toast.LENGTH_LONG).show();
            txtvRSS.setText("\tNEW VIDEOS\n" + kq);

        }
    }

    private static String docNoiDung_Tu_URL(String theUrl) {
        StringBuilder content = new StringBuilder();

        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
