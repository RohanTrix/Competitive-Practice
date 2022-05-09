//Simple recursion to build the full flattened list
public class Flatten_Nested_List_Iterator
{
    List<Integer> list;
    Iterator<Integer> it;
    public void recur(List<NestedInteger> nestedList)
    {
        for(NestedInteger obj : nestedList)
        {
            if(obj.isInteger())
                list.add(obj.getInteger());
            else
                recur(obj.getList());
        }
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        recur(nestedList);
        it = list.iterator();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}