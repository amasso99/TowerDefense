package Model.DataStructure;

/**
 * Created by 204g04 on 07.11.2016.
 */
public class Stack<ContentType> {

    private StackNode head;

    /* ---------------------- Anfang der inneren Klasse ----------------------*/
    private class StackNode{
        private StackNode nextNode;
        private ContentType content;

        public StackNode(ContentType content){
            this.content = content;
        }

        private void setNext(StackNode next){
            this.nextNode = next;
        }

        private StackNode getNext(){
            return nextNode;
        }

        private ContentType getContent(){
            return content;
        }
    }
    /* ---------------------- Ende der inneren Klasse ----------------------*/

    public Stack(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void push(ContentType newContent){
        StackNode newNode = new StackNode(newContent);
        if (!isEmpty()){
            newNode.setNext(head);
        }
        head = newNode;
    }

    public void pop(){
        if (!isEmpty()){
            head = head.getNext();
        }
    }

    public ContentType top(){
        if (!isEmpty()){
            return head.getContent();
        }
        return null;
    }
}
