/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMTypeContainer.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MType Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMTypeContainer()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMTypeContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType#getTypeContainer <em>Type Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMTypeContainer_Types()
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType#getTypeContainer
	 * @model type="de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType" opposite="typeContainer" containment="true"
	 * @generated
	 */
	EList getTypes();

} // AbstractMTypeContainer