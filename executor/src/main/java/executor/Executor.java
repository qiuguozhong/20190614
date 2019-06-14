package executor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import executor.action.BaseAction;
import executor.model.TestCase;
import executor.model.TestCaseFlow;
import executor.model.TestData;

public class Executor {
	public static void executor() {
		Map<String, Object> returnMap = new HashMap<>();

		List<Object> actionList = new ArrayList<>();
		BaseAction baseAction = new BaseAction();
		actionList.add(baseAction);

		List<TestCaseFlow> testCaseFlowList = new ArrayList<>();
		List<TestCase> testCaseList = new ArrayList<>();
		List<TestData> testDataList = new ArrayList<>();

		TestCaseFlow testCaseFlow = new TestCaseFlow();
		testCaseFlow.setId(1l);
		testCaseFlow.setName("Flow1");
		testCaseFlow.setFlowStep(1);
		testCaseFlow.setDescription("flow step 1");
		testCaseFlow.setActionName("test1");
		testCaseFlow.setParameters(Arrays.asList(new String[] { "parameter1", "parameter2" }));
		testCaseFlow.setReturnValues(Arrays.asList(new String[] { "return1", "return2" }));
		testCaseFlow.setIsExecute("Y");
		testCaseFlowList.add(testCaseFlow);

		TestCaseFlow testCaseFlow1 = new TestCaseFlow();
		testCaseFlow1.setId(2l);
		testCaseFlow1.setName("Flow1");
		testCaseFlow1.setFlowStep(1);
		testCaseFlow1.setDescription("flow step 2");
		testCaseFlow1.setActionName("test2");
		testCaseFlow1.setParameters(Arrays.asList(new String[] { "parameter3", "parameter4", "parameter5" }));
		testCaseFlow1.setReturnValues(Arrays.asList(new String[] { "return3" }));
		testCaseFlow1.setIsExecute("Y");
		testCaseFlowList.add(testCaseFlow1);

		TestCaseFlow testCaseFlow2 = new TestCaseFlow();
		testCaseFlow2.setId(2l);
		testCaseFlow2.setName("Flow1");
		testCaseFlow2.setFlowStep(1);
		testCaseFlow2.setDescription("flow step 3");
		testCaseFlow2.setActionName("test3");
		testCaseFlow2.setParameters(Arrays.asList(new String[] { "parameter6" }));
		testCaseFlow2.setReturnValues(Arrays.asList(new String[] {}));
		testCaseFlow2.setIsExecute("Y");
		testCaseFlowList.add(testCaseFlow2);

		TestCase testCase = new TestCase();
		testCase.setId(1l);
		testCase.setJiraKey("jira_key1");
		testCase.setSummary("test case 1");
		testCase.setComponent("component1");
		testCase.setSubComponent("sub component 1");
		testCase.setFlowName("Flow1");
		testCase.setIsExecute("Y");
		testCaseList.add(testCase);

		for (Long i = 1l; i <= 6; i++) {
			TestData testData = new TestData();
			testData.setId(i);
			testData.setJiraKey("jira_key1");
			testData.setDescription("round1 test data");
			testData.setRound(1);
			testData.setParameterName("parameter" + i);
			testData.setParameterValue("testdata" + i);
			testData.setIsExecute("Y");
			testDataList.add(testData);
		}

		Map<String, List<TestCase>> caseMap = testCaseList.stream().filter(tCase -> "Y".equals(tCase.getIsExecute()))
				.collect(Collectors.groupingBy(tCase -> tCase.getFlowName()));

		Map<String, List<TestData>> dataMap = testDataList.stream().filter(tData -> "Y".equals(tData.getIsExecute()))
				.collect(Collectors.groupingBy(tData -> tData.getJiraKey()));

		Map<String, List<TestCaseFlow>> tflowMap = testCaseFlowList.stream()
				.filter(tflow -> "Y".equals(tflow.getIsExecute()))
				.collect(Collectors.groupingBy(tflow -> tflow.getName()));

		for (Entry<String, List<TestCaseFlow>> entry : tflowMap.entrySet()) {
			List<TestCaseFlow> tflowList = entry.getValue();

			tflowList.stream().sorted(Comparator.comparing(TestCaseFlow::getFlowStep)).forEach(tflow -> {
				String actionName = tflow.getActionName();
				List<String> parameters = tflow.getParameters();
				List<String> returnValues = tflow.getReturnValues();
				List<TestCase> tCaseList = caseMap.get(tflow.getName());

				for (TestCase tCase : tCaseList) {
					List<TestData> tDataList = dataMap.get(tCase.getJiraKey());

					Map<String, List<TestData>> roundMap = tDataList.stream()
							.collect(Collectors.groupingBy(tData -> Integer.toString(tData.getRound())));

					for (Entry<String, List<TestData>> dataEntry : roundMap.entrySet()) {
						List<TestData> rtDataList = dataEntry.getValue();
						Map<String, String> testParameterMap = new HashMap<>();
						for (TestData rtData : rtDataList) {
							testParameterMap.put(rtData.getParameterName(), rtData.getParameterValue());
						}

						// invoke action
						List<Object> params = new ArrayList<>();
						for (String p : parameters) {
							String v = testParameterMap.get(p);
							if (v == null) {
								params.add(returnMap.get(p));
							} else {
								params.add(v);
							}
						}

						for (String r : returnValues) {
							params.add(r);
						}

						try {
							for (Object o : actionList) {
								Method[] methods = o.getClass().getDeclaredMethods();
								for (Method m : methods) {
									System.out.println("method name:" + m.getName());
									if (m.getName().equals(actionName)) {
										Object returnResult = m.invoke(o, params.toArray());
										System.out.println("result:" + returnResult);
										break;
									}

								}

							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

				}

			});
		}

	}
}
