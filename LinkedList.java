package MyStructure;
/*
 * Author : Abdullah Altahery 
 * Email  : AbdullahAltahery@Gmail.com
 * Website: www.KernelC0de.com
 * */
public class LinkedList<YourType>{
	class node{
		node next;
		YourType data;
	};
	public node head;
	public node tail;
	public int count;
	
	
	/* create instance head of the list */
	LinkedList(){
		head = new node();
		head.next=null;
		tail=head;count=0;
	};
	
	
	/* add to the end of the list */
	void add(YourType data){
		
		if(head.data==null){
			head.data=data;
			return;
		}
		
		///
		node temp = new node();
		temp.data=data;
		temp.next=null;
		///
		
		tail.next=temp;
		tail=temp;
		if(head.next==null){
			head.next=tail;
		}

		count++;
	}
	
	
	/* add to the head of the list */
	void addFirst(YourType data){
		node temp = new node();
		temp.data=data;
		if(head.data==null){
			head.data=data;
			return;
		}
		temp.next=head;
		head=temp;
		count++;
	}
	
	/* Get data by Index */
	YourType getAt(int index){
		if( index > count )
			return null;
		
		node temp=head;
		int i=0;
		while(temp.next!=null && i<index){
			temp=temp.next;
			i++;
		}
		
		return temp.data;
	}
	
	/* Set data by Index */
	void setAt(int index,YourType data){
		if( index > count )
			return ;
		
		node temp=head;
		int i=0;
		while(temp.next!=null && i<index){
			temp=temp.next;
			i++;
		}
		
		temp.data=data;
		
		
	}
	
	/* Delete node by data  */
	boolean delete(YourType data){
		node temp=head;
		node lastnode=null;
		while( temp.next != null ){
			if(temp.data == data){
				lastnode.next=temp.next;
				temp.next=null;
				temp=null;
				count--;
				return true;
			}
			
			lastnode=temp;
			temp=temp.next;
		}
		return false;
	}
	
	/* Delete last node  */
	YourType deleteLast(){
		node temp=head;
		YourType data;
		if(head.next==null){
			head.data=null;
			tail=head;
			return head.data;
		}
		while( temp.next != null ){
			if(temp.next.next==null)
				break;
			temp=temp.next;
		}
		data=temp.data;
		temp.next=null;
		count--;
		tail=temp;
		return data;
		

	}
	
	/* Delete first node  */
	YourType deleteFirst(){
		YourType data=null;
		if(head.next!=null){
			data=head.data;
			count--;
			head=head.next;
		}
		
		return data;
		

	}
	
	/* search for data by data  */
	YourType search(YourType data){
		node temp=head;
		
		while( temp.next != null ){
			if(temp.data == data){
				return data;
				
			}
			temp=temp.next;
		}
		return null;
	}
	
	/* print all data   */
	void printall(){
		node temp=head;
		
		while( temp.next != null ){
			System.out.print(temp.data+" ,");
			temp=temp.next;
		}
		System.out.print(temp.data+" ,");
		System.out.print("\n");
		
	}

}
