package io.github.qyvlik.iostnode.response.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;

public class TokenBalance {
    @JSONField(name = "balance")
    private BigDecimal balance;                         // 余额

    @JSONField(name = "frozen_balances")
    private List<FrozenBalance> frozenBalances;    // 冻结信息

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<FrozenBalance> getFrozenBalances() {
        return frozenBalances;
    }

    public void setFrozenBalances(List<FrozenBalance> frozenBalances) {
        this.frozenBalances = frozenBalances;
    }

    @Override
    public String toString() {
        return "TokenBalance{" +
                "balance=" + balance +
                ", frozenBalances=" + frozenBalances +
                '}';
    }
}
