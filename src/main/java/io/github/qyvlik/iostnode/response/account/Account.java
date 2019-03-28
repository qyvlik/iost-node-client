package io.github.qyvlik.iostnode.response.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Account {
    @JSONField(name = "name")
    private String name;                // 账户名字

    @JSONField(name = "balance")
    private BigDecimal balance;         // 余额

    @JSONField(name = "gas_info")
    private GasInfo gasInfo;            // Gas信息

    @JSONField(name = "ram_info")
    private Object ramInfo;            // Ram信息

    @JSONField(name = "permissions")
    private Map<String, Permission> permissions;    // 权限

    @JSONField(name = "groups")
    private Map<String, Group> groups;         // 权限组

    @JSONField(name = "frozen_balances")
    private List<FrozenBalance> frozenBalances;       // 冻结余额信息

    @JSONField(name = "vote_infos")
    private List<VoteInfo> voteInfos;            // 投票信息


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public GasInfo getGasInfo() {
        return gasInfo;
    }

    public void setGasInfo(GasInfo gasInfo) {
        this.gasInfo = gasInfo;
    }

    public Object getRamInfo() {
        return ramInfo;
    }

    public void setRamInfo(Object ramInfo) {
        this.ramInfo = ramInfo;
    }

    public Map<String, Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<String, Permission> permissions) {
        this.permissions = permissions;
    }

    public Map<String, Group> getGroups() {
        return groups;
    }

    public void setGroups(Map<String, Group> groups) {
        this.groups = groups;
    }

    public List<FrozenBalance> getFrozenBalances() {
        return frozenBalances;
    }

    public void setFrozenBalances(List<FrozenBalance> frozenBalances) {
        this.frozenBalances = frozenBalances;
    }

    public List<VoteInfo> getVoteInfos() {
        return voteInfos;
    }

    public void setVoteInfos(List<VoteInfo> voteInfos) {
        this.voteInfos = voteInfos;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", gasInfo=" + gasInfo +
                ", ramInfo=" + ramInfo +
                ", permissions=" + permissions +
                ", groups=" + groups +
                ", frozenBalances=" + frozenBalances +
                ", voteInfos=" + voteInfos +
                '}';
    }
}
