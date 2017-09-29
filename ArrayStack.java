
public class ArrayStack implements Stack {
	
	private Object[] arr = new Object[10];
	private int top = 0;
	
	@Override
	public void push(Object item) {
		// TODO Auto-generated method stub
		if(top == arr.length) {
			grow_stack();
			
		}
		arr[top++] = item;
	}

	private void grow_stack() {
		// TODO Auto-generated method stub
		Object[] new_arr = new Object[arr.length*2];
//		new_arr = Arrays.copyOfRange(arr, 0, arr.length);
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr;
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if( empty() ){
			return null;
		}
		return arr[--top];
	} //delete the top item in the array

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if( empty() ){
			return null;
		}
		return arr[top-1];
	}  // return the top item in the array

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return top == 0;
		
		
	} //check if it is an empty array

}
