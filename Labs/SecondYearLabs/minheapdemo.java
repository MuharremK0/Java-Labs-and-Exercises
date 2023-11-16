package DataLabs;


public class minheapdemo {

	public static void main(String[] args) {
		MinHeap mh=new MinHeap(10);
		mh.insert(7);
		mh.insert(22);
		mh.insert(9);
		mh.insert(6);
		mh.insert(1);
		mh.insert(33);
		mh.insert(15);
		mh.insert(-1);
		mh.extractMin();
		mh.extractMin();
		
		mh.print();
		
		

	}

}

class MinHeap {
	private int size;
	private int[] heap;

	public MinHeap(int capacity) {
		size = 0;
		this.heap=new int[capacity+1];
		this.heap[0]=Integer.MIN_VALUE;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int peek() {
		return heap[1];
	}
	
	private void swap(int index1,int index2) {
		int temp=heap[index1];
		heap[index1]=heap[index2];
		heap[index2]=temp;
	}
	
	private void siftUp(int index) {
		int parent=index/2;
		if(heap[index] < heap[parent]) {
			swap(index,parent);
			siftUp(parent);
		}
	}
	
	private void siftDown(int index) {
		int child = index *2;
		if(child > size)
			return;
		if(child+1<=size && heap[child+1] < heap[child])
			child++;
		if(heap[child]<heap[index]) {
			swap(child,index);
			siftDown(child);
		}
	}
	
	public void insert(int data) {
		heap[++size]=data;
		siftUp(size);
	}
	
	public int extractMin() {
		int min=heap[1];
		heap[1]=heap[size--];
		siftDown(1);
		return min;
	}
	
	public int get(int index) {
		return heap[index];
	}
	
	public void print() {
		int condition=1;
		int condition2=1;
		for(int i=1;i<=size;i++) {
			System.out.print(heap[i]+" ");
			if(i==condition2) {
				condition*=2;
				condition2+=condition;
				System.out.println();
			}	
		}
	}

}
