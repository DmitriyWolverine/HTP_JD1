package MyArrayList;

public class MyArrayList<T> {
	//Task: implement your own realization of arrayList
	private int dimension;
	private Object[] array;
	
	public MyArrayList() {
		dimension = 0;
		array = new Object [dimension];
	}
	
	public MyArrayList( T [] array) {
		dimension = array.length;
		this.array = array;
	}
	
	public MyArrayList( MyArrayList<?> arrayList) {
		dimension = arrayList.getDimension();
		array = arrayList.getArray();
	}
	
	public int getDimension () {
		return dimension;
	}
	
	public void setArray(T[] array) {
		this.array = array;
	}
	
	//dangerous place!
	public Object[] getArray() {
		return array;
	}
	
	public MyArrayList<T> add (T newEntity) {
		dimension++;
		Object[] secondArr = new Object [dimension];
		copyPartOfArrayToSecondArrayBeforePos(array, secondArr, 0, array.length );
		secondArr[ (this.dimension - 1) ] = newEntity;
		array = secondArr;
		return this;
	}
	
	public MyArrayList<T> add (T newEntity , int position) {
		if( position >= dimension) {
			System.out.println("MyArrayList has not been changed: Wrong psoition!");
			return this;
		}
		dimension++;
		Object[] secondArr = new Object [dimension];
		copyPartOfArrayToSecondArrayBeforePos(array, secondArr, 0, position );
		secondArr[ position ] = newEntity;
		copyPartOfArrayToSecondArrayAfterPos(array, secondArr, position+1, dimension);
		array = secondArr;
		return this;
	}
	
	public boolean contains (Object entity) {
		if(entity == null) {
			for( int i = 0 ; i < dimension; ++i) {
				if(array[i]==null) {
					return true;
				}
			}
		}
		for( int i = 0 ; i < dimension; ++i) {
			if(array[i].equals(entity)) {
				return true;
			}
		}
		return false;
	}
	
	public int indexOf (Object entity) {
		if(entity == null) {
			for( int i = 0 ; i < dimension; ++i) {
				if(array[i]==null) {
					return i;
				}
			}
		}
		for( int i = 0 ; i < dimension; ++i) {
			if(array[i].equals(entity)) {
				return i;
			}
		}
		return -1;
	}
	
	public int latIndexOf (Object entity) {
		if(entity == null) {
			for( int i = dimension - 1 ; i >=0; --i) {
				if(array[i]==null) {
					return i;
				}
			}
		}
		for( int i = dimension - 1 ; i >=0; --i) {
			if(array[i].equals(entity)) {
				return i;
			}
		}
		return -1;
	}
	
	public T get(int index) {
		if(index<0 || index >= dimension) {
			throw new IndexOutOfBoundsException();
		}
		
		return (T)array[index];
	}
	
	public void set (T entity, int index) {
		if(index<0 || index >= dimension) {
			throw new IndexOutOfBoundsException();
		}
		array[index] = entity;
	}
	
	public MyArrayList<T> removeAll (Object entity){
		int newSize = 0;
		for(int i = 0 ; i < dimension ;  ) {
			if( array[i].equals(entity)){
				i++;
			}
			else {
				i++;
				newSize++;
			}
		}
		Object[] newArray = new Object[newSize];
		int j = 0;
		for(int i = 0 ; i < dimension ;  ) {
			if( array[i].equals(entity))
			{
				i++;
			}
			else {
				newArray[j] = array[i] ;
				i++;
				j++;
			}
		}
		dimension = newSize;
		array = newArray;
		return this;
	}
	
	public boolean isEmpty()
	{
		return dimension == 0;
	
	}
	
	public T remove (int index) {
		Object[] current = new Object[dimension -1];
		T elementToRemove = this.get(index);
		if(!this.contains(elementToRemove)) {
			return null;
		}
		copyPartOfArrayToSecondArrayBeforePos(array,current,0,index);
		copyPartOfArrayToSecondArrayAfterPos(array,current, index, current.length);
		array = current;
		dimension--;
		return elementToRemove;
	}
	
	public void clear() {
		for(int i = 0 ; i < dimension; ++i) {
			array[i] = null;
		}
	}
		
	private void copyPartOfArrayToSecondArrayBeforePos(Object [] firstArr, Object[] secondArr, int startInd, int secondInd) {
		if( (startInd >= secondInd ) || ( startInd < 0 ) || (secondInd < 0) ) {
			return ;
		}
		
		for( int i = startInd ; i < secondInd ; i++) {
			secondArr[i] = firstArr[i];
		}
	}
	
	private void copyPartOfArrayToSecondArrayAfterPos(Object [] firstArr, Object[] secondArr, int startInd, int secondInd) {
		if( (startInd >= secondInd ) || ( startInd < 0 ) || (secondInd < 0) ) {
			return ;
		}
		if( firstArr.length < secondArr.length) {
			for( int i = startInd ; i < secondInd ; i++) {
				secondArr[i] = firstArr[i-1];
			}
		}
		if( firstArr.length > secondArr.length) {
			for( int i = startInd ; i < secondInd  ; i++) {
				secondArr[i] = firstArr[i+1];
			}
		}
	}
	
	public void printArray() {
		for( int i = 0 ; i < dimension ; ++i) {
			System.out.println(array[i]);
		}
	}
}
