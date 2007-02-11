/**
 * <copyright>
 * </copyright>
 *
 * $Id: MInstanceClassFieldDeclaration.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MInstance Class Field Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration#getOwner <em>Owner</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration#isTransient <em>Transient</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMInstanceClassFieldDeclaration()
 * @model
 * @generated
 */
public interface MInstanceClassFieldDeclaration extends AbstractMClassFieldDeclaration {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getInstanceFields <em>Instance Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(MDeclaredClass)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMInstanceClassFieldDeclaration_Owner()
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getInstanceFields
	 * @model opposite="instanceFields" required="true"
	 * @generated
	 */
	MDeclaredClass getOwner();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(MDeclaredClass value);

	/**
	 * Returns the value of the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transient</em>' attribute.
	 * @see #setTransient(boolean)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMInstanceClassFieldDeclaration_Transient()
	 * @model required="true"
	 * @generated
	 */
	boolean isTransient();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration#isTransient <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transient</em>' attribute.
	 * @see #isTransient()
	 * @generated
	 */
	void setTransient(boolean value);

} // MInstanceClassFieldDeclaration