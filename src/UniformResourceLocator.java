import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

class UniformResourceLocator {

    private UniformResourceLocator(){}
    private static String serviceKey = "";

    static void setServicekey(String inValue){ serviceKey = inValue; }
    static URL Parameter(String inUrl, String[] inType, String[] inValue) throws UnsupportedEncodingException, MalformedURLException {

        if(inType.length != inValue.length) return null;  // 값이 정상적으로 오지 않을 경우

        int inLength = inValue.length;
        StringBuilder urlBuilder = new StringBuilder("http://openapi.g2b.go.kr/openapi/service/rest/"+inUrl+"?" + URLEncoder.encode("ServiceKey","UTF-8") + serviceKey);

        for(int i = 0;i<inLength;i++)
            urlBuilder
                    .append("&")
                    .append(URLEncoder.encode(inType[i], "UTF-8"))
                    .append("=")
                    .append(URLEncoder.encode(inValue[i], "UTF-8"));

        return new URL(urlBuilder.toString());

    }

}

//        StringBuilder urlBuilder = new StringBuilder("http://openapi.g2b.go.kr/openapi/service/rest/BidPublicInfoService/getBidPblancListInfoThng"); /*URL*/
//        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=7H64sQyENcYAjqog9RaFcPjZLb7Tu4cBWM1OtL3boY9r%2BpZoZM%2ByJ69mEJCbZuVBvgJacgjDEaj1mSBrmHuExg%3D%3D"); /*Service Key*/
//        urlBuilder.append("&" + URLEncoder.encode("sDate","UTF-8") + "=" + URLEncoder.encode("20150925", "UTF-8")); /*조회날짜(시작)*/
//        urlBuilder.append("&" + URLEncoder.encode("eDate","UTF-8") + "=" + URLEncoder.encode("20160421", "UTF-8")); /*조회날짜(끝)*/
//        urlBuilder.append("&" + URLEncoder.encode("dateType","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*공고/개찰일*/
//        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("999", "UTF-8")); /*검색건수*/
//        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//
//        // URL 인코더를 사용안할경우 나쁜요청이라고 뜨고 URL인코더를 사용시에 특수기호는 별도로 보내야함.
//
//        URL url = new URL(urlBuilder.toString());
