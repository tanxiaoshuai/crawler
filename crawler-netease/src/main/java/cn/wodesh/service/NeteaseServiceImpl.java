package cn.wodesh.service;

import cn.wodesh.MongDao.MongDao;
import cn.wodesh.Service.IGetUrlService;
import cn.wodesh.bean.DataInfo;
import cn.wodesh.bean.ScanHtmlUrl;
import cn.wodesh.bean.ScanUrl;
import cn.wodesh.config.Config;
import cn.wodesh.util.JsoupUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NeteaseServiceImpl implements IGetUrlService{

    @Autowired
    private MongDao mongDao;

    /**
     * 网易 抓取类型 url
     * @param url
     * @return
     * @throws Exception
     */
    @Override
    public List<ScanUrl> getTypeUrl(String url) throws Exception {
        List<ScanUrl> list = new ArrayList<>();
        Document document = JsoupUtil.getHtmlDoc(url);
        Elements esl = document.getElementsByClass("ntes-quicknav-column");
        for(Element es : esl){
            Elements ement = es.getElementsByTag("a");
            for(Element ent : ement){
                if(ent.text() != null && !"".equals(ent.text())
                        && mongDao.findOne("scanurl" , ent.attr("href") , ScanUrl.class)  == null ){
                    ScanUrl model = new ScanUrl();
                    model.setType(ent.text());
                    model.setScanurl(ent.attr("href"));
                    model.setSource(Config.SITENAME);
                    model.setUuid(UUID.randomUUID().toString().replace("-" , ""));
                    list.add(model);
                }
            }
        }
        mongDao.insertAll(list);
        return list;
    }

    @Override
    public List<ScanHtmlUrl> getHtmlUrl(String typeurl , String rex, String type) throws Exception {
        Document doc = JsoupUtil.getHtmlDoc(typeurl);
        Elements el = doc.getElementsByTag("a");
        for(Element e : el){
            Pattern pattern = Pattern.compile(rex);
            Matcher matcher = pattern.matcher(e.attr("href"));
            if(!matcher.matches()){
                System.out.println(e.attr("href"));
                continue;
            }
            ScanHtmlUrl urlAll = mongDao.
                    findOne( "scanhtmlurl", e.attr("href") , ScanHtmlUrl.class);
            if(urlAll != null){
                continue;
            }
            urlAll = new ScanHtmlUrl();
            urlAll.setUuid(UUID.randomUUID().toString().replace("-" , ""));
            urlAll.setTitle(e.text());
            urlAll.setScanhtmlurl(e.attr("href"));
            urlAll.setSource(Config.SITENAME);
            urlAll.setScancount(0);
            urlAll.setType(type);
            mongDao.insertOne(urlAll.getClass());
        }
        return null;
    }

    @Override
    public DataInfo getData(String htmlurl , String type) {
        return null;
    }
}
