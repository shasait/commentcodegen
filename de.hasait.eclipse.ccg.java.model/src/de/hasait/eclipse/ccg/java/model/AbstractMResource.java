/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMResource.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MResource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getPackage <em>Package</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getName <em>Name</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#isDerived <em>Derived</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getDerivedFrom <em>Derived From</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getSuperOf <em>Super Of</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMResource()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMResource extends EObject {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MPackage#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(MPackage)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMResource_Package()
	 * @see de.hasait.eclipse.ccg.java.model.MPackage#getResources
	 * @model opposite="resources" required="true"
	 * @generated
	 */
	MPackage getPackage();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(MPackage value);

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
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMResource_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Derived</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived</em>' attribute.
	 * @see #setDerived(boolean)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMResource_Derived()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isDerived();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#isDerived <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived</em>' attribute.
	 * @see #isDerived()
	 * @generated
	 */
	void setDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Derived From</b></em>' reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.AbstractMResource}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getSuperOf <em>Super Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived From</em>' reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMResource_DerivedFrom()
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMResource#getSuperOf
	 * @model type="de.hasait.eclipse.ccg.java.model.AbstractMResource" opposite="superOf"
	 * @generated
	 */
	EList getDerivedFrom();

	/**
	 * Returns the value of the '<em><b>Super Of</b></em>' reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.AbstractMResource}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getDerivedFrom <em>Derived From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Of</em>' reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMResource_SuperOf()
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMResource#getDerivedFrom
	 * @model type="de.hasait.eclipse.ccg.java.model.AbstractMResource" opposite="derivedFrom"
	 * @generated
	 */
	EList getSuperOf();

} // AbstractMResource