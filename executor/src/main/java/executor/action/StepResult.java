package executor.action;

import java.util.HashMap;
import java.util.Map;

public class StepResult {
	private String status;
	private String message;
	private Map<String, Object> dataMap;

	public StepResult() {
		dataMap = new HashMap<>();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setReturnValue(String name, String value) {
		dataMap.put(name, value);
	}

	public void getReturnValue(String name) {
		dataMap.get(name);
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	@Override
	public String toString() {
		return "StepResult [status=" + status + ", message=" + message + ", dataMap=" + dataMap + "]";
	}

}
