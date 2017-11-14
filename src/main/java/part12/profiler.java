package part12;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect   //AOP 선언부
@Component("profiler")
public class profiler<Ojbect> {
	@Pointcut("execution(public * part12..*(..))")
	public void publicMethod() {}

	@Around("publicMethod()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("profiler == Before  || " + joinPoint.getSignature().toShortString());
		try {
			Object result = joinPoint.proceed();
			return result;
		}
		finally {
			System.out.println("profiler == After || " + joinPoint.getSignature().toShortString());
		}
	}
}
