package executor.model;

public class TestData {
	private Long id;
	private String jiraKey;
	private int round;
	private String description;
	private String parameterName;
	private String parameterValue;
	private String isExecute;

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

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public String getIsExecute() {
		return isExecute;
	}

	public void setIsExecute(String isExecute) {
		this.isExecute = isExecute;
	}

	@Override
	public String toString() {
		return "TestData [id=" + id + ", jiraKey=" + jiraKey + ", round=" + round + ", description=" + description
				+ ", parameterName=" + parameterName + ", parameterValue=" + parameterValue + ", isExecute=" + isExecute
				+ "]";
	}

}
