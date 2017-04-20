import java.io.*;
import java.net.*;

public class ImdbAPI {
    public static String omdbGet(String title) throws MalformedURLException, IOException
    {
        StringBuilder result = new StringBuilder();
        title = title.replaceAll(" ", "_");
        URL url = new URL("http://www.omdbapi.com/?t=" + title);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while((line = rd.readLine()) != null)
        {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
}
