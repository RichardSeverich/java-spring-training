package org.jala.support;

import java.time.Instant;

/**
 * Created by Richard Severich on 28/10/2017.
 */
public class Message {

    private String code;
    private String message;
    private long unixTimestamp;

    public Message() {

    }

    public Message(String code, String message) {
        this.code = code;
        this.message = message;
        this.unixTimestamp = Instant.now().getEpochSecond();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getUnixTimestamp() {
        return unixTimestamp;
    }

    public void setUnixTimestamp(long unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
