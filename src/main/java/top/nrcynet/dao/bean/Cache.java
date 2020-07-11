package top.nrcynet.dao.bean;

public class Cache {

    private Integer id;

    private String name;

    private String breakfast;

    private Integer roomId;

    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

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
