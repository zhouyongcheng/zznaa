package cn.com.zzn.model.persist;

public class Area {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.citycode
     *
     * @mbggenerated
     */
    private String citycode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.id
     *
     * @return the value of area.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.id
     *
     * @param id the value for area.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.code
     *
     * @return the value of area.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.code
     *
     * @param code the value for area.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.name
     *
     * @return the value of area.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.name
     *
     * @param name the value for area.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.citycode
     *
     * @return the value of area.citycode
     *
     * @mbggenerated
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.citycode
     *
     * @param citycode the value for area.citycode
     *
     * @mbggenerated
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }
}