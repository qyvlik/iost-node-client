package io.github.qyvlik.iostnode.response.contract;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Contract {
    @JSONField(name = "id")
    private String id;

    @JSONField(name = "code")
    private String code;

    @JSONField(name = "language")
    private String language;

    @JSONField(name = "version")
    private String version;

    @JSONField(name = "abis")
    private List<ABI> abis;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ABI> getAbis() {
        return abis;
    }

    public void setAbis(List<ABI> abis) {
        this.abis = abis;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", language='" + language + '\'' +
                ", version='" + version + '\'' +
                ", abis=" + abis +
                '}';
    }
}
