import java.io.*;
import java.net.*;

public class ImdbAPI {
    
    private String rawText;
    public ImdbAPI(String title)
    {
        this.rawText = omdbGet(title);
    }
    
    public String getRawText()
    {
        return this.rawText;
    }
    
    private static String omdbGet(String title)
    {
        StringBuilder result = new StringBuilder();
        title = title.replaceAll(" ", "_");
        URL url;
        try
        {
            url = new URL("http://www.omdbapi.com/?t=" + title);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream())))
            {
                String line;
                while((line = rd.readLine()) != null)
                {
                    result.append(line);
                }
            }
        }
        catch(MalformedURLException e)
        {
            return e.toString();
        }
        catch(IOException e)
        {
            return e.toString();
        }
        return result.toString();
    }
}
