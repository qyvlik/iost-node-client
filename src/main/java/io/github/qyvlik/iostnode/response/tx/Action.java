package io.github.qyvlik.iostnode.response.tx;

import com.alibaba.fastjson.annotation.JSONField;

public class Action {
    @JSONField(name = "contract")
    private String contract;            // 调用的合约名字

    @JSONField(name = "action_name")
    private String actionName;          // 调用的合约函数名

    @JSONField(name = "data")
    private String data;                // 调用的具体参数。把所有的参数生成 array 后再用 json 序列化，一般形如 '["a_string",13]'

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Action{" +
                "contract='" + contract + '\'' +
                ", actionName='" + actionName + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
