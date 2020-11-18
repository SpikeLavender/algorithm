//package com.natsumes.linearlist;
//
//
//import java.util.*;
//import java.util.function.Consumer;
//import java.util.function.Predicate;
//import java.util.function.UnaryOperator;
//
///**
// * @author hetengjiao
// */
//public class ArrayDemo<E> implements List<E>{
//
//    private static final int DEFAULT_CAPACITY = 10;
//
//    private static final Object[] EMPTY_ELEMENTDATA = {};
//
//    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
//
//    transient Object[] elementData;
//
//    private int size;
//
//    protected transient int modCount = 0;
//
//    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
//
//    public ArrayDemo(int initialCapacity) {
//        if (initialCapacity > 0) {
//            this.elementData = new Object[initialCapacity];
//        } else if(initialCapacity == 0) {
//            this.elementData = EMPTY_ELEMENTDATA;
//        } else {
//            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
//        }
//    }
//
//    public ArrayDemo() {
//        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
//    }
//
//    public ArrayDemo(Collection<? extends E> c) {
//        elementData = c.toArray();
//        if ((size = elementData.length) != 0) {
//            if (elementData.getClass() != Object[].class) {
//                elementData = Arrays.copyOf(elementData, size, Object[].class);
//            }
//        } else {
//            this.elementData = EMPTY_ELEMENTDATA;
//        }
//    }
//
//    public void trimToSize() {
//        modCount++;
//        if (size < elementData.length) {
//            elementData = (size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyOf(elementData, size);
//        }
//    }
//
//    public void ensureCapacity(int minCapacity) {
//        boolean isDefault = (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) && (minCapacity <= DEFAULT_CAPACITY);
//        if (minCapacity > elementData.length && !isDefault) {
//            modCount++;
//            grow(minCapacity);
//        }
//    }
//
//    private Object[] grow(int minCapacity) {
//        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
//    }
//
//    private Object[] grow() {
//        return grow(size + 1);
//    }
//
//    private int newCapacity(int minCapacity) {
//        int oldCapacity = elementData.length;
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        if (newCapacity - minCapacity <= 0) {
//            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
//                return Math.max(DEFAULT_CAPACITY, minCapacity);
//            }
//            if (minCapacity < 0) {
//                throw new OutOfMemoryError();
//            }
//            return minCapacity;
//        }
//        return (newCapacity - MAX_ARRAY_SIZE <= 0) ? newCapacity : hugeCapacity(minCapacity);
//    }
//
//    private static int hugeCapacity(int minCapacity) {
//        if (minCapacity < 0) {
//            throw new OutOfMemoryError();
//        }
//        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//       return size == 0;
//    }
//
//    @Override
//    public boolean contains(Object o) {
//        return indexOf(o) >= 0;
//    }
//
//    @Override
//    public int indexOf(Object o) {
//        return indexOfRange(o, 0, size);
//    }
//
//    private int indexOfRange(Object o, int start, int end) {
//        Object[] es = elementData;
//        if (o == null) {
//            for (int i = start; i < end; i++) {
//                if (es[i] == null) {
//                    return i;
//                }
//            }
//        } else {
//            for (int i = start; i < end; i++) {
//                if (o.equals(es[i])) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    @Override
//    public int lastIndexOf(Object o) {
//        return lastIndexOfRange(o, 0, size);
//    }
//
//    private int lastIndexOfRange(Object o, int start, int end) {
//        Object[] es = elementData;
//        if (o == null) {
//            for (int i = end - 1; i >= start; i--) {
//                if (es[i] == null) {
//                    return i;
//                }
//            }
//        } else {
//            for (int i = end - 1; i >= start; i--) {
//                if (o.equals(es[i])) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    @Override
//    public Object clone() {
//        try {
//            ArrayDemo<?> v = (ArrayDemo<?>) super.clone();
//            v.elementData = Arrays.copyOf(elementData, size);
//            v.modCount = 0;
//            return v;
//        } catch (CloneNotSupportedException e) {
//            throw new InternalError();
//        }
//    }
//
//    @Override
//    public Object[] toArray() {
//        return Arrays.copyOf(elementData, size);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public <T> T[] toArray(T[] a) {
//        if (a.length < size) {
//            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
//        }
//        System.arraycopy(elementData, 0, a, 0, size);
//        if (a.length > size) {
//            a[size] = null;
//        }
//        return a;
//    }
//
//    @SuppressWarnings("unchecked")
//    E elementData(int index) {
//        return (E) elementData[index];
//    }
//
//    @SuppressWarnings("unchecked")
//    static <E> E elementAt(Object[] es, int index) {
//        return (E) es[index];
//    }
//
//    @Override
//    public E get(int index) {
//        Objects.checkIndex(index, size);
//        return elementData(index);
//    }
//
//    @Override
//    public E set(int index, E element) {
//        Objects.checkIndex(index, size);
//        E oldValue = elementData(index);
//        elementData[index] = element;
//        return oldValue;
//    }
//
//    private void add(E e, Object[] elementData, int s) {
//        if (s == elementData.length) {
//            elementData = grow();
//        }
//        elementData[s] = e;
//        size = s + 1;
//    }
//
//    @Override
//    public boolean add(E e) {
//        modCount++;
//        add(e, elementData, size);
//        return true;
//    }
//
//    @Override
//    public void add(int index, E element) {
//        rangeCheckForAdd(index);
//        modCount++;
//        final int s;
//        Object[] elementData;
//        if ((s = size) == (elementData = this.elementData).length) {
//            elementData = grow();
//        }
//        System.arraycopy(elementData, index, elementData, index + 1, s - index);
//        elementData[index] = element;
//        size = s + 1;
//    }
//
//    private void rangeCheckForAdd(int index) {
//        if (index > size || index < 0) {
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//        }
//    }
//
//    private String outOfBoundsMsg(int index) {
//        return "Index: " + index + ", Size: " + size;
//    }
//
//    private static String outOfBoundsMsg(int fromIndex, int toIndex) {
//        return "From Index: " + fromIndex + " > To Index: " + toIndex;
//    }
//
//    @Override
//    public E remove(int index) {
//        Objects.checkIndex(index, size);
//        final Object[] es = elementData;
//
//        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
//        fastRemove(es, index);
//
//        return oldValue;
//    }
//
//    private void fastRemove(Object[] es, int i) {
//        modCount++;
//        final int newSize;
//        if ((newSize = size - 1) > i) {
//            System.arraycopy(es, i + 1, es, i, newSize - i);
//        }
//        es[size = newSize] = null;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        }
//        if (!(o instanceof List)) {
//            return false;
//        }
////        final int expectedModCount = modCount;
////        boolean equal = (o.getClass() == ArrayList.class)
////                ? equalsArrayList((ArrayList<?>) o)
////                : equalsRange((List<?>) o, 0, size);
////
////        checkForComodification(expectedModCount);
////        return equal;
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int expectedModCount = modCount;
//        int hash = hashCodeRange(0, size);
//        checkForComodification(expectedModCount);
//        return hash;
//    }
//
//    private void checkForComodification(final int expectedModCount) {
//        if (modCount != expectedModCount) {
//            throw new ConcurrentModificationException();
//        }
//    }
//
//    int hashCodeRange(int from, int to) {
//        final Object[] es = elementData;
//        if (to > es.length) {
//            throw new ConcurrentModificationException();
//        }
//        int hashCode = 1;
//        for (int i = from; i < to; i++) {
//            Object e = es[i];
//            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
//        }
//        return hashCode;
//    }
//
//    @Override
//    public boolean remove(Object o) {
//        final Object[] es = elementData;
//        final int size = this.size;
//        int i = 0;
//        found: {
//            if (o == null) {
//                for (; i < size; i++) {
//                    if (es[i] == null) {
//                        break found;
//                    }
//                }
//            } else {
//                for (; i < size; i++) {
//                    if (o.equals(es[i])) {
//                        break found;
//                    }
//                }
//            }
//            return false;
//        }
//        fastRemove(es, i);
//        return true;
//    }
//
//    @Override
//    public boolean containsAll(Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public void clear() {
//
//    }
//
//    @Override
//    public boolean addAll(Collection c) {
//        return true;
//    }
//
//    @Override
//    public boolean addAll(int index, Collection c) {
//        return true;
//    }
//
//    protected void removeRange(int fromIndex, int toIndex) {
//
//    }
//
//    @Override
//    public boolean removeAll(Collection c) {
//        return true;
//    }
//
//    @Override
//    public boolean retainAll(Collection c) {
//        return true;
//    }
//
//    @Override
//    public ListIterator listIterator(int index) {
//
//    }
//
//    @Override
//    public ListIterator listIterator() {
//
//    }
//
//    @Override
//    public Iterator iterator() {
//
//    }
//
//    @Override
//    public List subList(int fromIndex, int toIndex) {
//
//    }
//
//    @Override
//    public void forEach(Consumer action) {
//
//    }
//
//    @Override
//    public Spliterator spliterator() {
//
//    }
//
//    @Override
//    public boolean removeIf(Predicate filter) {
//
//    }
//
//    @Override
//    public void replaceAll(UnaryOperator operator) {
//
//    }
//
//    @Override
//    public void sort(Comparator c) {
//
//    }
//}
