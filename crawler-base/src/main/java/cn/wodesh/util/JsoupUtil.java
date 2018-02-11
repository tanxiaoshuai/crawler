package cn.wodesh.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static sun.net.www.protocol.http.HttpURLConnection.userAgent;

public class JsoupUtil {

    /**
     * 获取 html字串
     * @param url
     * @return
     * @throws Exception
     */
    public static String getHtmlStr(String url) throws Exception {
        Connection conn = Jsoup.connect(url);
        // 修改http包中的header,伪装成浏览器进行抓取
        conn.header("User-Agent", userAgent);
        conn.timeout(3000);
        return conn.get().toString();
    }

    /**
     * 获取 html dom对象
     * @param url
     * @return
     * @throws Exception
     */
    public static Document getHtmlDoc(String url) throws Exception {
        String str = getHtmlStr(url);
        return Jsoup.parse(str);
    }
}
