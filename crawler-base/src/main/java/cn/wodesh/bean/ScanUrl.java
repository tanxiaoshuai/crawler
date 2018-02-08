package cn.wodesh.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by TS on 2018/2/8.
 */

@Component
@Scope("prototype")
public class ScanUrl {


    private String uuid;

    //扫描的URL
    private String scanurl;

    //来源
    private String source;

    //类型
    private String type;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getScanurl() {
        return scanurl;
    }

    public void setScanurl(String scanurl) {
        this.scanurl = scanurl;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
