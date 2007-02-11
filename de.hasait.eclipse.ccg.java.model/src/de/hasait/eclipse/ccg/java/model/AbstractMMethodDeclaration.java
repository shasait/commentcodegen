/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMMethodDeclaration.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MMethod Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodDeclaration#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMMethodDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMMethodDeclaration extends AbstractMTypeWithNameDeclaration {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter#getMethodDeclaration <em>Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMMethodDeclaration_Parameters()
	 * @see de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter#getMethodDeclaration
	 * @model type="de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter" opposite="methodDeclaration" containment="true"
	 * @generated
	 */
	EList getParameters();

} // AbstractMMethodDeclaration