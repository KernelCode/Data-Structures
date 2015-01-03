package MyStructure;

public class Stack<YourType>{
	LinkedList<YourType> mystack ;
	
	
	Stack(){
		mystack = new LinkedList<YourType>();
	}
	
	
	//Push data to stack
	void Push(YourType data){
		mystack.addFirst(data);
		
	}
	
	//Pop data from stack
	YourType Pop(){
		return mystack.deleteFirst();
	}
	
	//Pop all data from stack
	/*YourType PopAll(){
		YourType data = null;
		
		return data;
	}*/

}
