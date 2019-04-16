package io.github.qyvlik.iostnode.response.info;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class RAMInfo {
    @JSONField(name = "available")
    private BigDecimal available;        // 可用 RAM 数量，以 byte 为单位

    @JSONField(name = "total")
    private BigDecimal total;            // 系统总计 RAM 数量，以 byte 为单位

    @JSONField(name = "used")
    private BigDecimal used;             // 已经出售的 RAM 数量，以 byte 为单位

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getUsed() {
        return used;
    }

    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "RAMInfo{" +
                "available=" + available +
                ", total=" + total +
                ", used=" + used +
                '}';
    }
}
