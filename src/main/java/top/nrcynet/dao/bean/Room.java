package top.nrcynet.dao.bean;

import com.fasterxml.jackson.annotation.JsonView;

public class Room {

	private Integer id;

	private Integer num;

	private Integer size;

	private Integer floor;

	private Integer type;

	private Integer price;

	private Integer status;

	@JsonView(ResultModel.GetDataResult.class)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonView(ResultModel.GetDataResult.class)
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@JsonView(ResultModel.GetDataResult.class)
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@JsonView(ResultModel.GetDataResult.class)
	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	@JsonView(ResultModel.GetDataResult.class)
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@JsonView(ResultModel.GetDataResult.class)
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@JsonView(ResultModel.GetDataResult.class)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Room{" + "id=" + id + ", num=" + num + ", size=" + size + ", floor=" + floor + ", type=" + type
				+ ", price=" + price + ", status=" + status + '}';
	}
}
