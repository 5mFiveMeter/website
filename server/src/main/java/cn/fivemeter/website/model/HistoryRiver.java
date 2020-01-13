package cn.fivemeter.website.model;

public class HistoryRiver {
    private Integer id;

    private String occurTime;

    private String occurYear;

    private String nickName;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(String occurTime) {
        this.occurTime = occurTime == null ? null : occurTime.trim();
    }

    public String getOccurYear() {
        return occurYear;
    }

    public void setOccurYear(String occurYear) {
        this.occurYear = occurYear == null ? null : occurYear.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}