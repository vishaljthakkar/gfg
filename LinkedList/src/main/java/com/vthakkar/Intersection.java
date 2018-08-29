package com.vthakkar;

public class Intersection {

    class Result {
        LinkedListNode tail;
        int size;

        public Result(LinkedListNode tail, int size) {
            this.size = size;
            this.tail = tail;
        }
    }

    public LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null)
            return null;
        /* Get tail and size */
        Result res1 = getTailSize(list1);
        Result res2 = getTailSize(list2);

        if (res1.tail != res2.tail)
            return null;

        LinkedListNode shorter = res1.size < res2.size ? list1 : list2;
        LinkedListNode longer = res1.size < res2.size ? list2 : list1;

        longer = getKthNode(longer, Math.abs(res1.size - res2.size));
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }

    private Result getTailSize(LinkedListNode list) {
        if (list == null) {
            return null;
        }
        int size = 1;
        LinkedListNode current = list;
        while(current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    private LinkedListNode getKthNode(LinkedListNode head, int count) {
        LinkedListNode current = head;
        while(count > 0 && current != null) {
            current = current.next;
            count--;
        }
        return current;
    }
}
