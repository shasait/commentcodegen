/**
 * <copyright>
 * </copyright>
 *
 * $Id: CUnparsedStatement.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CUnparsed Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.CUnparsedStatement#getCode <em>Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCUnparsedStatement()
 * @model
 * @generated
 */
public interface CUnparsedStatement extends AbstractCStatement {
	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(String)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCUnparsedStatement_Code()
	 * @model required="true"
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.CUnparsedStatement#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

} // CUnparsedStatement