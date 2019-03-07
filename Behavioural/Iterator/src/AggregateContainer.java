import java.util.ArrayList;
import java.util.List;

//Aggregate interface: following the program-to-interface programming model, the client should
//adoperate this interface to instantiate a MyContainer object. It defines the method "iterator"
//that will eventually return an iterator of that class.
public interface AggregateContainer<T> {
    AbstractIterator iterator();
}

//Interface of the iterator, it defines all the method that an iterator should implement.
interface AbstractIterator {
    Object next();
    Object first();
    Object cur();
    Boolean hasNext();
}

//Actual container class: the one who could be instantiated
class MyContainer<T> implements AggregateContainer {
    //Private list incapsulated into the container
    private List<T> container = new ArrayList<>();


    public void add(T elem) {
        this.container.add(elem);
    }

    //Iterator class nested inside MyContainer
    private class Iterator implements AbstractIterator {
        private int cur_position = -1;

        @Override
        public T next() {
            T elem = null;

            if (this.hasNext()) {
                elem = container.get(cur_position+1);
                cur_position++;
            }

            return elem;
        }

        @Override
        public T first() {
            T elem = null;

            if(container.size() != 0) {
                elem = container.get(0);
            }

            return elem;
        }

        @Override
        public T cur() {
            T elem = null;

            if(container.size() != 0) {
                elem = container.get(cur_position);
            }

            return elem;
        }

        @Override
        public Boolean hasNext() {
            if(cur_position+1 < container.size()) {
                return true;
            } else {
                return false;
            }
        }

        public void reset() {
            cur_position = 0;
        }
    }



    @Override
    public AbstractIterator iterator() {
        return new Iterator();
    }
}


