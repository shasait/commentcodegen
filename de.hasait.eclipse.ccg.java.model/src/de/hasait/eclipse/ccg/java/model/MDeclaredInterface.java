/**
 * <copyright>
 * </copyright>
 *
 * $Id: MDeclaredInterface.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MDeclared Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredInterface#getExtends <em>Extends</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredInterface#getConstants <em>Constants</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MDeclaredInterface#getMethods <em>Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredInterface()
 * @model
 * @generated
 */
public interface MDeclaredInterface extends AbstractMInterface, AbstractMDeclaredType {
	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.AbstractMInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredInterface_Extends()
	 * @model type="de.hasait.eclipse.ccg.java.model.AbstractMInterface"
	 * @generated
	 */
	EList getExtends();

	/**
	 * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constants</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredInterface_Constants()
	 * @see de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration#getOwner
	 * @model type="de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration" opposite="owner" containment="true"
	 * @generated
	 */
	EList getConstants();

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMDeclaredInterface_Methods()
	 * @see de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration#getOwner
	 * @model type="de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration" opposite="owner" containment="true"
	 * @generated
	 */
	EList getMethods();

} // MDeclaredInterface