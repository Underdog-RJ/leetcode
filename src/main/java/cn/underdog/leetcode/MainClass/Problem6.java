package cn.underdog.leetcode.MainClass;


/**
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 *
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 *
 * 返回一个由上述 k 部分组成的数组。
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * 示例 2：
 *
 *输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * 解释：
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *

 */
public class Problem6 {
    public static void main(String[] args) {

        //ListNode head= new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,new ListNode(7,new ListNode(8,new ListNode(9,new ListNode(10))))))))));
        ListNode head= new ListNode(1,new ListNode(2,new ListNode(3)));

        ListNode[] listNodes = splitListToParts(head, 3);
        System.out.println(listNodes);
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        int length=0;
        int ys=0;
        int splitT=0;
        ListNode headT=head;
        while (head!=null){
            length++;
            head=head.next;
        }
        int splitTT=0;
        splitT=length/k;
        splitTT=splitT;
        ys=length%k;
        ListNode[] result=new ListNode[k];
        int tempYs=0;  //  如果有余数的话，每次加一，直到等于余数
        for (int i = 0; i < k; i++) {
            ListNode node=new ListNode();
            ListNode node1=node;
            splitT=splitTT;
            if(ys!=0&&tempYs!=ys){
                splitT+=1;
                tempYs++;
            }
            /**
             * 分段头插法，
             */
            for (int j = 0; j < splitT&&headT!=null; j++) {
                ListNode temp=new ListNode(headT.val);
                node1.next=temp;
                node1=temp;
                headT=headT.next;
            }
            node=node.next;
            result[i]=node;
        }
        return result;
    }


}



