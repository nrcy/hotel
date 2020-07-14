package top.nrcynet.dao.bean;

import com.fasterxml.jackson.annotation.JsonView;

public class ResultModel {

	private boolean result;
	
	private Object object;

	@JsonView(GetDataResult.class)
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@JsonView(GetResult.class)
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	public interface GetResult{};
	public interface GetDataResult extends GetResult{};
	
}
