import java.util.Collection;
import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.LSTORE;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import sun.security.ec.ECDHKeyAgreement;

public class MyList<E> implements Collection<E> {

	// can not create a  generic array
	// E []Lst = new E[10];
	E []lst;
    int elementCount;
	
	
	// pass the array through constructor
    public MyList(E[] in, int eCount) {
    	lst = in;
        elementCount = eCount;
	}
	@Override
	public boolean add(E arg0){
		// TODO Auto-generated method stub
		if (elementCount >= lst.length) {
			System.out.println("List is full!");
			return false;
		}
		lst[elementCount] = arg0;
		elementCount++;
		
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		boolean addAllFlag;
		for (E i:arg0) {
			
			addAllFlag = add(i);
			if(!addAllFlag) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void clear() {
		elementCount = 0;
		
	}

	@Override
	public boolean contains(Object arg0) {
        for (E i:lst){
			
			if (i == arg0) {
				return true;
			}
        }
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
        for (Object i :arg0){
			
			if (! contains(i)) {
				return false;
			}
        }
		return true;
		
	}

	@Override
	public boolean isEmpty() {
		
		return size() == 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		
		int i;
		for (i=0; i < elementCount; i++) {
			if (lst[i] == arg0) {
				break;
			}
			
		}
		
		for (;i<elementCount-1;i++) {
			lst[i] = lst[i+1];
		}
		elementCount--;
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		
		return elementCount;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
