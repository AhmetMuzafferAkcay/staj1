public class ReverseALinkedList {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode nextNode = null;

        // Klasik while döngüsü ile düğümlerin yönünü tersine çevir
        while (current != null) {
            nextNode = current.next; // Sonraki düğümü kaydet
            current.next = prev;     // Bağlantıyı bir önceki düğüme ters çevir
            prev = current;          // Prev işaretçisini ilerlet
            current = nextNode;      // Current işaretçisini ilerlet
        }

        // Yeni başlangıç (head) düğümü prev olacaktır
        return prev;
    }

    // Listeyi ekrana yazdırmak için yardımcı metot
    public static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test örneği oluşturma: 1 -> 2 -> 3 -> NULL
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        head.next = new SinglyLinkedListNode(2);
        head.next.next = new SinglyLinkedListNode(3);

        System.out.print("Orijinal Liste: ");
        printLinkedList(head);

        // Listeyi ters çevir
        head = reverse(head);

        System.out.print("Ters Çevrilmiş Liste: ");
        printLinkedList(head);
    }
}
