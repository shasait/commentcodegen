/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMPackageContainer.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MPackage Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer#getPackages <em>Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMPackageContainer()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMPackageContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.MPackage}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MPackage#getPackageContainer <em>Package Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMPackageContainer_Packages()
	 * @see de.hasait.eclipse.ccg.java.model.MPackage#getPackageContainer
	 * @model type="de.hasait.eclipse.ccg.java.model.MPackage" opposite="packageContainer" containment="true"
	 * @generated
	 */
	EList getPackages();

} // AbstractMPackageContainer