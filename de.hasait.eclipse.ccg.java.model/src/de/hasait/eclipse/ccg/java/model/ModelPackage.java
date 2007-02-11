/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelPackage.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hasait.eclipse.ccg.java.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.hasait.de/ccg/java/model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMPackageContainerImpl <em>Abstract MPackage Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMPackageContainerImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMPackageContainer()
	 * @generated
	 */
	int ABSTRACT_MPACKAGE_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MPACKAGE_CONTAINER__PACKAGES = 0;

	/**
	 * The number of structural features of the '<em>Abstract MPackage Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MPACKAGE_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MRootImpl <em>MRoot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MRootImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMRoot()
	 * @generated
	 */
	int MROOT = 1;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MROOT__PACKAGES = ABSTRACT_MPACKAGE_CONTAINER__PACKAGES;

	/**
	 * The feature id for the '<em><b>External Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MROOT__EXTERNAL_TYPES = ABSTRACT_MPACKAGE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MRoot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MROOT_FEATURE_COUNT = ABSTRACT_MPACKAGE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MPackageImpl <em>MPackage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MPackageImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMPackage()
	 * @generated
	 */
	int MPACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE__PACKAGES = ABSTRACT_MPACKAGE_CONTAINER__PACKAGES;

	/**
	 * The feature id for the '<em><b>Package Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE__PACKAGE_CONTAINER = ABSTRACT_MPACKAGE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE__NAME = ABSTRACT_MPACKAGE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE__RESOURCES = ABSTRACT_MPACKAGE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>MPackage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPACKAGE_FEATURE_COUNT = ABSTRACT_MPACKAGE_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMResourceImpl <em>Abstract MResource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMResourceImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMResource()
	 * @generated
	 */
	int ABSTRACT_MRESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MRESOURCE__PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MRESOURCE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MRESOURCE__DERIVED = 2;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MRESOURCE__DERIVED_FROM = 3;

	/**
	 * The feature id for the '<em><b>Super Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MRESOURCE__SUPER_OF = 4;

	/**
	 * The number of structural features of the '<em>Abstract MResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MRESOURCE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MResourceImpl <em>MResource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MResourceImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMResource()
	 * @generated
	 */
	int MRESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE__PACKAGE = ABSTRACT_MRESOURCE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE__NAME = ABSTRACT_MRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE__DERIVED = ABSTRACT_MRESOURCE__DERIVED;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE__DERIVED_FROM = ABSTRACT_MRESOURCE__DERIVED_FROM;

	/**
	 * The feature id for the '<em><b>Super Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE__SUPER_OF = ABSTRACT_MRESOURCE__SUPER_OF;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE__CONTENT = ABSTRACT_MRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MResource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MRESOURCE_FEATURE_COUNT = ABSTRACT_MRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeContainerImpl <em>Abstract MType Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeContainerImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMTypeContainer()
	 * @generated
	 */
	int ABSTRACT_MTYPE_CONTAINER = 5;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MTYPE_CONTAINER__TYPES = 0;

	/**
	 * The number of structural features of the '<em>Abstract MType Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MTYPE_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MCompilationUnitImpl <em>MCompilation Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MCompilationUnitImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMCompilationUnit()
	 * @generated
	 */
	int MCOMPILATION_UNIT = 6;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMPILATION_UNIT__PACKAGE = ABSTRACT_MRESOURCE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMPILATION_UNIT__NAME = ABSTRACT_MRESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMPILATION_UNIT__DERIVED = ABSTRACT_MRESOURCE__DERIVED;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMPILATION_UNIT__DERIVED_FROM = ABSTRACT_MRESOURCE__DERIVED_FROM;

	/**
	 * The feature id for the '<em><b>Super Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMPILATION_UNIT__SUPER_OF = ABSTRACT_MRESOURCE__SUPER_OF;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMPILATION_UNIT__TYPES = ABSTRACT_MRESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMPILATION_UNIT__IMPORTS = ABSTRACT_MRESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>MCompilation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCOMPILATION_UNIT_FEATURE_COUNT = ABSTRACT_MRESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMDeclaredTypeImpl <em>Abstract MDeclared Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMDeclaredTypeImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMDeclaredType()
	 * @generated
	 */
	int ABSTRACT_MDECLARED_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MDECLARED_TYPE__TYPES = ABSTRACT_MTYPE_CONTAINER__TYPES;

	/**
	 * The feature id for the '<em><b>Type Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MDECLARED_TYPE__TYPE_CONTAINER = ABSTRACT_MTYPE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MDECLARED_TYPE__NAME = ABSTRACT_MTYPE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract MDeclared Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MDECLARED_TYPE_FEATURE_COUNT = ABSTRACT_MTYPE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMExternalTypeImpl <em>Abstract MExternal Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMExternalTypeImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMExternalType()
	 * @generated
	 */
	int ABSTRACT_MEXTERNAL_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEXTERNAL_TYPE__ROOT = 0;

	/**
	 * The feature id for the '<em><b>Full Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEXTERNAL_TYPE__FULL_QUALIFIED_NAME = 1;

	/**
	 * The number of structural features of the '<em>Abstract MExternal Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MEXTERNAL_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeImpl <em>Abstract MType</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMType()
	 * @generated
	 */
	int ABSTRACT_MTYPE = 9;

	/**
	 * The number of structural features of the '<em>Abstract MType</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MTYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeReferenceImpl <em>Abstract MType Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeReferenceImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMTypeReference()
	 * @generated
	 */
	int ABSTRACT_MTYPE_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Array</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MTYPE_REFERENCE__ARRAY = 0;

	/**
	 * The number of structural features of the '<em>Abstract MType Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MTYPE_REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredTypeReferenceImpl <em>MDeclared Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MDeclaredTypeReferenceImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMDeclaredTypeReference()
	 * @generated
	 */
	int MDECLARED_TYPE_REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Array</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_TYPE_REFERENCE__ARRAY = ABSTRACT_MTYPE_REFERENCE__ARRAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_TYPE_REFERENCE__TYPE = ABSTRACT_MTYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MDeclared Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_TYPE_REFERENCE_FEATURE_COUNT = ABSTRACT_MTYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MExternalTypeReferenceImpl <em>MExternal Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MExternalTypeReferenceImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMExternalTypeReference()
	 * @generated
	 */
	int MEXTERNAL_TYPE_REFERENCE = 12;

	/**
	 * The feature id for the '<em><b>Array</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEXTERNAL_TYPE_REFERENCE__ARRAY = ABSTRACT_MTYPE_REFERENCE__ARRAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEXTERNAL_TYPE_REFERENCE__TYPE = ABSTRACT_MTYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MExternal Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEXTERNAL_TYPE_REFERENCE_FEATURE_COUNT = ABSTRACT_MTYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MPrimitiveTypeReferenceImpl <em>MPrimitive Type Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MPrimitiveTypeReferenceImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMPrimitiveTypeReference()
	 * @generated
	 */
	int MPRIMITIVE_TYPE_REFERENCE = 13;

	/**
	 * The feature id for the '<em><b>Array</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPRIMITIVE_TYPE_REFERENCE__ARRAY = ABSTRACT_MTYPE_REFERENCE__ARRAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPRIMITIVE_TYPE_REFERENCE__TYPE = ABSTRACT_MTYPE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MPrimitive Type Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MPRIMITIVE_TYPE_REFERENCE_FEATURE_COUNT = ABSTRACT_MTYPE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractModifiersImpl <em>Abstract Modifiers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractModifiersImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractModifiers()
	 * @generated
	 */
	int ABSTRACT_MODIFIERS = 14;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODIFIERS__VISIBILITY = 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODIFIERS__FINAL = 1;

	/**
	 * The feature id for the '<em><b>Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODIFIERS__SYNCHRONIZED = 2;

	/**
	 * The number of structural features of the '<em>Abstract Modifiers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODIFIERS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodLikeImpl <em>Abstract MMethod Like</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodLikeImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMMethodLike()
	 * @generated
	 */
	int ABSTRACT_MMETHOD_LIKE = 15;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_LIKE__VISIBILITY = ABSTRACT_MODIFIERS__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_LIKE__FINAL = ABSTRACT_MODIFIERS__FINAL;

	/**
	 * The feature id for the '<em><b>Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_LIKE__SYNCHRONIZED = ABSTRACT_MODIFIERS__SYNCHRONIZED;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_LIKE__STATEMENT = ABSTRACT_MODIFIERS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract MMethod Like</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_LIKE_FEATURE_COUNT = ABSTRACT_MODIFIERS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeWithNameDeclarationImpl <em>Abstract MType With Name Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeWithNameDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMTypeWithNameDeclaration()
	 * @generated
	 */
	int ABSTRACT_MTYPE_WITH_NAME_DECLARATION = 16;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MTYPE_WITH_NAME_DECLARATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MTYPE_WITH_NAME_DECLARATION__NAME = 1;

	/**
	 * The number of structural features of the '<em>Abstract MType With Name Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MTYPE_WITH_NAME_DECLARATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMClassImpl <em>Abstract MClass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMClassImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMClass()
	 * @generated
	 */
	int ABSTRACT_MCLASS = 17;

	/**
	 * The number of structural features of the '<em>Abstract MClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MCLASS_FEATURE_COUNT = ABSTRACT_MTYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl <em>MDeclared Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMDeclaredClass()
	 * @generated
	 */
	int MDECLARED_CLASS = 18;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_CLASS__TYPES = ABSTRACT_MCLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_CLASS__TYPE_CONTAINER = ABSTRACT_MCLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_CLASS__NAME = ABSTRACT_MCLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_CLASS__EXTENDS = ABSTRACT_MCLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Implements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_CLASS__IMPLEMENTS = ABSTRACT_MCLASS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Static Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_CLASS__STATIC_FIELDS = ABSTRACT_MCLASS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Instance Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_CLASS__INSTANCE_FIELDS = ABSTRACT_MCLASS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Constructors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_CLASS__CONSTRUCTORS = ABSTRACT_MCLASS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Implemented Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_CLASS__IMPLEMENTED_METHODS = ABSTRACT_MCLASS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Native Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_CLASS__NATIVE_METHODS = ABSTRACT_MCLASS_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>MDeclared Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_CLASS_FEATURE_COUNT = ABSTRACT_MCLASS_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MAbstractDeclaredClassImpl <em>MAbstract Declared Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MAbstractDeclaredClassImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMAbstractDeclaredClass()
	 * @generated
	 */
	int MABSTRACT_DECLARED_CLASS = 19;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS__TYPES = MDECLARED_CLASS__TYPES;

	/**
	 * The feature id for the '<em><b>Type Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS__TYPE_CONTAINER = MDECLARED_CLASS__TYPE_CONTAINER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS__NAME = MDECLARED_CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS__EXTENDS = MDECLARED_CLASS__EXTENDS;

	/**
	 * The feature id for the '<em><b>Implements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS__IMPLEMENTS = MDECLARED_CLASS__IMPLEMENTS;

	/**
	 * The feature id for the '<em><b>Static Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS__STATIC_FIELDS = MDECLARED_CLASS__STATIC_FIELDS;

	/**
	 * The feature id for the '<em><b>Instance Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS__INSTANCE_FIELDS = MDECLARED_CLASS__INSTANCE_FIELDS;

	/**
	 * The feature id for the '<em><b>Constructors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS__CONSTRUCTORS = MDECLARED_CLASS__CONSTRUCTORS;

	/**
	 * The feature id for the '<em><b>Implemented Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS__IMPLEMENTED_METHODS = MDECLARED_CLASS__IMPLEMENTED_METHODS;

	/**
	 * The feature id for the '<em><b>Native Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS__NATIVE_METHODS = MDECLARED_CLASS__NATIVE_METHODS;

	/**
	 * The feature id for the '<em><b>Abstract Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS = MDECLARED_CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MAbstract Declared Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_DECLARED_CLASS_FEATURE_COUNT = MDECLARED_CLASS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MExternalClassImpl <em>MExternal Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MExternalClassImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMExternalClass()
	 * @generated
	 */
	int MEXTERNAL_CLASS = 20;

	/**
	 * The feature id for the '<em><b>Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEXTERNAL_CLASS__ROOT = ABSTRACT_MCLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Full Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEXTERNAL_CLASS__FULL_QUALIFIED_NAME = ABSTRACT_MCLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>MExternal Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEXTERNAL_CLASS_FEATURE_COUNT = ABSTRACT_MCLASS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMInterfaceImpl <em>Abstract MInterface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMInterfaceImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMInterface()
	 * @generated
	 */
	int ABSTRACT_MINTERFACE = 21;

	/**
	 * The number of structural features of the '<em>Abstract MInterface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MINTERFACE_FEATURE_COUNT = ABSTRACT_MTYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredInterfaceImpl <em>MDeclared Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MDeclaredInterfaceImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMDeclaredInterface()
	 * @generated
	 */
	int MDECLARED_INTERFACE = 22;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_INTERFACE__TYPES = ABSTRACT_MINTERFACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_INTERFACE__TYPE_CONTAINER = ABSTRACT_MINTERFACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_INTERFACE__NAME = ABSTRACT_MINTERFACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_INTERFACE__EXTENDS = ABSTRACT_MINTERFACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_INTERFACE__CONSTANTS = ABSTRACT_MINTERFACE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_INTERFACE__METHODS = ABSTRACT_MINTERFACE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>MDeclared Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_INTERFACE_FEATURE_COUNT = ABSTRACT_MINTERFACE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MExternalInterfaceImpl <em>MExternal Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MExternalInterfaceImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMExternalInterface()
	 * @generated
	 */
	int MEXTERNAL_INTERFACE = 23;

	/**
	 * The feature id for the '<em><b>Root</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEXTERNAL_INTERFACE__ROOT = ABSTRACT_MINTERFACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Full Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEXTERNAL_INTERFACE__FULL_QUALIFIED_NAME = ABSTRACT_MINTERFACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>MExternal Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEXTERNAL_INTERFACE_FEATURE_COUNT = ABSTRACT_MINTERFACE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMFieldDeclarationImpl <em>Abstract MField Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMFieldDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMFieldDeclaration()
	 * @generated
	 */
	int ABSTRACT_MFIELD_DECLARATION = 24;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MFIELD_DECLARATION__TYPE = ABSTRACT_MTYPE_WITH_NAME_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MFIELD_DECLARATION__NAME = ABSTRACT_MTYPE_WITH_NAME_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MFIELD_DECLARATION__INITIAL_VALUE = ABSTRACT_MTYPE_WITH_NAME_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract MField Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MFIELD_DECLARATION_FEATURE_COUNT = ABSTRACT_MTYPE_WITH_NAME_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMClassFieldDeclarationImpl <em>Abstract MClass Field Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMClassFieldDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMClassFieldDeclaration()
	 * @generated
	 */
	int ABSTRACT_MCLASS_FIELD_DECLARATION = 25;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MCLASS_FIELD_DECLARATION__TYPE = ABSTRACT_MFIELD_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MCLASS_FIELD_DECLARATION__NAME = ABSTRACT_MFIELD_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MCLASS_FIELD_DECLARATION__INITIAL_VALUE = ABSTRACT_MFIELD_DECLARATION__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MCLASS_FIELD_DECLARATION__VISIBILITY = ABSTRACT_MFIELD_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MCLASS_FIELD_DECLARATION__FINAL = ABSTRACT_MFIELD_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract MClass Field Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MCLASS_FIELD_DECLARATION_FEATURE_COUNT = ABSTRACT_MFIELD_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MStaticClassFieldDeclarationImpl <em>MStatic Class Field Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MStaticClassFieldDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMStaticClassFieldDeclaration()
	 * @generated
	 */
	int MSTATIC_CLASS_FIELD_DECLARATION = 26;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSTATIC_CLASS_FIELD_DECLARATION__TYPE = ABSTRACT_MCLASS_FIELD_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSTATIC_CLASS_FIELD_DECLARATION__NAME = ABSTRACT_MCLASS_FIELD_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSTATIC_CLASS_FIELD_DECLARATION__INITIAL_VALUE = ABSTRACT_MCLASS_FIELD_DECLARATION__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSTATIC_CLASS_FIELD_DECLARATION__VISIBILITY = ABSTRACT_MCLASS_FIELD_DECLARATION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSTATIC_CLASS_FIELD_DECLARATION__FINAL = ABSTRACT_MCLASS_FIELD_DECLARATION__FINAL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSTATIC_CLASS_FIELD_DECLARATION__OWNER = ABSTRACT_MCLASS_FIELD_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MStatic Class Field Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSTATIC_CLASS_FIELD_DECLARATION_FEATURE_COUNT = ABSTRACT_MCLASS_FIELD_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MInstanceClassFieldDeclarationImpl <em>MInstance Class Field Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MInstanceClassFieldDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMInstanceClassFieldDeclaration()
	 * @generated
	 */
	int MINSTANCE_CLASS_FIELD_DECLARATION = 27;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINSTANCE_CLASS_FIELD_DECLARATION__TYPE = ABSTRACT_MCLASS_FIELD_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINSTANCE_CLASS_FIELD_DECLARATION__NAME = ABSTRACT_MCLASS_FIELD_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINSTANCE_CLASS_FIELD_DECLARATION__INITIAL_VALUE = ABSTRACT_MCLASS_FIELD_DECLARATION__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINSTANCE_CLASS_FIELD_DECLARATION__VISIBILITY = ABSTRACT_MCLASS_FIELD_DECLARATION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINSTANCE_CLASS_FIELD_DECLARATION__FINAL = ABSTRACT_MCLASS_FIELD_DECLARATION__FINAL;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINSTANCE_CLASS_FIELD_DECLARATION__OWNER = ABSTRACT_MCLASS_FIELD_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINSTANCE_CLASS_FIELD_DECLARATION__TRANSIENT = ABSTRACT_MCLASS_FIELD_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>MInstance Class Field Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINSTANCE_CLASS_FIELD_DECLARATION_FEATURE_COUNT = ABSTRACT_MCLASS_FIELD_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MConstantInterfaceFieldDeclarationImpl <em>MConstant Interface Field Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MConstantInterfaceFieldDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMConstantInterfaceFieldDeclaration()
	 * @generated
	 */
	int MCONSTANT_INTERFACE_FIELD_DECLARATION = 28;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTANT_INTERFACE_FIELD_DECLARATION__TYPE = ABSTRACT_MFIELD_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTANT_INTERFACE_FIELD_DECLARATION__NAME = ABSTRACT_MFIELD_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTANT_INTERFACE_FIELD_DECLARATION__INITIAL_VALUE = ABSTRACT_MFIELD_DECLARATION__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTANT_INTERFACE_FIELD_DECLARATION__OWNER = ABSTRACT_MFIELD_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MConstant Interface Field Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTANT_INTERFACE_FIELD_DECLARATION_FEATURE_COUNT = ABSTRACT_MFIELD_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodDeclarationImpl <em>Abstract MMethod Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMMethodDeclaration()
	 * @generated
	 */
	int ABSTRACT_MMETHOD_DECLARATION = 29;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_DECLARATION__TYPE = ABSTRACT_MTYPE_WITH_NAME_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_DECLARATION__NAME = ABSTRACT_MTYPE_WITH_NAME_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_DECLARATION__PARAMETERS = ABSTRACT_MTYPE_WITH_NAME_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract MMethod Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_DECLARATION_FEATURE_COUNT = ABSTRACT_MTYPE_WITH_NAME_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MMethodDeclarationParameterImpl <em>MMethod Declaration Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MMethodDeclarationParameterImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMMethodDeclarationParameter()
	 * @generated
	 */
	int MMETHOD_DECLARATION_PARAMETER = 30;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMETHOD_DECLARATION_PARAMETER__TYPE = ABSTRACT_MTYPE_WITH_NAME_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMETHOD_DECLARATION_PARAMETER__NAME = ABSTRACT_MTYPE_WITH_NAME_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Method Declaration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION = ABSTRACT_MTYPE_WITH_NAME_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MMethod Declaration Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMETHOD_DECLARATION_PARAMETER_FEATURE_COUNT = ABSTRACT_MTYPE_WITH_NAME_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MImplicitMethodDeclarationImpl <em>MImplicit Method Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MImplicitMethodDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMImplicitMethodDeclaration()
	 * @generated
	 */
	int MIMPLICIT_METHOD_DECLARATION = 31;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIMPLICIT_METHOD_DECLARATION__TYPE = ABSTRACT_MMETHOD_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIMPLICIT_METHOD_DECLARATION__NAME = ABSTRACT_MMETHOD_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIMPLICIT_METHOD_DECLARATION__PARAMETERS = ABSTRACT_MMETHOD_DECLARATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIMPLICIT_METHOD_DECLARATION__OWNER = ABSTRACT_MMETHOD_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MImplicit Method Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIMPLICIT_METHOD_DECLARATION_FEATURE_COUNT = ABSTRACT_MMETHOD_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMImplementableMethodDeclarationImpl <em>Abstract MImplementable Method Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMImplementableMethodDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMImplementableMethodDeclaration()
	 * @generated
	 */
	int ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION = 32;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__TYPE = ABSTRACT_MMETHOD_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__NAME = ABSTRACT_MMETHOD_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__PARAMETERS = ABSTRACT_MMETHOD_DECLARATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Implementations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS = ABSTRACT_MMETHOD_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract MImplementable Method Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION_FEATURE_COUNT = ABSTRACT_MMETHOD_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MAbstractClassMethodDeclarationImpl <em>MAbstract Class Method Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MAbstractClassMethodDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMAbstractClassMethodDeclaration()
	 * @generated
	 */
	int MABSTRACT_CLASS_METHOD_DECLARATION = 33;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_CLASS_METHOD_DECLARATION__TYPE = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_CLASS_METHOD_DECLARATION__NAME = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_CLASS_METHOD_DECLARATION__PARAMETERS = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Implementations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_CLASS_METHOD_DECLARATION__IMPLEMENTATIONS = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_CLASS_METHOD_DECLARATION__OWNER = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_CLASS_METHOD_DECLARATION__VISIBILITY = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>MAbstract Class Method Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MABSTRACT_CLASS_METHOD_DECLARATION_FEATURE_COUNT = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MInterfaceMethodDeclarationImpl <em>MInterface Method Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MInterfaceMethodDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMInterfaceMethodDeclaration()
	 * @generated
	 */
	int MINTERFACE_METHOD_DECLARATION = 34;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINTERFACE_METHOD_DECLARATION__TYPE = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINTERFACE_METHOD_DECLARATION__NAME = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINTERFACE_METHOD_DECLARATION__PARAMETERS = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Implementations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINTERFACE_METHOD_DECLARATION__IMPLEMENTATIONS = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINTERFACE_METHOD_DECLARATION__OWNER = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MInterface Method Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MINTERFACE_METHOD_DECLARATION_FEATURE_COUNT = ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MNativeMethodDeclarationImpl <em>MNative Method Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MNativeMethodDeclarationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMNativeMethodDeclaration()
	 * @generated
	 */
	int MNATIVE_METHOD_DECLARATION = 35;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MNATIVE_METHOD_DECLARATION__TYPE = ABSTRACT_MMETHOD_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MNATIVE_METHOD_DECLARATION__NAME = ABSTRACT_MMETHOD_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MNATIVE_METHOD_DECLARATION__PARAMETERS = ABSTRACT_MMETHOD_DECLARATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MNATIVE_METHOD_DECLARATION__OWNER = ABSTRACT_MMETHOD_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MNative Method Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MNATIVE_METHOD_DECLARATION_FEATURE_COUNT = ABSTRACT_MMETHOD_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodImplementationImpl <em>Abstract MMethod Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodImplementationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMMethodImplementation()
	 * @generated
	 */
	int ABSTRACT_MMETHOD_IMPLEMENTATION = 36;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_IMPLEMENTATION__VISIBILITY = ABSTRACT_MMETHOD_LIKE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_IMPLEMENTATION__FINAL = ABSTRACT_MMETHOD_LIKE__FINAL;

	/**
	 * The feature id for the '<em><b>Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_IMPLEMENTATION__SYNCHRONIZED = ABSTRACT_MMETHOD_LIKE__SYNCHRONIZED;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_IMPLEMENTATION__STATEMENT = ABSTRACT_MMETHOD_LIKE__STATEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER = ABSTRACT_MMETHOD_LIKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS = ABSTRACT_MMETHOD_LIKE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract MMethod Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MMETHOD_IMPLEMENTATION_FEATURE_COUNT = ABSTRACT_MMETHOD_LIKE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredMethodImplementationImpl <em>MDeclared Method Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MDeclaredMethodImplementationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMDeclaredMethodImplementation()
	 * @generated
	 */
	int MDECLARED_METHOD_IMPLEMENTATION = 37;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_METHOD_IMPLEMENTATION__VISIBILITY = ABSTRACT_MMETHOD_IMPLEMENTATION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_METHOD_IMPLEMENTATION__FINAL = ABSTRACT_MMETHOD_IMPLEMENTATION__FINAL;

	/**
	 * The feature id for the '<em><b>Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_METHOD_IMPLEMENTATION__SYNCHRONIZED = ABSTRACT_MMETHOD_IMPLEMENTATION__SYNCHRONIZED;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_METHOD_IMPLEMENTATION__STATEMENT = ABSTRACT_MMETHOD_IMPLEMENTATION__STATEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_METHOD_IMPLEMENTATION__OWNER = ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_METHOD_IMPLEMENTATION__PARAMETERS = ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_METHOD_IMPLEMENTATION__DECLARATION = ABSTRACT_MMETHOD_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MDeclared Method Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDECLARED_METHOD_IMPLEMENTATION_FEATURE_COUNT = ABSTRACT_MMETHOD_IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MDirectMethodImplementationImpl <em>MDirect Method Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MDirectMethodImplementationImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMDirectMethodImplementation()
	 * @generated
	 */
	int MDIRECT_METHOD_IMPLEMENTATION = 38;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDIRECT_METHOD_IMPLEMENTATION__VISIBILITY = ABSTRACT_MMETHOD_IMPLEMENTATION__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDIRECT_METHOD_IMPLEMENTATION__FINAL = ABSTRACT_MMETHOD_IMPLEMENTATION__FINAL;

	/**
	 * The feature id for the '<em><b>Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDIRECT_METHOD_IMPLEMENTATION__SYNCHRONIZED = ABSTRACT_MMETHOD_IMPLEMENTATION__SYNCHRONIZED;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDIRECT_METHOD_IMPLEMENTATION__STATEMENT = ABSTRACT_MMETHOD_IMPLEMENTATION__STATEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDIRECT_METHOD_IMPLEMENTATION__OWNER = ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDIRECT_METHOD_IMPLEMENTATION__PARAMETERS = ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDIRECT_METHOD_IMPLEMENTATION__DECLARATION = ABSTRACT_MMETHOD_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>MDirect Method Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MDIRECT_METHOD_IMPLEMENTATION_FEATURE_COUNT = ABSTRACT_MMETHOD_IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MMethodImplementationParameterImpl <em>MMethod Implementation Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MMethodImplementationParameterImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMMethodImplementationParameter()
	 * @generated
	 */
	int MMETHOD_IMPLEMENTATION_PARAMETER = 39;

	/**
	 * The feature id for the '<em><b>Method Implementation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION = 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMETHOD_IMPLEMENTATION_PARAMETER__FINAL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMETHOD_IMPLEMENTATION_PARAMETER__NAME = 2;

	/**
	 * The number of structural features of the '<em>MMethod Implementation Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MMETHOD_IMPLEMENTATION_PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MConstructorImpl <em>MConstructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MConstructorImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMConstructor()
	 * @generated
	 */
	int MCONSTRUCTOR = 40;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR__VISIBILITY = ABSTRACT_MMETHOD_LIKE__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR__FINAL = ABSTRACT_MMETHOD_LIKE__FINAL;

	/**
	 * The feature id for the '<em><b>Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR__SYNCHRONIZED = ABSTRACT_MMETHOD_LIKE__SYNCHRONIZED;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR__STATEMENT = ABSTRACT_MMETHOD_LIKE__STATEMENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR__OWNER = ABSTRACT_MMETHOD_LIKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR__PARAMETERS = ABSTRACT_MMETHOD_LIKE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>MConstructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR_FEATURE_COUNT = ABSTRACT_MMETHOD_LIKE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.MConstructorParameterImpl <em>MConstructor Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.MConstructorParameterImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMConstructorParameter()
	 * @generated
	 */
	int MCONSTRUCTOR_PARAMETER = 41;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR_PARAMETER__TYPE = ABSTRACT_MTYPE_WITH_NAME_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR_PARAMETER__NAME = ABSTRACT_MTYPE_WITH_NAME_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Constructor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR_PARAMETER__CONSTRUCTOR = ABSTRACT_MTYPE_WITH_NAME_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR_PARAMETER__FINAL = ABSTRACT_MTYPE_WITH_NAME_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>MConstructor Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MCONSTRUCTOR_PARAMETER_FEATURE_COUNT = ABSTRACT_MTYPE_WITH_NAME_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractCStatementImpl <em>Abstract CStatement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractCStatementImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractCStatement()
	 * @generated
	 */
	int ABSTRACT_CSTATEMENT = 42;

	/**
	 * The number of structural features of the '<em>Abstract CStatement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CSTATEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.CBlockStatementImpl <em>CBlock Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.CBlockStatementImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCBlockStatement()
	 * @generated
	 */
	int CBLOCK_STATEMENT = 43;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CBLOCK_STATEMENT__STATEMENTS = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CBlock Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CBLOCK_STATEMENT_FEATURE_COUNT = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.CDeclarationStatementImpl <em>CDeclaration Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.CDeclarationStatementImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCDeclarationStatement()
	 * @generated
	 */
	int CDECLARATION_STATEMENT = 44;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDECLARATION_STATEMENT__TYPE = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDECLARATION_STATEMENT__NAME = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDECLARATION_STATEMENT__FINAL = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDECLARATION_STATEMENT__VALUE = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>CDeclaration Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDECLARATION_STATEMENT_FEATURE_COUNT = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.CExpressionStatementImpl <em>CExpression Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.CExpressionStatementImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCExpressionStatement()
	 * @generated
	 */
	int CEXPRESSION_STATEMENT = 45;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CEXPRESSION_STATEMENT__EXPRESSION = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CExpression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CEXPRESSION_STATEMENT_FEATURE_COUNT = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.CIfStatementImpl <em>CIf Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.CIfStatementImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCIfStatement()
	 * @generated
	 */
	int CIF_STATEMENT = 46;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIF_STATEMENT__CONDITION = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>True Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIF_STATEMENT__TRUE_STATEMENT = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>False Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIF_STATEMENT__FALSE_STATEMENT = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CIf Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIF_STATEMENT_FEATURE_COUNT = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.CUnparsedStatementImpl <em>CUnparsed Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.CUnparsedStatementImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCUnparsedStatement()
	 * @generated
	 */
	int CUNPARSED_STATEMENT = 47;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUNPARSED_STATEMENT__CODE = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CUnparsed Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUNPARSED_STATEMENT_FEATURE_COUNT = ABSTRACT_CSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractCExpressionImpl <em>Abstract CExpression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractCExpressionImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractCExpression()
	 * @generated
	 */
	int ABSTRACT_CEXPRESSION = 48;

	/**
	 * The number of structural features of the '<em>Abstract CExpression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CEXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.CConditionalExpressionImpl <em>CConditional Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.CConditionalExpressionImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCConditionalExpression()
	 * @generated
	 */
	int CCONDITIONAL_EXPRESSION = 49;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCONDITIONAL_EXPRESSION__CONDITION = ABSTRACT_CEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>True Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION = ABSTRACT_CEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>False Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION = ABSTRACT_CEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CConditional Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCONDITIONAL_EXPRESSION_FEATURE_COUNT = ABSTRACT_CEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.impl.CUnparsedExpressionImpl <em>CUnparsed Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.impl.CUnparsedExpressionImpl
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCUnparsedExpression()
	 * @generated
	 */
	int CUNPARSED_EXPRESSION = 50;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUNPARSED_EXPRESSION__CODE = ABSTRACT_CEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CUnparsed Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUNPARSED_EXPRESSION_FEATURE_COUNT = ABSTRACT_CEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.MPrimitiveTypes <em>MPrimitive Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.MPrimitiveTypes
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMPrimitiveTypes()
	 * @generated
	 */
	int MPRIMITIVE_TYPES = 51;

	/**
	 * The meta object id for the '{@link de.hasait.eclipse.ccg.java.model.MVisibility <em>MVisibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hasait.eclipse.ccg.java.model.MVisibility
	 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMVisibility()
	 * @generated
	 */
	int MVISIBILITY = 52;


	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer <em>Abstract MPackage Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MPackage Container</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer
	 * @generated
	 */
	EClass getAbstractMPackageContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer#getPackages()
	 * @see #getAbstractMPackageContainer()
	 * @generated
	 */
	EReference getAbstractMPackageContainer_Packages();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MRoot <em>MRoot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MRoot</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MRoot
	 * @generated
	 */
	EClass getMRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.MRoot#getExternalTypes <em>External Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>External Types</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MRoot#getExternalTypes()
	 * @see #getMRoot()
	 * @generated
	 */
	EReference getMRoot_ExternalTypes();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MPackage <em>MPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MPackage</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MPackage
	 * @generated
	 */
	EClass getMPackage();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MPackage#getPackageContainer <em>Package Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package Container</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MPackage#getPackageContainer()
	 * @see #getMPackage()
	 * @generated
	 */
	EReference getMPackage_PackageContainer();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.MPackage#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MPackage#getName()
	 * @see #getMPackage()
	 * @generated
	 */
	EAttribute getMPackage_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.MPackage#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MPackage#getResources()
	 * @see #getMPackage()
	 * @generated
	 */
	EReference getMPackage_Resources();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource <em>Abstract MResource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MResource</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMResource
	 * @generated
	 */
	EClass getAbstractMResource();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMResource#getPackage()
	 * @see #getAbstractMResource()
	 * @generated
	 */
	EReference getAbstractMResource_Package();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMResource#getName()
	 * @see #getAbstractMResource()
	 * @generated
	 */
	EAttribute getAbstractMResource_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#isDerived <em>Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derived</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMResource#isDerived()
	 * @see #getAbstractMResource()
	 * @generated
	 */
	EAttribute getAbstractMResource_Derived();

	/**
	 * Returns the meta object for the reference list '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getDerivedFrom <em>Derived From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Derived From</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMResource#getDerivedFrom()
	 * @see #getAbstractMResource()
	 * @generated
	 */
	EReference getAbstractMResource_DerivedFrom();

	/**
	 * Returns the meta object for the reference list '{@link de.hasait.eclipse.ccg.java.model.AbstractMResource#getSuperOf <em>Super Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Of</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMResource#getSuperOf()
	 * @see #getAbstractMResource()
	 * @generated
	 */
	EReference getAbstractMResource_SuperOf();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MResource <em>MResource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MResource</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MResource
	 * @generated
	 */
	EClass getMResource();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.MResource#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MResource#getContent()
	 * @see #getMResource()
	 * @generated
	 */
	EAttribute getMResource_Content();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer <em>Abstract MType Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MType Container</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer
	 * @generated
	 */
	EClass getAbstractMTypeContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer#getTypes()
	 * @see #getAbstractMTypeContainer()
	 * @generated
	 */
	EReference getAbstractMTypeContainer_Types();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MCompilationUnit <em>MCompilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MCompilation Unit</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MCompilationUnit
	 * @generated
	 */
	EClass getMCompilationUnit();

	/**
	 * Returns the meta object for the reference list '{@link de.hasait.eclipse.ccg.java.model.MCompilationUnit#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MCompilationUnit#getImports()
	 * @see #getMCompilationUnit()
	 * @generated
	 */
	EReference getMCompilationUnit_Imports();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType <em>Abstract MDeclared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MDeclared Type</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType
	 * @generated
	 */
	EClass getAbstractMDeclaredType();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType#getTypeContainer <em>Type Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Type Container</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType#getTypeContainer()
	 * @see #getAbstractMDeclaredType()
	 * @generated
	 */
	EReference getAbstractMDeclaredType_TypeContainer();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType#getName()
	 * @see #getAbstractMDeclaredType()
	 * @generated
	 */
	EAttribute getAbstractMDeclaredType_Name();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMExternalType <em>Abstract MExternal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MExternal Type</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMExternalType
	 * @generated
	 */
	EClass getAbstractMExternalType();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.AbstractMExternalType#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Root</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMExternalType#getRoot()
	 * @see #getAbstractMExternalType()
	 * @generated
	 */
	EReference getAbstractMExternalType_Root();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.AbstractMExternalType#getFullQualifiedName <em>Full Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Qualified Name</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMExternalType#getFullQualifiedName()
	 * @see #getAbstractMExternalType()
	 * @generated
	 */
	EAttribute getAbstractMExternalType_FullQualifiedName();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMType <em>Abstract MType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MType</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMType
	 * @generated
	 */
	EClass getAbstractMType();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeReference <em>Abstract MType Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MType Reference</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMTypeReference
	 * @generated
	 */
	EClass getAbstractMTypeReference();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeReference#isArray <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMTypeReference#isArray()
	 * @see #getAbstractMTypeReference()
	 * @generated
	 */
	EAttribute getAbstractMTypeReference_Array();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MDeclaredTypeReference <em>MDeclared Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MDeclared Type Reference</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredTypeReference
	 * @generated
	 */
	EClass getMDeclaredTypeReference();

	/**
	 * Returns the meta object for the reference '{@link de.hasait.eclipse.ccg.java.model.MDeclaredTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredTypeReference#getType()
	 * @see #getMDeclaredTypeReference()
	 * @generated
	 */
	EReference getMDeclaredTypeReference_Type();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MExternalTypeReference <em>MExternal Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MExternal Type Reference</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MExternalTypeReference
	 * @generated
	 */
	EClass getMExternalTypeReference();

	/**
	 * Returns the meta object for the reference '{@link de.hasait.eclipse.ccg.java.model.MExternalTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MExternalTypeReference#getType()
	 * @see #getMExternalTypeReference()
	 * @generated
	 */
	EReference getMExternalTypeReference_Type();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MPrimitiveTypeReference <em>MPrimitive Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MPrimitive Type Reference</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MPrimitiveTypeReference
	 * @generated
	 */
	EClass getMPrimitiveTypeReference();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.MPrimitiveTypeReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MPrimitiveTypeReference#getType()
	 * @see #getMPrimitiveTypeReference()
	 * @generated
	 */
	EAttribute getMPrimitiveTypeReference_Type();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractModifiers <em>Abstract Modifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Modifiers</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractModifiers
	 * @generated
	 */
	EClass getAbstractModifiers();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.AbstractModifiers#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractModifiers#getVisibility()
	 * @see #getAbstractModifiers()
	 * @generated
	 */
	EAttribute getAbstractModifiers_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.AbstractModifiers#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractModifiers#isFinal()
	 * @see #getAbstractModifiers()
	 * @generated
	 */
	EAttribute getAbstractModifiers_Final();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.AbstractModifiers#isSynchronized <em>Synchronized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synchronized</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractModifiers#isSynchronized()
	 * @see #getAbstractModifiers()
	 * @generated
	 */
	EAttribute getAbstractModifiers_Synchronized();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodLike <em>Abstract MMethod Like</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MMethod Like</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodLike
	 * @generated
	 */
	EClass getAbstractMMethodLike();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodLike#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statement</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodLike#getStatement()
	 * @see #getAbstractMMethodLike()
	 * @generated
	 */
	EReference getAbstractMMethodLike_Statement();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration <em>Abstract MType With Name Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MType With Name Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration
	 * @generated
	 */
	EClass getAbstractMTypeWithNameDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration#getType()
	 * @see #getAbstractMTypeWithNameDeclaration()
	 * @generated
	 */
	EReference getAbstractMTypeWithNameDeclaration_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration#getName()
	 * @see #getAbstractMTypeWithNameDeclaration()
	 * @generated
	 */
	EAttribute getAbstractMTypeWithNameDeclaration_Name();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMClass <em>Abstract MClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MClass</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMClass
	 * @generated
	 */
	EClass getAbstractMClass();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass <em>MDeclared Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MDeclared Class</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass
	 * @generated
	 */
	EClass getMDeclaredClass();

	/**
	 * Returns the meta object for the reference '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extends</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getExtends()
	 * @see #getMDeclaredClass()
	 * @generated
	 */
	EReference getMDeclaredClass_Extends();

	/**
	 * Returns the meta object for the reference list '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getImplements <em>Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Implements</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getImplements()
	 * @see #getMDeclaredClass()
	 * @generated
	 */
	EReference getMDeclaredClass_Implements();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getStaticFields <em>Static Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Static Fields</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getStaticFields()
	 * @see #getMDeclaredClass()
	 * @generated
	 */
	EReference getMDeclaredClass_StaticFields();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getInstanceFields <em>Instance Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance Fields</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getInstanceFields()
	 * @see #getMDeclaredClass()
	 * @generated
	 */
	EReference getMDeclaredClass_InstanceFields();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getConstructors <em>Constructors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constructors</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getConstructors()
	 * @see #getMDeclaredClass()
	 * @generated
	 */
	EReference getMDeclaredClass_Constructors();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getImplementedMethods <em>Implemented Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implemented Methods</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getImplementedMethods()
	 * @see #getMDeclaredClass()
	 * @generated
	 */
	EReference getMDeclaredClass_ImplementedMethods();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.MDeclaredClass#getNativeMethods <em>Native Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Native Methods</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredClass#getNativeMethods()
	 * @see #getMDeclaredClass()
	 * @generated
	 */
	EReference getMDeclaredClass_NativeMethods();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass <em>MAbstract Declared Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MAbstract Declared Class</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass
	 * @generated
	 */
	EClass getMAbstractDeclaredClass();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass#getAbstractMethods <em>Abstract Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Abstract Methods</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass#getAbstractMethods()
	 * @see #getMAbstractDeclaredClass()
	 * @generated
	 */
	EReference getMAbstractDeclaredClass_AbstractMethods();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MExternalClass <em>MExternal Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MExternal Class</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MExternalClass
	 * @generated
	 */
	EClass getMExternalClass();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMInterface <em>Abstract MInterface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MInterface</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMInterface
	 * @generated
	 */
	EClass getAbstractMInterface();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MDeclaredInterface <em>MDeclared Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MDeclared Interface</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredInterface
	 * @generated
	 */
	EClass getMDeclaredInterface();

	/**
	 * Returns the meta object for the reference list '{@link de.hasait.eclipse.ccg.java.model.MDeclaredInterface#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extends</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredInterface#getExtends()
	 * @see #getMDeclaredInterface()
	 * @generated
	 */
	EReference getMDeclaredInterface_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.MDeclaredInterface#getConstants <em>Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constants</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredInterface#getConstants()
	 * @see #getMDeclaredInterface()
	 * @generated
	 */
	EReference getMDeclaredInterface_Constants();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.MDeclaredInterface#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredInterface#getMethods()
	 * @see #getMDeclaredInterface()
	 * @generated
	 */
	EReference getMDeclaredInterface_Methods();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MExternalInterface <em>MExternal Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MExternal Interface</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MExternalInterface
	 * @generated
	 */
	EClass getMExternalInterface();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMFieldDeclaration <em>Abstract MField Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MField Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMFieldDeclaration
	 * @generated
	 */
	EClass getAbstractMFieldDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.AbstractMFieldDeclaration#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Value</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMFieldDeclaration#getInitialValue()
	 * @see #getAbstractMFieldDeclaration()
	 * @generated
	 */
	EReference getAbstractMFieldDeclaration_InitialValue();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration <em>Abstract MClass Field Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MClass Field Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration
	 * @generated
	 */
	EClass getAbstractMClassFieldDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration#getVisibility()
	 * @see #getAbstractMClassFieldDeclaration()
	 * @generated
	 */
	EAttribute getAbstractMClassFieldDeclaration_Visibility();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration#isFinal()
	 * @see #getAbstractMClassFieldDeclaration()
	 * @generated
	 */
	EAttribute getAbstractMClassFieldDeclaration_Final();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration <em>MStatic Class Field Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MStatic Class Field Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration
	 * @generated
	 */
	EClass getMStaticClassFieldDeclaration();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration#getOwner()
	 * @see #getMStaticClassFieldDeclaration()
	 * @generated
	 */
	EReference getMStaticClassFieldDeclaration_Owner();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration <em>MInstance Class Field Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MInstance Class Field Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration
	 * @generated
	 */
	EClass getMInstanceClassFieldDeclaration();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration#getOwner()
	 * @see #getMInstanceClassFieldDeclaration()
	 * @generated
	 */
	EReference getMInstanceClassFieldDeclaration_Owner();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration#isTransient <em>Transient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transient</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration#isTransient()
	 * @see #getMInstanceClassFieldDeclaration()
	 * @generated
	 */
	EAttribute getMInstanceClassFieldDeclaration_Transient();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration <em>MConstant Interface Field Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MConstant Interface Field Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration
	 * @generated
	 */
	EClass getMConstantInterfaceFieldDeclaration();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration#getOwner()
	 * @see #getMConstantInterfaceFieldDeclaration()
	 * @generated
	 */
	EReference getMConstantInterfaceFieldDeclaration_Owner();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodDeclaration <em>Abstract MMethod Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MMethod Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodDeclaration
	 * @generated
	 */
	EClass getAbstractMMethodDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodDeclaration#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodDeclaration#getParameters()
	 * @see #getAbstractMMethodDeclaration()
	 * @generated
	 */
	EReference getAbstractMMethodDeclaration_Parameters();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter <em>MMethod Declaration Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MMethod Declaration Parameter</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter
	 * @generated
	 */
	EClass getMMethodDeclarationParameter();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter#getMethodDeclaration <em>Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Method Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter#getMethodDeclaration()
	 * @see #getMMethodDeclarationParameter()
	 * @generated
	 */
	EReference getMMethodDeclarationParameter_MethodDeclaration();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MImplicitMethodDeclaration <em>MImplicit Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MImplicit Method Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MImplicitMethodDeclaration
	 * @generated
	 */
	EClass getMImplicitMethodDeclaration();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MImplicitMethodDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MImplicitMethodDeclaration#getOwner()
	 * @see #getMImplicitMethodDeclaration()
	 * @generated
	 */
	EReference getMImplicitMethodDeclaration_Owner();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration <em>Abstract MImplementable Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MImplementable Method Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration
	 * @generated
	 */
	EClass getAbstractMImplementableMethodDeclaration();

	/**
	 * Returns the meta object for the reference list '{@link de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration#getImplementations <em>Implementations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Implementations</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration#getImplementations()
	 * @see #getAbstractMImplementableMethodDeclaration()
	 * @generated
	 */
	EReference getAbstractMImplementableMethodDeclaration_Implementations();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration <em>MAbstract Class Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MAbstract Class Method Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration
	 * @generated
	 */
	EClass getMAbstractClassMethodDeclaration();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration#getOwner()
	 * @see #getMAbstractClassMethodDeclaration()
	 * @generated
	 */
	EReference getMAbstractClassMethodDeclaration_Owner();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration#getVisibility()
	 * @see #getMAbstractClassMethodDeclaration()
	 * @generated
	 */
	EAttribute getMAbstractClassMethodDeclaration_Visibility();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration <em>MInterface Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MInterface Method Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration
	 * @generated
	 */
	EClass getMInterfaceMethodDeclaration();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration#getOwner()
	 * @see #getMInterfaceMethodDeclaration()
	 * @generated
	 */
	EReference getMInterfaceMethodDeclaration_Owner();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration <em>MNative Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MNative Method Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration
	 * @generated
	 */
	EClass getMNativeMethodDeclaration();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration#getOwner()
	 * @see #getMNativeMethodDeclaration()
	 * @generated
	 */
	EReference getMNativeMethodDeclaration_Owner();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation <em>Abstract MMethod Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract MMethod Implementation</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation
	 * @generated
	 */
	EClass getAbstractMMethodImplementation();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation#getOwner()
	 * @see #getAbstractMMethodImplementation()
	 * @generated
	 */
	EReference getAbstractMMethodImplementation_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation#getParameters()
	 * @see #getAbstractMMethodImplementation()
	 * @generated
	 */
	EReference getAbstractMMethodImplementation_Parameters();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation <em>MDeclared Method Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MDeclared Method Implementation</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation
	 * @generated
	 */
	EClass getMDeclaredMethodImplementation();

	/**
	 * Returns the meta object for the reference '{@link de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation#getDeclaration()
	 * @see #getMDeclaredMethodImplementation()
	 * @generated
	 */
	EReference getMDeclaredMethodImplementation_Declaration();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MDirectMethodImplementation <em>MDirect Method Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MDirect Method Implementation</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDirectMethodImplementation
	 * @generated
	 */
	EClass getMDirectMethodImplementation();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.MDirectMethodImplementation#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declaration</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MDirectMethodImplementation#getDeclaration()
	 * @see #getMDirectMethodImplementation()
	 * @generated
	 */
	EReference getMDirectMethodImplementation_Declaration();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter <em>MMethod Implementation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MMethod Implementation Parameter</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter
	 * @generated
	 */
	EClass getMMethodImplementationParameter();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#getMethodImplementation <em>Method Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Method Implementation</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#getMethodImplementation()
	 * @see #getMMethodImplementationParameter()
	 * @generated
	 */
	EReference getMMethodImplementationParameter_MethodImplementation();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#isFinal()
	 * @see #getMMethodImplementationParameter()
	 * @generated
	 */
	EAttribute getMMethodImplementationParameter_Final();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter#getName()
	 * @see #getMMethodImplementationParameter()
	 * @generated
	 */
	EAttribute getMMethodImplementationParameter_Name();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MConstructor <em>MConstructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MConstructor</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MConstructor
	 * @generated
	 */
	EClass getMConstructor();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MConstructor#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MConstructor#getOwner()
	 * @see #getMConstructor()
	 * @generated
	 */
	EReference getMConstructor_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.MConstructor#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MConstructor#getParameters()
	 * @see #getMConstructor()
	 * @generated
	 */
	EReference getMConstructor_Parameters();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.MConstructorParameter <em>MConstructor Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>MConstructor Parameter</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MConstructorParameter
	 * @generated
	 */
	EClass getMConstructorParameter();

	/**
	 * Returns the meta object for the container reference '{@link de.hasait.eclipse.ccg.java.model.MConstructorParameter#getConstructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Constructor</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MConstructorParameter#getConstructor()
	 * @see #getMConstructorParameter()
	 * @generated
	 */
	EReference getMConstructorParameter_Constructor();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.MConstructorParameter#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MConstructorParameter#isFinal()
	 * @see #getMConstructorParameter()
	 * @generated
	 */
	EAttribute getMConstructorParameter_Final();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractCStatement <em>Abstract CStatement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract CStatement</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractCStatement
	 * @generated
	 */
	EClass getAbstractCStatement();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.CBlockStatement <em>CBlock Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CBlock Statement</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CBlockStatement
	 * @generated
	 */
	EClass getCBlockStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hasait.eclipse.ccg.java.model.CBlockStatement#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CBlockStatement#getStatements()
	 * @see #getCBlockStatement()
	 * @generated
	 */
	EReference getCBlockStatement_Statements();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.CDeclarationStatement <em>CDeclaration Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CDeclaration Statement</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CDeclarationStatement
	 * @generated
	 */
	EClass getCDeclarationStatement();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.CDeclarationStatement#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CDeclarationStatement#isFinal()
	 * @see #getCDeclarationStatement()
	 * @generated
	 */
	EAttribute getCDeclarationStatement_Final();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.CDeclarationStatement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CDeclarationStatement#getValue()
	 * @see #getCDeclarationStatement()
	 * @generated
	 */
	EReference getCDeclarationStatement_Value();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.CExpressionStatement <em>CExpression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CExpression Statement</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CExpressionStatement
	 * @generated
	 */
	EClass getCExpressionStatement();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.CExpressionStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CExpressionStatement#getExpression()
	 * @see #getCExpressionStatement()
	 * @generated
	 */
	EReference getCExpressionStatement_Expression();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.CIfStatement <em>CIf Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CIf Statement</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CIfStatement
	 * @generated
	 */
	EClass getCIfStatement();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.CIfStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CIfStatement#getCondition()
	 * @see #getCIfStatement()
	 * @generated
	 */
	EReference getCIfStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.CIfStatement#getTrueStatement <em>True Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>True Statement</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CIfStatement#getTrueStatement()
	 * @see #getCIfStatement()
	 * @generated
	 */
	EReference getCIfStatement_TrueStatement();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.CIfStatement#getFalseStatement <em>False Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>False Statement</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CIfStatement#getFalseStatement()
	 * @see #getCIfStatement()
	 * @generated
	 */
	EReference getCIfStatement_FalseStatement();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.CUnparsedStatement <em>CUnparsed Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CUnparsed Statement</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CUnparsedStatement
	 * @generated
	 */
	EClass getCUnparsedStatement();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.CUnparsedStatement#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CUnparsedStatement#getCode()
	 * @see #getCUnparsedStatement()
	 * @generated
	 */
	EAttribute getCUnparsedStatement_Code();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.AbstractCExpression <em>Abstract CExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract CExpression</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.AbstractCExpression
	 * @generated
	 */
	EClass getAbstractCExpression();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.CConditionalExpression <em>CConditional Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CConditional Expression</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CConditionalExpression
	 * @generated
	 */
	EClass getCConditionalExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.CConditionalExpression#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CConditionalExpression#getCondition()
	 * @see #getCConditionalExpression()
	 * @generated
	 */
	EReference getCConditionalExpression_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.CConditionalExpression#getTrueExpression <em>True Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>True Expression</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CConditionalExpression#getTrueExpression()
	 * @see #getCConditionalExpression()
	 * @generated
	 */
	EReference getCConditionalExpression_TrueExpression();

	/**
	 * Returns the meta object for the containment reference '{@link de.hasait.eclipse.ccg.java.model.CConditionalExpression#getFalseExpression <em>False Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>False Expression</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CConditionalExpression#getFalseExpression()
	 * @see #getCConditionalExpression()
	 * @generated
	 */
	EReference getCConditionalExpression_FalseExpression();

	/**
	 * Returns the meta object for class '{@link de.hasait.eclipse.ccg.java.model.CUnparsedExpression <em>CUnparsed Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CUnparsed Expression</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CUnparsedExpression
	 * @generated
	 */
	EClass getCUnparsedExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.hasait.eclipse.ccg.java.model.CUnparsedExpression#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.CUnparsedExpression#getCode()
	 * @see #getCUnparsedExpression()
	 * @generated
	 */
	EAttribute getCUnparsedExpression_Code();

	/**
	 * Returns the meta object for enum '{@link de.hasait.eclipse.ccg.java.model.MPrimitiveTypes <em>MPrimitive Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>MPrimitive Types</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MPrimitiveTypes
	 * @generated
	 */
	EEnum getMPrimitiveTypes();

	/**
	 * Returns the meta object for enum '{@link de.hasait.eclipse.ccg.java.model.MVisibility <em>MVisibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>MVisibility</em>'.
	 * @see de.hasait.eclipse.ccg.java.model.MVisibility
	 * @generated
	 */
	EEnum getMVisibility();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMPackageContainerImpl <em>Abstract MPackage Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMPackageContainerImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMPackageContainer()
		 * @generated
		 */
		EClass ABSTRACT_MPACKAGE_CONTAINER = eINSTANCE.getAbstractMPackageContainer();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MPACKAGE_CONTAINER__PACKAGES = eINSTANCE.getAbstractMPackageContainer_Packages();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MRootImpl <em>MRoot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MRootImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMRoot()
		 * @generated
		 */
		EClass MROOT = eINSTANCE.getMRoot();

		/**
		 * The meta object literal for the '<em><b>External Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MROOT__EXTERNAL_TYPES = eINSTANCE.getMRoot_ExternalTypes();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MPackageImpl <em>MPackage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MPackageImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMPackage()
		 * @generated
		 */
		EClass MPACKAGE = eINSTANCE.getMPackage();

		/**
		 * The meta object literal for the '<em><b>Package Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MPACKAGE__PACKAGE_CONTAINER = eINSTANCE.getMPackage_PackageContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MPACKAGE__NAME = eINSTANCE.getMPackage_Name();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MPACKAGE__RESOURCES = eINSTANCE.getMPackage_Resources();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMResourceImpl <em>Abstract MResource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMResourceImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMResource()
		 * @generated
		 */
		EClass ABSTRACT_MRESOURCE = eINSTANCE.getAbstractMResource();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MRESOURCE__PACKAGE = eINSTANCE.getAbstractMResource_Package();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MRESOURCE__NAME = eINSTANCE.getAbstractMResource_Name();

		/**
		 * The meta object literal for the '<em><b>Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MRESOURCE__DERIVED = eINSTANCE.getAbstractMResource_Derived();

		/**
		 * The meta object literal for the '<em><b>Derived From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MRESOURCE__DERIVED_FROM = eINSTANCE.getAbstractMResource_DerivedFrom();

		/**
		 * The meta object literal for the '<em><b>Super Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MRESOURCE__SUPER_OF = eINSTANCE.getAbstractMResource_SuperOf();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MResourceImpl <em>MResource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MResourceImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMResource()
		 * @generated
		 */
		EClass MRESOURCE = eINSTANCE.getMResource();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MRESOURCE__CONTENT = eINSTANCE.getMResource_Content();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeContainerImpl <em>Abstract MType Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeContainerImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMTypeContainer()
		 * @generated
		 */
		EClass ABSTRACT_MTYPE_CONTAINER = eINSTANCE.getAbstractMTypeContainer();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MTYPE_CONTAINER__TYPES = eINSTANCE.getAbstractMTypeContainer_Types();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MCompilationUnitImpl <em>MCompilation Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MCompilationUnitImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMCompilationUnit()
		 * @generated
		 */
		EClass MCOMPILATION_UNIT = eINSTANCE.getMCompilationUnit();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MCOMPILATION_UNIT__IMPORTS = eINSTANCE.getMCompilationUnit_Imports();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMDeclaredTypeImpl <em>Abstract MDeclared Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMDeclaredTypeImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMDeclaredType()
		 * @generated
		 */
		EClass ABSTRACT_MDECLARED_TYPE = eINSTANCE.getAbstractMDeclaredType();

		/**
		 * The meta object literal for the '<em><b>Type Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MDECLARED_TYPE__TYPE_CONTAINER = eINSTANCE.getAbstractMDeclaredType_TypeContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MDECLARED_TYPE__NAME = eINSTANCE.getAbstractMDeclaredType_Name();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMExternalTypeImpl <em>Abstract MExternal Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMExternalTypeImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMExternalType()
		 * @generated
		 */
		EClass ABSTRACT_MEXTERNAL_TYPE = eINSTANCE.getAbstractMExternalType();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MEXTERNAL_TYPE__ROOT = eINSTANCE.getAbstractMExternalType_Root();

		/**
		 * The meta object literal for the '<em><b>Full Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MEXTERNAL_TYPE__FULL_QUALIFIED_NAME = eINSTANCE.getAbstractMExternalType_FullQualifiedName();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeImpl <em>Abstract MType</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMType()
		 * @generated
		 */
		EClass ABSTRACT_MTYPE = eINSTANCE.getAbstractMType();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeReferenceImpl <em>Abstract MType Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeReferenceImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMTypeReference()
		 * @generated
		 */
		EClass ABSTRACT_MTYPE_REFERENCE = eINSTANCE.getAbstractMTypeReference();

		/**
		 * The meta object literal for the '<em><b>Array</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MTYPE_REFERENCE__ARRAY = eINSTANCE.getAbstractMTypeReference_Array();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredTypeReferenceImpl <em>MDeclared Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MDeclaredTypeReferenceImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMDeclaredTypeReference()
		 * @generated
		 */
		EClass MDECLARED_TYPE_REFERENCE = eINSTANCE.getMDeclaredTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_TYPE_REFERENCE__TYPE = eINSTANCE.getMDeclaredTypeReference_Type();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MExternalTypeReferenceImpl <em>MExternal Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MExternalTypeReferenceImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMExternalTypeReference()
		 * @generated
		 */
		EClass MEXTERNAL_TYPE_REFERENCE = eINSTANCE.getMExternalTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEXTERNAL_TYPE_REFERENCE__TYPE = eINSTANCE.getMExternalTypeReference_Type();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MPrimitiveTypeReferenceImpl <em>MPrimitive Type Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MPrimitiveTypeReferenceImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMPrimitiveTypeReference()
		 * @generated
		 */
		EClass MPRIMITIVE_TYPE_REFERENCE = eINSTANCE.getMPrimitiveTypeReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MPRIMITIVE_TYPE_REFERENCE__TYPE = eINSTANCE.getMPrimitiveTypeReference_Type();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractModifiersImpl <em>Abstract Modifiers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractModifiersImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractModifiers()
		 * @generated
		 */
		EClass ABSTRACT_MODIFIERS = eINSTANCE.getAbstractModifiers();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MODIFIERS__VISIBILITY = eINSTANCE.getAbstractModifiers_Visibility();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MODIFIERS__FINAL = eINSTANCE.getAbstractModifiers_Final();

		/**
		 * The meta object literal for the '<em><b>Synchronized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MODIFIERS__SYNCHRONIZED = eINSTANCE.getAbstractModifiers_Synchronized();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodLikeImpl <em>Abstract MMethod Like</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodLikeImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMMethodLike()
		 * @generated
		 */
		EClass ABSTRACT_MMETHOD_LIKE = eINSTANCE.getAbstractMMethodLike();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MMETHOD_LIKE__STATEMENT = eINSTANCE.getAbstractMMethodLike_Statement();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeWithNameDeclarationImpl <em>Abstract MType With Name Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMTypeWithNameDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMTypeWithNameDeclaration()
		 * @generated
		 */
		EClass ABSTRACT_MTYPE_WITH_NAME_DECLARATION = eINSTANCE.getAbstractMTypeWithNameDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MTYPE_WITH_NAME_DECLARATION__TYPE = eINSTANCE.getAbstractMTypeWithNameDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MTYPE_WITH_NAME_DECLARATION__NAME = eINSTANCE.getAbstractMTypeWithNameDeclaration_Name();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMClassImpl <em>Abstract MClass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMClassImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMClass()
		 * @generated
		 */
		EClass ABSTRACT_MCLASS = eINSTANCE.getAbstractMClass();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl <em>MDeclared Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MDeclaredClassImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMDeclaredClass()
		 * @generated
		 */
		EClass MDECLARED_CLASS = eINSTANCE.getMDeclaredClass();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_CLASS__EXTENDS = eINSTANCE.getMDeclaredClass_Extends();

		/**
		 * The meta object literal for the '<em><b>Implements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_CLASS__IMPLEMENTS = eINSTANCE.getMDeclaredClass_Implements();

		/**
		 * The meta object literal for the '<em><b>Static Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_CLASS__STATIC_FIELDS = eINSTANCE.getMDeclaredClass_StaticFields();

		/**
		 * The meta object literal for the '<em><b>Instance Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_CLASS__INSTANCE_FIELDS = eINSTANCE.getMDeclaredClass_InstanceFields();

		/**
		 * The meta object literal for the '<em><b>Constructors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_CLASS__CONSTRUCTORS = eINSTANCE.getMDeclaredClass_Constructors();

		/**
		 * The meta object literal for the '<em><b>Implemented Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_CLASS__IMPLEMENTED_METHODS = eINSTANCE.getMDeclaredClass_ImplementedMethods();

		/**
		 * The meta object literal for the '<em><b>Native Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_CLASS__NATIVE_METHODS = eINSTANCE.getMDeclaredClass_NativeMethods();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MAbstractDeclaredClassImpl <em>MAbstract Declared Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MAbstractDeclaredClassImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMAbstractDeclaredClass()
		 * @generated
		 */
		EClass MABSTRACT_DECLARED_CLASS = eINSTANCE.getMAbstractDeclaredClass();

		/**
		 * The meta object literal for the '<em><b>Abstract Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS = eINSTANCE.getMAbstractDeclaredClass_AbstractMethods();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MExternalClassImpl <em>MExternal Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MExternalClassImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMExternalClass()
		 * @generated
		 */
		EClass MEXTERNAL_CLASS = eINSTANCE.getMExternalClass();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMInterfaceImpl <em>Abstract MInterface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMInterfaceImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMInterface()
		 * @generated
		 */
		EClass ABSTRACT_MINTERFACE = eINSTANCE.getAbstractMInterface();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredInterfaceImpl <em>MDeclared Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MDeclaredInterfaceImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMDeclaredInterface()
		 * @generated
		 */
		EClass MDECLARED_INTERFACE = eINSTANCE.getMDeclaredInterface();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_INTERFACE__EXTENDS = eINSTANCE.getMDeclaredInterface_Extends();

		/**
		 * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_INTERFACE__CONSTANTS = eINSTANCE.getMDeclaredInterface_Constants();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_INTERFACE__METHODS = eINSTANCE.getMDeclaredInterface_Methods();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MExternalInterfaceImpl <em>MExternal Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MExternalInterfaceImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMExternalInterface()
		 * @generated
		 */
		EClass MEXTERNAL_INTERFACE = eINSTANCE.getMExternalInterface();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMFieldDeclarationImpl <em>Abstract MField Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMFieldDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMFieldDeclaration()
		 * @generated
		 */
		EClass ABSTRACT_MFIELD_DECLARATION = eINSTANCE.getAbstractMFieldDeclaration();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MFIELD_DECLARATION__INITIAL_VALUE = eINSTANCE.getAbstractMFieldDeclaration_InitialValue();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMClassFieldDeclarationImpl <em>Abstract MClass Field Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMClassFieldDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMClassFieldDeclaration()
		 * @generated
		 */
		EClass ABSTRACT_MCLASS_FIELD_DECLARATION = eINSTANCE.getAbstractMClassFieldDeclaration();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MCLASS_FIELD_DECLARATION__VISIBILITY = eINSTANCE.getAbstractMClassFieldDeclaration_Visibility();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_MCLASS_FIELD_DECLARATION__FINAL = eINSTANCE.getAbstractMClassFieldDeclaration_Final();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MStaticClassFieldDeclarationImpl <em>MStatic Class Field Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MStaticClassFieldDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMStaticClassFieldDeclaration()
		 * @generated
		 */
		EClass MSTATIC_CLASS_FIELD_DECLARATION = eINSTANCE.getMStaticClassFieldDeclaration();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MSTATIC_CLASS_FIELD_DECLARATION__OWNER = eINSTANCE.getMStaticClassFieldDeclaration_Owner();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MInstanceClassFieldDeclarationImpl <em>MInstance Class Field Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MInstanceClassFieldDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMInstanceClassFieldDeclaration()
		 * @generated
		 */
		EClass MINSTANCE_CLASS_FIELD_DECLARATION = eINSTANCE.getMInstanceClassFieldDeclaration();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MINSTANCE_CLASS_FIELD_DECLARATION__OWNER = eINSTANCE.getMInstanceClassFieldDeclaration_Owner();

		/**
		 * The meta object literal for the '<em><b>Transient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MINSTANCE_CLASS_FIELD_DECLARATION__TRANSIENT = eINSTANCE.getMInstanceClassFieldDeclaration_Transient();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MConstantInterfaceFieldDeclarationImpl <em>MConstant Interface Field Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MConstantInterfaceFieldDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMConstantInterfaceFieldDeclaration()
		 * @generated
		 */
		EClass MCONSTANT_INTERFACE_FIELD_DECLARATION = eINSTANCE.getMConstantInterfaceFieldDeclaration();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MCONSTANT_INTERFACE_FIELD_DECLARATION__OWNER = eINSTANCE.getMConstantInterfaceFieldDeclaration_Owner();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodDeclarationImpl <em>Abstract MMethod Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMMethodDeclaration()
		 * @generated
		 */
		EClass ABSTRACT_MMETHOD_DECLARATION = eINSTANCE.getAbstractMMethodDeclaration();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MMETHOD_DECLARATION__PARAMETERS = eINSTANCE.getAbstractMMethodDeclaration_Parameters();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MMethodDeclarationParameterImpl <em>MMethod Declaration Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MMethodDeclarationParameterImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMMethodDeclarationParameter()
		 * @generated
		 */
		EClass MMETHOD_DECLARATION_PARAMETER = eINSTANCE.getMMethodDeclarationParameter();

		/**
		 * The meta object literal for the '<em><b>Method Declaration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION = eINSTANCE.getMMethodDeclarationParameter_MethodDeclaration();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MImplicitMethodDeclarationImpl <em>MImplicit Method Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MImplicitMethodDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMImplicitMethodDeclaration()
		 * @generated
		 */
		EClass MIMPLICIT_METHOD_DECLARATION = eINSTANCE.getMImplicitMethodDeclaration();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIMPLICIT_METHOD_DECLARATION__OWNER = eINSTANCE.getMImplicitMethodDeclaration_Owner();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMImplementableMethodDeclarationImpl <em>Abstract MImplementable Method Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMImplementableMethodDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMImplementableMethodDeclaration()
		 * @generated
		 */
		EClass ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION = eINSTANCE.getAbstractMImplementableMethodDeclaration();

		/**
		 * The meta object literal for the '<em><b>Implementations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS = eINSTANCE.getAbstractMImplementableMethodDeclaration_Implementations();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MAbstractClassMethodDeclarationImpl <em>MAbstract Class Method Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MAbstractClassMethodDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMAbstractClassMethodDeclaration()
		 * @generated
		 */
		EClass MABSTRACT_CLASS_METHOD_DECLARATION = eINSTANCE.getMAbstractClassMethodDeclaration();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MABSTRACT_CLASS_METHOD_DECLARATION__OWNER = eINSTANCE.getMAbstractClassMethodDeclaration_Owner();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MABSTRACT_CLASS_METHOD_DECLARATION__VISIBILITY = eINSTANCE.getMAbstractClassMethodDeclaration_Visibility();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MInterfaceMethodDeclarationImpl <em>MInterface Method Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MInterfaceMethodDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMInterfaceMethodDeclaration()
		 * @generated
		 */
		EClass MINTERFACE_METHOD_DECLARATION = eINSTANCE.getMInterfaceMethodDeclaration();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MINTERFACE_METHOD_DECLARATION__OWNER = eINSTANCE.getMInterfaceMethodDeclaration_Owner();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MNativeMethodDeclarationImpl <em>MNative Method Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MNativeMethodDeclarationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMNativeMethodDeclaration()
		 * @generated
		 */
		EClass MNATIVE_METHOD_DECLARATION = eINSTANCE.getMNativeMethodDeclaration();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MNATIVE_METHOD_DECLARATION__OWNER = eINSTANCE.getMNativeMethodDeclaration_Owner();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodImplementationImpl <em>Abstract MMethod Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractMMethodImplementationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractMMethodImplementation()
		 * @generated
		 */
		EClass ABSTRACT_MMETHOD_IMPLEMENTATION = eINSTANCE.getAbstractMMethodImplementation();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER = eINSTANCE.getAbstractMMethodImplementation_Owner();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS = eINSTANCE.getAbstractMMethodImplementation_Parameters();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MDeclaredMethodImplementationImpl <em>MDeclared Method Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MDeclaredMethodImplementationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMDeclaredMethodImplementation()
		 * @generated
		 */
		EClass MDECLARED_METHOD_IMPLEMENTATION = eINSTANCE.getMDeclaredMethodImplementation();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDECLARED_METHOD_IMPLEMENTATION__DECLARATION = eINSTANCE.getMDeclaredMethodImplementation_Declaration();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MDirectMethodImplementationImpl <em>MDirect Method Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MDirectMethodImplementationImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMDirectMethodImplementation()
		 * @generated
		 */
		EClass MDIRECT_METHOD_IMPLEMENTATION = eINSTANCE.getMDirectMethodImplementation();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MDIRECT_METHOD_IMPLEMENTATION__DECLARATION = eINSTANCE.getMDirectMethodImplementation_Declaration();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MMethodImplementationParameterImpl <em>MMethod Implementation Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MMethodImplementationParameterImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMMethodImplementationParameter()
		 * @generated
		 */
		EClass MMETHOD_IMPLEMENTATION_PARAMETER = eINSTANCE.getMMethodImplementationParameter();

		/**
		 * The meta object literal for the '<em><b>Method Implementation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION = eINSTANCE.getMMethodImplementationParameter_MethodImplementation();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MMETHOD_IMPLEMENTATION_PARAMETER__FINAL = eINSTANCE.getMMethodImplementationParameter_Final();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MMETHOD_IMPLEMENTATION_PARAMETER__NAME = eINSTANCE.getMMethodImplementationParameter_Name();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MConstructorImpl <em>MConstructor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MConstructorImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMConstructor()
		 * @generated
		 */
		EClass MCONSTRUCTOR = eINSTANCE.getMConstructor();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MCONSTRUCTOR__OWNER = eINSTANCE.getMConstructor_Owner();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MCONSTRUCTOR__PARAMETERS = eINSTANCE.getMConstructor_Parameters();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.MConstructorParameterImpl <em>MConstructor Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.MConstructorParameterImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMConstructorParameter()
		 * @generated
		 */
		EClass MCONSTRUCTOR_PARAMETER = eINSTANCE.getMConstructorParameter();

		/**
		 * The meta object literal for the '<em><b>Constructor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MCONSTRUCTOR_PARAMETER__CONSTRUCTOR = eINSTANCE.getMConstructorParameter_Constructor();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MCONSTRUCTOR_PARAMETER__FINAL = eINSTANCE.getMConstructorParameter_Final();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractCStatementImpl <em>Abstract CStatement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractCStatementImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractCStatement()
		 * @generated
		 */
		EClass ABSTRACT_CSTATEMENT = eINSTANCE.getAbstractCStatement();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.CBlockStatementImpl <em>CBlock Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.CBlockStatementImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCBlockStatement()
		 * @generated
		 */
		EClass CBLOCK_STATEMENT = eINSTANCE.getCBlockStatement();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CBLOCK_STATEMENT__STATEMENTS = eINSTANCE.getCBlockStatement_Statements();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.CDeclarationStatementImpl <em>CDeclaration Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.CDeclarationStatementImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCDeclarationStatement()
		 * @generated
		 */
		EClass CDECLARATION_STATEMENT = eINSTANCE.getCDeclarationStatement();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CDECLARATION_STATEMENT__FINAL = eINSTANCE.getCDeclarationStatement_Final();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CDECLARATION_STATEMENT__VALUE = eINSTANCE.getCDeclarationStatement_Value();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.CExpressionStatementImpl <em>CExpression Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.CExpressionStatementImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCExpressionStatement()
		 * @generated
		 */
		EClass CEXPRESSION_STATEMENT = eINSTANCE.getCExpressionStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CEXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getCExpressionStatement_Expression();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.CIfStatementImpl <em>CIf Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.CIfStatementImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCIfStatement()
		 * @generated
		 */
		EClass CIF_STATEMENT = eINSTANCE.getCIfStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CIF_STATEMENT__CONDITION = eINSTANCE.getCIfStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>True Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CIF_STATEMENT__TRUE_STATEMENT = eINSTANCE.getCIfStatement_TrueStatement();

		/**
		 * The meta object literal for the '<em><b>False Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CIF_STATEMENT__FALSE_STATEMENT = eINSTANCE.getCIfStatement_FalseStatement();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.CUnparsedStatementImpl <em>CUnparsed Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.CUnparsedStatementImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCUnparsedStatement()
		 * @generated
		 */
		EClass CUNPARSED_STATEMENT = eINSTANCE.getCUnparsedStatement();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUNPARSED_STATEMENT__CODE = eINSTANCE.getCUnparsedStatement_Code();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.AbstractCExpressionImpl <em>Abstract CExpression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.AbstractCExpressionImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getAbstractCExpression()
		 * @generated
		 */
		EClass ABSTRACT_CEXPRESSION = eINSTANCE.getAbstractCExpression();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.CConditionalExpressionImpl <em>CConditional Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.CConditionalExpressionImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCConditionalExpression()
		 * @generated
		 */
		EClass CCONDITIONAL_EXPRESSION = eINSTANCE.getCConditionalExpression();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CCONDITIONAL_EXPRESSION__CONDITION = eINSTANCE.getCConditionalExpression_Condition();

		/**
		 * The meta object literal for the '<em><b>True Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION = eINSTANCE.getCConditionalExpression_TrueExpression();

		/**
		 * The meta object literal for the '<em><b>False Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION = eINSTANCE.getCConditionalExpression_FalseExpression();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.impl.CUnparsedExpressionImpl <em>CUnparsed Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.impl.CUnparsedExpressionImpl
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getCUnparsedExpression()
		 * @generated
		 */
		EClass CUNPARSED_EXPRESSION = eINSTANCE.getCUnparsedExpression();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUNPARSED_EXPRESSION__CODE = eINSTANCE.getCUnparsedExpression_Code();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.MPrimitiveTypes <em>MPrimitive Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.MPrimitiveTypes
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMPrimitiveTypes()
		 * @generated
		 */
		EEnum MPRIMITIVE_TYPES = eINSTANCE.getMPrimitiveTypes();

		/**
		 * The meta object literal for the '{@link de.hasait.eclipse.ccg.java.model.MVisibility <em>MVisibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hasait.eclipse.ccg.java.model.MVisibility
		 * @see de.hasait.eclipse.ccg.java.model.impl.ModelPackageImpl#getMVisibility()
		 * @generated
		 */
		EEnum MVISIBILITY = eINSTANCE.getMVisibility();

	}

} //ModelPackage
