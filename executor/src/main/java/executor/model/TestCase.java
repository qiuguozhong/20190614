package executor.model;

import java.util.List;

public class TestCase {
	private Long id;
	private String jiraKey;
	private String summary;
	private String component;
	private String subComponent;
	private String flowName;
	private String isExecute;
	private List<TestCaseFlow> testCaseFlowList;
	private List<TestData> testDataList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJiraKey() {
		return jiraKey;
	}

	public void setJiraKey(String jiraKey) {
		this.jiraKey = jiraKey;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getSubComponent() {
		return subComponent;
	}

	public void setSubComponent(String subComponent) {
		this.subComponent = subComponent;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getIsExecute() {
		return isExecute;
	}

	public void setIsExecute(String isExecute) {
		this.isExecute = isExecute;
	}

	public List<TestCaseFlow> getTestCaseFlowList() {
		return testCaseFlowList;
	}

	public void setTestCaseFlowList(List<TestCaseFlow> testCaseFlowList) {
		this.testCaseFlowList = testCaseFlowList;
	}

	public List<TestData> getTestDataList() {
		return testDataList;
	}

	public void setTestDataList(List<TestData> testDataList) {
		this.testDataList = testDataList;
	}

	@Override
	public String toString() {
		return "TestCase [id=" + id + ", jiraKey=" + jiraKey + ", summary=" + summary + ", component=" + component
				+ ", subComponent=" + subComponent + ", flowName=" + flowName + ", isExecute=" + isExecute + "]";
	}

}
