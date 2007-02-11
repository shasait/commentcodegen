/**
 * <copyright>
 * </copyright>
 *
 * $Id: MVisibility.java,v 1.1 2007-02-11 22:29:51 concentus Exp $
 */
package de.hasait.eclipse.ccg.java.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>MVisibility</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hasait.eclipse.ccg.java.model.ModelPackage#getMVisibility()
 * @model
 * @generated
 */
public final class MVisibility extends AbstractEnumerator {
	/**
	 * The '<em><b>DEFAULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEFAULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT = 0;

	/**
	 * The '<em><b>PRIVATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRIVATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRIVATE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRIVATE = 1;

	/**
	 * The '<em><b>PROTECTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROTECTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROTECTED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROTECTED = 2;

	/**
	 * The '<em><b>PUBLIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PUBLIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PUBLIC_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PUBLIC = 3;

	/**
	 * The '<em><b>DEFAULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEFAULT
	 * @generated
	 * @ordered
	 */
	public static final MVisibility DEFAULT_LITERAL = new MVisibility(DEFAULT, "DEFAULT", "DEFAULT");

	/**
	 * The '<em><b>PRIVATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIVATE
	 * @generated
	 * @ordered
	 */
	public static final MVisibility PRIVATE_LITERAL = new MVisibility(PRIVATE, "PRIVATE", "PRIVATE");

	/**
	 * The '<em><b>PROTECTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROTECTED
	 * @generated
	 * @ordered
	 */
	public static final MVisibility PROTECTED_LITERAL = new MVisibility(PROTECTED, "PROTECTED", "PROTECTED");

	/**
	 * The '<em><b>PUBLIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PUBLIC
	 * @generated
	 * @ordered
	 */
	public static final MVisibility PUBLIC_LITERAL = new MVisibility(PUBLIC, "PUBLIC", "PUBLIC");

	/**
	 * An array of all the '<em><b>MVisibility</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MVisibility[] VALUES_ARRAY =
		new MVisibility[] {
			DEFAULT_LITERAL,
			PRIVATE_LITERAL,
			PROTECTED_LITERAL,
			PUBLIC_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>MVisibility</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>MVisibility</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MVisibility get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MVisibility result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>MVisibility</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MVisibility getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MVisibility result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>MVisibility</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MVisibility get(int value) {
		switch (value) {
			case DEFAULT: return DEFAULT_LITERAL;
			case PRIVATE: return PRIVATE_LITERAL;
			case PROTECTED: return PROTECTED_LITERAL;
			case PUBLIC: return PUBLIC_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private MVisibility(int value, String name, String literal) {
		super(value, name, literal);
	}

} //MVisibility
