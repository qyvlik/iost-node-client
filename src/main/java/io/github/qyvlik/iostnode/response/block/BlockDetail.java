package io.github.qyvlik.iostnode.response.block;

import com.alibaba.fastjson.annotation.JSONField;
import io.github.qyvlik.iostnode.response.tx.Transaction;

import java.util.List;

public class BlockDetail {
    @JSONField(name = "hash")
    private String hash;                    // block hash

    @JSONField(name = "version")
    private String version;                 // bock版本号

    @JSONField(name = "parent_hash")
    private String parentHash;              // block父块的hash

    @JSONField(name = "tx_merkle_hash")
    private String txMerkleHash;            // 所有交易的merkle tree hash

    @JSONField(name = "tx_receipt_merkle_hash")
    private String txReceiptMerkleHash;     // 所有receipt的merkle tree hash

    @JSONField(name = "number")
    private Long number;                    // block号

    @JSONField(name = "witness")
    private String witness;                 // block生产者的pubkey

    @JSONField(name = "time")
    private Long time;                      // block生产时间

    @JSONField(name = "gas_usage")
    private Double gasUsage;                // block中交易消耗的总Gas

    @JSONField(name = "tx_count")
    private Long txCount;                   // block中交易总数

    @JSONField(name = "info")
    private BlockInfo info;                  // 保留字段

    @JSONField(name = "transactions")
    private List<Transaction> transactions;      // 交易字段

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getParentHash() {
        return parentHash;
    }

    public void setParentHash(String parentHash) {
        this.parentHash = parentHash;
    }

    public String getTxMerkleHash() {
        return txMerkleHash;
    }

    public void setTxMerkleHash(String txMerkleHash) {
        this.txMerkleHash = txMerkleHash;
    }

    public String getTxReceiptMerkleHash() {
        return txReceiptMerkleHash;
    }

    public void setTxReceiptMerkleHash(String txReceiptMerkleHash) {
        this.txReceiptMerkleHash = txReceiptMerkleHash;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getWitness() {
        return witness;
    }

    public void setWitness(String witness) {
        this.witness = witness;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getGasUsage() {
        return gasUsage;
    }

    public void setGasUsage(Double gasUsage) {
        this.gasUsage = gasUsage;
    }

    public Long getTxCount() {
        return txCount;
    }

    public void setTxCount(Long txCount) {
        this.txCount = txCount;
    }

    public BlockInfo getInfo() {
        return info;
    }

    public void setInfo(BlockInfo info) {
        this.info = info;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "BlockDetail{" +
                "hash='" + hash + '\'' +
                ", version='" + version + '\'' +
                ", parentHash='" + parentHash + '\'' +
                ", txMerkleHash='" + txMerkleHash + '\'' +
                ", txReceiptMerkleHash='" + txReceiptMerkleHash + '\'' +
                ", number=" + number +
                ", witness='" + witness + '\'' +
                ", time=" + time +
                ", gasUsage=" + gasUsage +
                ", txCount=" + txCount +
                ", info=" + info +
                ", transactions=" + transactions +
                '}';
    }
}
