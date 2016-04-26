import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {

        String[] dataType = new String[5];
        String[] dataValue = new String[5];

        dataType[0] = "sDate"; dataValue[0] = "20160320";
        dataType[1] = "eDate"; dataValue[1] = "20160421";
        dataType[2] = "dataType"; dataValue[2] = "1";
        dataType[3] = "numOfRows"; dataValue[3] = "10";
        dataType[4] = "pageNo"; dataValue[4] = "1";

        UniformResourceLocator.setServicekey("=7H64sQyENcYAjqog9RaFcPjZLb7Tu4cBWM1OtL3boY9r%2BpZoZM%2ByJ69mEJCbZuVBvgJacgjDEaj1mSBrmHuExg%3D%3D");
        URL url = UniformResourceLocator.Parameter("BidPublicInfoService/getBidPblancListInfoThng",dataType,dataValue);

        out.println(url);

        if(url == null) { out.println("파라미터 값이 정확하지 않습니다."); return; } // 값이 정상적이지 않을 경우

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        out.println("Response code: " + conn.getResponseCode());

        //test

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300)
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        else
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

//        out.println(xStream.fromXML(url));

    }

}