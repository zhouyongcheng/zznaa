package cn.com.zzn.model.view;

/**
 * Created by cmwin on 9/6/15.
 */
public class Option implements java.io.Serializable {

    String code;
    String label;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
