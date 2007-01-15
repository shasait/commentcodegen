package de.hasait.eclipse.ccg.javag.model.java;


/**
 * @author CCG /model/ccg/model.ccg.xml
 */
public class MUserCodeStatement extends AbstractMCodeStatement {
	// @ccg.userblock.start ClassBegin
	
	// @ccg.userblock.end
	
	/** Name of property userBlockName. */
	public static final String PROPERTY_USER_BLOCK_NAME_NAME = "userBlockName";
	/** Type of property userBlockName. */
	public static final Class PROPERTY_USER_BLOCK_NAME_TYPE = String.class;
	
	
	private final String _userBlockName;
	
	public MUserCodeStatement(final String pUserBlockName) {
		super();
		if (pUserBlockName == null) {
			throw new IllegalArgumentException("pUserBlockName == null");
		}
		_userBlockName = pUserBlockName;
	}
	
	// @ccg.userblock.start ClassAfterConstructor
	
	// @ccg.userblock.end
	
	/**
	 * Return the value of property userBlockName.
	 * 
	 * @return The value of property userBlockName.
	 */
	public final String getUserBlockName() {
		return _userBlockName;
	}
	
	
	// @ccg.userblock.start ClassEnd
	
	// @ccg.userblock.end
}
