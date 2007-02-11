/**
 * <copyright>
 * </copyright>
 *
 * $Id: CIfStatement.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CIf Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.CIfStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.CIfStatement#getTrueStatement <em>True Statement</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.CIfStatement#getFalseStatement <em>False Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCIfStatement()
 * @model
 * @generated
 */
public interface CIfStatement extends AbstractCStatement {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(AbstractCExpression)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCIfStatement_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractCExpression getCondition();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.CIfStatement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(AbstractCExpression value);

	/**
	 * Returns the value of the '<em><b>True Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True Statement</em>' containment reference.
	 * @see #setTrueStatement(AbstractCStatement)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCIfStatement_TrueStatement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractCStatement getTrueStatement();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.CIfStatement#getTrueStatement <em>True Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>True Statement</em>' containment reference.
	 * @see #getTrueStatement()
	 * @generated
	 */
	void setTrueStatement(AbstractCStatement value);

	/**
	 * Returns the value of the '<em><b>False Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>False Statement</em>' containment reference.
	 * @see #setFalseStatement(AbstractCStatement)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCIfStatement_FalseStatement()
	 * @model containment="true"
	 * @generated
	 */
	AbstractCStatement getFalseStatement();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.CIfStatement#getFalseStatement <em>False Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>False Statement</em>' containment reference.
	 * @see #getFalseStatement()
	 * @generated
	 */
	void setFalseStatement(AbstractCStatement value);

} // CIfStatement