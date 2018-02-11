package cn.wodesh.Service;
import cn.wodesh.bean.DataInfo;
import cn.wodesh.bean.ScanHtmlUrl;
import cn.wodesh.bean.ScanUrl;
import java.util.List;
/**
 * Created by TS on 2018/2/8.
 */
public interface IGetUrlService {

    /**
     * 获取分类栏目
     * @return
     */
    List<ScanUrl> getTypeUrl(String url) throws Exception;

    /**
     * 获取 扫描html url
     * @param typeurl
     * @param rex
     * @return
     */
    List<ScanHtmlUrl> getHtmlUrl(String typeurl , String rex , String type) throws Exception;

    /**
     * 返回 爬取数据
     * @param htmlurl
     * @return
     */
    DataInfo getData(String htmlurl , String type);

}
