/**
 * <copyright>
 * </copyright>
 *
 * $Id: CDeclarationStatement.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CDeclaration Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.CDeclarationStatement#isFinal <em>Final</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.CDeclarationStatement#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCDeclarationStatement()
 * @model
 * @generated
 */
public interface CDeclarationStatement extends AbstractCStatement, AbstractMTypeWithNameDeclaration {
	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCDeclarationStatement_Final()
	 * @model required="true"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.CDeclarationStatement#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(AbstractCExpression)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getCDeclarationStatement_Value()
	 * @model containment="true"
	 * @generated
	 */
	AbstractCExpression getValue();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.CDeclarationStatement#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(AbstractCExpression value);

} // CDeclarationStatement