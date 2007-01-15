package de.hasait.eclipse.ccg.javag.model.java;


/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MAssignmentCodeStatement extends AbstractMCodeStatement {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property varName. */
	public static final String PROPERTY_VAR_NAME_NAME = "varName";
	/** Type of property varName. */
	public static final Class PROPERTY_VAR_NAME_TYPE = String.class;
	
	/** Name of property valueExpression. */
	public static final String PROPERTY_VALUE_EXPRESSION_NAME = "valueExpression";
	/** Type of property valueExpression. */
	public static final Class PROPERTY_VALUE_EXPRESSION_TYPE = AbstractMCodeExpression.class;
	
	
	private final String _varName;
	
	private final AbstractMCodeExpression _valueExpression;
	
	public MAssignmentCodeStatement(final String pVarName, final AbstractMCodeExpression pValueExpression) {
		super();
		if (pVarName == null) {
			throw new IllegalArgumentException("pVarName == null");
		}
		_varName = pVarName;
		if (pValueExpression == null) {
			throw new IllegalArgumentException("pValueExpression == null");
		}
		_valueExpression = pValueExpression;
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	
	// @ccg.userblock.end
	
	/**
	 * Return the value of property varName.
	 * 
	 * @return The value of property varName.
	 */
	public final String getVarName() {
		return _varName;
	}
	
	/**
	 * Return the value of property valueExpression.
	 * 
	 * @return The value of property valueExpression.
	 */
	public final AbstractMCodeExpression getValueExpression() {
		return _valueExpression;
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
