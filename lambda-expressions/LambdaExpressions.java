public class LambdaExpressions {
    public static void main(String[] args) {
	String localData = "local-data"; // should be final or effectively final to be accessible within lambda, below
	LambdaExpressions obj = new LambdaExpressions();
	
	// using lambda expression in-place
	obj.apply(text -> {
		System.out.println("In-place lambda expression can access received '" + text + "'");
		System.out.println("In-place lambda expression can also access local variables, i.e. '" + localData + "'");
	});

	// assigning lambda expression to a functor
	Func functor = str -> System.out.println("Lambda expression assigned to variable, then applied to '" 
						+ str + "' and '" + localData + "'");
	obj.apply(functor);
    
	// using instance methods as lambda
	System.out.println("Passing object method in place of lambda:");
	obj.apply(System.out::println);
    }

    void apply(Func f) {f.process("lambda-argument");}
}

@FunctionalInterface // interface should provide exactly one abstract method (default methods do not count)
interface Func {
    void process(String textToProcess);
}
