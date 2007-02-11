/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMTypeWithNameDeclaration.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MType With Name Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration#getType <em>Type</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMTypeWithNameDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMTypeWithNameDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(AbstractMTypeReference)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMTypeWithNameDeclaration_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractMTypeReference getType();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(AbstractMTypeReference value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMTypeWithNameDeclaration_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // AbstractMTypeWithNameDeclaration