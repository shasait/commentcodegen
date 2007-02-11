/**
 * <copyright>
 * </copyright>
 *
 * $Id: MPrimitiveTypeReference.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MPrimitive Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MPrimitiveTypeReference#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMPrimitiveTypeReference()
 * @model
 * @generated
 */
public interface MPrimitiveTypeReference extends AbstractMTypeReference {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.hasait.eclipse.ccg.java.model.MPrimitiveTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.hasait.eclipse.ccg.java.model.MPrimitiveTypes
	 * @see #setType(MPrimitiveTypes)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMPrimitiveTypeReference_Type()
	 * @model required="true"
	 * @generated
	 */
	MPrimitiveTypes getType();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MPrimitiveTypeReference#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.hasait.eclipse.ccg.java.model.MPrimitiveTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(MPrimitiveTypes value);

} // MPrimitiveTypeReference