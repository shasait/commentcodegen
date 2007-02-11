/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractModifiers.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Modifiers</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractModifiers#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractModifiers#isFinal <em>Final</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractModifiers#isSynchronized <em>Synchronized</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractModifiers()
 * @model abstract="true"
 * @generated
 */
public interface AbstractModifiers extends EObject {
	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The default value is <code>"PUBLIC"</code>.
	 * The literals are from the enumeration {@link de.hasait.eclipse.ccg.java.model.MVisibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see de.hasait.eclipse.ccg.java.model.MVisibility
	 * @see #setVisibility(MVisibility)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractModifiers_Visibility()
	 * @model default="PUBLIC" required="true"
	 * @generated
	 */
	MVisibility getVisibility();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractModifiers#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see de.hasait.eclipse.ccg.java.model.MVisibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(MVisibility value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractModifiers_Final()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractModifiers#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Synchronized</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synchronized</em>' attribute.
	 * @see #setSynchronized(boolean)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractModifiers_Synchronized()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isSynchronized();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractModifiers#isSynchronized <em>Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synchronized</em>' attribute.
	 * @see #isSynchronized()
	 * @generated
	 */
	void setSynchronized(boolean value);

} // AbstractModifiers