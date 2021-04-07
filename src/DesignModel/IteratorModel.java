package DesignModel;

// 迭代模式适用于顺序访问集合对象的元素,不需要知道集合对象的底层表示.

// 主要解决:遍历一个聚合对象; 何时使用:遍历一个聚合对象; 如何解决:把在元素之间游走的责任交给迭代器,而不是聚合对象.


interface Iterator{
    public boolean hasNext();
    public Object next();
}

interface Container{
    public Iterator getIterator();
}

class NameRepository implements Container{

    public String[] names = {"hello", "world", "python", "have", "fun"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator{

        private  int index;
        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}


public class IteratorModel {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Iterator iter = nameRepository.getIterator(); iter.hasNext();){
            String name = (String) iter.next();
            System.out.println("name: " + name);
        }
    }
}
