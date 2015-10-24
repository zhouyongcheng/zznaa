package org.tynamo.activiti;

import org.activiti.engine.delegate.VariableScope;
import org.activiti.engine.impl.el.ExpressionManager;
import org.activiti.engine.impl.el.VariableScopeElResolver;
import org.activiti.engine.impl.javax.el.*;
import org.apache.tapestry5.ioc.ObjectLocator;

/**
 * {@link ExpressionManager} that exposes Tapestry services to an Activiti process.
 *
 */
public class TapestryExpressionManager extends ExpressionManager {
	private final ObjectLocator objectLocator;

	public TapestryExpressionManager(final ObjectLocator objectLocator) {
		this.objectLocator = objectLocator;
	}

	protected ELResolver createElResolver(VariableScope variableScope) {
		CompositeELResolver compositeElResolver = new CompositeELResolver();
		compositeElResolver.add(new VariableScopeElResolver(variableScope));
		compositeElResolver.add(new ServiceElResolver(objectLocator));
		compositeElResolver.add(new ArrayELResolver());
		compositeElResolver.add(new ListELResolver());
		compositeElResolver.add(new MapELResolver());
		compositeElResolver.add(new BeanELResolver());
		return compositeElResolver;
	}
}