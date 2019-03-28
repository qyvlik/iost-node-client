package io.github.qyvlik.iostnode.response.info;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class ChainInfo {
    @JSONField(name = "net_name")
    private String netName;

    @JSONField(name = "protocol_version")
    private String protocolVersion;

    @JSONField(name = "chain_id")
    private Long chainId;

    @JSONField(name = "head_block")
    private Long headBlock;

    @JSONField(name = "head_block_hash")
    private String headBlockHash;

    @JSONField(name = "lib_block")
    private Long libBlock;

    @JSONField(name = "lib_block_hash")
    private String libBlockHash;

    @JSONField(name = "witness_list")
    private List<String> witnessList;

    @JSONField(name = "lib_witness_list")
    private List<String> libWitnessList;

    @JSONField(name = "pending_witness_list")
    private List<String> pendingWitnessList;

    @JSONField(name = "head_block_time")
    private Long headBlockTime;               //  单位，纳秒，除以 1000000，得到毫秒

    @JSONField(name = "lib_block_time")
    private Long libBlockTime;                //  单位，纳秒，除以 1000000，得到毫秒


    public String getNetName() {
        return netName;
    }

    public void setNetName(String netName) {
        this.netName = netName;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    public Long getHeadBlock() {
        return headBlock;
    }

    public void setHeadBlock(Long headBlock) {
        this.headBlock = headBlock;
    }

    public String getHeadBlockHash() {
        return headBlockHash;
    }

    public void setHeadBlockHash(String headBlockHash) {
        this.headBlockHash = headBlockHash;
    }

    public Long getLibBlock() {
        return libBlock;
    }

    public void setLibBlock(Long libBlock) {
        this.libBlock = libBlock;
    }

    public String getLibBlockHash() {
        return libBlockHash;
    }

    public void setLibBlockHash(String libBlockHash) {
        this.libBlockHash = libBlockHash;
    }

    public List<String> getWitnessList() {
        return witnessList;
    }

    public void setWitnessList(List<String> witnessList) {
        this.witnessList = witnessList;
    }

    public List<String> getLibWitnessList() {
        return libWitnessList;
    }

    public void setLibWitnessList(List<String> libWitnessList) {
        this.libWitnessList = libWitnessList;
    }

    public List<String> getPendingWitnessList() {
        return pendingWitnessList;
    }

    public void setPendingWitnessList(List<String> pendingWitnessList) {
        this.pendingWitnessList = pendingWitnessList;
    }

    public Long getHeadBlockTime() {
        return headBlockTime;
    }

    public void setHeadBlockTime(Long headBlockTime) {
        this.headBlockTime = headBlockTime;
    }

    public Long getLibBlockTime() {
        return libBlockTime;
    }

    public void setLibBlockTime(Long libBlockTime) {
        this.libBlockTime = libBlockTime;
    }

    @Override
    public String toString() {
        return "ChainInfo{" +
                "netName='" + netName + '\'' +
                ", protocolVersion='" + protocolVersion + '\'' +
                ", chainId=" + chainId +
                ", headBlock=" + headBlock +
                ", headBlockHash='" + headBlockHash + '\'' +
                ", libBlock=" + libBlock +
                ", libBlockHash='" + libBlockHash + '\'' +
                ", witnessList=" + witnessList +
                ", libWitnessList=" + libWitnessList +
                ", pendingWitnessList=" + pendingWitnessList +
                ", headBlockTime=" + headBlockTime +
                ", libBlockTime=" + libBlockTime +
                '}';
    }
}
