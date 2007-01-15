package de.hasait.eclipse.ccg.javag.model.java;


/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MTextCodeExpression extends AbstractMCodeExpression {
	// @ccg.userblock.start ClassBegin
	// @ccg.userblock.end

	/** Name of property expressionText. */
	public static final String PROPERTY_EXPRESSION_TEXT_NAME = "expressionText";
	/** Type of property expressionText. */
	public static final Class PROPERTY_EXPRESSION_TEXT_TYPE = String.class;


	private final String _expressionText;

	public MTextCodeExpression(final String pExpressionText) {
		super();
		if (pExpressionText == null) {
			throw new IllegalArgumentException("pExpressionText == null");
		}
		_expressionText = pExpressionText;
	}

	// @ccg.userblock.start ClassAfterConstructor
	// @ccg.userblock.end

	/**
	 * Return the value of property expressionText.

	 * @return The value of property expressionText.
	 */
	public final String getExpressionText() {
		return _expressionText;
	}


	// @ccg.userblock.start ClassEnd
	// @ccg.userblock.end
}
