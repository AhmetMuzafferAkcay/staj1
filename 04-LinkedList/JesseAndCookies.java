import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class JesseAndCookiesLinkedList {

    // Bağlı liste düğümü (Node) sınıfı
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Küçükten büyüğe sıralı çalışan Linked List yapısı
    static class SortedLinkedList {
        Node head;
        int size;

        public SortedLinkedList() {
            head = null;
            size = 0;
        }

        // Listeye elemanı sıralı bir şekilde ekle (Ascending order)
        public void add(int data) {
            Node newNode = new Node(data);
            
            // Eğer liste boşsa veya yeni eleman baştaki elemandan küçükse başa ekle
            if (head == null || head.data >= data) {
                newNode.next = head;
                head = newNode;
            } else {
                // Uygun konumu bulmak için klasik while döngüsü kullan
                Node current = head;
                while (current.next != null && current.next.data < data) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
            size++;
        }

        // Listenin başındaki en küçük elemanı al ve listeden çıkar (Poll)
        public int poll() {
            if (head == null) {
                return -1;
            }
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }

        // Listenin başındaki en küçük elemana bak (Silmeden - Peek)
        public int peek() {
            if (head == null) {
                return -1;
            }
            return head.data;
        }

        public int size() {
            return size;
        }
    }

    public static int cookies(int k, List<Integer> A) {
        SortedLinkedList list = new SortedLinkedList();

        // Klasik for döngüsü ile çerezleri sıralı bağlı listeye aktar
        for (int i = 0; i < A.size(); i++) {
            list.add(A.get(i));
        }

        int operations = 0;

        // En küçük çerezin tatlılığı k'dan küçük olduğu sürece ve en az 2 çerez varken
        while (list.size() > 1 && list.peek() < k) {
            int leastSweet = list.poll();         // En küçük 1. çerez
            int secondLeastSweet = list.poll();   // En küçük 2. çerez

            int newCookie = leastSweet + (2 * secondLeastSweet);
            
            list.add(newCookie); // Yeni çerezi sıralı bir şekilde listeye geri ekle
            operations++;
        }

        // Eğer döngü bittiğinde en küçük eleman hala k'dan küçükse sonuç -1
        if (list.peek() < k) {
            return -1;
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }

        scanner.close();

        int result = cookies(k, A);
        System.out.println(result);
    }
}
