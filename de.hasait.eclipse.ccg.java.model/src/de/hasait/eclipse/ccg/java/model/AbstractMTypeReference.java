/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMTypeReference.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MType Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeReference#isArray <em>Array</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMTypeReference()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMTypeReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Array</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array</em>' attribute.
	 * @see #setArray(boolean)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMTypeReference_Array()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isArray();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeReference#isArray <em>Array</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array</em>' attribute.
	 * @see #isArray()
	 * @generated
	 */
	void setArray(boolean value);

} // AbstractMTypeReference