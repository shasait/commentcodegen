/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMClassFieldDeclaration.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MClass Field Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration#isFinal <em>Final</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMClassFieldDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMClassFieldDeclaration extends AbstractMFieldDeclaration {
	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The default value is <code>"PRIVATE"</code>.
	 * The literals are from the enumeration {@link de.hasait.eclipse.ccg.java.model.MVisibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see de.hasait.eclipse.ccg.java.model.MVisibility
	 * @see #setVisibility(MVisibility)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMClassFieldDeclaration_Visibility()
	 * @model default="PRIVATE" required="true"
	 * @generated
	 */
	MVisibility getVisibility();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see de.hasait.eclipse.ccg.java.model.MVisibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(MVisibility value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMClassFieldDeclaration_Final()
	 * @model required="true"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

} // AbstractMClassFieldDeclaration