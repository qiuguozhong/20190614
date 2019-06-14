package executor.model;

import java.util.Map;

public class TestCaseFlowResult {
	private Long id;
	private String status;
	private String inputData;
	private String expectedData;
	private String outputData;
	private Map<String, String> dataMap;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInputData() {
		return inputData;
	}

	public void setInputData(String inputData) {
		this.inputData = inputData;
	}

	public String getExpectedData() {
		return expectedData;
	}

	public void setExpectedData(String expectedData) {
		this.expectedData = expectedData;
	}

	public String getOutputData() {
		return outputData;
	}

	public void setOutputData(String outputData) {
		this.outputData = outputData;
	}

	public Map<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}

	@Override
	public String toString() {
		return "TestCaseFlowResult [id=" + id + ", status=" + status + ", inputData=" + inputData + ", expectedData="
				+ expectedData + ", outputData=" + outputData + "]";
	}

}
