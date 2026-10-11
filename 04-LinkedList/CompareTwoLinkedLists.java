public class CompareTwoLinkedLists {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode current1 = head1;
        SinglyLinkedListNode current2 = head2;

        // İki liste de bitene kadar kontrol et
        while (current1 != null && current2 != null) {
            // Eğer düğüm verileri farklıysa listeler eşit değildir
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        // Eğer döngü bittiğinde her iki liste de tamamen bittiyse (uzunlukları aynıysa) true döner,
        // biri diğerinden önce bittiyse false döner.
        if (current1 == null && current2 == null) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Test örneği oluşturma
        SinglyLinkedListNode l1 = new SinglyLinkedListNode(1);
        l1.next = new SinglyLinkedListNode(2);

        SinglyLinkedListNode l2 = new SinglyLinkedListNode(1);
        l2.next = new SinglyLinkedListNode(2);

        boolean result = compareLists(l1, l2);
        System.out.println(result ? 1 : 0); // HackerRank genellikle eşitsizlik durumunda 0, eşitlikte 1 bekler
    }
}
