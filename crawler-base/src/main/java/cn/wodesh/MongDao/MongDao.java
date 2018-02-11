package cn.wodesh.MongDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TS on 2018/2/8.
 */
@Repository
public class MongDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据条件查询 对象
     * @param pram
     * @param value
     * @param cs
     * @param <T>
     * @return
     */
    public <T> T findOne(String pram , String value , Class<T> cs){
        return mongoTemplate.findOne(new Query(Criteria.where(pram).is(value)) , cs);
    }

    /**
     * 根据条件查询集合
     * @param pram
     * @param value
     * @param cs
     * @return
     */
    public List findAll(String pram , String value , Class cs){
        return mongoTemplate.find(new Query(Criteria.where(pram).is(value)) , cs);
    }

    /**
     * 根据对象查询集合
     * @param cs
     * @return
     */
    public List findAll(Class cs){
        return mongoTemplate.findAll(cs);
    }

    /**
     * 添加实例对象
     * @param cs
     */
    public void insertOne(Class cs){
        mongoTemplate.insert(cs);
    }

    /**
     * 添加对象集合
     * @param list
     */
    public void insertAll(List<?> list){
        mongoTemplate.insertAll(list);
    }

    /**
     * 根基条件删除对象
     * @param pram
     * @param value
     * @param cs
     */
    public void delete(String pram , String value , Class cs){
        mongoTemplate.remove(new Query(Criteria.where(pram).is(value)) , cs);
    }

    /**
     * 根据类模板删除
     * @param cs
     */
    public void delete(Class cs){
        mongoTemplate.remove(cs);
    }

}
