package com.Lantz2024.Krahets2023;

/**
 * <p>Project: Algorithm20230913 - Pra01
 * <p>Powered by Lantz On 2024-01-10 10:19:54
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra01
 * @since 1.8
 */
public class Pra01 {

}
class Solution01 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}