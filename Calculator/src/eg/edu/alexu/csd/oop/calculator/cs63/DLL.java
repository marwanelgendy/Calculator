package eg.edu.alexu.csd.oop.calculator.cs63;

import java.io.Serializable;

public class DLL implements Serializable {

    NodeD head;
    NodeD tail;
    NodeD curr;
    int size = 0;

    public void add(String element) {
        String x = element;
        if (tail == null && head == null) {
            NodeD i = new NodeD();
            i.value = x;
            i.next = null;
            i.previous = null;
            head = i;
            tail = i;
            curr = i;
            size++;
            return;
        }
        if(size<5)
        {
            NodeD i = new NodeD();
            i.value = x;
            i.previous = tail;
            i.next = null;
            tail.next = i;
            tail = i;
            curr = i;
            size++;
        }
        else
        {
            NodeD i = new NodeD();
            i.value = x;
            i.previous = tail;
            i.next = null;
            tail.next = i;
            tail = i;
            curr = i;
            head = head.getNext();
            head.setPrevious(null);
        }

    }



    class NodeD implements Serializable {
        String value;
        NodeD next;
        NodeD previous;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public NodeD getNext() {
            return next;
        }

        public void setNext(NodeD next) {
            this.next = next;
        }

        public NodeD getPrevious() {
            return previous;
        }

        public void setPrevious(NodeD previous) {
            this.previous = previous;
        }
    }
}
