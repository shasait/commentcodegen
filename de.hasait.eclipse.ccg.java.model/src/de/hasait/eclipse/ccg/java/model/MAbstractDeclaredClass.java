/**
 * <copyright>
 * </copyright>
 *
 * $Id: MAbstractDeclaredClass.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAbstract Declared Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass#getAbstractMethods <em>Abstract Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMAbstractDeclaredClass()
 * @model
 * @generated
 */
public interface MAbstractDeclaredClass extends MDeclaredClass {
	/**
	 * Returns the value of the '<em><b>Abstract Methods</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Methods</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMAbstractDeclaredClass_AbstractMethods()
	 * @see de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration#getOwner
	 * @model type="de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration" opposite="owner" containment="true"
	 * @generated
	 */
	EList getAbstractMethods();

} // MAbstractDeclaredClass