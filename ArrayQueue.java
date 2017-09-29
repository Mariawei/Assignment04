
public class ArrayQueue implements Queue {
	
	private Object[] arr = new Object[10];
	private int head = 0;
	private int tail = 0;
	
	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if( empty() ){
			return null;
		}
		if(head == arr.length){
			head = 0;
		}
		return arr[head++];
		
	} //remove item from head

	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if( full() ){
			grow_queue();
		}
		arr[tail] = item;
		tail++;
		if(tail == arr.length){
			tail = 0;
		}
	} // add item to tail

	private void grow_queue() {
		// TODO Auto-generated method stub
		Object[] new_arr = new Object[arr.length*2];
//		System.arraycopy(arr, srcPos, dest, destPos, length);
		if(tail < head){
			System.arraycopy(arr, head, new_arr, 0, arr.length-head);
			System.arraycopy(arr, 0, new_arr, arr.length-head, tail);
			tail = (arr.length-head) + tail;
			head = 0;			
			arr = new_arr;
			return;
		}
//		new_arr = Arrays.copyOfRange(arr, head, new_arr.length);
		System.arraycopy(arr, 0, new_arr, 0, tail);
		arr = new_arr;

	}

	private boolean full() {
		// TODO Auto-generated method stub
		if( ((tail+1) % arr.length) == head){
			return true;
		}
		return false;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if(head == tail){
			return true;
		}
		return false;
	}

}
