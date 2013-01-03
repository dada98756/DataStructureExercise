package stack;

public class ArrayStack {
	int[] data;
	int size;
	int curr;
	
	public ArrayStack(){
		data = new int[50];
		size = 50;
		curr = -1;
	}
	public ArrayStack(int s){
		data = new int[s];
		size = s;
		curr = -1;
	}
	
	public void push(int d){
		if (curr + 1 >= size){
			resize();
		}
		data[curr+1] = d;
		curr++;
	}
	
	public int pop(){
		if (curr == -1){
			return -1;
		}
		int temp = data[curr];
		curr--;
		return temp;
	}
	
	public void resize(){
		size = 2*size;
		int[] newData = new int[size];
		System.arraycopy(data, 0, newData, 0, size/2);
		data=newData;
	}
}
