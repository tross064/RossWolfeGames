package e2.tictactoe;

import java.io.*;

public class RubyScriptCaller {
        
    public static String callScript(String filePath) {
            
        Runtime rt = Runtime.getRuntime();
        String result = "";
        
        try {             
            Process pr = rt.exec("ruby " + filePath);
            BufferedReader processIn =
                new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line;
            while ((line = processIn.readLine()) != null) {
                result += line;
            }
                
            return result;
                
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }       
}
