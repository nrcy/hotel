package top.nrcynet.dao.bean;

import com.fasterxml.jackson.annotation.JsonView;

public class User {

	private Integer id;

	private String name;

	private Integer password;

	private String isEvaluate;

	private Integer consumption;

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
	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	@JsonView(ResultModel.GetDataResult.class)
	public String getIsEvaluate() {
		return isEvaluate;
	}

	public void setIsEvaluate(String isEvaluate) {
		this.isEvaluate = isEvaluate;
	}

	@JsonView(ResultModel.GetDataResult.class)
	public Integer getConsumption() {
		return consumption;
	}

	public void setConsumption(Integer consumption) {
		this.consumption = consumption;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", password=" + password + ", isEvaluate='"
				+ isEvaluate + '\'' + ", consumption=" + consumption + '}';
	}
}
