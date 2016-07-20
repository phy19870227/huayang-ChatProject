package huayang.hychat.enums;

/**
 * Created by buhuayang on 16/7/21.
 */
public enum WebResultFlag {

    Y("Y", "成功"),
    N("N", "失败");

    private final String id;
    private final String value;

    WebResultFlag(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
