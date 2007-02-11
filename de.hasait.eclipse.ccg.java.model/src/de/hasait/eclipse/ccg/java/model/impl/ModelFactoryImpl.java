/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelFactoryImpl.java,v 1.1 2007-02-11 22:29:53 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model.impl;

import de.hasait.eclipse.ccg.java.model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.hasait.de/ccg/java/model.ecore"); 
			if (theModelFactory != null) {
				return theModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelPackage.MROOT: return createMRoot();
			case ModelPackage.MPACKAGE: return createMPackage();
			case ModelPackage.MRESOURCE: return createMResource();
			case ModelPackage.MCOMPILATION_UNIT: return createMCompilationUnit();
			case ModelPackage.MDECLARED_TYPE_REFERENCE: return createMDeclaredTypeReference();
			case ModelPackage.MEXTERNAL_TYPE_REFERENCE: return createMExternalTypeReference();
			case ModelPackage.MPRIMITIVE_TYPE_REFERENCE: return createMPrimitiveTypeReference();
			case ModelPackage.MDECLARED_CLASS: return createMDeclaredClass();
			case ModelPackage.MABSTRACT_DECLARED_CLASS: return createMAbstractDeclaredClass();
			case ModelPackage.MEXTERNAL_CLASS: return createMExternalClass();
			case ModelPackage.MDECLARED_INTERFACE: return createMDeclaredInterface();
			case ModelPackage.MEXTERNAL_INTERFACE: return createMExternalInterface();
			case ModelPackage.MSTATIC_CLASS_FIELD_DECLARATION: return createMStaticClassFieldDeclaration();
			case ModelPackage.MINSTANCE_CLASS_FIELD_DECLARATION: return createMInstanceClassFieldDeclaration();
			case ModelPackage.MCONSTANT_INTERFACE_FIELD_DECLARATION: return createMConstantInterfaceFieldDeclaration();
			case ModelPackage.MMETHOD_DECLARATION_PARAMETER: return createMMethodDeclarationParameter();
			case ModelPackage.MIMPLICIT_METHOD_DECLARATION: return createMImplicitMethodDeclaration();
			case ModelPackage.MABSTRACT_CLASS_METHOD_DECLARATION: return createMAbstractClassMethodDeclaration();
			case ModelPackage.MINTERFACE_METHOD_DECLARATION: return createMInterfaceMethodDeclaration();
			case ModelPackage.MNATIVE_METHOD_DECLARATION: return createMNativeMethodDeclaration();
			case ModelPackage.MDECLARED_METHOD_IMPLEMENTATION: return createMDeclaredMethodImplementation();
			case ModelPackage.MDIRECT_METHOD_IMPLEMENTATION: return createMDirectMethodImplementation();
			case ModelPackage.MMETHOD_IMPLEMENTATION_PARAMETER: return createMMethodImplementationParameter();
			case ModelPackage.MCONSTRUCTOR: return createMConstructor();
			case ModelPackage.MCONSTRUCTOR_PARAMETER: return createMConstructorParameter();
			case ModelPackage.CBLOCK_STATEMENT: return createCBlockStatement();
			case ModelPackage.CDECLARATION_STATEMENT: return createCDeclarationStatement();
			case ModelPackage.CEXPRESSION_STATEMENT: return createCExpressionStatement();
			case ModelPackage.CIF_STATEMENT: return createCIfStatement();
			case ModelPackage.CUNPARSED_STATEMENT: return createCUnparsedStatement();
			case ModelPackage.CCONDITIONAL_EXPRESSION: return createCConditionalExpression();
			case ModelPackage.CUNPARSED_EXPRESSION: return createCUnparsedExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ModelPackage.MPRIMITIVE_TYPES:
				return createMPrimitiveTypesFromString(eDataType, initialValue);
			case ModelPackage.MVISIBILITY:
				return createMVisibilityFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ModelPackage.MPRIMITIVE_TYPES:
				return convertMPrimitiveTypesToString(eDataType, instanceValue);
			case ModelPackage.MVISIBILITY:
				return convertMVisibilityToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MRoot createMRoot() {
		MRootImpl mRoot = new MRootImpl();
		return mRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MPackage createMPackage() {
		MPackageImpl mPackage = new MPackageImpl();
		return mPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MResource createMResource() {
		MResourceImpl mResource = new MResourceImpl();
		return mResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MCompilationUnit createMCompilationUnit() {
		MCompilationUnitImpl mCompilationUnit = new MCompilationUnitImpl();
		return mCompilationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MDeclaredTypeReference createMDeclaredTypeReference() {
		MDeclaredTypeReferenceImpl mDeclaredTypeReference = new MDeclaredTypeReferenceImpl();
		return mDeclaredTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MExternalTypeReference createMExternalTypeReference() {
		MExternalTypeReferenceImpl mExternalTypeReference = new MExternalTypeReferenceImpl();
		return mExternalTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MPrimitiveTypeReference createMPrimitiveTypeReference() {
		MPrimitiveTypeReferenceImpl mPrimitiveTypeReference = new MPrimitiveTypeReferenceImpl();
		return mPrimitiveTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MDeclaredClass createMDeclaredClass() {
		MDeclaredClassImpl mDeclaredClass = new MDeclaredClassImpl();
		return mDeclaredClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAbstractDeclaredClass createMAbstractDeclaredClass() {
		MAbstractDeclaredClassImpl mAbstractDeclaredClass = new MAbstractDeclaredClassImpl();
		return mAbstractDeclaredClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MExternalClass createMExternalClass() {
		MExternalClassImpl mExternalClass = new MExternalClassImpl();
		return mExternalClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MDeclaredInterface createMDeclaredInterface() {
		MDeclaredInterfaceImpl mDeclaredInterface = new MDeclaredInterfaceImpl();
		return mDeclaredInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MExternalInterface createMExternalInterface() {
		MExternalInterfaceImpl mExternalInterface = new MExternalInterfaceImpl();
		return mExternalInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MStaticClassFieldDeclaration createMStaticClassFieldDeclaration() {
		MStaticClassFieldDeclarationImpl mStaticClassFieldDeclaration = new MStaticClassFieldDeclarationImpl();
		return mStaticClassFieldDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MInstanceClassFieldDeclaration createMInstanceClassFieldDeclaration() {
		MInstanceClassFieldDeclarationImpl mInstanceClassFieldDeclaration = new MInstanceClassFieldDeclarationImpl();
		return mInstanceClassFieldDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MConstantInterfaceFieldDeclaration createMConstantInterfaceFieldDeclaration() {
		MConstantInterfaceFieldDeclarationImpl mConstantInterfaceFieldDeclaration = new MConstantInterfaceFieldDeclarationImpl();
		return mConstantInterfaceFieldDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MMethodDeclarationParameter createMMethodDeclarationParameter() {
		MMethodDeclarationParameterImpl mMethodDeclarationParameter = new MMethodDeclarationParameterImpl();
		return mMethodDeclarationParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MImplicitMethodDeclaration createMImplicitMethodDeclaration() {
		MImplicitMethodDeclarationImpl mImplicitMethodDeclaration = new MImplicitMethodDeclarationImpl();
		return mImplicitMethodDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MAbstractClassMethodDeclaration createMAbstractClassMethodDeclaration() {
		MAbstractClassMethodDeclarationImpl mAbstractClassMethodDeclaration = new MAbstractClassMethodDeclarationImpl();
		return mAbstractClassMethodDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MInterfaceMethodDeclaration createMInterfaceMethodDeclaration() {
		MInterfaceMethodDeclarationImpl mInterfaceMethodDeclaration = new MInterfaceMethodDeclarationImpl();
		return mInterfaceMethodDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MNativeMethodDeclaration createMNativeMethodDeclaration() {
		MNativeMethodDeclarationImpl mNativeMethodDeclaration = new MNativeMethodDeclarationImpl();
		return mNativeMethodDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MDeclaredMethodImplementation createMDeclaredMethodImplementation() {
		MDeclaredMethodImplementationImpl mDeclaredMethodImplementation = new MDeclaredMethodImplementationImpl();
		return mDeclaredMethodImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MDirectMethodImplementation createMDirectMethodImplementation() {
		MDirectMethodImplementationImpl mDirectMethodImplementation = new MDirectMethodImplementationImpl();
		return mDirectMethodImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MMethodImplementationParameter createMMethodImplementationParameter() {
		MMethodImplementationParameterImpl mMethodImplementationParameter = new MMethodImplementationParameterImpl();
		return mMethodImplementationParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MConstructor createMConstructor() {
		MConstructorImpl mConstructor = new MConstructorImpl();
		return mConstructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MConstructorParameter createMConstructorParameter() {
		MConstructorParameterImpl mConstructorParameter = new MConstructorParameterImpl();
		return mConstructorParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CBlockStatement createCBlockStatement() {
		CBlockStatementImpl cBlockStatement = new CBlockStatementImpl();
		return cBlockStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CDeclarationStatement createCDeclarationStatement() {
		CDeclarationStatementImpl cDeclarationStatement = new CDeclarationStatementImpl();
		return cDeclarationStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CExpressionStatement createCExpressionStatement() {
		CExpressionStatementImpl cExpressionStatement = new CExpressionStatementImpl();
		return cExpressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CIfStatement createCIfStatement() {
		CIfStatementImpl cIfStatement = new CIfStatementImpl();
		return cIfStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CUnparsedStatement createCUnparsedStatement() {
		CUnparsedStatementImpl cUnparsedStatement = new CUnparsedStatementImpl();
		return cUnparsedStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CConditionalExpression createCConditionalExpression() {
		CConditionalExpressionImpl cConditionalExpression = new CConditionalExpressionImpl();
		return cConditionalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CUnparsedExpression createCUnparsedExpression() {
		CUnparsedExpressionImpl cUnparsedExpression = new CUnparsedExpressionImpl();
		return cUnparsedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MPrimitiveTypes createMPrimitiveTypesFromString(EDataType eDataType, String initialValue) {
		MPrimitiveTypes result = MPrimitiveTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMPrimitiveTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MVisibility createMVisibilityFromString(EDataType eDataType, String initialValue) {
		MVisibility result = MVisibility.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMVisibilityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

} //ModelFactoryImpl
