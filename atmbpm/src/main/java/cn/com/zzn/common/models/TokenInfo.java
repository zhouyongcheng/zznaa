package cn.com.zzn.common.models;

import org.joda.time.DateTime;

/**
 * Created by cmwin on 10/10/15.
 */
public class TokenInfo implements java.io.Serializable {
    private String userId;
    private DateTime issued;
    private DateTime expires;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public DateTime getIssued() {
        return issued;
    }

    public void setIssued(DateTime issued) {
        this.issued = issued;
    }

    public DateTime getExpires() {
        return expires;
    }

    public void setExpires(DateTime expires) {
        this.expires = expires;
    }
}
