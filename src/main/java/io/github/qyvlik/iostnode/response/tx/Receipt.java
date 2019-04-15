package io.github.qyvlik.iostnode.response.tx;

import com.alibaba.fastjson.annotation.JSONField;

public class Receipt {
    @JSONField(name = "func_name")
    private String funcName;            // abi函数的名字
    @JSONField(name = "content")
    private String content;            // 内容

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Receipt{" +
                "funcName='" + funcName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
