package huayang.hychat.enums;

import huayang.hychat.common.GeneralEnum;

/**
 * Created by buhuayang on 16/7/28.
 */
public enum MenusetTypeEnum implements GeneralEnum<String> {

    Split("Split", "分割菜单"),
    Tree("Tree", "树菜单");

    private String code;
    private String name;

    MenusetTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
