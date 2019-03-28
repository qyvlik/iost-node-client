package io.github.qyvlik.iostnode.response.block;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class BlockInfo {
    @JSONField(name = "mode")
    private Integer mode;                       // 并发的模式，0 - 不并发， 1 - 并发

    @JSONField(name = "thread")
    private Integer thread;                     // 交易并发执行的线程数量

    @JSONField(name = "batch_index")
    private List<Integer> batchIndex;           // 交易的索引

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Integer getThread() {
        return thread;
    }

    public void setThread(Integer thread) {
        this.thread = thread;
    }

    public List<Integer> getBatchIndex() {
        return batchIndex;
    }

    public void setBatchIndex(List<Integer> batchIndex) {
        this.batchIndex = batchIndex;
    }

    @Override
    public String toString() {
        return "BlockInfo{" +
                "mode=" + mode +
                ", thread=" + thread +
                ", batchIndex=" + batchIndex +
                '}';
    }
}
