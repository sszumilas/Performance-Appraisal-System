package pl.lodz.p.it.spjava.sop8.ejb.interceptor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {

    @Resource
    private SessionContext sessionContext;

	
	@AroundInvoke
    public Object additionalInvokeForMethod(InvocationContext invocation) throws Exception {
        StringBuilder sb = new StringBuilder("Business method induction: ");
        sb.append(invocation.getTarget().getClass().getName()).append('.').append(invocation.getMethod().getName());
        sb.append(" with user identity: " + sessionContext.getCallerPrincipal().getName());
        try {
            Object[] parameters = invocation.getParameters();
            if (null != parameters) {
                for (Object param : parameters) {
                    if (param != null) {
                        sb.append(" with parameter type:" + param.getClass().getName() + " with value" + param.toString());
                    } else {
                        sb.append(" with null parameter");
                    }
                }
            }

            Object result = invocation.proceed();

            if (result != null) {
                sb.append(" returned object type: " + result.getClass().getName() + " with value: " + result.toString());
            } else {
                sb.append(" returned null value");
            }

            return result;
        } catch (Exception ex) {
            sb.append(" occured exception type: " + ex.getClass().getName());
            throw ex;
        } finally {
            Logger.getGlobal().log(Level.INFO, sb.toString());
        }
    }
}
