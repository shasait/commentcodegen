/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMExternalType.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MExternal Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMExternalType#getRoot <em>Root</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMExternalType#getFullQualifiedName <em>Full Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMExternalType()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMExternalType extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MRoot#getExternalTypes <em>External Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' container reference.
	 * @see #setRoot(MRoot)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMExternalType_Root()
	 * @see de.hasait.eclipse.ccg.java.model.MRoot#getExternalTypes
	 * @model opposite="externalTypes" required="true"
	 * @generated
	 */
	MRoot getRoot();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMExternalType#getRoot <em>Root</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' container reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(MRoot value);

	/**
	 * Returns the value of the '<em><b>Full Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Full Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Full Qualified Name</em>' attribute.
	 * @see #setFullQualifiedName(String)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMExternalType_FullQualifiedName()
	 * @model required="true"
	 * @generated
	 */
	String getFullQualifiedName();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMExternalType#getFullQualifiedName <em>Full Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Full Qualified Name</em>' attribute.
	 * @see #getFullQualifiedName()
	 * @generated
	 */
	void setFullQualifiedName(String value);

} // AbstractMExternalType