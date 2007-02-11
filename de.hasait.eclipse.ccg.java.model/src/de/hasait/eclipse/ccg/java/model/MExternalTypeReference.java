/**
 * <copyright>
 * </copyright>
 *
 * $Id: MExternalTypeReference.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MExternal Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MExternalTypeReference#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMExternalTypeReference()
 * @model
 * @generated
 */
public interface MExternalTypeReference extends AbstractMTypeReference {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(AbstractMExternalType)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMExternalTypeReference_Type()
	 * @model required="true"
	 * @generated
	 */
	AbstractMExternalType getType();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MExternalTypeReference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(AbstractMExternalType value);

} // MExternalTypeReference