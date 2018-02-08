package cn.wodesh.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by TS on 2018/2/8.
 */

@Component
@Scope("prototype")
public class ScanHtmlUrl {

    private String uuid;

    //标题
    private String title;

    //扫描的网页地址
    private String scanhtmlurl;

    //来源
    private String source;

    //扫描次数
    private Integer scancount = 0;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getScanhtmlurl() {
        return scanhtmlurl;
    }

    public void setScanhtmlurl(String scanhtmlurl) {
        this.scanhtmlurl = scanhtmlurl;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getScancount() {
        return scancount;
    }

    public void setScancount(Integer scancount) {
        this.scancount = scancount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
