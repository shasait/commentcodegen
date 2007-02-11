/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMFieldDeclaration.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MField Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMFieldDeclaration#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMFieldDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMFieldDeclaration extends AbstractMTypeWithNameDeclaration {
	/**
	 * Returns the value of the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Value</em>' containment reference.
	 * @see #setInitialValue(AbstractCExpression)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMFieldDeclaration_InitialValue()
	 * @model containment="true"
	 * @generated
	 */
	AbstractCExpression getInitialValue();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMFieldDeclaration#getInitialValue <em>Initial Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Value</em>' containment reference.
	 * @see #getInitialValue()
	 * @generated
	 */
	void setInitialValue(AbstractCExpression value);

} // AbstractMFieldDeclaration