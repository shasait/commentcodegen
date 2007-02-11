/**
 * <copyright>
 * </copyright>
 *
 * $Id: MPackage.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MPackage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MPackage#getPackageContainer <em>Package Container</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MPackage#getName <em>Name</em>}</li>
 *   <li>{@link de.hasait.eclipse.ccg.java.model.MPackage#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMPackage()
 * @model
 * @generated
 */
public interface MPackage extends AbstractMPackageContainer {
	/**
	 * Returns the value of the '<em><b>Package Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Container</em>' container reference.
	 * @see #setPackageContainer(AbstractMPackageContainer)
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMPackage_PackageContainer()
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer#getPackages
	 * @model opposite="packages" required="true"
	 * @generated
	 */
	AbstractMPackageContainer getPackageContainer();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MPackage#getPackageContainer <em>Package Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Container</em>' container reference.
	 * @see #getPackageContainer()
	 * @generated
	 */
	void setPackageContainer(AbstractMPackageContainer value);

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
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMPackage_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hasait.eclipse.ccg.java.model.MPackage#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link de.hasait.eclipse.ccg.java.model.AbstractMResource}.
	 * It is bidirectional and its opposite is '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMPackage_Resources()
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMResource#getPackage
	 * @model type="de.hasait.eclipse.ccg.java.model.AbstractMResource" opposite="package" containment="true"
	 * @generated
	 */
	EList getResources();

} // MPackage