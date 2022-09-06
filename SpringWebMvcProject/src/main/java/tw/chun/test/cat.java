package tw.chun.test;

class Cat1 {

	private String name = "";

	public Cat1(String name) {
		this.name = name;
	}

	public String Shout() {
		return "我的名字叫"+name+"喵";
	}
}

public class cat {

	public static void main(String[] args) {
		
		Cat1 cat = new Cat1("e04");
	    System.out.println(cat.Shout());

	}

}
