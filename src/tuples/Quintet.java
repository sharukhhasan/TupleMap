package tuples;

import base.Tuple;
import values.Value0;
import values.Value1;
import values.Value2;
import values.Value3;
import values.Value4;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Sharukh Hasan on 9/28/16
 *
 * Five-element Tuple
 */
public final class Quintet<A,B,C,D,E> extends Tuple implements Value0<A>, Value1<B>, Value2<C>, Value3<D>, Value4<E> {
    private static final long serialVersionUID = -1579008485383872628L;
    private static final int SIZE = 5;

    private final A val0;
    private final B val1;
    private final C val2;
    private final D val3;
    private final E val4;

    public static <A,B,C,D,E> Quintet<A,B,C,D,E> with(final A value0, final B value1, final C value2, final D value3, final E value4) {
        return new Quintet<A,B,C,D,E>(value0,value1,value2,value3,value4);
    }


    //Create tuple from array. Array has to have exactly five elements.
    public static <X> Quintet<X,X,X,X,X> fromArray(final X[] array) {
        if(array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if(array.length != 5) {
            throw new IllegalArgumentException("Array must have exactly 5 elements in order to create a Quintet. Size is " + array.length);
        }
        return new Quintet<X,X,X,X,X>(
                array[0],array[1],array[2],array[3],array[4]);
    }


    //Create tuple from collection. Collection has to have exactly five elements.
    public static <X> Quintet<X,X,X,X,X> fromCollection(final Collection<X> collection) {
        return fromIterable(collection);
    }



    //Create tuple from iterable. Iterable has to have exactly five elements.
    public static <X> Quintet<X,X,X,X,X> fromIterable(final Iterable<X> iterable) {
        return fromIterable(iterable, 0, true);
    }



    //Create tuple from iterable, starting from the specified index.
    public static <X> Quintet<X,X,X,X,X> fromIterable(final Iterable<X> iterable, int index) {
        return fromIterable(iterable, index, false);
    }

    private static <X> Quintet<X,X,X,X,X> fromIterable(final Iterable<X> iterable, int index, final boolean exactSize) {
        if(iterable == null) {
            throw new IllegalArgumentException("Iterable cannot be null");
        }

        boolean tooFewElements = false;

        X element0 = null;
        X element1 = null;
        X element2 = null;
        X element3 = null;
        X element4 = null;

        final Iterator<X> iter = iterable.iterator();
        int i = 0;
        while(i < index) {
            if(iter.hasNext()) {
                iter.next();
            } else {
                tooFewElements = true;
            }
            i++;
        }

        if(iter.hasNext()) {
            element0 = iter.next();
        } else {
            tooFewElements = true;
        }

        if(iter.hasNext()) {
            element1 = iter.next();
        } else {
            tooFewElements = true;
        }

        if(iter.hasNext()) {
            element2 = iter.next();
        } else {
            tooFewElements = true;
        }

        if(iter.hasNext()) {
            element3 = iter.next();
        } else {
            tooFewElements = true;
        }

        if(iter.hasNext()) {
            element4 = iter.next();
        } else {
            tooFewElements = true;
        }

        if(tooFewElements && exactSize) {
            throw new IllegalArgumentException("Not enough elements for creating a Quintet (5 needed)");
        }

        if(iter.hasNext() && exactSize) {
            throw new IllegalArgumentException("Iterable must have exactly 5 available elements in order to create a Quintet.");
        }

        return new Quintet<X,X,X,X,X>(element0, element1, element2, element3, element4);

    }

    public Quintet(final A value0, final B value1, final C value2, final D value3, final E value4) {
        super(value0, value1, value2, value3, value4);
        this.val0 = value0;
        this.val1 = value1;
        this.val2 = value2;
        this.val3 = value3;
        this.val4 = value4;
    }

    public A getValue0() {
        return this.val0;
    }

    public B getValue1() {
        return this.val1;
    }

    public C getValue2() {
        return this.val2;
    }

    public D getValue3() {
        return this.val3;
    }

    public E getValue4() {
        return this.val4;
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    public <X> Quintet<X,B,C,D,E> setAt0(final X value) {
        return new Quintet<X,B,C,D,E>(value, this.val1, this.val2, this.val3, this.val4);
    }

    public <X> Quintet<A,X,C,D,E> setAt1(final X value) {
        return new Quintet<A,X,C,D,E>(this.val0, value, this.val2, this.val3, this.val4);
    }

    public <X> Quintet<A,B,X,D,E> setAt2(final X value) {
        return new Quintet<A,B,X,D,E>(this.val0, this.val1, value, this.val3, this.val4);
    }

    public <X> Quintet<A,B,C,X,E> setAt3(final X value) {
        return new Quintet<A,B,C,X,E>(this.val0, this.val1, this.val2, value, this.val4);
    }

    public <X> Quintet<A,B,C,D,X> setAt4(final X value) {
        return new Quintet<A,B,C,D,X>(this.val0, this.val1, this.val2, this.val3, value);
    }

    public Quartet<B,C,D,E> removeFrom0() {
        return new Quartet<B,C,D,E>(this.val1, this.val2, this.val3, this.val4);
    }

    public Quartet<A,C,D,E> removeFrom1() {
        return new Quartet<A,C,D,E>(this.val0, this.val2, this.val3, this.val4);
    }

    public Quartet<A,B,D,E> removeFrom2() {
        return new Quartet<A,B,D,E>(this.val0, this.val1, this.val3, this.val4);
    }

    public Quartet<A,B,C,E> removeFrom3() {
        return new Quartet<A,B,C,E>(this.val0, this.val1, this.val2, this.val4);
    }

    public Quartet<A,B,C,D> removeFrom4() {
        return new Quartet<A,B,C,D>(this.val0, this.val1, this.val2, this.val3);
    }

}