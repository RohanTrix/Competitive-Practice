/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;

 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Add_Two_Polynomials_Represented_as_Linked_Lists.java {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode gen = new PolyNode();
        PolyNode prev = gen;
        while(poly1!=null && poly2!=null) {
            if(poly1.power > poly2.power) {
                prev.next = poly1;
                poly1 = poly1.next;
            }
            else if(poly2.power > poly1.power) {
                prev.next = poly2;
                poly2 = poly2.next;
            }
            else {
                int sum = poly1.coefficient + poly2.coefficient;
                if(sum == 0) {
                    poly1 = poly1.next;
                    poly2 = poly2.next;
                    continue;
                }
                prev.next = new PolyNode(sum, poly1.power);
                poly1 = poly1.next;
                poly2 = poly2.next;

            }
            prev = prev.next;
        }
        if(poly1 == null)
            prev.next = poly2;
        if(poly2 == null)
            prev.next = poly1;
        return gen.next;
    }
}