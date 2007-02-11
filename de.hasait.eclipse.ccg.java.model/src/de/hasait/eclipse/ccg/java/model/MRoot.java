/**
 * <copyright>
 * </copyright>
 *
 * $Id: MRoot.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MRoot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MRoot#getExternalTypes <em>External Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMRoot()
 * @model
 * @generated
 */
public interface MRoot extends AbstractMPackageContainer {
	/**
	 * Returns the value of the '<em><b>External Types</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.AbstractMExternalType}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.AbstractMExternalType#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Types</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMRoot_ExternalTypes()
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMExternalType#getRoot
	 * @model type="de.hasait.eclipse.ccg.java.model.AbstractMExternalType" opposite="root" containment="true"
	 * @generated
	 */
	EList getExternalTypes();

} // MRoot