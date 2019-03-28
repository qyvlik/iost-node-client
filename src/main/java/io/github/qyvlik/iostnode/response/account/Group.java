package io.github.qyvlik.iostnode.response.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Group {
    @JSONField(name = "name")
    private String name;                // 组名字

    @JSONField(name = "items")
    private List<Item> items;       // 权限组信息

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
