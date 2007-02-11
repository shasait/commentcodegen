/**
 * <copyright>
 * </copyright>
 *
 * $Id: MConstructorParameter.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MConstructor Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MConstructorParameter#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MConstructorParameter#isFinal <em>Final</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMConstructorParameter()
 * @model
 * @generated
 */
public interface MConstructorParameter extends AbstractMTypeWithNameDeclaration {
	/**
	 * Returns the value of the '<em><b>Constructor</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.MConstructor#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constructor</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constructor</em>' container reference.
	 * @see #setConstructor(MConstructor)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMConstructorParameter_Constructor()
	 * @see de.hasait.eclipse.ccg.java.model.MConstructor#getParameters
	 * @model opposite="parameters" required="true"
	 * @generated
	 */
	MConstructor getConstructor();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MConstructorParameter#getConstructor <em>Constructor</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constructor</em>' container reference.
	 * @see #getConstructor()
	 * @generated
	 */
	void setConstructor(MConstructor value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMConstructorParameter_Final()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MConstructorParameter#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

} // MConstructorParameter