package cn.com.zzn.model.persist;

public class Codetable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column codetable.category_
     *
     * @mbggenerated
     */
    private String category;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column codetable.code_
     *
     * @mbggenerated
     */
    private Integer code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column codetable.label_
     *
     * @mbggenerated
     */
    private String label;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column codetable.desc_
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column codetable.order_
     *
     * @mbggenerated
     */
    private Integer order;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column codetable.category_
     *
     * @return the value of codetable.category_
     *
     * @mbggenerated
     */
    public String getCategory() {
        return category;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column codetable.category_
     *
     * @param category the value for codetable.category_
     *
     * @mbggenerated
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column codetable.code_
     *
     * @return the value of codetable.code_
     *
     * @mbggenerated
     */
    public Integer getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column codetable.code_
     *
     * @param code the value for codetable.code_
     *
     * @mbggenerated
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column codetable.label_
     *
     * @return the value of codetable.label_
     *
     * @mbggenerated
     */
    public String getLabel() {
        return label;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column codetable.label_
     *
     * @param label the value for codetable.label_
     *
     * @mbggenerated
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column codetable.desc_
     *
     * @return the value of codetable.desc_
     *
     * @mbggenerated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column codetable.desc_
     *
     * @param desc the value for codetable.desc_
     *
     * @mbggenerated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column codetable.order_
     *
     * @return the value of codetable.order_
     *
     * @mbggenerated
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column codetable.order_
     *
     * @param order the value for codetable.order_
     *
     * @mbggenerated
     */
    public void setOrder(Integer order) {
        this.order = order;
    }
}