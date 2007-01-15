package de.hasait.eclipse.ccg.javag.app.global;


/**
 * @author CCG /model/ccg/model.ccg.xml
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ModelEventDispatcher {
	private LinkedList _changeQueue;

	private int _txLevel = 0;

	public void start() {
		if (!isTransactionOpen()) {
			_changeQueue = new LinkedList();
		}
		_txLevel++;
	}

	public void commit() {
		while(true) {
			assertOpenTransaction();
			_txLevel--;
			if (isTransactionOpen()) {
				return;
			}
			// no transaction open
			if (_changeQueue.isEmpty()) {
				// no changes to dispatch
				return;
			}
			// save changeQueue, because start() creates a new one
			LinkedList vOldChangeQueue = _changeQueue;
			// dispatch within transaction for grouping changes
			start();
			dispatch(vOldChangeQueue);
		}
	}

	public void rollback() {
		if (isTransactionOpen()) {
			_txLevel = 0;
			_changeQueue = null;
		}
	}

	public boolean isTransactionOpen() {
		return _txLevel > 0;
	}

	public void assertOpenTransaction() {
		if (!isTransactionOpen()) {
			throw new IllegalStateException("No open transaction");
		}
	}

	public void assertNoOpenTransaction() {
		if (isTransactionOpen()) {
			throw new IllegalStateException("Open transaction");
		}
	}

	private void dispatch(final LinkedList pChangeQueue) {
		while (!pChangeQueue.isEmpty()) {
			AbstractChange vChange = (AbstractChange) pChangeQueue.removeFirst();
			dispatch(vChange);
		}
	}
	
	private void dispatch(final AbstractChange pChange) {
		IChangeListener[] vChangeListeners = getChangeListeners(pChange.getSource(), pChange.getPropertyName());
		if (vChangeListeners != null) {
			for (int vChangeListenersI = 0; vChangeListenersI < vChangeListeners.length; vChangeListenersI++) {
				IChangeListener vChangeListener = vChangeListeners[vChangeListenersI];
				try {
					vChangeListener.handle(pChange);
				} catch (Exception e) {
					System.err.println("Exception must be handled inside ChangeListener");
					e.printStackTrace();
				}
			}
		}
	}

	private void addChange(final AbstractChange pChange) {
		if (isTransactionOpen()) {
			// enqueue change for dispatch on commit
			_changeQueue.addLast(pChange);
		} else {
			// no change grouping, so dispatch immediatly
			dispatch(pChange);
		}
	}

	public final void addSingleChange(final Object pSource, final String pPropertyName, final Object pOldValue,
	      final Object pNewValue) {
		addChange(new SingleChange(pSource, pPropertyName, pOldValue, pNewValue));
	}

	public final void addSingleChange(final Object pSource, final String pPropertyName, final boolean pOldValue,
	      final boolean pNewValue) {
		addSingleChange(pSource, pPropertyName, Boolean.valueOf(pOldValue), Boolean.valueOf(pNewValue));
	}

	public final void addSingleChange(final Object pSource, final String pPropertyName, final short pOldValue,
	      final short pNewValue) {
		addSingleChange(pSource, pPropertyName, Short.valueOf(pOldValue), Short.valueOf(pNewValue));
	}

	public final void addSingleChange(final Object pSource, final String pPropertyName, final int pOldValue,
	      final int pNewValue) {
		addSingleChange(pSource, pPropertyName, Integer.valueOf(pOldValue), Integer.valueOf(pNewValue));
	}

	public final void addSingleChange(final Object pSource, final String pPropertyName, final long pOldValue,
	      final long pNewValue) {
		addSingleChange(pSource, pPropertyName, Long.valueOf(pOldValue), Long.valueOf(pNewValue));
	}

	public final void addSingleChange(final Object pSource, final String pPropertyName, final float pOldValue,
	      final float pNewValue) {
		addSingleChange(pSource, pPropertyName, Float.valueOf(pOldValue), Float.valueOf(pNewValue));
	}

	public final void addSingleChange(final Object pSource, final String pPropertyName, final double pOldValue,
	      final double pNewValue) {
		addSingleChange(pSource, pPropertyName, Double.valueOf(pOldValue), Double.valueOf(pNewValue));
	}

	public final void addMultiAddChange(final Object pSource, final String pPropertyName, final Object pAddedValue) {
		addChange(new MultiAddChange(pSource, pPropertyName, pAddedValue));
	}

	public final void addMultiRemoveChange(final Object pSource, final String pPropertyName, final Object pRemovedValue) {
		addChange(new MultiRemoveChange(pSource, pPropertyName, pRemovedValue));
	}

	private final Map _changeListenersByPropertyNameBySource = new HashMap();

	public final void addChangeListener(final Object pSource, final String pPropertyName,
	      final IChangeListener pChangeListener) {
		if (!_changeListenersByPropertyNameBySource.containsKey(pSource)) {
			_changeListenersByPropertyNameBySource.put(pSource, new HashMap());
		}
		Map vChangeListenersByPropertyName = (Map) _changeListenersByPropertyNameBySource.get(pSource);
		if (!vChangeListenersByPropertyName.containsKey(pPropertyName)) {
			vChangeListenersByPropertyName.put(pPropertyName, new ArrayList());
		}
		Collection vChangeListeners = (Collection) vChangeListenersByPropertyName.get(pPropertyName);
		vChangeListeners.add(pChangeListener);
	}

	public final void removeChangeListener(final Object pSource, final String pPropertyName,
	      final IChangeListener pChangeListener) {
		if (!_changeListenersByPropertyNameBySource.containsKey(pSource)) {
			return;
		}
		Map vChangeListenersByPropertyName = (Map) _changeListenersByPropertyNameBySource.get(pSource);
		if (!vChangeListenersByPropertyName.containsKey(pPropertyName)) {
			return;
		}
		Collection vChangeListeners = (Collection) vChangeListenersByPropertyName.get(pPropertyName);
		vChangeListeners.remove(pChangeListener);
	}

	public final boolean containsChangeListener(final Object pSource, final String pPropertyName) {
		if (!_changeListenersByPropertyNameBySource.containsKey(pSource)) {
			return false;
		}
		Map vChangeListenersByPropertyName = (Map) _changeListenersByPropertyNameBySource.get(pSource);
		if (vChangeListenersByPropertyName.containsKey(pPropertyName)) {
			Collection vChangeListeners = (Collection) vChangeListenersByPropertyName.get(pPropertyName);
			if (!vChangeListeners.isEmpty()) {
				return true;
			}
		}
		if (pPropertyName != null && vChangeListenersByPropertyName.containsKey(null)) {
			Collection vChangeListeners = (Collection) vChangeListenersByPropertyName.get(null);
			if (!vChangeListeners.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public final IChangeListener[] getChangeListeners(final Object pSource, final String pPropertyName) {
		List vResult = null;
		if (_changeListenersByPropertyNameBySource.containsKey(pSource)) {
			Map vChangeListenersByPropertyName = (Map) _changeListenersByPropertyNameBySource.get(pSource);
			if (vChangeListenersByPropertyName.containsKey(pPropertyName)) {
				Collection vChangeListeners = (Collection) vChangeListenersByPropertyName.get(pPropertyName);
				if (!vChangeListeners.isEmpty()) {
					if (vResult == null) {
						vResult = new ArrayList(vChangeListeners);
					} else {
						vResult.addAll(vChangeListeners);
					}
				}
			}
			if (pPropertyName != null && vChangeListenersByPropertyName.containsKey(null)) {
				Collection vChangeListeners = (Collection) vChangeListenersByPropertyName.get(null);
				if (!vChangeListeners.isEmpty()) {
					if (vResult == null) {
						vResult = new ArrayList(vChangeListeners);
					} else {
						vResult.addAll(vChangeListeners);
					}
				}
			}
		}
		return vResult == null ? null : (IChangeListener[]) vResult.toArray(new IChangeListener[vResult.size()]);
	}

	public final void dispatchChange() {
	}

	private static int TYPE_COUNTER = 0;

	public static class AbstractChange {
		private final int _type;

		private final Object _source;

		private final String _propertyName;

		protected AbstractChange(final int pType, final Object pSource, final String pPropertyName) {
			super();
			_type = pType;
			_source = pSource;
			_propertyName = pPropertyName;
		}

		/**
		 * @return the type
		 */
		public final int getType() {
			return _type;
		}

		/**
		 * @return the source
		 */
		public final Object getSource() {
			return _source;
		}

		/**
		 * @return the propertyName
		 */
		public final String getPropertyName() {
			return _propertyName;
		}
	}

	public static final int TYPE_COMPLEX_CHANGE = TYPE_COUNTER++;

	public static class ComplexChange extends AbstractChange {
		/**
		 */
		public ComplexChange(final Object pSource, final String pPropertyName) {
			super(TYPE_COMPLEX_CHANGE, pSource, pPropertyName);
		}
	}

	public static final int TYPE_SINGLE_CHANGE = TYPE_COUNTER++;

	public static class SingleChange extends AbstractChange {
		private final Object _oldValue;

		private final Object _newValue;

		/**
		 * @param pOldValue
		 * @param pNewValue
		 */
		public SingleChange(final Object pSource, final String pPropertyName, final Object pOldValue,
		      final Object pNewValue) {
			super(TYPE_SINGLE_CHANGE, pSource, pPropertyName);
			_oldValue = pOldValue;
			_newValue = pNewValue;
		}

		/**
		 * @return the oldValue
		 */
		public final Object getOldValue() {
			return _oldValue;
		}

		/**
		 * @return the newValue
		 */
		public final Object getNewValue() {
			return _newValue;
		}
	}

	public static final int TYPE_MULTI_ADD_CHANGE = TYPE_COUNTER++;

	public static class MultiAddChange extends AbstractChange {
		private final Object _addedValue;

		/**
		 * @param pAddedValue
		 */
		public MultiAddChange(final Object pSource, final String pPropertyName, final Object pAddedValue) {
			super(TYPE_MULTI_ADD_CHANGE, pSource, pPropertyName);
			_addedValue = pAddedValue;
		}

		/**
		 * @return the addedValue
		 */
		public final Object getAddedValue() {
			return _addedValue;
		}
	}

	public static final int TYPE_MULTI_REMOVE_CHANGE = TYPE_COUNTER++;

	public static class MultiRemoveChange extends AbstractChange {
		private final Object _removedValue;

		/**
		 * @param pRemovedValue
		 */
		public MultiRemoveChange(final Object pSource, final String pPropertyName, final Object pRemovedValue) {
			super(TYPE_MULTI_REMOVE_CHANGE, pSource, pPropertyName);
			_removedValue = pRemovedValue;
		}

		/**
		 * @return the removedValue
		 */
		public final Object getRemovedValue() {
			return _removedValue;
		}
	}

	public static interface IChangeListener {
		void handle(AbstractChange pChange);
	}
}
