package executor.action;

public class BaseAction {
	public StepResult test1(String p1, String p2, String r1, String r2) {
		System.out.println("This is test1 ," + p1 + "," + p2 + "," + r1 + "," + r2);
		StepResult stepResult = new StepResult();
		stepResult.setStatus("Pass");
		stepResult.setMessage("message test");
		stepResult.setReturnValue(r1, "r1Result");
		stepResult.setReturnValue(r2, "r2Result");
		return stepResult;
	}

	public StepResult test2(String p1, String p2, String p3, String r1) {
		System.out.println("This is test1 ," + p1 + "," + p2 + "," + p3 + "," + r1);
		StepResult stepResult = new StepResult();
		stepResult.setStatus("Pass");
		stepResult.setMessage("message test");
		stepResult.setReturnValue(r1, "r1Result");
		return stepResult;
	}

	public StepResult test3(String p1) {
		System.out.println("This is test1 ," + p1);
		StepResult stepResult = new StepResult();
		stepResult.setStatus("Pass");
		stepResult.setMessage("message test");
		return stepResult;
	}
}
