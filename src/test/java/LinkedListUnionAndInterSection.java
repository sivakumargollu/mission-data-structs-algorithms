import com.ds.practice.list.Node;
import com.ds.practice.list.single_linked_list.LinkedList;
import com.ds.practice.list.single_linked_list.UnionAndIntersection;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListUnionAndInterSection {

	UnionAndIntersection unionAndIntersection = new UnionAndIntersection();

	@Test
	public void intersectionTest() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] { 41, 35, 56, 2, 47, 1}).build();
		LinkedList linkedList2 = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10, 35, 4, 56, 2, 47, 1}).build();
		Node n = unionAndIntersection.getIntersection(linkedList.getHead(), linkedList2.getHead());
		linkedList.printList(n);
		Assert.assertNotNull(n);
	}

	@Test
	public void shouldReturnIfNoIntersectinElements() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {41}).build();
		LinkedList linkedList2 = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10}).build();
		Node n = unionAndIntersection.getIntersection(linkedList.getHead(), linkedList2.getHead());
		linkedList.printList(n);
		Assert.assertNull(n);
	}

	@Test
	public void shouldReturnTwoElementInUnion() {
		LinkedList linkedList = new LinkedList.ArrayLinkedListBuilder().add(new int[] {41}).build();
		LinkedList linkedList2 = new LinkedList.ArrayLinkedListBuilder().add(new int[] {10}).build();
		Node n = unionAndIntersection.getUnion(linkedList.getHead(), linkedList2.getHead());
		linkedList.printList(n);
		Assert.assertNotNull(n);
	}
}
