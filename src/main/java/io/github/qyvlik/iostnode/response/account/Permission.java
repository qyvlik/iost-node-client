package io.github.qyvlik.iostnode.response.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Permission {
    @JSONField(name = "name")
    private String name;                // 权限名字

    @JSONField(name = "group_names")
    private List<String> groupNames;   // 权限组名字

    @JSONField(name = "items")
    private List<Item> items;         // 权限信息

    @JSONField(name = "threshold")
    private Long threshold;             // 权限阈值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(List<String> groupNames) {
        this.groupNames = groupNames;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getThreshold() {
        return threshold;
    }

    public void setThreshold(Long threshold) {
        this.threshold = threshold;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "name='" + name + '\'' +
                ", groupNames=" + groupNames +
                ", items=" + items +
                ", threshold=" + threshold +
                '}';
    }
}
