package StrategyPattern;

public class StrategyS {

	public static void main(String[] args) {
		//Client
		Context context = new Context();
		
		int result = context.executeStrategy(new OperationAdd(), 10, 5);
		System.out.println(result);
		
		result = context.executeStrategy(new OperationSubstract(), 10, 5);
		System.out.println(result);
		
		result = context.executeStrategy(new OperationMultiply(), 10, 5);
		System.out.println(result);
	}

}

interface Strategyy{
	public int performOperation(int num1,int num2);
}

class OperationAdd implements Strategyy{
	@Override
	public int performOperation(int num1,int num2) {
		return num1 + num2;
	}
}

class OperationSubstract implements Strategyy{
	@Override
	public int performOperation(int num1,int num2) {
		return num1 - num2;
	}
}

class OperationMultiply implements Strategyy{
	@Override
	public int performOperation(int num1,int num2) {
		return num1 * num2;
	}
}

class Context{
	public int executeStrategy(Strategyy strategy,int num1,int num2) {
		return strategy.performOperation(num1, num2);
	}
}
