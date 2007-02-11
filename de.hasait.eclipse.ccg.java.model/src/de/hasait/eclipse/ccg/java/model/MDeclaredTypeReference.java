/**
 * <copyright>
 * </copyright>
 *
 * $Id: MDeclaredTypeReference.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MDeclared Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredTypeReference#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredTypeReference()
 * @model
 * @generated
 */
public interface MDeclaredTypeReference extends AbstractMTypeReference {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(AbstractMDeclaredType)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredTypeReference_Type()
	 * @model required="true"
	 * @generated
	 */
	AbstractMDeclaredType getType();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MDeclaredTypeReference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(AbstractMDeclaredType value);

} // MDeclaredTypeReference