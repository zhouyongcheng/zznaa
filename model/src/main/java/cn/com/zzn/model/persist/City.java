package cn.com.zzn.model.persist;

public class City {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.provincecode
     *
     * @mbggenerated
     */
    private String provincecode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.id
     *
     * @return the value of city.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.id
     *
     * @param id the value for city.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.code
     *
     * @return the value of city.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.code
     *
     * @param code the value for city.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.name
     *
     * @return the value of city.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.name
     *
     * @param name the value for city.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.provincecode
     *
     * @return the value of city.provincecode
     *
     * @mbggenerated
     */
    public String getProvincecode() {
        return provincecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.provincecode
     *
     * @param provincecode the value for city.provincecode
     *
     * @mbggenerated
     */
    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode == null ? null : provincecode.trim();
    }
}