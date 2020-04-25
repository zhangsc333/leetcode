import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class TestInsertSortLink {

    private InsertSortLink.ListNode head;
    private String result;
    private boolean expect;

    public TestInsertSortLink(InsertSortLink.ListNode head, String result, boolean expect) {
        this.head = head;
        this.result = result;
        this.expect = expect;
    }

    public static InsertSortLink.ListNode initListNode(int... vals){
        int i = 0;
        List<InsertSortLink.ListNode> listNodes = new ArrayList<InsertSortLink.ListNode>();
        for(int val : vals){
            InsertSortLink.ListNode listNode = new InsertSortLink.ListNode(val);
            listNodes.add(listNode);
            i++;
        }
        for(int index = 0;index < i-1;index++){
            listNodes.get(index).next = listNodes.get(index + 1);
        }
        return listNodes.get(0);
    }

    private String convert(InsertSortLink.ListNode head){
        StringBuffer sb = new StringBuffer();
        while (head != null){
            sb.append(String.valueOf(head.val));
            head = head.next;
        }
        return sb.toString();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {initListNode(5,4,3,1,2),"12345",true},
                {initListNode(3,7,6,8,2,0),"023678",true},
                {initListNode(1,1),"11",true}
        });
    }

    @Test
    public void test(){
        Assert.assertThat(convert(InsertSortLink.insertionSortList(head)).equals(result), Is.is(expect));
    }
}
