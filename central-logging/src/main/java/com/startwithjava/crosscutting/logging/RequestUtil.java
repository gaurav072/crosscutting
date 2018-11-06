package com.startwithjava.crosscutting.logging;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestUtil {
    public static String getRequestBodyAsString(HttpServletRequest request){
        HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(request);
        StringBuffer sb = new StringBuffer();
        try {
            ServletInputStream inputStream = requestWrapper.getInputStream();
            BufferedReader brReq =
                    new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = brReq.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
