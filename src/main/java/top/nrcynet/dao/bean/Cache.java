package top.nrcynet.dao.bean;

import com.fasterxml.jackson.annotation.JsonView;

public class Cache {

    private Integer id;

    private String name;

    private String breakfast;

    private Integer roomId;

    private Integer price;

    @JsonView(ResultModel.GetDataResult.class)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView(ResultModel.GetDataResult.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(ResultModel.GetDataResult.class)
    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    @JsonView(ResultModel.GetDataResult.class)
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @JsonView(ResultModel.GetDataResult.class)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cache{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breakfast='" + breakfast + '\'' +
                ", roomId=" + roomId +
                ", price=" + price +
                '}';
    }
}
