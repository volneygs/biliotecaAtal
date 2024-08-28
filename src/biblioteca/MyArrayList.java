package biblioteca;

import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] elements;
    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    
    /*retona tamanho da lista*/
    public int size() {
        return size;
    }

    /*retorna verdadeiro se a lista estiver vazia e falso caso contrário*/
    public boolean isEmpty() {
        return size == 0;
    }

    /*pesquisa por elemento na lista e retorna verdade caso ela exista*/
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /*adiciona elemento na lista*/
    public boolean add(E e) {
        increaseCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    /*retorna elemento na lista pesquisando pelo elemento*/
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }
    
    /*limpa a lista (adiciona o valor null em todas as posições)*/
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /*retorna um elemento da lista pesquisando pelo indice*/
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    /*adiciona um elemento na lista no indice passado como parametro*/
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        increaseCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /*remove elemento da lista removendo pelo indice*/
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Clear to let GC do its work
        return oldValue;
    }

    /*retorna o indice do objetivo pesquisado (retorna -1 caso o elemento não exista na lista)*/
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /*aumenta capacidade do array (dobra)*/
    private void increaseCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(DEFAULT_CAPACITY, elements.length * 2);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}
