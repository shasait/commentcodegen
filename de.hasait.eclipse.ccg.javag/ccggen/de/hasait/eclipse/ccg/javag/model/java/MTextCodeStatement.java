package de.hasait.eclipse.ccg.javag.model.java;


/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MTextCodeStatement extends AbstractMCodeStatement {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property statementText. */
	public static final String PROPERTY_STATEMENT_TEXT_NAME = "statementText";
	/** Type of property statementText. */
	public static final Class PROPERTY_STATEMENT_TEXT_TYPE = String.class;
	
	
	private final String _statementText;
	
	public MTextCodeStatement(final String pStatementText) {
		super();
		if (pStatementText == null) {
			throw new IllegalArgumentException("pStatementText == null");
		}
		_statementText = pStatementText;
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	
	// @ccg.userblock.end
	
	/**
	 * Return the value of property statementText.
	 * 
	 * @return The value of property statementText.
	 */
	public final String getStatementText() {
		return _statementText;
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
