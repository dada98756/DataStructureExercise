package queue;

public class ArrayQueue {
	int[] data;
	int head;
	int tail;
	int size;
	
	public ArrayQueue(){
		data = new int[50];
		head = -1;
		tail = 0;
		size = 50;
	}
	public ArrayQueue(int size){
		data = new int[size];
		head = -1;
		tail = 0;
		this.size = size;
	}
	public void offer(int value){
		if (tail == head){
			resize();
		}
		data[tail] = value;
		tail = (tail+1)%size;
		if (head == -1){
			head = 0;
		}
	}
	
	public int poll(){
		if (tail == head){
			return -1;
		}
		if (head == -1){
			return -1;
		}
		int temp = data[head];
		head = (head+1)%size;
		return temp;
	}
	public void resize(){
		int[] newData = new int[2*size];
		for (int i = head;i<data.length;i++){
			newData[i-head] = data[i];
		}
		for (int i = 0;i<tail;i++){
			newData[data.length-head+i]=data[i];
		}
		head = 0;
		tail = data.length;
		data = newData;
		size = 2*size;
	}
}
