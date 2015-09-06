package cn.com.zzn.persist.client;

import cn.com.zzn.model.persist.Codetable;
import java.util.List;

import cn.com.zzn.model.view.Option;
import org.apache.ibatis.annotations.Param;

public interface CodetableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table codetable
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("category") String category, @Param("code") Integer code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table codetable
     *
     * @mbggenerated
     */
    int insert(Codetable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table codetable
     *
     * @mbggenerated
     */
    Codetable selectByPrimaryKey(@Param("category") String category, @Param("code") Integer code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table codetable
     *
     * @mbggenerated
     */
    List<Codetable> selectAll();

    /**
     * get all code value pairs for specified category
     * @param category
     * @return
     */
    List<Option>  selectByCategory(String category);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table codetable
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Codetable record);
}