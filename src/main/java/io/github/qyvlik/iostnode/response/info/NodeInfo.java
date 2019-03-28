package io.github.qyvlik.iostnode.response.info;

import com.alibaba.fastjson.annotation.JSONField;

public class NodeInfo {
    @JSONField(name = "build_time")
    private String buildTime;

    @JSONField(name = "git_hash")
    private String gitHash;

    @JSONField(name = "mode")
    private String mode;

    @JSONField(name = "network")
    private Object network;

    @JSONField(name = "code_version")
    private String codeVersion;

    @JSONField(name = "server_time")
    private Long serverTime;

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    public String getGitHash() {
        return gitHash;
    }

    public void setGitHash(String gitHash) {
        this.gitHash = gitHash;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Object getNetwork() {
        return network;
    }

    public void setNetwork(Object network) {
        this.network = network;
    }

    public String getCodeVersion() {
        return codeVersion;
    }

    public void setCodeVersion(String codeVersion) {
        this.codeVersion = codeVersion;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

    @Override
    public String toString() {
        return "NodeInfo{" +
                "buildTime='" + buildTime + '\'' +
                ", gitHash='" + gitHash + '\'' +
                ", mode='" + mode + '\'' +
                ", network=" + network +
                ", codeVersion='" + codeVersion + '\'' +
                ", serverTime=" + serverTime +
                '}';
    }
}
