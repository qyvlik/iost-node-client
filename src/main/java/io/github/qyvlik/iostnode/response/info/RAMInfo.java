package io.github.qyvlik.iostnode.response.info;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class RAMInfo {
    @JSONField(name = "available_ram")
    private BigDecimal availableRam;        // 可用 RAM 数量，以 byte 为单位

    @JSONField(name = "buy_price")
    private BigDecimal buyPrice;            // 此刻购买 RAM 的价格，以 IOST/byte 为单位，已经包含手续费

    @JSONField(name = "sell_price")
    private BigDecimal sellPrice;           // 此刻购买 RAM 的价格，以 IOST/byte 为单位

    @JSONField(name = "total_ram")
    private BigDecimal totalRam;            // 系统总计 RAM 数量，以 byte 为单位

    @JSONField(name = "used_ram")
    private BigDecimal usedRam;             // 已经出售的 RAM 数量，以 byte 为单位


    public BigDecimal getAvailableRam() {
        return availableRam;
    }

    public void setAvailableRam(BigDecimal availableRam) {
        this.availableRam = availableRam;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getTotalRam() {
        return totalRam;
    }

    public void setTotalRam(BigDecimal totalRam) {
        this.totalRam = totalRam;
    }

    public BigDecimal getUsedRam() {
        return usedRam;
    }

    public void setUsedRam(BigDecimal usedRam) {
        this.usedRam = usedRam;
    }

    @Override
    public String toString() {
        return "RAMInfo{" +
                "availableRam=" + availableRam +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                ", totalRam=" + totalRam +
                ", usedRam=" + usedRam +
                '}';
    }
}
