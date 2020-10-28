import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author liyuke
 * @date 2020-10-28 23:22
 */
public class Work03 {
    private void TestHttpClient(String urlStr) throws Exception{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        conn.setReadTimeout(5000);
        conn.setConnectTimeout(60 * 1000);
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        BufferedOutputStream out = new BufferedOutputStream(conn
                .getOutputStream());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"));
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws Exception{
        Work03 work03 = new Work03();
        work03.TestHttpClient("http://localhost:8801");
    }
}
