/**
 * <copyright>
 * </copyright>
 *
 * $Id: CExpressionStatement.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CExpression Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.CExpressionStatement#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCExpressionStatement()
 * @model
 * @generated
 */
public interface CExpressionStatement extends AbstractCStatement {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(AbstractCExpression)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCExpressionStatement_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractCExpression getExpression();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.CExpressionStatement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(AbstractCExpression value);

} // CExpressionStatement