package cn.com.zzn.persist.service;

import cn.com.zzn.model.persist.Codetable;
import cn.com.zzn.model.view.Option;

import java.util.List;

/**
 * Created by cmwin on 9/6/15.
 */
public interface CodeTableService {

    List<Codetable> getAllCategories();

    List<Codetable> getCategories(String category);

    List<Option> getOptions(String category);

    Codetable getCategoryItem(String category, Integer code);

    int addCodetableRecord(Codetable record);

    int updCodetableRecord(Codetable record);
}
