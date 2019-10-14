
import org.rosuda.JRI.*;

public class Test {

	public static void main(String[] args) {
		String[] Rargs = {"--vanilla"};
		Rengine re = new Rengine(Rargs, false, null);
		System.out.println("Create R Engine...");

		
		if(!re.waitForR()) {
			System.out.println("Loading R engine was failed");
			return;
		}
		
		REXP a = re.eval("a <- 10", true);
		REXP b = re.eval("class(a)");
		
		REXP c = re.eval("x <- c(1,2,3,4,5)", true);
		REXP d = re.eval("barplot(x)");
		
		
		
		System.out.println(a.asDouble());
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}

}
