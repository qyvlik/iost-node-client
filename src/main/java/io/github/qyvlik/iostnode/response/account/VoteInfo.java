package io.github.qyvlik.iostnode.response.account;

import com.alibaba.fastjson.annotation.JSONField;

public class VoteInfo {
    @JSONField(name = "option")
    private String option;          // 候选人

    @JSONField(name = "votes")
    private String votes;           // 投票数

    @JSONField(name = "cleared_votes")
    private String clearedVotes;   // 被清零投票数

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getClearedVotes() {
        return clearedVotes;
    }

    public void setClearedVotes(String clearedVotes) {
        this.clearedVotes = clearedVotes;
    }

    @Override
    public String toString() {
        return "VoteInfo{" +
                "option='" + option + '\'' +
                ", votes='" + votes + '\'' +
                ", clearedVotes='" + clearedVotes + '\'' +
                '}';
    }
}
