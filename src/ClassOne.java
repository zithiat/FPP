public class ClassOne {
	
	private String initStr = "";
	
	public ClassOne() {
		System.out.println("Hello from Class ONE");
		initStr = "Init String from ONE";
	}
	
	public void publicMethod() {
		System.out.println("PublicMethod from Class ONE");
	}
	
	public String getInitStr() {
		return this.initStr;
	}
}
