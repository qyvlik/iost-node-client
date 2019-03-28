package io.github.qyvlik.iostnode.response.info;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class TokenInfo {
    @JSONField(name = "symbol")
    private String symbol;              // token 名字

    @JSONField(name = "full_name")
    private String fullName;            // token 全称

    @JSONField(name = "issuer")
    private String issuer;              // token 发行人

    @JSONField(name = "total_supply")
    private BigDecimal totalSupply;     // token 总发行量

    @JSONField(name = "current_supply")
    private BigDecimal currentSupply;   // token 当前发行量

    @JSONField(name = "decimal")
    private Integer decimal;            // token 小数位

    @JSONField(name = "can_transfer")
    private Boolean canTransfer;        // token 能否进行转账


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public BigDecimal getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(BigDecimal totalSupply) {
        this.totalSupply = totalSupply;
    }

    public BigDecimal getCurrentSupply() {
        return currentSupply;
    }

    public void setCurrentSupply(BigDecimal currentSupply) {
        this.currentSupply = currentSupply;
    }

    public Integer getDecimal() {
        return decimal;
    }

    public void setDecimal(Integer decimal) {
        this.decimal = decimal;
    }

    public Boolean getCanTransfer() {
        return canTransfer;
    }

    public void setCanTransfer(Boolean canTransfer) {
        this.canTransfer = canTransfer;
    }

    @Override
    public String toString() {
        return "TokenInfo{" +
                "symbol='" + symbol + '\'' +
                ", fullName='" + fullName + '\'' +
                ", issuer='" + issuer + '\'' +
                ", totalSupply=" + totalSupply +
                ", currentSupply=" + currentSupply +
                ", decimal=" + decimal +
                ", canTransfer=" + canTransfer +
                '}';
    }
}
