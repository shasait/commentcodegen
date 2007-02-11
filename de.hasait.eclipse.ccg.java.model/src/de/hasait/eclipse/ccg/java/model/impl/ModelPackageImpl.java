/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelPackageImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.AbstractCExpression;
import de.hasait.eclipse.ccg.java.model.AbstractCStatement;
import de.hasait.eclipse.ccg.java.model.AbstractMClass;
import de.hasait.eclipse.ccg.java.model.AbstractMClassFieldDeclaration;
import de.hasait.eclipse.ccg.java.model.AbstractMDeclaredType;
import de.hasait.eclipse.ccg.java.model.AbstractMExternalType;
import de.hasait.eclipse.ccg.java.model.AbstractMFieldDeclaration;
import de.hasait.eclipse.ccg.java.model.AbstractMImplementableMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.AbstractMInterface;
import de.hasait.eclipse.ccg.java.model.AbstractMMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.AbstractMMethodImplementation;
import de.hasait.eclipse.ccg.java.model.AbstractMMethodLike;
import de.hasait.eclipse.ccg.java.model.AbstractMPackageContainer;
import de.hasait.eclipse.ccg.java.model.AbstractMResource;
import de.hasait.eclipse.ccg.java.model.AbstractMType;
import de.hasait.eclipse.ccg.java.model.AbstractMTypeContainer;
import de.hasait.eclipse.ccg.java.model.AbstractMTypeReference;
import de.hasait.eclipse.ccg.java.model.AbstractMTypeWithNameDeclaration;
import de.hasait.eclipse.ccg.java.model.AbstractModifiers;
import de.hasait.eclipse.ccg.java.model.CBlockStatement;
import de.hasait.eclipse.ccg.java.model.CConditionalExpression;
import de.hasait.eclipse.ccg.java.model.CDeclarationStatement;
import de.hasait.eclipse.ccg.java.model.CExpressionStatement;
import de.hasait.eclipse.ccg.java.model.CIfStatement;
import de.hasait.eclipse.ccg.java.model.CUnparsedExpression;
import de.hasait.eclipse.ccg.java.model.CUnparsedStatement;
import de.hasait.eclipse.ccg.java.model.MAbstractClassMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.MAbstractDeclaredClass;
import de.hasait.eclipse.ccg.java.model.MCompilationUnit;
import de.hasait.eclipse.ccg.java.model.MConstantInterfaceFieldDeclaration;
import de.hasait.eclipse.ccg.java.model.MConstructor;
import de.hasait.eclipse.ccg.java.model.MConstructorParameter;
import de.hasait.eclipse.ccg.java.model.MDeclaredClass;
import de.hasait.eclipse.ccg.java.model.MDeclaredInterface;
import de.hasait.eclipse.ccg.java.model.MDeclaredMethodImplementation;
import de.hasait.eclipse.ccg.java.model.MDeclaredTypeReference;
import de.hasait.eclipse.ccg.java.model.MDirectMethodImplementation;
import de.hasait.eclipse.ccg.java.model.MExternalClass;
import de.hasait.eclipse.ccg.java.model.MExternalInterface;
import de.hasait.eclipse.ccg.java.model.MExternalTypeReference;
import de.hasait.eclipse.ccg.java.model.MImplicitMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.MInstanceClassFieldDeclaration;
import de.hasait.eclipse.ccg.java.model.MInterfaceMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.MMethodDeclarationParameter;
import de.hasait.eclipse.ccg.java.model.MMethodImplementationParameter;
import de.hasait.eclipse.ccg.java.model.MNativeMethodDeclaration;
import de.hasait.eclipse.ccg.java.model.MPackage;
import de.hasait.eclipse.ccg.java.model.MPrimitiveTypeReference;
import de.hasait.eclipse.ccg.java.model.MPrimitiveTypes;
import de.hasait.eclipse.ccg.java.model.MResource;
import de.hasait.eclipse.ccg.java.model.MRoot;
import de.hasait.eclipse.ccg.java.model.MStaticClassFieldDeclaration;
import de.hasait.eclipse.ccg.java.model.MVisibility;
import de.hasait.eclipse.ccg.java.model.ModelFactory;
import de.hasait.eclipse.ccg.java.model.ModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMPackageContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMTypeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mCompilationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMDeclaredTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMExternalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mDeclaredTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mExternalTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mPrimitiveTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractModifiersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMMethodLikeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMTypeWithNameDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mDeclaredClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mAbstractDeclaredClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mExternalClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mDeclaredInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mExternalInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMFieldDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMClassFieldDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mStaticClassFieldDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mInstanceClassFieldDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mConstantInterfaceFieldDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMMethodDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mMethodDeclarationParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mImplicitMethodDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMImplementableMethodDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mAbstractClassMethodDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mInterfaceMethodDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mNativeMethodDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractMMethodImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mDeclaredMethodImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mDirectMethodImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mMethodImplementationParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mConstructorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mConstructorParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractCStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cBlockStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cDeclarationStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cExpressionStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cIfStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cUnparsedStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractCExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cConditionalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cUnparsedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mPrimitiveTypesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mVisibilityEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMPackageContainer() {
		return abstractMPackageContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMPackageContainer_Packages() {
		return (EReference)abstractMPackageContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMRoot() {
		return mRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMRoot_ExternalTypes() {
		return (EReference)mRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMPackage() {
		return mPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMPackage_PackageContainer() {
		return (EReference)mPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMPackage_Name() {
		return (EAttribute)mPackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMPackage_Resources() {
		return (EReference)mPackageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMResource() {
		return abstractMResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMResource_Package() {
		return (EReference)abstractMResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractMResource_Name() {
		return (EAttribute)abstractMResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractMResource_Derived() {
		return (EAttribute)abstractMResourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMResource_DerivedFrom() {
		return (EReference)abstractMResourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMResource_SuperOf() {
		return (EReference)abstractMResourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMResource() {
		return mResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMResource_Content() {
		return (EAttribute)mResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMTypeContainer() {
		return abstractMTypeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMTypeContainer_Types() {
		return (EReference)abstractMTypeContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMCompilationUnit() {
		return mCompilationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMCompilationUnit_Imports() {
		return (EReference)mCompilationUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMDeclaredType() {
		return abstractMDeclaredTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMDeclaredType_TypeContainer() {
		return (EReference)abstractMDeclaredTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractMDeclaredType_Name() {
		return (EAttribute)abstractMDeclaredTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMExternalType() {
		return abstractMExternalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMExternalType_Root() {
		return (EReference)abstractMExternalTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractMExternalType_FullQualifiedName() {
		return (EAttribute)abstractMExternalTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMType() {
		return abstractMTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMTypeReference() {
		return abstractMTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractMTypeReference_Array() {
		return (EAttribute)abstractMTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMDeclaredTypeReference() {
		return mDeclaredTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredTypeReference_Type() {
		return (EReference)mDeclaredTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMExternalTypeReference() {
		return mExternalTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMExternalTypeReference_Type() {
		return (EReference)mExternalTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMPrimitiveTypeReference() {
		return mPrimitiveTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMPrimitiveTypeReference_Type() {
		return (EAttribute)mPrimitiveTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractModifiers() {
		return abstractModifiersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractModifiers_Visibility() {
		return (EAttribute)abstractModifiersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractModifiers_Final() {
		return (EAttribute)abstractModifiersEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractModifiers_Synchronized() {
		return (EAttribute)abstractModifiersEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMMethodLike() {
		return abstractMMethodLikeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMMethodLike_Statement() {
		return (EReference)abstractMMethodLikeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMTypeWithNameDeclaration() {
		return abstractMTypeWithNameDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMTypeWithNameDeclaration_Type() {
		return (EReference)abstractMTypeWithNameDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractMTypeWithNameDeclaration_Name() {
		return (EAttribute)abstractMTypeWithNameDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMClass() {
		return abstractMClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMDeclaredClass() {
		return mDeclaredClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredClass_Extends() {
		return (EReference)mDeclaredClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredClass_Implements() {
		return (EReference)mDeclaredClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredClass_StaticFields() {
		return (EReference)mDeclaredClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredClass_InstanceFields() {
		return (EReference)mDeclaredClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredClass_Constructors() {
		return (EReference)mDeclaredClassEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredClass_ImplementedMethods() {
		return (EReference)mDeclaredClassEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredClass_NativeMethods() {
		return (EReference)mDeclaredClassEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAbstractDeclaredClass() {
		return mAbstractDeclaredClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMAbstractDeclaredClass_AbstractMethods() {
		return (EReference)mAbstractDeclaredClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMExternalClass() {
		return mExternalClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMInterface() {
		return abstractMInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMDeclaredInterface() {
		return mDeclaredInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredInterface_Extends() {
		return (EReference)mDeclaredInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredInterface_Constants() {
		return (EReference)mDeclaredInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredInterface_Methods() {
		return (EReference)mDeclaredInterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMExternalInterface() {
		return mExternalInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMFieldDeclaration() {
		return abstractMFieldDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMFieldDeclaration_InitialValue() {
		return (EReference)abstractMFieldDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMClassFieldDeclaration() {
		return abstractMClassFieldDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractMClassFieldDeclaration_Visibility() {
		return (EAttribute)abstractMClassFieldDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractMClassFieldDeclaration_Final() {
		return (EAttribute)abstractMClassFieldDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMStaticClassFieldDeclaration() {
		return mStaticClassFieldDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMStaticClassFieldDeclaration_Owner() {
		return (EReference)mStaticClassFieldDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMInstanceClassFieldDeclaration() {
		return mInstanceClassFieldDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMInstanceClassFieldDeclaration_Owner() {
		return (EReference)mInstanceClassFieldDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMInstanceClassFieldDeclaration_Transient() {
		return (EAttribute)mInstanceClassFieldDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMConstantInterfaceFieldDeclaration() {
		return mConstantInterfaceFieldDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMConstantInterfaceFieldDeclaration_Owner() {
		return (EReference)mConstantInterfaceFieldDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMMethodDeclaration() {
		return abstractMMethodDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMMethodDeclaration_Parameters() {
		return (EReference)abstractMMethodDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMMethodDeclarationParameter() {
		return mMethodDeclarationParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMMethodDeclarationParameter_MethodDeclaration() {
		return (EReference)mMethodDeclarationParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMImplicitMethodDeclaration() {
		return mImplicitMethodDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMImplicitMethodDeclaration_Owner() {
		return (EReference)mImplicitMethodDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMImplementableMethodDeclaration() {
		return abstractMImplementableMethodDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMImplementableMethodDeclaration_Implementations() {
		return (EReference)abstractMImplementableMethodDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMAbstractClassMethodDeclaration() {
		return mAbstractClassMethodDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMAbstractClassMethodDeclaration_Owner() {
		return (EReference)mAbstractClassMethodDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMAbstractClassMethodDeclaration_Visibility() {
		return (EAttribute)mAbstractClassMethodDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMInterfaceMethodDeclaration() {
		return mInterfaceMethodDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMInterfaceMethodDeclaration_Owner() {
		return (EReference)mInterfaceMethodDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMNativeMethodDeclaration() {
		return mNativeMethodDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMNativeMethodDeclaration_Owner() {
		return (EReference)mNativeMethodDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractMMethodImplementation() {
		return abstractMMethodImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMMethodImplementation_Owner() {
		return (EReference)abstractMMethodImplementationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractMMethodImplementation_Parameters() {
		return (EReference)abstractMMethodImplementationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMDeclaredMethodImplementation() {
		return mDeclaredMethodImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDeclaredMethodImplementation_Declaration() {
		return (EReference)mDeclaredMethodImplementationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMDirectMethodImplementation() {
		return mDirectMethodImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMDirectMethodImplementation_Declaration() {
		return (EReference)mDirectMethodImplementationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMMethodImplementationParameter() {
		return mMethodImplementationParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMMethodImplementationParameter_MethodImplementation() {
		return (EReference)mMethodImplementationParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMMethodImplementationParameter_Final() {
		return (EAttribute)mMethodImplementationParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMMethodImplementationParameter_Name() {
		return (EAttribute)mMethodImplementationParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMConstructor() {
		return mConstructorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMConstructor_Owner() {
		return (EReference)mConstructorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMConstructor_Parameters() {
		return (EReference)mConstructorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMConstructorParameter() {
		return mConstructorParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMConstructorParameter_Constructor() {
		return (EReference)mConstructorParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMConstructorParameter_Final() {
		return (EAttribute)mConstructorParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractCStatement() {
		return abstractCStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCBlockStatement() {
		return cBlockStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCBlockStatement_Statements() {
		return (EReference)cBlockStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCDeclarationStatement() {
		return cDeclarationStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCDeclarationStatement_Final() {
		return (EAttribute)cDeclarationStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCDeclarationStatement_Value() {
		return (EReference)cDeclarationStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCExpressionStatement() {
		return cExpressionStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCExpressionStatement_Expression() {
		return (EReference)cExpressionStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCIfStatement() {
		return cIfStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCIfStatement_Condition() {
		return (EReference)cIfStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCIfStatement_TrueStatement() {
		return (EReference)cIfStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCIfStatement_FalseStatement() {
		return (EReference)cIfStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCUnparsedStatement() {
		return cUnparsedStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCUnparsedStatement_Code() {
		return (EAttribute)cUnparsedStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractCExpression() {
		return abstractCExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCConditionalExpression() {
		return cConditionalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCConditionalExpression_Condition() {
		return (EReference)cConditionalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCConditionalExpression_TrueExpression() {
		return (EReference)cConditionalExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCConditionalExpression_FalseExpression() {
		return (EReference)cConditionalExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCUnparsedExpression() {
		return cUnparsedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCUnparsedExpression_Code() {
		return (EAttribute)cUnparsedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMPrimitiveTypes() {
		return mPrimitiveTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMVisibility() {
		return mVisibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractMPackageContainerEClass = createEClass(ABSTRACT_MPACKAGE_CONTAINER);
		createEReference(abstractMPackageContainerEClass, ABSTRACT_MPACKAGE_CONTAINER__PACKAGES);

		mRootEClass = createEClass(MROOT);
		createEReference(mRootEClass, MROOT__EXTERNAL_TYPES);

		mPackageEClass = createEClass(MPACKAGE);
		createEReference(mPackageEClass, MPACKAGE__PACKAGE_CONTAINER);
		createEAttribute(mPackageEClass, MPACKAGE__NAME);
		createEReference(mPackageEClass, MPACKAGE__RESOURCES);

		abstractMResourceEClass = createEClass(ABSTRACT_MRESOURCE);
		createEReference(abstractMResourceEClass, ABSTRACT_MRESOURCE__PACKAGE);
		createEAttribute(abstractMResourceEClass, ABSTRACT_MRESOURCE__NAME);
		createEAttribute(abstractMResourceEClass, ABSTRACT_MRESOURCE__DERIVED);
		createEReference(abstractMResourceEClass, ABSTRACT_MRESOURCE__DERIVED_FROM);
		createEReference(abstractMResourceEClass, ABSTRACT_MRESOURCE__SUPER_OF);

		mResourceEClass = createEClass(MRESOURCE);
		createEAttribute(mResourceEClass, MRESOURCE__CONTENT);

		abstractMTypeContainerEClass = createEClass(ABSTRACT_MTYPE_CONTAINER);
		createEReference(abstractMTypeContainerEClass, ABSTRACT_MTYPE_CONTAINER__TYPES);

		mCompilationUnitEClass = createEClass(MCOMPILATION_UNIT);
		createEReference(mCompilationUnitEClass, MCOMPILATION_UNIT__IMPORTS);

		abstractMDeclaredTypeEClass = createEClass(ABSTRACT_MDECLARED_TYPE);
		createEReference(abstractMDeclaredTypeEClass, ABSTRACT_MDECLARED_TYPE__TYPE_CONTAINER);
		createEAttribute(abstractMDeclaredTypeEClass, ABSTRACT_MDECLARED_TYPE__NAME);

		abstractMExternalTypeEClass = createEClass(ABSTRACT_MEXTERNAL_TYPE);
		createEReference(abstractMExternalTypeEClass, ABSTRACT_MEXTERNAL_TYPE__ROOT);
		createEAttribute(abstractMExternalTypeEClass, ABSTRACT_MEXTERNAL_TYPE__FULL_QUALIFIED_NAME);

		abstractMTypeEClass = createEClass(ABSTRACT_MTYPE);

		abstractMTypeReferenceEClass = createEClass(ABSTRACT_MTYPE_REFERENCE);
		createEAttribute(abstractMTypeReferenceEClass, ABSTRACT_MTYPE_REFERENCE__ARRAY);

		mDeclaredTypeReferenceEClass = createEClass(MDECLARED_TYPE_REFERENCE);
		createEReference(mDeclaredTypeReferenceEClass, MDECLARED_TYPE_REFERENCE__TYPE);

		mExternalTypeReferenceEClass = createEClass(MEXTERNAL_TYPE_REFERENCE);
		createEReference(mExternalTypeReferenceEClass, MEXTERNAL_TYPE_REFERENCE__TYPE);

		mPrimitiveTypeReferenceEClass = createEClass(MPRIMITIVE_TYPE_REFERENCE);
		createEAttribute(mPrimitiveTypeReferenceEClass, MPRIMITIVE_TYPE_REFERENCE__TYPE);

		abstractModifiersEClass = createEClass(ABSTRACT_MODIFIERS);
		createEAttribute(abstractModifiersEClass, ABSTRACT_MODIFIERS__VISIBILITY);
		createEAttribute(abstractModifiersEClass, ABSTRACT_MODIFIERS__FINAL);
		createEAttribute(abstractModifiersEClass, ABSTRACT_MODIFIERS__SYNCHRONIZED);

		abstractMMethodLikeEClass = createEClass(ABSTRACT_MMETHOD_LIKE);
		createEReference(abstractMMethodLikeEClass, ABSTRACT_MMETHOD_LIKE__STATEMENT);

		abstractMTypeWithNameDeclarationEClass = createEClass(ABSTRACT_MTYPE_WITH_NAME_DECLARATION);
		createEReference(abstractMTypeWithNameDeclarationEClass, ABSTRACT_MTYPE_WITH_NAME_DECLARATION__TYPE);
		createEAttribute(abstractMTypeWithNameDeclarationEClass, ABSTRACT_MTYPE_WITH_NAME_DECLARATION__NAME);

		abstractMClassEClass = createEClass(ABSTRACT_MCLASS);

		mDeclaredClassEClass = createEClass(MDECLARED_CLASS);
		createEReference(mDeclaredClassEClass, MDECLARED_CLASS__EXTENDS);
		createEReference(mDeclaredClassEClass, MDECLARED_CLASS__IMPLEMENTS);
		createEReference(mDeclaredClassEClass, MDECLARED_CLASS__STATIC_FIELDS);
		createEReference(mDeclaredClassEClass, MDECLARED_CLASS__INSTANCE_FIELDS);
		createEReference(mDeclaredClassEClass, MDECLARED_CLASS__CONSTRUCTORS);
		createEReference(mDeclaredClassEClass, MDECLARED_CLASS__IMPLEMENTED_METHODS);
		createEReference(mDeclaredClassEClass, MDECLARED_CLASS__NATIVE_METHODS);

		mAbstractDeclaredClassEClass = createEClass(MABSTRACT_DECLARED_CLASS);
		createEReference(mAbstractDeclaredClassEClass, MABSTRACT_DECLARED_CLASS__ABSTRACT_METHODS);

		mExternalClassEClass = createEClass(MEXTERNAL_CLASS);

		abstractMInterfaceEClass = createEClass(ABSTRACT_MINTERFACE);

		mDeclaredInterfaceEClass = createEClass(MDECLARED_INTERFACE);
		createEReference(mDeclaredInterfaceEClass, MDECLARED_INTERFACE__EXTENDS);
		createEReference(mDeclaredInterfaceEClass, MDECLARED_INTERFACE__CONSTANTS);
		createEReference(mDeclaredInterfaceEClass, MDECLARED_INTERFACE__METHODS);

		mExternalInterfaceEClass = createEClass(MEXTERNAL_INTERFACE);

		abstractMFieldDeclarationEClass = createEClass(ABSTRACT_MFIELD_DECLARATION);
		createEReference(abstractMFieldDeclarationEClass, ABSTRACT_MFIELD_DECLARATION__INITIAL_VALUE);

		abstractMClassFieldDeclarationEClass = createEClass(ABSTRACT_MCLASS_FIELD_DECLARATION);
		createEAttribute(abstractMClassFieldDeclarationEClass, ABSTRACT_MCLASS_FIELD_DECLARATION__VISIBILITY);
		createEAttribute(abstractMClassFieldDeclarationEClass, ABSTRACT_MCLASS_FIELD_DECLARATION__FINAL);

		mStaticClassFieldDeclarationEClass = createEClass(MSTATIC_CLASS_FIELD_DECLARATION);
		createEReference(mStaticClassFieldDeclarationEClass, MSTATIC_CLASS_FIELD_DECLARATION__OWNER);

		mInstanceClassFieldDeclarationEClass = createEClass(MINSTANCE_CLASS_FIELD_DECLARATION);
		createEReference(mInstanceClassFieldDeclarationEClass, MINSTANCE_CLASS_FIELD_DECLARATION__OWNER);
		createEAttribute(mInstanceClassFieldDeclarationEClass, MINSTANCE_CLASS_FIELD_DECLARATION__TRANSIENT);

		mConstantInterfaceFieldDeclarationEClass = createEClass(MCONSTANT_INTERFACE_FIELD_DECLARATION);
		createEReference(mConstantInterfaceFieldDeclarationEClass, MCONSTANT_INTERFACE_FIELD_DECLARATION__OWNER);

		abstractMMethodDeclarationEClass = createEClass(ABSTRACT_MMETHOD_DECLARATION);
		createEReference(abstractMMethodDeclarationEClass, ABSTRACT_MMETHOD_DECLARATION__PARAMETERS);

		mMethodDeclarationParameterEClass = createEClass(MMETHOD_DECLARATION_PARAMETER);
		createEReference(mMethodDeclarationParameterEClass, MMETHOD_DECLARATION_PARAMETER__METHOD_DECLARATION);

		mImplicitMethodDeclarationEClass = createEClass(MIMPLICIT_METHOD_DECLARATION);
		createEReference(mImplicitMethodDeclarationEClass, MIMPLICIT_METHOD_DECLARATION__OWNER);

		abstractMImplementableMethodDeclarationEClass = createEClass(ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION);
		createEReference(abstractMImplementableMethodDeclarationEClass, ABSTRACT_MIMPLEMENTABLE_METHOD_DECLARATION__IMPLEMENTATIONS);

		mAbstractClassMethodDeclarationEClass = createEClass(MABSTRACT_CLASS_METHOD_DECLARATION);
		createEReference(mAbstractClassMethodDeclarationEClass, MABSTRACT_CLASS_METHOD_DECLARATION__OWNER);
		createEAttribute(mAbstractClassMethodDeclarationEClass, MABSTRACT_CLASS_METHOD_DECLARATION__VISIBILITY);

		mInterfaceMethodDeclarationEClass = createEClass(MINTERFACE_METHOD_DECLARATION);
		createEReference(mInterfaceMethodDeclarationEClass, MINTERFACE_METHOD_DECLARATION__OWNER);

		mNativeMethodDeclarationEClass = createEClass(MNATIVE_METHOD_DECLARATION);
		createEReference(mNativeMethodDeclarationEClass, MNATIVE_METHOD_DECLARATION__OWNER);

		abstractMMethodImplementationEClass = createEClass(ABSTRACT_MMETHOD_IMPLEMENTATION);
		createEReference(abstractMMethodImplementationEClass, ABSTRACT_MMETHOD_IMPLEMENTATION__OWNER);
		createEReference(abstractMMethodImplementationEClass, ABSTRACT_MMETHOD_IMPLEMENTATION__PARAMETERS);

		mDeclaredMethodImplementationEClass = createEClass(MDECLARED_METHOD_IMPLEMENTATION);
		createEReference(mDeclaredMethodImplementationEClass, MDECLARED_METHOD_IMPLEMENTATION__DECLARATION);

		mDirectMethodImplementationEClass = createEClass(MDIRECT_METHOD_IMPLEMENTATION);
		createEReference(mDirectMethodImplementationEClass, MDIRECT_METHOD_IMPLEMENTATION__DECLARATION);

		mMethodImplementationParameterEClass = createEClass(MMETHOD_IMPLEMENTATION_PARAMETER);
		createEReference(mMethodImplementationParameterEClass, MMETHOD_IMPLEMENTATION_PARAMETER__METHOD_IMPLEMENTATION);
		createEAttribute(mMethodImplementationParameterEClass, MMETHOD_IMPLEMENTATION_PARAMETER__FINAL);
		createEAttribute(mMethodImplementationParameterEClass, MMETHOD_IMPLEMENTATION_PARAMETER__NAME);

		mConstructorEClass = createEClass(MCONSTRUCTOR);
		createEReference(mConstructorEClass, MCONSTRUCTOR__OWNER);
		createEReference(mConstructorEClass, MCONSTRUCTOR__PARAMETERS);

		mConstructorParameterEClass = createEClass(MCONSTRUCTOR_PARAMETER);
		createEReference(mConstructorParameterEClass, MCONSTRUCTOR_PARAMETER__CONSTRUCTOR);
		createEAttribute(mConstructorParameterEClass, MCONSTRUCTOR_PARAMETER__FINAL);

		abstractCStatementEClass = createEClass(ABSTRACT_CSTATEMENT);

		cBlockStatementEClass = createEClass(CBLOCK_STATEMENT);
		createEReference(cBlockStatementEClass, CBLOCK_STATEMENT__STATEMENTS);

		cDeclarationStatementEClass = createEClass(CDECLARATION_STATEMENT);
		createEAttribute(cDeclarationStatementEClass, CDECLARATION_STATEMENT__FINAL);
		createEReference(cDeclarationStatementEClass, CDECLARATION_STATEMENT__VALUE);

		cExpressionStatementEClass = createEClass(CEXPRESSION_STATEMENT);
		createEReference(cExpressionStatementEClass, CEXPRESSION_STATEMENT__EXPRESSION);

		cIfStatementEClass = createEClass(CIF_STATEMENT);
		createEReference(cIfStatementEClass, CIF_STATEMENT__CONDITION);
		createEReference(cIfStatementEClass, CIF_STATEMENT__TRUE_STATEMENT);
		createEReference(cIfStatementEClass, CIF_STATEMENT__FALSE_STATEMENT);

		cUnparsedStatementEClass = createEClass(CUNPARSED_STATEMENT);
		createEAttribute(cUnparsedStatementEClass, CUNPARSED_STATEMENT__CODE);

		abstractCExpressionEClass = createEClass(ABSTRACT_CEXPRESSION);

		cConditionalExpressionEClass = createEClass(CCONDITIONAL_EXPRESSION);
		createEReference(cConditionalExpressionEClass, CCONDITIONAL_EXPRESSION__CONDITION);
		createEReference(cConditionalExpressionEClass, CCONDITIONAL_EXPRESSION__TRUE_EXPRESSION);
		createEReference(cConditionalExpressionEClass, CCONDITIONAL_EXPRESSION__FALSE_EXPRESSION);

		cUnparsedExpressionEClass = createEClass(CUNPARSED_EXPRESSION);
		createEAttribute(cUnparsedExpressionEClass, CUNPARSED_EXPRESSION__CODE);

		// Create enums
		mPrimitiveTypesEEnum = createEEnum(MPRIMITIVE_TYPES);
		mVisibilityEEnum = createEEnum(MVISIBILITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Add supertypes to classes
		mRootEClass.getESuperTypes().add(this.getAbstractMPackageContainer());
		mPackageEClass.getESuperTypes().add(this.getAbstractMPackageContainer());
		mResourceEClass.getESuperTypes().add(this.getAbstractMResource());
		mCompilationUnitEClass.getESuperTypes().add(this.getAbstractMResource());
		mCompilationUnitEClass.getESuperTypes().add(this.getAbstractMTypeContainer());
		abstractMDeclaredTypeEClass.getESuperTypes().add(this.getAbstractMTypeContainer());
		mDeclaredTypeReferenceEClass.getESuperTypes().add(this.getAbstractMTypeReference());
		mExternalTypeReferenceEClass.getESuperTypes().add(this.getAbstractMTypeReference());
		mPrimitiveTypeReferenceEClass.getESuperTypes().add(this.getAbstractMTypeReference());
		abstractMMethodLikeEClass.getESuperTypes().add(this.getAbstractModifiers());
		abstractMClassEClass.getESuperTypes().add(this.getAbstractMType());
		mDeclaredClassEClass.getESuperTypes().add(this.getAbstractMClass());
		mDeclaredClassEClass.getESuperTypes().add(this.getAbstractMDeclaredType());
		mAbstractDeclaredClassEClass.getESuperTypes().add(this.getMDeclaredClass());
		mExternalClassEClass.getESuperTypes().add(this.getAbstractMClass());
		mExternalClassEClass.getESuperTypes().add(this.getAbstractMExternalType());
		abstractMInterfaceEClass.getESuperTypes().add(this.getAbstractMType());
		mDeclaredInterfaceEClass.getESuperTypes().add(this.getAbstractMInterface());
		mDeclaredInterfaceEClass.getESuperTypes().add(this.getAbstractMDeclaredType());
		mExternalInterfaceEClass.getESuperTypes().add(this.getAbstractMInterface());
		mExternalInterfaceEClass.getESuperTypes().add(this.getAbstractMExternalType());
		abstractMFieldDeclarationEClass.getESuperTypes().add(this.getAbstractMTypeWithNameDeclaration());
		abstractMClassFieldDeclarationEClass.getESuperTypes().add(this.getAbstractMFieldDeclaration());
		mStaticClassFieldDeclarationEClass.getESuperTypes().add(this.getAbstractMClassFieldDeclaration());
		mInstanceClassFieldDeclarationEClass.getESuperTypes().add(this.getAbstractMClassFieldDeclaration());
		mConstantInterfaceFieldDeclarationEClass.getESuperTypes().add(this.getAbstractMFieldDeclaration());
		abstractMMethodDeclarationEClass.getESuperTypes().add(this.getAbstractMTypeWithNameDeclaration());
		mMethodDeclarationParameterEClass.getESuperTypes().add(this.getAbstractMTypeWithNameDeclaration());
		mImplicitMethodDeclarationEClass.getESuperTypes().add(this.getAbstractMMethodDeclaration());
		abstractMImplementableMethodDeclarationEClass.getESuperTypes().add(this.getAbstractMMethodDeclaration());
		mAbstractClassMethodDeclarationEClass.getESuperTypes().add(this.getAbstractMImplementableMethodDeclaration());
		mInterfaceMethodDeclarationEClass.getESuperTypes().add(this.getAbstractMImplementableMethodDeclaration());
		mNativeMethodDeclarationEClass.getESuperTypes().add(this.getAbstractMMethodDeclaration());
		abstractMMethodImplementationEClass.getESuperTypes().add(this.getAbstractMMethodLike());
		mDeclaredMethodImplementationEClass.getESuperTypes().add(this.getAbstractMMethodImplementation());
		mDirectMethodImplementationEClass.getESuperTypes().add(this.getAbstractMMethodImplementation());
		mConstructorEClass.getESuperTypes().add(this.getAbstractMMethodLike());
		mConstructorParameterEClass.getESuperTypes().add(this.getAbstractMTypeWithNameDeclaration());
		cBlockStatementEClass.getESuperTypes().add(this.getAbstractCStatement());
		cDeclarationStatementEClass.getESuperTypes().add(this.getAbstractCStatement());
		cDeclarationStatementEClass.getESuperTypes().add(this.getAbstractMTypeWithNameDeclaration());
		cExpressionStatementEClass.getESuperTypes().add(this.getAbstractCStatement());
		cIfStatementEClass.getESuperTypes().add(this.getAbstractCStatement());
		cUnparsedStatementEClass.getESuperTypes().add(this.getAbstractCStatement());
		cConditionalExpressionEClass.getESuperTypes().add(this.getAbstractCExpression());
		cUnparsedExpressionEClass.getESuperTypes().add(this.getAbstractCExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractMPackageContainerEClass, AbstractMPackageContainer.class, "AbstractMPackageContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMPackageContainer_Packages(), this.getMPackage(), this.getMPackage_PackageContainer(), "packages", null, 0, -1, AbstractMPackageContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mRootEClass, MRoot.class, "MRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMRoot_ExternalTypes(), this.getAbstractMExternalType(), this.getAbstractMExternalType_Root(), "externalTypes", null, 0, -1, MRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mPackageEClass, MPackage.class, "MPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMPackage_PackageContainer(), this.getAbstractMPackageContainer(), this.getAbstractMPackageContainer_Packages(), "packageContainer", null, 1, 1, MPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMPackage_Name(), ecorePackage.getEString(), "name", null, 1, 1, MPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMPackage_Resources(), this.getAbstractMResource(), this.getAbstractMResource_Package(), "resources", null, 0, -1, MPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMResourceEClass, AbstractMResource.class, "AbstractMResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMResource_Package(), this.getMPackage(), this.getMPackage_Resources(), "package", null, 1, 1, AbstractMResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractMResource_Name(), ecorePackage.getEString(), "name", null, 1, 1, AbstractMResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractMResource_Derived(), ecorePackage.getEBoolean(), "derived", "false", 1, 1, AbstractMResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractMResource_DerivedFrom(), this.getAbstractMResource(), this.getAbstractMResource_SuperOf(), "derivedFrom", null, 0, -1, AbstractMResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractMResource_SuperOf(), this.getAbstractMResource(), this.getAbstractMResource_DerivedFrom(), "superOf", null, 0, -1, AbstractMResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mResourceEClass, MResource.class, "MResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMResource_Content(), ecorePackage.getEByteArray(), "content", null, 0, 1, MResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMTypeContainerEClass, AbstractMTypeContainer.class, "AbstractMTypeContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMTypeContainer_Types(), this.getAbstractMDeclaredType(), this.getAbstractMDeclaredType_TypeContainer(), "types", null, 0, -1, AbstractMTypeContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mCompilationUnitEClass, MCompilationUnit.class, "MCompilationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMCompilationUnit_Imports(), this.getAbstractMType(), null, "imports", null, 0, -1, MCompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMDeclaredTypeEClass, AbstractMDeclaredType.class, "AbstractMDeclaredType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMDeclaredType_TypeContainer(), this.getAbstractMTypeContainer(), this.getAbstractMTypeContainer_Types(), "typeContainer", null, 1, 1, AbstractMDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractMDeclaredType_Name(), ecorePackage.getEString(), "name", null, 1, 1, AbstractMDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMExternalTypeEClass, AbstractMExternalType.class, "AbstractMExternalType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMExternalType_Root(), this.getMRoot(), this.getMRoot_ExternalTypes(), "root", null, 1, 1, AbstractMExternalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractMExternalType_FullQualifiedName(), ecorePackage.getEString(), "fullQualifiedName", null, 1, 1, AbstractMExternalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMTypeEClass, AbstractMType.class, "AbstractMType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractMTypeReferenceEClass, AbstractMTypeReference.class, "AbstractMTypeReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractMTypeReference_Array(), ecorePackage.getEBoolean(), "array", "false", 1, 1, AbstractMTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mDeclaredTypeReferenceEClass, MDeclaredTypeReference.class, "MDeclaredTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMDeclaredTypeReference_Type(), this.getAbstractMDeclaredType(), null, "type", null, 1, 1, MDeclaredTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mExternalTypeReferenceEClass, MExternalTypeReference.class, "MExternalTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMExternalTypeReference_Type(), this.getAbstractMExternalType(), null, "type", null, 1, 1, MExternalTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mPrimitiveTypeReferenceEClass, MPrimitiveTypeReference.class, "MPrimitiveTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMPrimitiveTypeReference_Type(), this.getMPrimitiveTypes(), "type", null, 1, 1, MPrimitiveTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractModifiersEClass, AbstractModifiers.class, "AbstractModifiers", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractModifiers_Visibility(), this.getMVisibility(), "visibility", "PUBLIC", 1, 1, AbstractModifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractModifiers_Final(), ecorePackage.getEBoolean(), "final", "false", 1, 1, AbstractModifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractModifiers_Synchronized(), ecorePackage.getEBoolean(), "synchronized", "false", 1, 1, AbstractModifiers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMMethodLikeEClass, AbstractMMethodLike.class, "AbstractMMethodLike", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMMethodLike_Statement(), this.getAbstractCStatement(), null, "statement", null, 0, 1, AbstractMMethodLike.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMTypeWithNameDeclarationEClass, AbstractMTypeWithNameDeclaration.class, "AbstractMTypeWithNameDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMTypeWithNameDeclaration_Type(), this.getAbstractMTypeReference(), null, "type", null, 1, 1, AbstractMTypeWithNameDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractMTypeWithNameDeclaration_Name(), ecorePackage.getEString(), "name", null, 1, 1, AbstractMTypeWithNameDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMClassEClass, AbstractMClass.class, "AbstractMClass", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mDeclaredClassEClass, MDeclaredClass.class, "MDeclaredClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMDeclaredClass_Extends(), this.getAbstractMClass(), null, "extends", null, 0, 1, MDeclaredClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMDeclaredClass_Implements(), this.getAbstractMInterface(), null, "implements", null, 0, -1, MDeclaredClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMDeclaredClass_StaticFields(), this.getMStaticClassFieldDeclaration(), this.getMStaticClassFieldDeclaration_Owner(), "staticFields", null, 0, -1, MDeclaredClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMDeclaredClass_InstanceFields(), this.getMInstanceClassFieldDeclaration(), this.getMInstanceClassFieldDeclaration_Owner(), "instanceFields", null, 0, -1, MDeclaredClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMDeclaredClass_Constructors(), this.getMConstructor(), this.getMConstructor_Owner(), "constructors", null, 0, -1, MDeclaredClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMDeclaredClass_ImplementedMethods(), this.getAbstractMMethodImplementation(), this.getAbstractMMethodImplementation_Owner(), "implementedMethods", null, 0, -1, MDeclaredClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMDeclaredClass_NativeMethods(), this.getMNativeMethodDeclaration(), this.getMNativeMethodDeclaration_Owner(), "nativeMethods", null, 0, -1, MDeclaredClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mAbstractDeclaredClassEClass, MAbstractDeclaredClass.class, "MAbstractDeclaredClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMAbstractDeclaredClass_AbstractMethods(), this.getMAbstractClassMethodDeclaration(), this.getMAbstractClassMethodDeclaration_Owner(), "abstractMethods", null, 0, -1, MAbstractDeclaredClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mExternalClassEClass, MExternalClass.class, "MExternalClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractMInterfaceEClass, AbstractMInterface.class, "AbstractMInterface", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mDeclaredInterfaceEClass, MDeclaredInterface.class, "MDeclaredInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMDeclaredInterface_Extends(), this.getAbstractMInterface(), null, "extends", null, 0, -1, MDeclaredInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMDeclaredInterface_Constants(), this.getMConstantInterfaceFieldDeclaration(), this.getMConstantInterfaceFieldDeclaration_Owner(), "constants", null, 0, -1, MDeclaredInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMDeclaredInterface_Methods(), this.getMInterfaceMethodDeclaration(), this.getMInterfaceMethodDeclaration_Owner(), "methods", null, 0, -1, MDeclaredInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mExternalInterfaceEClass, MExternalInterface.class, "MExternalInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractMFieldDeclarationEClass, AbstractMFieldDeclaration.class, "AbstractMFieldDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMFieldDeclaration_InitialValue(), this.getAbstractCExpression(), null, "initialValue", null, 0, 1, AbstractMFieldDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMClassFieldDeclarationEClass, AbstractMClassFieldDeclaration.class, "AbstractMClassFieldDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractMClassFieldDeclaration_Visibility(), this.getMVisibility(), "visibility", "PRIVATE", 1, 1, AbstractMClassFieldDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractMClassFieldDeclaration_Final(), ecorePackage.getEBoolean(), "final", null, 1, 1, AbstractMClassFieldDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mStaticClassFieldDeclarationEClass, MStaticClassFieldDeclaration.class, "MStaticClassFieldDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMStaticClassFieldDeclaration_Owner(), this.getMDeclaredClass(), this.getMDeclaredClass_StaticFields(), "owner", null, 1, 1, MStaticClassFieldDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mInstanceClassFieldDeclarationEClass, MInstanceClassFieldDeclaration.class, "MInstanceClassFieldDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMInstanceClassFieldDeclaration_Owner(), this.getMDeclaredClass(), this.getMDeclaredClass_InstanceFields(), "owner", null, 1, 1, MInstanceClassFieldDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMInstanceClassFieldDeclaration_Transient(), ecorePackage.getEBoolean(), "transient", null, 1, 1, MInstanceClassFieldDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mConstantInterfaceFieldDeclarationEClass, MConstantInterfaceFieldDeclaration.class, "MConstantInterfaceFieldDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMConstantInterfaceFieldDeclaration_Owner(), this.getMDeclaredInterface(), this.getMDeclaredInterface_Constants(), "owner", null, 1, 1, MConstantInterfaceFieldDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMMethodDeclarationEClass, AbstractMMethodDeclaration.class, "AbstractMMethodDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMMethodDeclaration_Parameters(), this.getMMethodDeclarationParameter(), this.getMMethodDeclarationParameter_MethodDeclaration(), "parameters", null, 0, -1, AbstractMMethodDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mMethodDeclarationParameterEClass, MMethodDeclarationParameter.class, "MMethodDeclarationParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMMethodDeclarationParameter_MethodDeclaration(), this.getAbstractMMethodDeclaration(), this.getAbstractMMethodDeclaration_Parameters(), "methodDeclaration", null, 1, 1, MMethodDeclarationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mImplicitMethodDeclarationEClass, MImplicitMethodDeclaration.class, "MImplicitMethodDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMImplicitMethodDeclaration_Owner(), this.getMDirectMethodImplementation(), this.getMDirectMethodImplementation_Declaration(), "owner", null, 1, 1, MImplicitMethodDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMImplementableMethodDeclarationEClass, AbstractMImplementableMethodDeclaration.class, "AbstractMImplementableMethodDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMImplementableMethodDeclaration_Implementations(), this.getMDeclaredMethodImplementation(), this.getMDeclaredMethodImplementation_Declaration(), "implementations", null, 0, -1, AbstractMImplementableMethodDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mAbstractClassMethodDeclarationEClass, MAbstractClassMethodDeclaration.class, "MAbstractClassMethodDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMAbstractClassMethodDeclaration_Owner(), this.getMAbstractDeclaredClass(), this.getMAbstractDeclaredClass_AbstractMethods(), "owner", null, 1, 1, MAbstractClassMethodDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMAbstractClassMethodDeclaration_Visibility(), this.getMVisibility(), "visibility", "PROTECTED", 1, 1, MAbstractClassMethodDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mInterfaceMethodDeclarationEClass, MInterfaceMethodDeclaration.class, "MInterfaceMethodDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMInterfaceMethodDeclaration_Owner(), this.getMDeclaredInterface(), this.getMDeclaredInterface_Methods(), "owner", null, 1, 1, MInterfaceMethodDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mNativeMethodDeclarationEClass, MNativeMethodDeclaration.class, "MNativeMethodDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMNativeMethodDeclaration_Owner(), this.getMDeclaredClass(), this.getMDeclaredClass_NativeMethods(), "owner", null, 1, 1, MNativeMethodDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractMMethodImplementationEClass, AbstractMMethodImplementation.class, "AbstractMMethodImplementation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractMMethodImplementation_Owner(), this.getMDeclaredClass(), this.getMDeclaredClass_ImplementedMethods(), "owner", null, 1, 1, AbstractMMethodImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractMMethodImplementation_Parameters(), this.getMMethodImplementationParameter(), this.getMMethodImplementationParameter_MethodImplementation(), "parameters", null, 0, -1, AbstractMMethodImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mDeclaredMethodImplementationEClass, MDeclaredMethodImplementation.class, "MDeclaredMethodImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMDeclaredMethodImplementation_Declaration(), this.getAbstractMImplementableMethodDeclaration(), this.getAbstractMImplementableMethodDeclaration_Implementations(), "declaration", null, 1, 1, MDeclaredMethodImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mDirectMethodImplementationEClass, MDirectMethodImplementation.class, "MDirectMethodImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMDirectMethodImplementation_Declaration(), this.getMImplicitMethodDeclaration(), this.getMImplicitMethodDeclaration_Owner(), "declaration", null, 1, 1, MDirectMethodImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mMethodImplementationParameterEClass, MMethodImplementationParameter.class, "MMethodImplementationParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMMethodImplementationParameter_MethodImplementation(), this.getAbstractMMethodImplementation(), this.getAbstractMMethodImplementation_Parameters(), "methodImplementation", null, 1, 1, MMethodImplementationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMMethodImplementationParameter_Final(), ecorePackage.getEBoolean(), "final", "true", 1, 1, MMethodImplementationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMMethodImplementationParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1, MMethodImplementationParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mConstructorEClass, MConstructor.class, "MConstructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMConstructor_Owner(), this.getMDeclaredClass(), this.getMDeclaredClass_Constructors(), "owner", null, 1, 1, MConstructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMConstructor_Parameters(), this.getMConstructorParameter(), this.getMConstructorParameter_Constructor(), "parameters", null, 0, -1, MConstructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mConstructorParameterEClass, MConstructorParameter.class, "MConstructorParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMConstructorParameter_Constructor(), this.getMConstructor(), this.getMConstructor_Parameters(), "constructor", null, 1, 1, MConstructorParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMConstructorParameter_Final(), ecorePackage.getEBoolean(), "final", "true", 1, 1, MConstructorParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractCStatementEClass, AbstractCStatement.class, "AbstractCStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cBlockStatementEClass, CBlockStatement.class, "CBlockStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCBlockStatement_Statements(), this.getAbstractCStatement(), null, "statements", null, 0, -1, CBlockStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cDeclarationStatementEClass, CDeclarationStatement.class, "CDeclarationStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCDeclarationStatement_Final(), ecorePackage.getEBoolean(), "final", null, 1, 1, CDeclarationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCDeclarationStatement_Value(), this.getAbstractCExpression(), null, "value", null, 0, 1, CDeclarationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cExpressionStatementEClass, CExpressionStatement.class, "CExpressionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCExpressionStatement_Expression(), this.getAbstractCExpression(), null, "expression", null, 1, 1, CExpressionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cIfStatementEClass, CIfStatement.class, "CIfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCIfStatement_Condition(), this.getAbstractCExpression(), null, "condition", null, 1, 1, CIfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCIfStatement_TrueStatement(), this.getAbstractCStatement(), null, "trueStatement", null, 1, 1, CIfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCIfStatement_FalseStatement(), this.getAbstractCStatement(), null, "falseStatement", null, 0, 1, CIfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cUnparsedStatementEClass, CUnparsedStatement.class, "CUnparsedStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCUnparsedStatement_Code(), ecorePackage.getEString(), "code", null, 1, 1, CUnparsedStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractCExpressionEClass, AbstractCExpression.class, "AbstractCExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cConditionalExpressionEClass, CConditionalExpression.class, "CConditionalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCConditionalExpression_Condition(), this.getAbstractCExpression(), null, "condition", null, 1, 1, CConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCConditionalExpression_TrueExpression(), this.getAbstractCExpression(), null, "trueExpression", null, 1, 1, CConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCConditionalExpression_FalseExpression(), this.getAbstractCExpression(), null, "falseExpression", null, 0, 1, CConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cUnparsedExpressionEClass, CUnparsedExpression.class, "CUnparsedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCUnparsedExpression_Code(), ecorePackage.getEString(), "code", null, 1, 1, CUnparsedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(mPrimitiveTypesEEnum, MPrimitiveTypes.class, "MPrimitiveTypes");
		addEEnumLiteral(mPrimitiveTypesEEnum, MPrimitiveTypes.BOOLEAN_LITERAL);
		addEEnumLiteral(mPrimitiveTypesEEnum, MPrimitiveTypes.BYTE_LITERAL);
		addEEnumLiteral(mPrimitiveTypesEEnum, MPrimitiveTypes.SHORT_LITERAL);
		addEEnumLiteral(mPrimitiveTypesEEnum, MPrimitiveTypes.INT_LITERAL);
		addEEnumLiteral(mPrimitiveTypesEEnum, MPrimitiveTypes.LONG_LITERAL);
		addEEnumLiteral(mPrimitiveTypesEEnum, MPrimitiveTypes.FLOAT_LITERAL);
		addEEnumLiteral(mPrimitiveTypesEEnum, MPrimitiveTypes.DOUBLE_LITERAL);
		addEEnumLiteral(mPrimitiveTypesEEnum, MPrimitiveTypes.CHAR_LITERAL);

		initEEnum(mVisibilityEEnum, MVisibility.class, "MVisibility");
		addEEnumLiteral(mVisibilityEEnum, MVisibility.DEFAULT_LITERAL);
		addEEnumLiteral(mVisibilityEEnum, MVisibility.PRIVATE_LITERAL);
		addEEnumLiteral(mVisibilityEEnum, MVisibility.PROTECTED_LITERAL);
		addEEnumLiteral(mVisibilityEEnum, MVisibility.PUBLIC_LITERAL);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelPackageImpl
