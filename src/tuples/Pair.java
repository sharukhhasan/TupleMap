package tuples;

import base.Tuple;
import values.Value0;
import values.Value1;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by sharukhhasan on 9/28/16.
 */
public final class Pair<A,B> extends Tuple implements Value0<A>, Value1<B> {
    private static final long serialVersionUID = 2438099850625502138L;
    private static final int SIZE = 2;

    private final A val0;
    private final B val1;

    public static <A,B> Pair<A,B> with(final A value0, final B value1) {
        return new Pair<A,B>(value0,value1);
    }

    //Create tuple from array. Array has to have exactly two elements.
    public static <X> Pair<X,X> fromArray(final X[] array) {
        if(array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if(array.length != 2) {
            throw new IllegalArgumentException("Array must have exactly 2 elements in order to create a Pair. Size is " + array.length);
        }
        return new Pair<X,X>(array[0],array[1]);
    }

    //Create tuple from collection. Collection has to have exactly two elements.
    public static <X> Pair<X,X> fromCollection(final Collection<X> collection) {
        return fromIterable(collection);
    }

    //Create tuple from iterable. Iterable has to have exactly two elements.
    public static <X> Pair<X,X> fromIterable(final Iterable<X> iterable) {
        return fromIterable(iterable, 0, true);
    }

    //Create tuple from iterable, starting from the specified index.
    public static <X> Pair<X,X> fromIterable(final Iterable<X> iterable, int index) {
        return fromIterable(iterable, index, false);
    }

    private static <X> Pair<X,X> fromIterable(final Iterable<X> iterable, int index, final boolean exactSize) {

        if(iterable == null) {
            throw new IllegalArgumentException("Iterable cannot be null");
        }

        boolean tooFewElements = false;

        X element0 = null;
        X element1 = null;

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

        if(tooFewElements && exactSize) {
            throw new IllegalArgumentException("Not enough elements for creating a pair - 2 needed");
        }

        if(iter.hasNext() && exactSize) {
            throw new IllegalArgumentException("Iterable must have 2 available elements to create a pair.");
        }

        return new Pair<X,X>(element0, element1);
    }

    public Pair(final A value0, final B value1) {
        super(value0, value1);
        this.val0 = value0;
        this.val1 = value1;
    }

    public A getValue0() {
        return this.val0;
    }

    public B getValue1() {
        return this.val1;
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    //Single methods
    public Single<B> removeFrom0() {
        return new Single<B>(this.val1);
    }

    public Single<A> removeFrom1() {
        return new Single<A>(this.val0);
    }


    //Pair methods
    public <X> Pair<X,B> setAt0(final X value) {
        return new Pair<X,B>(value, this.val1);
    }

    public <X> Pair<A,X> setAt1(final X value) {
        return new Pair<A,X>(this.val0, value);
    }


    //Triplet methods
    public <X0> Triplet<X0,A,B> addAt0(final X0 value0) {
        return new Triplet<X0,A,B>(value0, this.val0, this.val1);
    }

    public <X0> Triplet<A,X0,B> addAt1(final X0 value0) {
        return new Triplet<A,X0,B>(this.val0, value0, this.val1);
    }

    public <X0> Triplet<A,B,X0> addAt2(final X0 value0) {
        return new Triplet<A,B,X0>(this.val0, this.val1, value0);
    }

    public <X0> Triplet<X0,A,B> addAt0(final Single<X0> tuple) {
        return addAt0(tuple.getValue0());
    }

    public <X0> Triplet<A,X0,B> addAt1(final Single<X0> tuple) {
        return addAt1(tuple.getValue0());
    }

    public <X0> Triplet<A,B,X0> addAt2(final Single<X0> tuple) {
        return addAt2(tuple.getValue0());
    }

    public <X0> Triplet<A,B,X0> add(final X0 value0) {
        return addAt2(value0);
    }


    public <X0> Triplet<A,B,X0> add(final Single<X0> tuple) {
        return addAt2(tuple);
    }


    //Quartet methods
    public <X0,X1> Quartet<X0,X1,A,B> addAt0(final X0 value0, final X1 value1) {
        return new Quartet<X0,X1,A,B>(value0, value1, this.val0, this.val1);
    }

    public <X0,X1> Quartet<A,X0,X1,B> addAt1(final X0 value0, final X1 value1) {
        return new Quartet<A,X0,X1,B>(this.val0, value0, value1, this.val1);
    }

    public <X0,X1> Quartet<A,B,X0,X1> addAt2(final X0 value0, final X1 value1) {
        return new Quartet<A,B,X0,X1>(this.val0, this.val1, value0, value1);
    }

    public <X0,X1> Quartet<X0,X1,A,B> addAt0(final Pair<X0,X1> tuple) {
        return addAt0(tuple.getValue0(),tuple.getValue1());
    }

    public <X0,X1> Quartet<A,X0,X1,B> addAt1(final Pair<X0,X1> tuple) {
        return addAt1(tuple.getValue0(),tuple.getValue1());
    }

    public <X0,X1> Quartet<A,B,X0,X1> addAt2(final Pair<X0,X1> tuple) {
        return addAt2(tuple.getValue0(),tuple.getValue1());
    }

    public <X0,X1> Quartet<A,B,X0,X1> add(final X0 value0, final X1 value1) {
        return addAt2(value0, value1);
    }

    public <X0,X1> Quartet<A,B,X0,X1> add(final Pair<X0,X1> tuple) {
        return addAt2(tuple);
    }


    //Quintet methods
    public <X0,X1,X2> Quintet<X0,X1,X2,A,B> addAt0(final X0 value0, final X1 value1, final X2 value2) {
        return new Quintet<X0,X1,X2,A,B>(value0, value1, value2, this.val0, this.val1);
    }

    public <X0,X1,X2> Quintet<A,X0,X1,X2,B> addAt1(final X0 value0, final X1 value1, final X2 value2) {
        return new Quintet<A,X0,X1,X2,B>(this.val0, value0, value1, value2, this.val1);
    }

    public <X0,X1,X2> Quintet<A,B,X0,X1,X2> addAt2(final X0 value0, final X1 value1, final X2 value2) {
        return new Quintet<A,B,X0,X1,X2>(this.val0, this.val1, value0, value1, value2);
    }

    public <X0,X1,X2> Quintet<X0,X1,X2,A,B> addAt0(final Triplet<X0,X1,X2> tuple) {
        return addAt0(tuple.getValue0(),tuple.getValue1(),tuple.getValue2());
    }

    public <X0,X1,X2> Quintet<A,X0,X1,X2,B> addAt1(final Triplet<X0,X1,X2> tuple) {
        return addAt1(tuple.getValue0(),tuple.getValue1(),tuple.getValue2());
    }

    public <X0,X1,X2> Quintet<A,B,X0,X1,X2> addAt2(final Triplet<X0,X1,X2> tuple) {
        return addAt2(tuple.getValue0(),tuple.getValue1(),tuple.getValue2());
    }

    public <X0,X1,X2> Quintet<A,B,X0,X1,X2> add(final X0 value0, final X1 value1, final X2 value2) {
        return addAt2(value0, value1, value2);
    }

    public <X0,X1,X2> Quintet<A,B,X0,X1,X2> add(final Triplet<X0,X1,X2> tuple) {
        return addAt2(tuple);
    }

}