/**
 * <copyright>
 * </copyright>
 *
 * $Id: MAbstractClassMethodDeclaration.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MAbstract Class Method Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration#getOwner <em>Owner</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMAbstractClassMethodDeclaration()
 * @model
 * @generated
 */
public interface MAbstractClassMethodDeclaration extends AbstractMImplementableMethodDeclaration {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass#getAbstractMethods <em>Abstract Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(MAbstractDeclaredClass)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMAbstractClassMethodDeclaration_Owner()
	 * @see de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass#getAbstractMethods
	 * @model opposite="abstractMethods" required="true"
	 * @generated
	 */
	MAbstractDeclaredClass getOwner();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(MAbstractDeclaredClass value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The default value is <code>"PROTECTED"</code>.
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
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMAbstractClassMethodDeclaration_Visibility()
	 * @model default="PROTECTED" required="true"
	 * @generated
	 */
	MVisibility getVisibility();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see de.hasait.eclipse.ccg.java.model.MVisibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(MVisibility value);

} // MAbstractClassMethodDeclaration