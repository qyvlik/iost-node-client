package io.github.qyvlik.iostnode.response.block;

import com.alibaba.fastjson.annotation.JSONField;

public class Block {

    public static final String BLOCK_STATUS_PENDING = "PENDING";               // block在缓存中
    public static final String BLOCK_STATUS_IRREVERSIBLE = "IRREVERSIBLE";     // block不可逆

    @JSONField(name = "status")
    private String status;

    @JSONField(name = "block")
    private BlockDetail block;            // block结构体

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BlockDetail getBlock() {
        return block;
    }

    public void setBlock(BlockDetail block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "Block{" +
                "status='" + status + '\'' +
                ", block=" + block +
                '}';
    }
}