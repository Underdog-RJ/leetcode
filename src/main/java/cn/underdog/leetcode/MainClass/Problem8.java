package cn.underdog.leetcode.MainClass;

import cn.underdog.leetcode.entity.Node;

public class Problem8 {

    public static void main(String[] args) {

        /*Node head = new Node();
        head.val = 1;



        Node node2=new Node();
        node2.val =2;
        head.next=node2;
        node2.prev=head;

        Node node3=new Node();
        node3.val =3;
        head.child=node3;

        Node node4=new Node();
        node4.val =4;
        node3.next=node4;
        node4.prev=node3;

        Node node5=new Node();
        node5.val =5;
        node3.child=node5;*/
    /*    Node head = new Node();
        head.val = 1;



        Node node2=new Node();
        node2.val =2;
        head.next=node2;
        node2.prev=head;

        node2.next=null;

        Node node3=new Node();
        node3.val =3;
        node2.next=node3;
        node3.prev=node2;

        Node node4=new Node();
        node4.val =4;
        node3.next=node4;
        node4.prev=node3;

        Node node5=new Node();
        node5.val =5;
        node4.next=node5;
        node5.prev=node4;

        Node node6=new Node();
        node6.val =6;
        node5.next=node6;
        node6.prev=node5;

        Node node7=new Node();
        node7.val =7;
        node3.child=node7;

        Node node8=new Node();
        node8.val = 8;
        node7.next=node8;
        node8.prev=node7;


        Node node9=new Node();
        node9.val =9;
        node8.next=node9;
        node9.prev=node8;

        Node node10=new Node();
        node10.val = 10;
        node9.next=node10;
        node10.prev=node9;

        Node node11=new Node();
        node11.val =11;
        node8.child=node11;
        Node node12=new Node();
        node12.val =12;
        node11.next=node12;
        node12.prev=node11;*/

        Node head= new Node();
        head.val=1;
        Node node2= new Node();
        node2.val=2;
        head.child=node2;
        Node node3= new Node();
        node3.val=3;
        node2.child=node3;
        Node node4= new Node();
        node4.val=4;
        node2.next=node4;
        node4.prev=node2;
        Node node5= new Node();
        node5.val=5;
        node3.child=node5;
        head=flatten(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

    public static Node flatten(Node head) {
        if(head==null) return null;
        Node next=head.next;
        Node current=head;
        while (current!=null){
            // 如果当前有儿子的话，把next挂到儿子的最后面
            if(current.child!=null){
                Node child=current.child;
                Node childTail=child;
                // 如果next==null 表示最后一个
                if(next==null){
                    current.child=null;
                    current.next=child;
                    child.prev=current;
                    current=child;
                    next=current.next;
                }else {
                    current.child=null;
                    // 求当前子节点的尾节点
                    while (childTail.next!=null){
                        childTail=childTail.next;
                    }
                    // 将next拼接到当前子节点最后边
                    childTail.next=next;
                    next.prev=childTail;
                    // 将当前节点的next置为child;
                    current.next=child;
                    child.prev=current;
                    current=child;
                    next=current.next;
                }
            }else {
                current=current.next;
                if(current!=null){
                    next=current.next;
                }
            }
        }
        return head;
    }


}
