package executor.model;

import java.util.List;

public class TestCaseFlow {
	private Long id;
	private String name;
	private int flowStep;
	private String description;
	private String actionName;
	private List<String> parameters;
	private List<String> returnValues;
	private String isExecute;

	private List<TestCaseFlowResult> testCaseFlowResultList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlowStep() {
		return flowStep;
	}

	public void setFlowStep(int flowStep) {
		this.flowStep = flowStep;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public List<String> getParameters() {
		return parameters;
	}

	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}

	public List<String> getReturnValues() {
		return returnValues;
	}

	public void setReturnValues(List<String> returnValues) {
		this.returnValues = returnValues;
	}

	public String getIsExecute() {
		return isExecute;
	}

	public void setIsExecute(String isExecute) {
		this.isExecute = isExecute;
	}

	public List<TestCaseFlowResult> getTestCaseFlowResultList() {
		return testCaseFlowResultList;
	}

	public void setTestCaseFlowResultList(List<TestCaseFlowResult> testCaseFlowResultList) {
		this.testCaseFlowResultList = testCaseFlowResultList;
	}

	@Override
	public String toString() {
		return "TestCaseFlow [id=" + id + ", name=" + name + ", flowStep=" + flowStep + ", description=" + description
				+ ", actionName=" + actionName + ", isExecute=" + isExecute + "]";
	}

}
