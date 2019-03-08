public class ClassTwo {

	private String initStr = "";
	
	public ClassTwo() {
		System.out.println("Hello from Class TWO");
		initStr = "Init String from TWO";
	}
	
	public void publicMethod() {
		System.out.println("PublicMethod from Class TWO");
	}
	
	public String getInitStr() {
		return this.initStr;
	}
}
