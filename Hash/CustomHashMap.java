//import java.util.*;
public class CustomHashMap {
     class Node{
        String key;
        int value;
        Node next;

        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
     }
    private int capacity = 10;
    private int size = 0;
    private Node[] buckets;

    public CustomHashMap(){
        buckets = new Node[capacity];
    }

    private int getBucketIndex(String key){
        return Math.abs(key.hashCode())% capacity;
    }

    public void put(String key, int value){
        int index = getBucketIndex(key);
        Node head = buckets[index];

        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;

        if((1.0*size) / capacity >= 0.75){
            rehash();
        }
    }
    public Integer get(String key){
        int index = getBucketIndex(key);
        Node head = buckets[index];

        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void remove(String key){
        int index = getBucketIndex(key);
        Node head = buckets[index];
        Node prev = null;

        while(head != null){
            if(head.key.equals(key)){
                if(prev != null){
                    prev.next = head.next;
                }else{
                    buckets[index] = head.next;
                }
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }
    }
    private void rehash(){
        Node[] oldBuckets = buckets;
        capacity = capacity * 2;
        buckets = new Node[capacity];
        size = 0;

        for(Node head : oldBuckets){
            while(head != null){
                put(head.key, head.value);
                head = head.next;
            }
        }
    }
    public void display(){
        for(int i=0; i<capacity; i++){
            System.out.println("Bucket "+ i+ ": ");
            Node head = buckets[i];
            while(head != null){
                System.out.print("[" + head.key + " -> " + head.value + "] ");
                head = head.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);
        map.put("Apple", 40);

        System.out.println("Value for 'Apple': " + map.get("Apple"));
        System.out.println("Value for 'Banana': " + map.get("Banana"));

        map.remove("Banana");
        System.out.println("After removing 'Banana': " + map.get("Banana"));

        System.out.println("Hash Map Contents");
        map.display();
    }
}
