/**
 * <copyright>
 * </copyright>
 *
 * $Id: MDeclaredClass.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MDeclared Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getExtends <em>Extends</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getImplements <em>Implements</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getStaticFields <em>Static Fields</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getInstanceFields <em>Instance Fields</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getConstructors <em>Constructors</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getImplementedMethods <em>Implemented Methods</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getNativeMethods <em>Native Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredClass()
 * @model
 * @generated
 */
public interface MDeclaredClass extends AbstractMClass, AbstractMDeclaredType {
	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference.
	 * @see #setExtends(AbstractMClass)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredClass_Extends()
	 * @model
	 * @generated
	 */
	AbstractMClass getExtends();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getExtends <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(AbstractMClass value);

	/**
	 * Returns the value of the '<em><b>Implements</b></em>' reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.AbstractMInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements</em>' reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredClass_Implements()
	 * @model type="de.hasait.eclipse.ccg.java.model.AbstractMInterface"
	 * @generated
	 */
	EList getImplements();

	/**
	 * Returns the value of the '<em><b>Static Fields</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Fields</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredClass_StaticFields()
	 * @see de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration#getOwner
	 * @model type="de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration" opposite="owner" containment="true"
	 * @generated
	 */
	EList getStaticFields();

	/**
	 * Returns the value of the '<em><b>Instance Fields</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Fields</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Fields</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredClass_InstanceFields()
	 * @see de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration#getOwner
	 * @model type="de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration" opposite="owner" containment="true"
	 * @generated
	 */
	EList getInstanceFields();

	/**
	 * Returns the value of the '<em><b>Constructors</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MConstructor}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MConstructor#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constructors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constructors</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredClass_Constructors()
	 * @see de.hasait.eclipse.ccg.java.model.MConstructor#getOwner
	 * @model type="de.hasait.eclipse.ccg.java.model.MConstructor" opposite="owner" containment="true"
	 * @generated
	 */
	EList getConstructors();

	/**
	 * Returns the value of the '<em><b>Implemented Methods</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implemented Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implemented Methods</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredClass_ImplementedMethods()
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation#getOwner
	 * @model type="de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation" opposite="owner" containment="true"
	 * @generated
	 */
	EList getImplementedMethods();

	/**
	 * Returns the value of the '<em><b>Native Methods</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native Methods</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredClass_NativeMethods()
	 * @see de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration#getOwner
	 * @model type="de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration" opposite="owner" containment="true"
	 * @generated
	 */
	EList getNativeMethods();

} // MDeclaredClass