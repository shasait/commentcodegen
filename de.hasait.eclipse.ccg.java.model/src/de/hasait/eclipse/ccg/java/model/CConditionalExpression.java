/**
 * <copyright>
 * </copyright>
 *
 * $Id: CConditionalExpression.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CConditional Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.CConditionalExpression#getCondition <em>Condition</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.CConditionalExpression#getTrueExpression <em>True Expression</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.CConditionalExpression#getFalseExpression <em>False Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCConditionalExpression()
 * @model
 * @generated
 */
public interface CConditionalExpression extends AbstractCExpression {
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
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCConditionalExpression_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractCExpression getCondition();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.CConditionalExpression#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(AbstractCExpression value);

	/**
	 * Returns the value of the '<em><b>True Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True Expression</em>' containment reference.
	 * @see #setTrueExpression(AbstractCExpression)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCConditionalExpression_TrueExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractCExpression getTrueExpression();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.CConditionalExpression#getTrueExpression <em>True Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>True Expression</em>' containment reference.
	 * @see #getTrueExpression()
	 * @generated
	 */
	void setTrueExpression(AbstractCExpression value);

	/**
	 * Returns the value of the '<em><b>False Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>False Expression</em>' containment reference.
	 * @see #setFalseExpression(AbstractCExpression)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCConditionalExpression_FalseExpression()
	 * @model containment="true"
	 * @generated
	 */
	AbstractCExpression getFalseExpression();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.CConditionalExpression#getFalseExpression <em>False Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>False Expression</em>' containment reference.
	 * @see #getFalseExpression()
	 * @generated
	 */
	void setFalseExpression(AbstractCExpression value);

} // CConditionalExpression