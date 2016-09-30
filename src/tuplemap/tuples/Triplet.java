package tuplemap.tuples;

import tuplemap.base.Tuple;
import tuplemap.values.Value0;
import tuplemap.values.Value1;
import tuplemap.values.Value2;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Sharukh Hasan on 9/28/16.
 *
 * Three-element tuple
 */
public final class Triplet<A,B,C> extends Tuple implements Value0<A>, Value1<B>, Value2<C> {
    private static final long serialVersionUID = -1877265551599483740L;
    private static final int SIZE = 3;

    private final A val0;
    private final B val1;
    private final C val2;

    public static <A,B,C> Triplet<A,B,C> with(final A value0, final B value1, final C value2) {
        return new Triplet<A,B,C>(value0,value1,value2);
    }

    //Create tuple from array. Array has to have exactly three elements.
    public static <X> Triplet<X,X,X> fromArray(final X[] array) {
        if(array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if(array.length != 3) {
            throw new IllegalArgumentException("Array must have exactly 3 elements in order to create a Triplet. Size is " + array.length);
        }

        return new Triplet<X,X,X>(array[0],array[1],array[2]);
    }

    //Create tuple from collection. Collection has to have exactly three elements.
    public static <X> Triplet<X,X,X> fromCollection(final Collection<X> collection) {
        return fromIterable(collection);
    }

    //Create tuple from iterable. Iterable has to have exactly three elements.
    public static <X> Triplet<X,X,X> fromIterable(final Iterable<X> iterable) {
        return fromIterable(iterable, 0, true);
    }

    //Create tuple from iterable, starting from the specified index.
    public static <X> Triplet<X,X,X> fromIterable(final Iterable<X> iterable, int index) {
        return fromIterable(iterable, index, false);
    }

    private static <X> Triplet<X,X,X> fromIterable(final Iterable<X> iterable, int index, final boolean exactSize) {
        if(iterable == null) {
            throw new IllegalArgumentException("Iterable cannot be null");
        }

        boolean tooFewElements = false;

        X element0 = null;
        X element1 = null;
        X element2 = null;

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

        if(tooFewElements && exactSize) {
            throw new IllegalArgumentException("Not enough elements for creating a Triplet (3 needed)");
        }

        if(iter.hasNext() && exactSize) {
            throw new IllegalArgumentException("Iterable must have exactly 3 available elements in order to create a Triplet.");
        }

        return new Triplet<X,X,X>(element0, element1, element2);

    }

    public Triplet(final A value0, final B value1, final C value2) {
        super(value0, value1, value2);
        this.val0 = value0;
        this.val1 = value1;
        this.val2 = value2;
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

    @Override
    public int getSize() {
        return SIZE;
    }

    //Triplet methods
    public <X> Triplet<X,B,C> setAt0(final X value) {
        return new Triplet<X,B,C>(value, this.val1, this.val2);
    }

    public <X> Triplet<A,X,C> setAt1(final X value) {
        return new Triplet<A,X,C>(this.val0, value, this.val2);
    }

    public <X> Triplet<A,B,X> setAt2(final X value) {
        return new Triplet<A,B,X>(this.val0, this.val1, value);
    }

    //Pair methods
    public Pair<B,C> removeFrom0() {
        return new Pair<B,C>(this.val1, this.val2);
    }

    public Pair<A,C> removeFrom1() {
        return new Pair<A,C>(this.val0, this.val2);
    }

    public Pair<A,B> removeFrom2() {
        return new Pair<A,B>(this.val0, this.val1);
    }

    //Quartet methods
    public <X0> Quartet<X0,A,B,C> addAt0(final X0 value0) {
        return new Quartet<X0,A,B,C>(value0, this.val0, this.val1, this.val2);
    }

    public <X0> Quartet<A,X0,B,C> addAt1(final X0 value0) {
        return new Quartet<A,X0,B,C>(this.val0, value0, this.val1, this.val2);
    }

    public <X0> Quartet<A,B,X0,C> addAt2(final X0 value0) {
        return new Quartet<A,B,X0,C>(this.val0, this.val1, value0, this.val2);
    }

    public <X0> Quartet<A,B,C,X0> addAt3(final X0 value0) {
        return new Quartet<A,B,C,X0>(this.val0, this.val1, this.val2, value0);
    }

    public <X0> Quartet<X0,A,B,C> addAt0(final Single<X0> tuple) {
        return addAt0(tuple.getValue0());
    }

    public <X0> Quartet<A,X0,B,C> addAt1(final Single<X0> tuple) {
        return addAt1(tuple.getValue0());
    }

    public <X0> Quartet<A,B,X0,C> addAt2(final Single<X0> tuple) {
        return addAt2(tuple.getValue0());
    }

    public <X0> Quartet<A,B,C,X0> addAt3(final Single<X0> tuple) {
        return addAt3(tuple.getValue0());
    }

    public <X0> Quartet<A,B,C,X0> add(final X0 value0) {
        return addAt3(value0);
    }


    public <X0> Quartet<A,B,C,X0> add(final Single<X0> tuple) {
        return addAt3(tuple);
    }


    //Quintet methods
    public <X0,X1> Quintet<X0,X1,A,B,C> addAt0(final X0 value0, final X1 value1) {
        return new Quintet<X0,X1,A,B,C>(value0, value1, this.val0, this.val1, this.val2);
    }

    public <X0,X1> Quintet<A,X0,X1,B,C> addAt1(final X0 value0, final X1 value1) {
        return new Quintet<A,X0,X1,B,C>(this.val0, value0, value1, this.val1, this.val2);
    }

    public <X0,X1> Quintet<A,B,X0,X1,C> addAt2(final X0 value0, final X1 value1) {
        return new Quintet<A,B,X0,X1,C>(this.val0, this.val1, value0, value1, this.val2);
    }

    public <X0,X1> Quintet<A,B,C,X0,X1> addAt3(final X0 value0, final X1 value1) {
        return new Quintet<A,B,C,X0,X1>(this.val0, this.val1, this.val2, value0, value1);
    }


    public <X0,X1> Quintet<X0,X1,A,B,C> addAt0(final Pair<X0,X1> tuple) {
        return addAt0(tuple.getValue0(),tuple.getValue1());
    }

    public <X0,X1> Quintet<A,X0,X1,B,C> addAt1(final Pair<X0,X1> tuple) {
        return addAt1(tuple.getValue0(),tuple.getValue1());
    }

    public <X0,X1> Quintet<A,B,X0,X1,C> addAt2(final Pair<X0,X1> tuple) {
        return addAt2(tuple.getValue0(),tuple.getValue1());
    }

    public <X0,X1> Quintet<A,B,C,X0,X1> addAt3(final Pair<X0,X1> tuple) {
        return addAt3(tuple.getValue0(),tuple.getValue1());
    }

    public <X0,X1> Quintet<A,B,C,X0,X1> add(final X0 value0, final X1 value1) {
        return addAt3(value0, value1);
    }


    public <X0,X1> Quintet<A,B,C,X0,X1> add(final Pair<X0,X1> tuple) {
        return addAt3(tuple);
    }

}