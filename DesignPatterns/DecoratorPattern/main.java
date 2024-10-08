package DecoratorPattern;

public class main {

	public static void main(String[] args) {
		
		System.out.println("***Decorator pattern Demo***");
		ConcreteComponent cc = new ConcreteComponent();
		
		ConcreteDecorateEx_1 cd_1 = new ConcreteDecorateEx_1();
		
		// Decorating ConcreteComponent Object cc with ConcreteDecoratorEx_1
		cd_1.SetTheComponent(cc);
		cd_1.doJob();
		
		ConcreteDecorateEx_2 cd_2 = new ConcreteDecorateEx_2();
		
		// Decorating ConcreteComponent Object cc with ConcreteDecoratorEx_1
		// & Concrete DecoratorEx_2
		cd_2.SetTheComponent(cd_1);
		cd_2.doJob();

	}

}

abstract class Component {
	public abstract void doJob();
}

class ConcreteComponent extends Component {
	@Override
	public void doJob() {
		System.out.println("I am from a Concrete Component -"
				+ " I am closed for modification.");
	}
}

abstract class AbstractDecorator extends Component {
	protected Component com;
	
	public void SetTheComponent(Component c) {
		com = c;
	}
	
	public void doJob() {
		if(com!=null)
			com.doJob();
	}
}

class ConcreteDecorateEx_1 extends AbstractDecorator{
	public void doJob() {
		super.doJob();
		
		// add additional responsibilities
		System.out.println("I am explicity from Ex-1");
	}
}

class ConcreteDecorateEx_2 extends AbstractDecorator{
	public void doJob() {
		System.out.println("");
		System.out.println("***START Ex-2***");
		
		super.doJob();
		
		// add additional responsibilities
		System.out.println("Explicitly From DecoratorEx_2");
		System.out.println("***END. EX-2***");
	}
}




