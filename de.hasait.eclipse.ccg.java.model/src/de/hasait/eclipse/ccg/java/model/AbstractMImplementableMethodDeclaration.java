/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMImplementableMethodDeclaration.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MImplementable Method Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration#getImplementations <em>Implementations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMImplementableMethodDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMImplementableMethodDeclaration extends AbstractMMethodDeclaration {
	/**
	 * Returns the value of the '<em><b>Implementations</b></em>' reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementations</em>' reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMImplementableMethodDeclaration_Implementations()
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation#getDeclaration
	 * @model type="de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation" opposite="declaration"
	 * @generated
	 */
	EList getImplementations();

} // AbstractMImplementableMethodDeclaration