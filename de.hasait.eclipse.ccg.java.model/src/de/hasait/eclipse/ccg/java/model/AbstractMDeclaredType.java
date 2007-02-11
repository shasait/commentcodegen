/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractMDeclaredType.java,v 1.1 2007-02-11 22:29:52 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract MDeclared Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType#getTypeContainer <em>Type Container</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMDeclaredType()
 * @model abstract="true"
 * @generated
 */
public interface AbstractMDeclaredType extends AbstractMTypeContainer {
	/**
	 * Returns the value of the '<em><b>Type Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Container</em>' container reference.
	 * @see #setTypeContainer(AbstractMTypeContainer)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMDeclaredType_TypeContainer()
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer#getTypes
	 * @model opposite="types" required="true"
	 * @generated
	 */
	AbstractMTypeContainer getTypeContainer();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType#getTypeContainer <em>Type Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Container</em>' container reference.
	 * @see #getTypeContainer()
	 * @generated
	 */
	void setTypeContainer(AbstractMTypeContainer value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getAbstractMDeclaredType_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // AbstractMDeclaredType